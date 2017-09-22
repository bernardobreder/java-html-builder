package org.breder.jhtml;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Map;

import org.dom4j.Element;

/**
 * Tag html
 * 
 * 
 * @author Bernardo Breder
 */
public abstract class WNode implements Serializable, Cloneable {

  /** CharSet */
  public static final Charset CHAR_SET = Charset.forName("utf-8");

  /**
   * Carrega o nó
   * 
   * @param elem
   * @return this
   * @throws IOException
   */
  public abstract WNode load(Element elem) throws IOException;

  /**
   * Salva o nó
   * 
   * @param map
   * @param output
   * @throws Exception
   */
  public abstract void execute(Map<String, Object> map, OutputStream output)
    throws Exception;

}
