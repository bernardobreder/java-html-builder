package org.breder.jhtml;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.breder.jhtml.el.Grammer;
import org.breder.jhtml.el.node.ELNode;
import org.breder.jhtml.el.node.StringNode;
import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;

/**
 * Tag html
 * 
 * 
 * @author Bernardo Breder
 */
public class WTag extends WNode {

  /** Nome da Tag */
  private final String name;
  /** Atributos */
  private Map<String, ELNode> attributes;
  /** Fihlos */
  private List<WNode> children;
  private byte[] nameBytes;
  /** Tags */
  private static final Map<String, WTag> tags = new HashMap<String, WTag>();

  static {
    WTag.addTag("html", new WHtml());
    WTag.addTag("body", new WBody());
    WTag.addTag("head", new WHead());
    WTag.addTag("div", new WDiv());
    WTag.addTag("if", new WIf());
    WTag.addTag("else", new WElse());
    WTag.addTag("for", new WFor());
    WTag.addTag("forEach", new WForEach());
    WTag.addTag("import", new WImport());
    WTag.addTag("table", new WTable());
    WTag.addTag("link", new WStyle());
    WTag.addTag("script", new WScript());
    WTag.addTag("textarea", new WTextArea());
    WTag.addTag("td", new WTd());
    WTag.addTag("nbsp", new WNbsp());
  }

  /**
   * Construtor
   * 
   * @param name
   */
  public WTag(String name) {
    this.name = name;
    this.nameBytes = name.getBytes(WNode.CHAR_SET);
  }

  /**
   * Carrega a tag
   * 
   * @param elem
   * @return tag
   * @throws IOException
   */
  public static WTag build(Element elem) throws IOException {
    String name = elem.getName();
    WTag tag = tags.get(name);
    if (tag != null) {
      try {
        WTag clone = (WTag) tag.clone();
        return clone.load(elem);
      }
      catch (CloneNotSupportedException e) {
        throw new IOException(e);
      }
    }
    else {
      return new WTag(name).load(elem);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public WTag load(Element elem) throws IOException {
    int attributeCount = elem == null ? 0 : elem.attributeCount();
    int nodeCount = elem == null ? 0 : elem.nodeCount();
    if (this.attributes == null) {
      this.attributes = new HashMap<String, ELNode>(attributeCount);
    }
    if (this.children == null) {
      this.children = new ArrayList<WNode>(nodeCount);
    }
    if (attributeCount > 0) {
      for (Attribute attr : elem.attributes()) {
        this.attributes.put(attr.getName(), Grammer.read(attr.getValue()));
      }
    }
    for (int n = 0; n < nodeCount; n++) {
      Node node = elem.node(n);
      if (node instanceof Text) {
        Text textNode = (Text) node;
        String text = textNode.getText().trim();
        if (text.length() > 0) {
          this.children.add(new WText(Grammer.read(text)));
        }
      }
      else if (node instanceof Element) {
        this.children.add(WTag.build((Element) node));
      }
    }
    return this;
  }

  /**
   * Adiciona um tag
   * 
   * @param elem
   * @return this
   */
  public WTag add(WTag elem) {
    if (this.children == null) {
      this.children = new ArrayList<WNode>();
    }
    this.children.add(elem);
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(Map<String, Object> map, OutputStream output)
    throws Exception {
    int childrenCount = this.children.size();
    output.write('<');
    output.write(nameBytes);
    for (String attr : this.attributes.keySet()) {
      output.write(' ');
      output.write(attr.getBytes("utf-8"));
      output.write('=');
      output.write('\"');
      output.write(this.attributes.get(attr).execute(map).toString().getBytes(
        "utf-8"));
      output.write('\"');
    }
    if (childrenCount == 0 && !this.hasBody()) {
      output.write('/');
      output.write('>');
    }
    else {
      output.write('>');
    }
    for (int n = 0; n < childrenCount; n++) {
      children.get(n).execute(map, output);
    }
    if (childrenCount > 0 || this.hasBody()) {
      output.write('<');
      output.write('/');
      output.write(nameBytes);
      output.write('>');
    }
  }

  /**
   * Executa o cabeçalho
   * 
   * @param map
   * @param output
   * @throws IOException
   */
  protected void executeHead(Map<String, Object> map, OutputStream output)
    throws IOException {
    StringBuilder sb = new StringBuilder();
    sb.append("<");
    sb.append(name);
    for (String attr : this.attributes.keySet()) {
      sb.append(" ");
      sb.append(attr);
      sb.append("='");
      sb.append(this.attributes.get(attr).execute(map));
      sb.append("'");
    }
    if (this.children.size() == 0 && !this.hasBody()) {
      sb.append("/>");
    }
    else {
      sb.append(">");
    }
    output.write(sb.toString().getBytes(WNode.CHAR_SET));
  }

  /**
   * Executa o rodapé
   * 
   * @param map
   * @param output
   * @throws IOException
   */
  protected void executeTail(Map<String, Object> map, OutputStream output)
    throws IOException {
    if (this.children.size() > 0 || this.hasBody()) {
      StringBuilder sb = new StringBuilder();
      sb.append("</");
      sb.append(name);
      sb.append(">");
      output.write(sb.toString().getBytes(WNode.CHAR_SET));
    }
  }

  /**
   * Executa o corpo
   * 
   * @param map
   * @param output
   * @throws Exception
   */
  protected void executeBody(Map<String, Object> map, OutputStream output)
    throws Exception {
    for (WNode node : children) {
      node.execute(map, output);
    }
  }

  /**
   * Adiciona um atributo
   * 
   * @param attr
   * @param value
   * @return this
   */
  public WTag add(String attr, String value) {
    if (this.attributes == null) {
      this.attributes = new HashMap<String, ELNode>();
    }
    this.attributes.put(attr, Grammer.read(value));
    return this;
  }

  /**
   * Retorna
   * 
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Retorna
   * 
   * @return attrs
   */
  public Map<String, ELNode> getAttributes() {
    return attributes;
  }

  /**
   * Retorna
   * 
   * @return children
   */
  public List<WNode> getChildren() {
    return children;
  }

  /**
   * Retorna o atributo
   * 
   * @param attribute
   * @return atributo
   */
  public ELNode get(String attribute) {
    ELNode node = this.getAttributes().get(attribute);
    if (node == null) {
      return new StringNode("");
    }
    else {
      return node;
    }
  }

  /**
   * Adiciona uma tag
   * 
   * @param name
   * @param tag
   */
  public static void addTag(String name, WTag tag) {
    tags.put(name, tag);
  }

  /**
   * Indica se a tag deve possuir corpo
   * 
   * @return corpo
   */
  public boolean hasBody() {
    return false;
  }

}
