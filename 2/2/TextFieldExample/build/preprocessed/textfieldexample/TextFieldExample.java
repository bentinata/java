/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package textfieldexample;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 @author bentinata
 */
public class TextFieldExample extends MIDlet implements CommandListener {

	Display display;
	Form textForm;
	Command exitCommand = new Command("Exit", Command.EXIT, 1);
	DateField dateonly, timeonly, datetime;
	Ticker ticker = new Ticker(
		"JENI - Java Education Network Indonesia");
	public void TextFieldExample() {
		textForm = new Form("TextField Types");
		textForm.addCommand(exitCommand);
		textForm.setCommandListener(this);
		TextField ANY = new TextField("ANY", "", 64, TextField.ANY);
		TextField EMAILADDR =
			new TextField("EMAILADDR", "", 64, TextField.EMAILADDR);
		TextField NUMERIC =
			new TextField("NUMERIC", "", 64, TextField.NUMERIC);
		TextField PHONENUMBER =
			new TextField("PHONENUMBER", "", 64, TextField.PHONENUMBER);
		TextField URL =
			new TextField("URL", "", 64, TextField.URL);
		TextField DECIMAL =
			new TextField("DECIMAL", "", 64, TextField.DECIMAL);
		textForm.append(ANY);
		textForm.append(EMAILADDR);
		textForm.append(NUMERIC);
		textForm.append(PHONENUMBER);
		textForm.append(URL);
		textForm.append(DECIMAL);
		textForm.setTicker(ticker);
	}
	public void startApp() {
		if (display == null) {
			display = Display.getDisplay(this);
			display.setCurrent(textForm);
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
