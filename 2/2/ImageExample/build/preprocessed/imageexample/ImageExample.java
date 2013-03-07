/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageexample;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 @author bentinata
 */
public class ImageExample extends MIDlet implements CommandListener {

	Display display;
	Form imageForm;
	Command exitCommand = new Command("Exit", Command.EXIT, 1);
	DateField dateonly, timeonly, datetime;
	Ticker ticker = new Ticker("JENI - Java Education Network Indonesia");
	public ImageExample() {
		imageForm = new Form("ImageItem");
		imageForm.addCommand(exitCommand);
		imageForm.setCommandListener(this);
		imageForm.setTicker(ticker);
		try {
			Image img = Image.createImage("/ubuntu.png");
			ImageItem image =
				new ImageItem("JENI", img, Item.LAYOUT_CENTER, "jeni logo");
			imageForm.append(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void startApp() {
		if (display == null) {
			display = Display.getDisplay(this);
			display.setCurrent(imageForm);
		}

	}
	public void pauseApp() {
	}
	public void destroyApp(boolean unconditional) {
	}
	public void commandAction(Command c, Displayable d) {
		if (c == exitCommand) {
			destroyApp(true);
			notifyDestroyed(); // Exit
		}

	}
}
