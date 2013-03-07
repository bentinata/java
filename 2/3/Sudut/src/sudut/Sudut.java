/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudut;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 @author bentinata
 */
public class Sudut extends MIDlet {

	private Display display;
	HelloCanvas4 canvas;
	public void startApp() {
		if (display == null) {
			canvas = new HelloCanvas4(this);
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
