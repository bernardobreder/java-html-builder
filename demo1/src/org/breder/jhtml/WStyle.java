package org.breder.jhtml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.breder.jhtml.el.node.ELNode;
import org.dom4j.Element;

/**
 * Tag html
 * 
 * 
 * @author Bernardo Breder
 */
public class WStyle extends WTag {

  /**
   * Construtor
   */
  public WStyle() {
    super("link");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public WTag load(Element elem) throws IOException {
    this.add("type", "text/css");
    this.add("rel", "stylesheet");
    return super.load(elem);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(Map<String, Object> map, OutputStream output)
    throws Exception {
    ELNode srcAtt = this.getAttributes().get("inline");
    if (srcAtt != null) {
      File file = new File(srcAtt.execute(map).toString());
      output.write("<style>".getBytes());
      FileInputStream input = new FileInputStream(file);
      for (int n; (n = input.read()) != -1;) {
        if (n != '\t' && n != '\r' && n != '\n') {
          output.write((char) n);
        }
      }
      input.close();
      output.write("</style>".getBytes());
    }
    else {
      super.execute(map, output);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean hasBody() {
    return true;
  }

}
