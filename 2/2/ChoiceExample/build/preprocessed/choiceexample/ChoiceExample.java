/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package choiceexample;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 @author bentinata
 */
public class ChoiceExample extends MIDlet implements CommandListener {

	Display display;
	Form choiceForm;
	Command exitCommand = new Command("Exit", Command.EXIT, 1);
	ChoiceGroup choiceExclusive, choiceMultiple, choicePopup;
	public ChoiceExample() {
		choiceForm = new Form("Choice Group Types");
		choiceForm.addCommand(exitCommand);
		choiceForm.setCommandListener(this);
		choiceExclusive = new ChoiceGroup("Exclusive", Choice.EXCLUSIVE);
		choiceExclusive.append("Male", null);
		choiceExclusive.append("Female", null);
		choiceForm.append(choiceExclusive);
		choiceMultiple = new ChoiceGroup("Multiple", Choice.MULTIPLE);
		choiceMultiple.append("Apple", null);
		choiceMultiple.append("Orange", null);
		choiceMultiple.append("Grapes", null);
		choiceForm.append(choiceMultiple);
		choicePopup = new ChoiceGroup("Popup", Choice.POPUP);
		choicePopup.append("Asia", null);
		choicePopup.append("Europe", null);
		choicePopup.append("Americas", null);
		choiceForm.append(choicePopup);
	}
	public void startApp() {
		if (display == null) {
			display = Display.getDisplay(this);
			display.setCurrent(choiceForm);
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
