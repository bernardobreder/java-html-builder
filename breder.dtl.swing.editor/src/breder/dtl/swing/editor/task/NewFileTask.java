package breder.dtl.swing.editor.task;

import breder.dtl.swing.editor.gui.DesktopFrame;
import breder.util.task.LocalTask;

public class NewFileTask extends LocalTask {

  @Override
  public void updateUI() {
    DesktopFrame.getInstance().getEditor().setText("");
  }

}
