package org.breder.jhtml;

import java.io.OutputStream;
import java.util.Map;

/**
 * Tag html
 * 
 * 
 * @author Bernardo Breder
 */
public class WNbsp extends WTag {

  /**
   * Construtor
   */
  public WNbsp() {
    super("nbsp");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(Map<String, Object> map, OutputStream output)
    throws Exception {
    output.write("&nbsp;".getBytes());
  }

}
