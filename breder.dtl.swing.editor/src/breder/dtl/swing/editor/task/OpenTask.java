package breder.dtl.swing.editor.task;

import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import breder.dtl.swing.editor.gui.DesktopFrame;
import breder.util.task.RemoteTask;
import breder.util.util.input.InputStreamUtil;

public class OpenTask extends RemoteTask {

  private File file;

  private String text;

  public OpenTask() {
    super("");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean preAction() {
    JFileChooser fc = new JFileChooser(new File("."));
    fc.setFileFilter(new FileNameExtensionFilter("", "dtl"));
    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int dialog = fc.showOpenDialog(DesktopFrame.getInstance());
    if (dialog == JFileChooser.APPROVE_OPTION && fc.getSelectedFile() != null) {
      this.file = fc.getSelectedFile();
      return file.exists();
    }
    return false;
  }

  @Override
  public void updateUI() {
    DesktopFrame.getInstance().getEditor().setFile(file);
    DesktopFrame.getInstance().getEditor().setText(text);
    DesktopFrame.getInstance().requestFocus();
  }

  @Override
  public void perform() throws Throwable {
    this.text = new String(InputStreamUtil.getBytes(new FileInputStream(file)));
  }

}
