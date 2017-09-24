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
public class WForEach extends WTag {

  /**
   * Construtor
   */
  public WForEach() {
    super("forEach");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(Map<String, Object> map, OutputStream output)
    throws Exception {
    String var = this.getAttributes().get("var").execute(map).toString();
    String index = this.get("index").execute(map).toString();
    List<?> list = (List<?>) this.getAttributes().get("list").execute(map);
    Object oldIndexValue = map.get(index);
    Object oldVarValue = map.get(var);
    if (list != null) {
      for (int n = 0; n < list.size(); n++) {
        Object value = list.get(n);
        map.put(var, value);
        map.put(index, n);
        for (WNode node : this.getChildren()) {
          node.execute(map, output);
        }
      }
    }
    if (oldVarValue != null) {
      map.put(var, oldVarValue);
    }
    else {
      map.remove(var);
    }
    if (oldIndexValue != null) {
      map.put(index, oldIndexValue);
    }
    else {
      map.remove(index);
    }
  }

}
