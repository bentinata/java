/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listexample;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 @author bentinata
 */
public class ListExample extends MIDlet implements CommandListener {

	Display display;
	List list;
	Command exitCommand = new Command("Exit", Command.EXIT, 1);
	Command newCommand = new Command("New Item", Command.OK, 1);
	Command renameCommand = new Command("Rename Item", Command.OK, 1);
	Command deleteCommand = new Command("Delete Item", Command.OK, 1);
	Ticker ticker = new Ticker(
		"JENI- Java Education Network Indonesia");
	public ListExample() {
		list = new List("JENI : Contoh List", List.IMPLICIT);
		list.append("List Item #1", null);
		list.append("List Item #2", null);
		list.append("List Item #3", null);
		list.setTicker(ticker);
		list.addCommand(exitCommand);
		list.addCommand(newCommand);
		list.addCommand(renameCommand);
		list.addCommand(deleteCommand);
		list.setCommandListener(this);
	}
	public void startApp() {
		if (display == null) {
			display = Display.getDisplay(this);
			display.setCurrent(list);
		}

	}
	public void pauseApp() {
	}
	public void destroyApp(boolean unconditional) {
	}
	public void commandAction(Command c, Displayable d) {
		if (c == exitCommand) {
			destroyApp(true);
			notifyDestroyed();
		}
		if (c == List.SELECT_COMMAND) {
			int index = list.getSelectedIndex();
			String currentItem = list.getString(index);
		}

	}
}
