package org.breder.jhtml.el.node;

import java.util.Map;

/**
 * Literal de string
 * 
 * 
 * @author Bernardo Breder
 */
public class StringNode extends PrimitiveNode {

  /**
   * Construtor
   * 
   * @param token
   */
  public StringNode(String token) {
    super(token);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object execute(Map<String, Object> map) {
    return this.getToken();
  }

}
