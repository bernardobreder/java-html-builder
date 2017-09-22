package org.breder.jhtml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.breder.jhtml.el.Grammer;
import org.breder.jhtml.el.node.ELNode;

/**
 * Tag html
 * 
 * 
 * @author Bernardo Breder
 */
public class WImport extends WTag {

  /**
   * Construtor
   */
  public WImport() {
    super("import");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(Map<String, Object> map, OutputStream output)
    throws Exception {
    String src = this.getAttributes().get("src").execute(map).toString();
    File file = new File(src);
    InputStream input = new FileInputStream(file);
    WTag page = Grammer.build(input);
    input.close();
    Map<String, Object> oldValues = new HashMap<String, Object>();
    for (String att : this.getAttributes().keySet()) {
      if (!att.equals("src")) {
        Object attribute = map.get(att);
        if (attribute != null) {
          oldValues.put(att, attribute);
        }
        String value = this.getAttributes().get(att).execute(map).toString();
        ELNode read = Grammer.read(value);
        map.put(att, read.execute(map));
      }
    }
    if (this.get("root").execute(map).equals("false")) {
      for (WNode node : page.getChildren()) {
        node.execute(map, output);
      }
    }
    else {
      page.execute(map, output);
    }
    for (String att : oldValues.keySet()) {
      if (!att.equals("src")) {
        map.put(att, oldValues.get(att));
      }
    }
  }

}
