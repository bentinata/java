/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stringexample;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 @author bentinata
 */
public class StringExample extends MIDlet implements CommandListener, ItemCommandListener {

	Display display;
	Form stringForm;
	Command exitCommand = new Command("Exit", Command.EXIT, 1);
	DateField dateonly, timeonly, datetime;
	public StringExample() {
		stringForm = new Form("StringField Modes");
		stringForm.addCommand(exitCommand);
		stringForm.setCommandListener(this);
		StringItem plain = new StringItem("Plain", "Plain Text", Item.PLAIN);
		StringItem hyperlink = new StringItem("Hyperlink", "http://www.sun.com",
			Item.HYPERLINK);
		hyperlink.setDefaultCommand(new Command("Set", Command.ITEM, 0));
		hyperlink.setItemCommandListener(this);
		StringItem button = new StringItem("Button", "Click me", Item.BUTTON);
		button.setDefaultCommand(new Command("Set", Command.ITEM, 0));
		button.setItemCommandListener(this);
		stringForm.append(plain);
		stringForm.append(hyperlink);
		stringForm.append(button);
	}
	public void startApp() {
		if (display == null) {
			display = Display.getDisplay(this);
			display.setCurrent(stringForm);
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
	public void commandAction(Command c, Item item) {
		if (item.getLabel().equals("Button")) {
//kerjakan Sesuatu
		}
		if (item.getLabel().equals("Hyperlink")) {
//kerjakan Sesuatu
		}

	}
}
