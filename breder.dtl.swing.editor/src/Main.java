import javax.swing.SwingUtilities;

import breder.dtl.swing.editor.gui.DesktopFrame;
import breder.util.lookandfeel.LookAndFeel;

public class Main {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        LookAndFeel.getInstance().installSeaglass();
        DesktopFrame.getInstance().setVisible(true);
      }
    });
  }

}
