package org.breder.jhtml;

import java.io.OutputStream;
import java.util.Map;

/**
 * Tag html
 * 
 * 
 * @author Bernardo Breder
 */
public class WHtml extends WTag {

  /** Constante de cabeçalho */
  private static final byte[] BYTES =
    "<!DOCTYPE html PUBLIC '-//WAPFORUM//DTD XHTML Mobile 1.0//EN'>"
      .getBytes(WNode.CHAR_SET);

  /**
   * Construtor
   */
  public WHtml() {
    super("html");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(Map<String, Object> map, OutputStream output)
    throws Exception {
    output.write(BYTES);
    super.execute(map, output);
  }

}
