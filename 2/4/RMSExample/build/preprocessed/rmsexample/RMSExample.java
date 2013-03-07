/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmsexample;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.*;

/**
 @author bentinata
 */
public class RMSExample extends MIDlet implements CommandListener {

	Display display;
	List recList;
	RecordStore recStore;
	byte[] data = null;
	Command exitCommand = new Command("Exit", Command.EXIT, 1);
	Command newCommand = new Command("New Item", Command.OK, 1);
	Ticker ticker = new Ticker(
		"JENI - Java Education Network Indonesia");
	public RMSExample() {
		recList = new List("Record Store", List.IMPLICIT);
		dispRec();
		recList.setTicker(ticker);
		recList.addCommand(exitCommand);
		recList.addCommand(newCommand);
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
		if (c == newCommand) {
			try {
// Buka dan buatlah record store dengan nama “RmsExample1”
				recStore = RecordStore.openRecordStore("RmsExample1", true);
// Ini adalah String yang akan kita masukkan kedalam record
				String newItem = "Record #" + recStore.getNextRecordID();
// Konversikan String ke byte array
				data = newItem.getBytes();
// Tulislah record kedalam record store
				recStore.addRecord(data, 0, data.length);
				recStore.closeRecordStore();
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			dispRec();
		}
	}
	public void dispRec() {
		recList.deleteAll();
		String[] data = getRecordList();
		if (data.length > 0) {
			for (int i = 0; i < data.length; i++) {
				recList.append(data[i], null);
			}
		}
	}
	public String[] getRecordList() {
		try {
// Buka dan buatlah record store dengan nama “RmsExample1”
			recStore = RecordStore.openRecordStore("RmsExample1", true);
// Masukkan content kedalam record store
			String[] dataList = new String[recStore.getNumRecords()];
			if (recStore.getNumRecords() > 0) {
				for (int recId = 1; recId <= recStore.getNumRecords(); recId++) {
					int size = recStore.getRecordSize(recId);
					if (data == null || data.length < size) {
						data = new byte[size + 20];
					}
// getRecord memiliki return value berupa panjang dari record
					int recLength = recStore.getRecord(recId, data, 0);
// Mengkonversikan byte array menjadi String
					dataList[recId - 1] = new String(data, 0, recLength);
				}
			}
			recStore.closeRecordStore();
			return dataList;
		} catch (Exception e) {
			return null;
		}
	}
}