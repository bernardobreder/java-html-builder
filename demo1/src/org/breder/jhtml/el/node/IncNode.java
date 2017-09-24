package org.breder.jhtml.el.node;

import java.util.Map;

/**
 * Incremento
 * 
 * 
 * @author Bernardo Breder
 */
public class IncNode extends UnaryNode {

  /**
   * Construtor
   * 
   * @param left
   */
  public IncNode(ELNode left) {
    super(left);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object execute(Map<String, Object> map) {
    Object value = this.getLeft().execute(map);
    if (value instanceof Double) {
      return ((Double) value) + 1;
    }
    return value;
  }

}
