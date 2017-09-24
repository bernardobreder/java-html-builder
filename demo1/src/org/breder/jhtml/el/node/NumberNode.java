package org.breder.jhtml.el.node;

import java.util.Map;

/**
 * Numero
 * 
 * 
 * @author Bernardo Breder
 */
public class NumberNode extends PrimitiveNode {

  /**
   * Construtor
   * 
   * @param token
   */
  public NumberNode(String token) {
    super(token);
  }

  /**
   * Valor
   * 
   * @return double
   */
  public Double getDouble() {
    return new Double(this.getToken());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object execute(Map<String, Object> map) {
    return this.getDouble();
  }

}
