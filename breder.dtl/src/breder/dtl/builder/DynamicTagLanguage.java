package breder.dtl.builder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import breder.dtl.el.node.AssignNode;
import breder.dtl.el.node.BinaryNode;
import breder.dtl.el.node.IdentifyNode;
import breder.dtl.el.node.Node;
import breder.dtl.el.node.NumberNode;
import breder.dtl.el.node.PrimitiveNode;
import breder.dtl.el.node.TagNode;
import breder.dtl.el.node.UnaryNode;
import breder.dtl.el.parse.DTL;
import breder.dtl.el.parse.ParseException;

public class DynamicTagLanguage {

	private InputStream input;

	private OutputStream output;

	private final Map<String, Class<?>> tags = new HashMap<String, Class<?>>();

	private final Map<String, Map<String, Integer>> params = new HashMap<String, Map<String, Integer>>();

	private final Map<Class<? extends Node>, Class<? extends AbstractTag>> nodes = new HashMap<Class<? extends Node>, Class<? extends AbstractTag>>();

	private StringBuilder sb;

	private String lastTagAdded;

	public DynamicTagLanguage(String resource) {
		this(DynamicTagLanguage.class.getClassLoader().getResourceAsStream(resource));
	}

	public DynamicTagLanguage(File file) throws FileNotFoundException {
		this(new FileInputStream(file));
	}

	public DynamicTagLanguage(InputStream input) {
		this.input = input;
		this.output = new ByteArrayOutputStream();
	}

	public void execute() throws IOException, ParseException, SemanticParserException {
		DTL el = new DTL(input);
		List<Node> nodes = el.execute();
		ClassWriter writer = new ClassWriter(this.output);
		String classname = "MyPage";
		writer.printClass(classname, new String[] { AbstractTag.class.getName() }, null);
		writer.printMethod("toString", String.class.getSimpleName(), new String[] { DyanmicTagLanguageContext.class.getName() + " context" }, true);
		this.sb = new StringBuilder();
		this.executeTags(nodes);
		writer.println("return " + sb.substring(1) + ";");
		writer.printClose();
		writer.printClose();
		writer.close();
	}

	/**
	 * Executa as tags
	 * 
	 * @param nodes
	 * @throws SemanticParserException
	 */
	private void executeTags(List<Node> nodes) throws SemanticParserException {
		for (Node node : nodes) {
			this.sb.append(",");
			this.executeTag(node);
		}
	}

	private void executeTag(Node node) throws SemanticParserException {
		if (node instanceof TagNode) {
			TagNode tagNode = (TagNode) node;
			Class<?> tagClass;
			String tagName = tagNode.getToken().image;
			tagClass = this.tags.get(tagName);
			if (tagClass == null) {
				throw new SemanticParserException(node.getToken());
			}
			this.executeNewInstance(tagClass);
			this.executeParameters(tagNode);
			this.executeChildren(tagNode);
			sb.append(")");
		} else {
			this.executeExpressionValue(node);
			sb.append(".toString()");
		}
	}

	private void executeNewInstance(Class<?> tagClass) {
		sb.append(tagClass.getName() + ".toString(context");
	}

	private void executeChildren(TagNode tagNode) throws SemanticParserException {
		if (tagNode.getNodes() != null) {
			this.executeTags(tagNode.getNodes());
		}
	}

	private void executeParameters(TagNode tagNode) throws SemanticParserException {
		List<Node> params = tagNode.getParams();
		if (params != null) {
			String tagNodeName = tagNode.getToken().image;
			int size = params.size();
			Map<String, Integer> map = this.params.get(tagNodeName);
			if (map != null && map.size() > 0) {
				AssignNode[] nodes = new AssignNode[map.size()];
				for (int n = 0; n < size; n++) {
					Node paramNode = params.get(n);
					if (paramNode instanceof AssignNode) {
						AssignNode assignNode = (AssignNode) paramNode;
						String key = assignNode.getLeft().getToken().image;
						Integer index = map.get(key);
						if (index != null) {
							nodes[index] = assignNode;
						} else {
							throw new SemanticParserException(paramNode.getToken());
						}
					} else {
						throw new SemanticParserException(paramNode.getToken());
					}
				}
				for (int n = 0; n < nodes.length; n++) {
					AssignNode node = nodes[n];
					if (node != null) {
						sb.append(",");
						AssignNode assignNode = node;
						this.executeExpressionValue(assignNode.getRight());
					}
				}
			} else {
				for (int n = 0; n < size; n++) {
					Node paramNode = params.get(n);
					sb.append(",");
					this.executeExpressionValue(paramNode);
				}
			}
		}
	}

	private void executeExpressionValue(Node paramNode) throws SemanticParserException {
		if (paramNode instanceof UnaryNode) {
			this.executeExpressionValue(((UnaryNode) paramNode).getLeft());
			return;
		}
		if (paramNode instanceof IdentifyNode) {
			sb.append("\"" + paramNode.getToken().image + "\"");
		} else if (paramNode instanceof PrimitiveNode) {
			executeExpressionPrimitive(paramNode);
		} else {
			this.executeNewInstance(this.getNode(paramNode.getClass()));
			sb.append(",");
			if (paramNode instanceof TagNode) {
				TagNode tagNode = (TagNode) paramNode;
				List<Node> params = tagNode.getParams();
				if (params != null) {
				} else {
					sb.append("\"" + tagNode.getToken().image + "\"");
				}
			} else if (paramNode instanceof BinaryNode) {
				BinaryNode binaryNode = (BinaryNode) paramNode;
				this.executeExpressionValue(binaryNode.getLeft());
				sb.append(",");
				this.executeExpressionValue(binaryNode.getRight());
			} else if (paramNode instanceof UnaryNode) {
				this.executeExpressionValue(((UnaryNode) paramNode).getLeft());
			} else if (paramNode instanceof PrimitiveNode) {
				executeExpressionPrimitive(paramNode);
			} else {
				throw new SemanticParserException(paramNode.getToken());
			}
			sb.append(")");
		}
	}

	private void executeExpressionPrimitive(Node paramNode) {
		sb.append(paramNode.getToken().image);
		if (paramNode instanceof NumberNode) {
			sb.append("d");
		}
	}

	/**
	 * Adiciona uma tag a um nome
	 * 
	 * @param name
	 * @param tagClass
	 * @return owner
	 */
	public DynamicTagLanguage addTag(String name, Class<?> tagClass) {
		this.lastTagAdded = name;
		this.tags.put(name, tagClass);
		return this;
	}

	/**
	 * Adiciona um parametro
	 * 
	 * @param name
	 * @return owner
	 */
	public DynamicTagLanguage addParam(String name) {
		Map<String, Integer> map = this.params.get(this.lastTagAdded);
		if (map == null) {
			map = new HashMap<String, Integer>();
			this.params.put(this.lastTagAdded, map);
		}
		map.put(name, map.size());
		return this;
	}

	/**
	 * Adiciona parametros
	 * 
	 * @param names
	 * @return owner
	 */
	public DynamicTagLanguage addParams(String... names) {
		for (String name : names) {
			this.addParam(name);
		}
		return this;
	}

	/**
	 * Adiciona uma tag a um nome
	 * 
	 * @param node
	 * @param tag
	 * @return owner
	 */
	public DynamicTagLanguage addNode(Class<? extends Node> node, Class<? extends AbstractTag> tag) {
		this.nodes.put(node, tag);
		return this;
	}

	/**
	 * Retorna a classe de um node
	 * 
	 * @param node
	 * @return classe
	 */
	public Class<? extends AbstractTag> getNode(Class<? extends Node> node) {
		Class<? extends AbstractTag> tagClass = this.nodes.get(node);
		if (tagClass == null) {
			throw new IllegalStateException("not define the node : " + node.getSimpleName());
		}
		return tagClass;
	}

	/**
	 * Retorna a saída
	 * 
	 * @return output
	 */
	public OutputStream getOutputStream() {
		return output;
	}

	/**
	 * @param output
	 */
	public void setOutputStream(OutputStream output) {
		this.output = output;
	}

}
