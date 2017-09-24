package breder.dtl.swing.editor.task;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import breder.dtl.swing.editor.gui.DesktopFrame;
import breder.util.task.RemoteTask;
import breder.util.util.input.InputStreamUtil;

public class SaveAsTask extends RemoteTask {

  protected File file;

  protected String text;

  public SaveAsTask() {
    super("");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean preAction() {
    JFileChooser fc = new JFileChooser(new File("../data"));
    fc.setFileFilter(new FileNameExtensionFilter("", ".dtl"));
    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int dialog = fc.showSaveDialog(DesktopFrame.getInstance());
    if (dialog == JFileChooser.APPROVE_OPTION && fc.getSelectedFile() != null) {
      this.file = fc.getSelectedFile();
      DesktopFrame.getInstance().getEditor().setFile(file);
      return true;
    }
    return false;
  }

  @Override
  public void updateUI() {
  }

  @Override
  public void perform() throws Throwable {
    byte[] bytes =
      DesktopFrame.getInstance().getEditor().getText().getBytes("UTF-8");
    if (!file.getName().endsWith(".dtl")) {
      file = new File(file.getParent(), file.getName() + ".dtl");
    }
    if (!file.exists()) {
      file.createNewFile();
    }
    FileOutputStream output = new FileOutputStream(file);
    InputStreamUtil.copyStream(new ByteArrayInputStream(bytes), output);
    output.close();
  }

}
