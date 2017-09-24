package breder.dtl.swing.editor.gui;

import java.io.IOException;
import java.util.Properties;

import org.gjt.sp.jedit.IPropertyManager;

public class EditorProperties extends Properties implements IPropertyManager {

  public EditorProperties() {
    try {
      this.load(this.getClass().getResourceAsStream(
        "/org/gjt/sp/jedit/jedit_keys.props"));
      this.load(this.getClass().getResourceAsStream(
        "/org/gjt/sp/jedit/jedit.props"));
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    this.put("tabsize", 4);
  }

}
