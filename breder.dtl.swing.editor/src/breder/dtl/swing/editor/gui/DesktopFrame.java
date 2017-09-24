package breder.dtl.swing.editor.gui;

import javax.swing.JFrame;

import breder.util.swing.BFrame;

public class DesktopFrame extends BFrame {

  public static final String TITLE = "DTL Swing Editor";

  private static final DesktopFrame instance = new DesktopFrame();

  private Editor editor;

  private DesktopFrame() {
    super(null);
    this.setTitle(TITLE);
    this.add(this.editor = new Editor());
    this.setJMenuBar(new DesktopMenu());
    this.setSize(800, 600);
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public Editor getEditor() {
    return this.editor;
  }

  /**
   * Retorna
   * 
   * @return instance
   */
  public static DesktopFrame getInstance() {
    return instance;
  }

}
