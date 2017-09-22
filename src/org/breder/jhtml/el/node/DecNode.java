package org.breder.jhtml.el.node;

import java.util.Map;

/**
 * Decremento
 * 
 * 
 * @author Bernardo Breder
 */
public class DecNode extends UnaryNode {

  /**
   * No de decremento
   * 
   * @param left
   */
  public DecNode(ELNode left) {
    super(left);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object execute(Map<String, Object> map) {
    Object value = this.getLeft().execute(map);
    if (value instanceof Double) {
      return ((Double) value) - 1;
    }
    return value;
  }

}
