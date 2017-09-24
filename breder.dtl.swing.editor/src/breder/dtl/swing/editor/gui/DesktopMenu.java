package breder.dtl.swing.editor.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import breder.dtl.swing.editor.task.NewFileTask;
import breder.dtl.swing.editor.task.OpenTask;
import breder.dtl.swing.editor.task.SaveAsTask;
import breder.dtl.swing.editor.task.SaveTask;
import breder.util.swing.BMenuItem;

public class DesktopMenu extends JMenuBar {

  public DesktopMenu() {
    this.add(this.buildFileMenu());
  }

  private JMenu buildFileMenu() {
    JMenu menu = new JMenu("File");
    menu.add(this.buildFileNew());
    menu.add(this.buildFileOpen());
    menu.add(this.buildFileSave());
    menu.add(this.buildFileSaveAs());
    menu.add(new JSeparator());
    menu.add(this.buildFileQuit());
    return menu;
  }

  private JMenuItem buildFileQuit() {
    return new BMenuItem("Quit", new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        DesktopFrame.getInstance().close();
      }
    }, "ctrl Q");
  }

  private JMenuItem buildFileNew() {
    return new BMenuItem("New", new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new NewFileTask().start();
      }
    }, "ctrl N");
  }

  private JMenuItem buildFileOpen() {
    return new BMenuItem("Open", new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new OpenTask().start();
      }
    }, "ctrl O");
  }

  private JMenuItem buildFileSaveAs() {
    return new BMenuItem("SaveAs", new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new SaveAsTask().start();
      }
    }, "ctrl shift S");
  }

  private JMenuItem buildFileSave() {
    return new BMenuItem("Save", new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new SaveTask().start();
      }
    }, "ctrl S");
  }

}
