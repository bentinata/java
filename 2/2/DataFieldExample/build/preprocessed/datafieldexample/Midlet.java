/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datafieldexample;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 @author bentinata
 */
public class Midlet extends MIDlet implements CommandListener {

	Display display;
	Form dateForm;
	Command exitCommand = new Command("Exit", Command.EXIT, 1);
	DateField dateonly, timeonly, datetime;
	public void DateFieldExample() {
		dateForm = new Form("DateField Modes");
		dateForm.addCommand(exitCommand);
		dateForm.setCommandListener(this);
		DateField dateonly =
			new DateField("Birthday (DATE)", DateField.DATE);
		DateField timeonly =
			new DateField("Set Alarm (TIME)", DateField.TIME);
		DateField datetime =
			new DateField("Departure (DATE_TIME)", DateField.DATE_TIME);
		dateForm.append(dateonly);
		dateForm.append(timeonly);
		dateForm.append(datetime);
	}
	public void startApp() {
		if (display == null) {
			display = Display.getDisplay(this);
			display.setCurrent(dateForm);
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
