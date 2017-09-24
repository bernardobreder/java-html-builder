package breder.dtl.swing.editor.task;

import breder.dtl.swing.editor.gui.DesktopFrame;
import breder.dtl.swing.editor.gui.Editor;

public class SaveTask extends SaveAsTask {

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean preAction() {
    Editor editor = DesktopFrame.getInstance().getEditor();
    this.file = editor.getFile();
    if (file == null) {
      return super.preAction();
    }
    else {
      return true;
    }
  }

}
