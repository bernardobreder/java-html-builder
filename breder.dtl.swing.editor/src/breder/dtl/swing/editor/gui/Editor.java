package breder.dtl.swing.editor.gui;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JPanel;

import org.gjt.sp.jedit.Mode;
import org.gjt.sp.jedit.syntax.ModeProvider;
import org.gjt.sp.jedit.textarea.StandaloneTextArea;
import org.gjt.sp.jedit.textarea.TextArea;

public class Editor extends JPanel {

  private StandaloneTextArea text;

  private File file;

  public Editor() {
    this.setLayout(new BorderLayout());
    this.add(this.createEditPane(), BorderLayout.CENTER);
  }

  private TextArea createEditPane() {
    this.text = StandaloneTextArea.createTextArea();
    this.text.propertiesChanged();
    Mode mode = new Mode("dtl");
    mode.setProperty("file", "/breder/dtl/swing/editor/resource/dtl.xml");
    ModeProvider.instance.addMode(mode);
    text.getBuffer().setMode(mode);
    return text;
  }

  public String getText() {
    return this.text.getText();
  }

  public void setText(String text) {
    this.text.setText(text);
  }

  public File getFile() {
    return this.file;
  }

  /**
   * @param file
   */
  public void setFile(File file) {
    this.file = file;
    if (file != null) {
      DesktopFrame.getInstance().setTitle(
        DesktopFrame.TITLE + " - " + file.getAbsolutePath());
    }
    else {
      DesktopFrame.getInstance().setTitle(DesktopFrame.TITLE);
    }
  }

}
