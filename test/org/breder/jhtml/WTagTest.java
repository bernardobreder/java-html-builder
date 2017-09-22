package org.breder.jhtml;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class WTagTest {

  @Test
  public void test() throws Exception {
    SAXReader reader = new SAXReader();
    Document document =
      reader.read(new ByteArrayInputStream("<html><body><p>a</p></body></html>"
        .getBytes("utf8")));
    Element element = document.getRootElement();
    WTag.build(element).execute(new HashMap<String, Object>(), System.out);
  }

}
