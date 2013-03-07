/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alertexample;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 @author bentinata
 */
public class AlertExample extends MIDlet implements CommandListener {

	Display display;
	Form mainForm;
	Command exitCommand = new Command("Exit", Command.EXIT, 0);
	Command okCommand = new Command("Ok", Command.OK, 0);
	Gauge gauge = new Gauge(null, false, 5, 0);
	Command[] commands = {
		new Command("Alarm", Command.OK, 0),
		new Command("Confirmation", Command.OK, 0),
		new Command("Info", Command.OK, 0),
		new Command("Warning", Command.OK, 0),
		new Command("Error", Command.OK, 0),
		new Command("Modal", Command.OK, 0)
	};
	Alert[] alerts = {
		new Alert("Alarm Alert", "Example of an Alarm type of Alert", null, AlertType.ALARM),
		new Alert("Confirmation Alert", "Example of an CONFIRMATION type of Alert", null, AlertType.CONFIRMATION),
		new Alert("Info Alert", "Example of an INFO type of Alert", null, AlertType.INFO),
		new Alert("Warning Alert", "Example of an WARNING type of Alert, w/ gauge indicator", null, AlertType.WARNING),
		new Alert("Error Alert", "Example of an ERROR type of Alert, w/ an 'OK' Command", null, AlertType.ERROR),
		new Alert("Modal Alert", "Example of an modal Alert: timeout = FOREVER", null, AlertType.ERROR),};
	public void AlertExample() {
		mainForm = new Form("JEDI: Alert Example");
		mainForm.addCommand(exitCommand);
		for (int i = 0; i < commands.length; i++) {
			mainForm.addCommand(commands[i]);
		}
		mainForm.setCommandListener(this);
		alerts[3].setIndicator(gauge);
		alerts[3].setTimeout(5000);
		alerts[4].addCommand(okCommand);
		alerts[5].setTimeout(Alert.FOREVER);
	}
	public void startApp() {
		if (display == null) {
			display = Display.getDisplay(this);
		}
			display.setCurrent(mainForm);
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
		for (int i = 0; i < commands.length; i++) {
			if (c == commands[i]) {
				display.setCurrent(alerts[i]);
			}
		}

	}
}
