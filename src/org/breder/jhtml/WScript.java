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
public class WScript extends WTag {

  /**
   * Construtor
   */
  public WScript() {
    super("script");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public WTag load(Element elem) throws IOException {
    this.add("type", "text/javascript");
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
      output.write("<script type='text/javascript'>".getBytes());
      FileInputStream input = new FileInputStream(file);
      for (int n; (n = input.read()) != -1;) {
        output.write((char) n);
      }
      input.close();
      output.write("</script>".getBytes());
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
