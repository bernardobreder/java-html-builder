package breder.dtl.swing.editor.gui;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import org.gjt.sp.jedit.textarea.StructureMatcher.Match;
import org.gjt.sp.jedit.textarea.TextArea;
import org.gjt.sp.jedit.textarea.TextAreaExtension;

/**
 * Paints the structure match highlight.
 */
public class Highlight extends TextAreaExtension {

  public Highlight(TextArea textArea) {
    this.textArea = textArea;
  }

  @Override
  public void paintValidLine(Graphics2D gfx, int screenLine, int physicalLine,
    int start, int end, int y) {
    Match match = textArea.getStructureMatch();
    if (match != null) {
      paintHighlight(gfx, screenLine, start, end, y, match);
    }
  }

  private int[] getOffsets(int screenLine, Match match) {
    int x1, x2;

    int matchStartLine = textArea.getScreenLineOfOffset(match.start);
    int matchEndLine = textArea.getScreenLineOfOffset(match.end);

    if (matchStartLine == screenLine) {
      x1 = match.start;
    }
    else {
      x1 = textArea.getScreenLineStartOffset(screenLine);
    }

    if (matchEndLine == screenLine) {
      x2 = match.end;
    }
    else {
      x2 = textArea.getScreenLineEndOffset(screenLine) - 1;
    }

    return new int[] { textArea.offsetToXY(x1).x, textArea.offsetToXY(x2).x };
  }

  private void paintHighlight(Graphics gfx, int screenLine, int start, int end,
    int y, Match match) {
    if (match.start >= end || match.end < start) {
      return;
    }

    int matchStartLine = textArea.getScreenLineOfOffset(match.start);
    int matchEndLine = textArea.getScreenLineOfOffset(match.end);

    FontMetrics fm = textArea.getPainter().getFontMetrics();
    int height = fm.getHeight();

    int[] offsets = getOffsets(screenLine, match);
    int x1 = offsets[0];
    int x2 = offsets[1];

    gfx.setColor(textArea.getPainter().getStructureHighlightColor());

    gfx.drawLine(x1, y, x1, y + height - 1);
    gfx.drawLine(x2, y, x2, y + height - 1);

    if (matchStartLine == screenLine || screenLine == 0) {
      gfx.drawLine(x1, y, x2, y);
    }
    else {
      offsets = getOffsets(screenLine - 1, match);
      int prevX1 = offsets[0];
      int prevX2 = offsets[1];

      gfx.drawLine(Math.min(x1, prevX1), y, Math.max(x1, prevX1), y);
      gfx.drawLine(Math.min(x2, prevX2), y, Math.max(x2, prevX2), y);
    }

    if (matchEndLine == screenLine) {
      gfx.drawLine(x1, y + height - 1, x2, y + height - 1);
    }
  }

  private TextArea textArea;
} //}}}