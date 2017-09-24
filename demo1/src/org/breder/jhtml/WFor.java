package org.breder.jhtml;

import java.io.OutputStream;
import java.util.Map;

/**
 * Tag html
 * 
 * 
 * @author Bernardo Breder
 */
public class WFor extends WTag {

  /**
   * Construtor
   */
  public WFor() {
    super("for");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(Map<String, Object> map, OutputStream output)
    throws Exception {
    String var = this.getAttributes().get("var").execute(map).toString();
    int begin =
      Integer
        .valueOf(this.getAttributes().get("begin").execute(map).toString());
    int end =
      Integer.valueOf(this.getAttributes().get("end").execute(map).toString());
    Object oldValue = map.get(var);
    for (int n = begin; n <= end; n++) {
      map.put(var, Integer.valueOf(n));
      for (WNode node : this.getChildren()) {
        node.execute(map, output);
      }
    }
    if (oldValue != null) {
      map.put(var, oldValue);
    }
    else {
      map.remove(var);
    }
  }

}
