package org.breder.jhtml.el.node;

import java.util.Map;

/**
 * Literal Boolean
 * 
 * 
 * @author Bernardo Breder
 */
public class BooleanNode extends PrimitiveNode {

  /**
   * Construtor
   * 
   * @param token
   */
  public BooleanNode(String token) {
    super(token);
  }

  /**
   * Flag
   * 
   * @return flag
   */
  public Boolean getFlag() {
    if (this.getToken().equals("true")) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object execute(Map<String, Object> map) {
    return this.getFlag();
  }

}
