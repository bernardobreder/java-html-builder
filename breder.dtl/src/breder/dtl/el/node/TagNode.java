package breder.dtl.el.node;

import java.util.ArrayList;
import java.util.List;

import breder.dtl.el.parse.Token;
import breder.dtl.el.util.LightArrayList;

/**
 * No de tag
 * 
 * 
 * @author Bernardo Breder
 */
public class TagNode extends Node {

	/** Parametros ou nulo */
	private final List<Node> params = new LightArrayList<Node>();
	/** Filhos ou nulo */
	private final List<Node> nodes = new LightArrayList<Node>();

	/**
	 * Construtor padrão
	 * 
	 * @param token
	 */
	public TagNode(Token token) {
		super(token);
	}

	/**
	 * Retorna
	 * 
	 * @return params
	 */
	public List<Node> getParams() {
		return params;
	}

	/**
	 * Retorna nós de tag de uma classe
	 * 
	 * @param <E>
	 * @param clazz
	 * @return nós
	 */
	public <E extends Node> List<E> getParams(Class<E> clazz) {
		List<E> list = new ArrayList<E>();
		if (this.getParams() != null) {
			for (Node node : this.getParams()) {
				if (clazz.isInstance(node)) {
					list.add(clazz.cast(node));
				}
			}
		}
		return list;
	}

	/**
	 * Retorna o valor de um parâmetro
	 * 
	 * @param attribute
	 * @return valor
	 */
	public Node getParamNodeValue(String attribute) {
		String lowerCase = attribute.toLowerCase();
		for (AssignNode param : this.getParams(AssignNode.class)) {
			if (param.getLeft() instanceof IdentifyNode) {
				IdentifyNode leftNode = (IdentifyNode) param.getLeft();
				if (leftNode.getToken().image.toLowerCase().equals(lowerCase)) {
					return param.getRight();
				}
			}
		}
		return null;
	}

	public <E> E getParamValue(String attribute, E defaultValue) {
		E value = (E) this.getParamValue(attribute, defaultValue.getClass());
		if (value != null) {
			return value;
		} else {
			return defaultValue;
		}
	}

	public <E> E getParamValue(String attribute, Class<E> c, E defaultValue) {
		E value = this.getParamValue(attribute, c);
		if (value != null) {
			return value;
		} else {
			return defaultValue;
		}
	}

	public <E> E getParamValue(String attribute) {
		return this.getParamValue(attribute, null);
	}

	/**
	 * Retorna o valor de um parâmetro
	 * 
	 * @param <E>
	 * @param attribute
	 * @param clazz
	 * @return valor
	 */
	public <E> E getParamValue(String attribute, Class<E> clazz) {
		String lowerCase = attribute.toLowerCase();
		for (AssignNode param : this.getParams(AssignNode.class)) {
			if (param.getLeft() instanceof IdentifyNode) {
				IdentifyNode leftNode = (IdentifyNode) param.getLeft();
				if (leftNode.getToken().image.toLowerCase().equals(lowerCase)) {
					try {
						String image = param.getRight().getToken().image;
						if (image.startsWith("\"") || image.startsWith("\'")) {
							image = image.substring(1, image.length() - 1);
						}
						E instance = clazz.getConstructor(String.class).newInstance(image);
						return instance;
					} catch (Exception e) {
					}
				}
			}
		}
		return null;
	}

	/**
	 * Adiciona um parametro
	 * 
	 * @param p
	 * @return owner
	 */
	public TagNode addParam(Node p) {
		this.params.add(p);
		return this;
	}

	/**
	 * Retorna
	 * 
	 * @return params
	 */
	public List<Node> getNodes() {
		return nodes;
	}

	/**
	 * Retorna nós de tag de uma classe
	 * 
	 * @param <E>
	 * @param clazz
	 * @return nós
	 */
	public <E extends Node> List<E> getNodes(Class<E> clazz) {
		List<E> list = new ArrayList<E>();
		if (this.getNodes() != null) {
			for (Node node : this.getNodes()) {
				if (clazz.isInstance(node)) {
					list.add(clazz.cast(node));
				}
			}
		}
		return list;
	}

	/**
	 * Retorna nós de tag de uma classe
	 * 
	 * @param <E>
	 * @param clazz
	 * @return nós
	 */
	public <E extends Node> E getNode(Class<E> clazz) {
		if (this.getNodes() != null) {
			for (Node node : this.getNodes()) {
				if (clazz.isInstance(node)) {
					return clazz.cast(node);
				}
			}
		}
		return null;
	}

	/**
	 * Retorna nós de nome de tag especifico
	 * 
	 * @param name
	 * @return nós
	 */
	public List<TagNode> getTagNodes(String name) {
		List<TagNode> list = new ArrayList<TagNode>();
		String lowerCase = name.toLowerCase();
		for (TagNode node : this.getNodes(TagNode.class)) {
			if (node.getToken().image.toLowerCase().equals(lowerCase)) {
				list.add(node);
			}
		}
		return list;
	}

	/**
	 * Adiciona um statement
	 * 
	 * @param p
	 * @return owner
	 */
	public TagNode addNode(Node p) {
		this.nodes.add(p);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int level) {
		StringBuilder sb = new StringBuilder();
		for (int n = 0; n < level; n++) {
			sb.append("\t");
		}
		sb.append(this.getToken().image);
		sb.append(" ");
		if (this.params != null && params.size() > 0) {
			sb.append("(");
			for (int n = 0; n < params.size(); n++) {
				Node param = params.get(n);
				sb.append(param.toString());
				if (n != params.size() - 1) {
					sb.append(" ");
				}
			}
			sb.append(")");
			sb.append(" ");
		}
		if (this.nodes != null && nodes.size() > 0) {
			if (nodes.size() == 1 && nodes.get(0) instanceof ExpressionNode) {
				sb.append("{ ");
				sb.append(nodes.get(0).toString());
				sb.append(" }");
			} else {
				sb.append("{\n");
				for (int n = 0; n < nodes.size(); n++) {
					Node node = nodes.get(n);
					sb.append(node.toString(level + 1));
					sb.append("\n");
				}
				for (int n = 0; n < level; n++) {
					sb.append("\t");
				}
				sb.append("}");
			}
		}
		return sb.toString();
	}
}
