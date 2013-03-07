/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellocanvasmidlet;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 @author bentinata
 */
public class HelloCanvasMIDlet extends MIDlet {

	private Display display;
	HelloCanvas canvas;
	Command exitCommand = new Command("Exit", Command.EXIT, 0);
	public void startApp() {
		if (display == null) {
			canvas = new HelloCanvas(this, "Hello World");
			display = Display.getDisplay(this);
		}
		display.setCurrent(canvas);

	}
	public void pauseApp() {
	}
	public void destroyApp(boolean unconditional) {
	}
	protected void Quit() {
		destroyApp(true);
		notifyDestroyed();
	}
}
