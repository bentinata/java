/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HelloMidlet;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 @author bentinata
 */
public class HelloMidlet extends MIDlet implements CommandListener {

	Display display;
	Command exitCommand = new Command("Exit", Command.EXIT, 1);
	Alert helloAlert;
	public HelloMidlet() {
		helloAlert = new Alert("Hello MIDlet", "Hello, world!", null, AlertType.INFO);
		helloAlert.setTimeout(Alert.FOREVER);
		helloAlert.addCommand(exitCommand);
		helloAlert.setCommandListener(this);

	}
	public void startApp() {
		if (display == null) {
			display = Display.getDisplay(this);
		}
		display.setCurrent(helloAlert);
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
