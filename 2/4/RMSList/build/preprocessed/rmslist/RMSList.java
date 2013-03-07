/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmslist;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.*;

/**
 @author bentinata
 */
public class RMSList extends MIDlet implements CommandListener {

	Display display;
	List recList;
	RecordStore recStore;
	byte[] data = null;
	Command exitCommand = new Command("Exit", Command.EXIT, 1);
	Ticker ticker = new Ticker(
		"JENI - Java Education Network Indonesia");
	public RMSList() {
		recList = new List("Record Store List", List.IMPLICIT);
		dispList();
		recList.setTicker(ticker);
		recList.addCommand(exitCommand);
		recList.setCommandListener(this);
	}
	public void startApp() {
		if (display == null) {
			display = Display.getDisplay(this);
			display.setCurrent(recList);
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
	public void dispList() {
		recList.deleteAll();
		try {
			String[] data = recStore.listRecordStores();
			if (data.length > 0) {
				for (int i = 0; i < data.length; i++) {
					recList.append(data[i], null);
				}
			}
		} catch (Exception e) {
		}
	}
}
