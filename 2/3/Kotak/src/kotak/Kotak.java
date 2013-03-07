/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kotak;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 @author bentinata
 */
public class Kotak extends MIDlet {

	private Display display;
	HelloCanvas3 canvas;
	public void startApp() {
		if (display == null) {
			canvas = new HelloCanvas3(this);
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
