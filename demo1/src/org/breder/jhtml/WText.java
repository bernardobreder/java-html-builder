package org.breder.jhtml;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.breder.jhtml.el.node.ELNode;
import org.dom4j.Element;

/**
 * Tag html
 * 
 * 
 * @author Bernardo Breder
 */
public class WText extends WNode {

  /** Texto */
  private ELNode text;

  /**
   * Construtor
   * 
   * @param node
   */
  public WText(ELNode node) {
    this.text = node;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public WNode load(Element elem) throws IOException {
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(Map<String, Object> map, OutputStream output)
    throws Exception {
    output.write(this.text.execute(map).toString().getBytes(WNode.CHAR_SET));
  }

}
