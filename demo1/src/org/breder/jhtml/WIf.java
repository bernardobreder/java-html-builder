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
public class WIf extends WTag {

  /**
   * Construtor
   */
  public WIf() {
    super("if");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(Map<String, Object> map, OutputStream output)
    throws Exception {
    Object test = this.getAttributes().get("test").execute(map);
    List<WNode> children = this.getChildren();
    if (test instanceof Boolean && (Boolean) test) {
      for (WNode node : children) {
        if (node instanceof WElse == false) {
          node.execute(map, output);
        }
      }
    }
    else {
      if (children.size() > 0) {
        WNode lastNode = children.get(children.size() - 1);
        if (lastNode instanceof WElse) {
          lastNode.execute(map, output);
        }
      }
    }
  }

}
