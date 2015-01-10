import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;

/**
 * This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com)
 * Copyright (c) 1997 by David Flanagan
 * This example is provided WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, modify, and distribute it for non-commercial purposes.
 * For any commercial use, see http://www.davidflanagan.com/javaexamples
 * A simple applet that uses the Java 1.0 event handling model
 */
public class Scribble extends Applet {
  private int lastX, lastY;
  private Button clearButton;
  private Graphics graphics;

  /** Initialize the button and the Graphics object. */
  @Override
  public void init() {
    clearButton = new Button("Clear");
    this.add(clearButton);
    graphics = this.getGraphics();
  }

  /**
   * Respond to mouse clicks.
   * @param e The Event.
   * @param x The X coordinate
   * @param y The Y coordinate.
   * @return True always.
   */
  @Override
  public boolean mouseDown(Event e, int x, int y) {
    lastX = x; lastY = y;
    return true;
  }

  /**
   * Respond to mouse drags.
   * @param e The Event.
   * @param x The X coordinate.
   * @param y The Y coordinate.
   * @return True always.
   */
  public boolean mouseDrag(Event e, int x, int y) {
    graphics.setColor(Color.black);
    graphics.drawLine(lastX, lastY, x, y);
    lastX = x;
    lastY = y;
    return true;
  }

  /**
   * Respond to key presses.
   * @param e The event.
   * @param key The Keypress
   * @return Return true if keypress is 'c'.
   */
  public boolean keyDown(Event e, int key) {
    if ((e.id == Event.KEY_PRESS) && (key == 'c')) {
      clear();
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Respond to button clicks.
   * @param e The event.
   * @param arg An argument, ignored.
   * @return True if the clearButton is the action.
   */
  public boolean action(Event e, Object arg) {
    if (e.target == clearButton) {
      clear();
      return true;
    }
    else {
      return false;
    }
  }
  /**
   * Convenience method to erase the scribble.
   */
  public void clear() {
    graphics.setColor(this.getBackground());
    graphics.fillRect(0, 0, bounds().width, bounds().height);
  }
}