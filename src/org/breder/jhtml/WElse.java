package org.breder.jhtml;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Tag html
 * 
 * 
 * @author Bernardo Breder
 */
public class WElse extends WTag {

  /**
   * Construtor
   */
  public WElse() {
    super("if");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(Map<String, Object> map, OutputStream output)
    throws Exception {
    List<WNode> children = this.getChildren();
    for (WNode node : children) {
      node.execute(map, output);
    }
  }

}
