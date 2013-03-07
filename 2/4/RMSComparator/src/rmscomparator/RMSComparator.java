/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmscomparator;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.*;
import java.io.*;

/**
 @author bentinata
 */
public class RMSComparator extends MIDlet implements CommandListener, RecordComparator {

	Display display;
	List recList;
	RecordStore recStore;
	byte[] data = null;
	Command exitCommand = new Command("Exit", Command.EXIT, 1);
	Command newCommand = new Command("New Item", Command.OK, 1);
	Ticker ticker = new Ticker(
		"JENI - Java Education Network Indonesia");
	public RMSComparator() {
		recList = new List("Record List", List.IMPLICIT);
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
// Buka dan atau buatlah record store dengan nama “RmsComparator”
				recStore = RecordStore.openRecordStore("RmsComparator", true);
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				DataOutputStream dOut = new DataOutputStream(out);
// Menyimpan sebuah integer
				dOut.writeInt(recStore.getNextRecordID() * recStore.getNextRecordID());
// Menyimpan sebuah string
				dOut.writeUTF("Record #" + recStore.getNextRecordID());
				byte[] bytes = out.toByteArray();
// Menuliskan Record pada Store
				recStore.addRecord(bytes, 0, bytes.length);
				dOut.close();
				out.close();
				recStore.closeRecordStore();
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			dispRec();
		}
	}
	public void dispRec() {
		recList.deleteAll();
		try {
// Membuka atau membuat sebuah record store dengan nama "RmsComparator"
			recStore = RecordStore.openRecordStore("RmsComparator", true);
// Mengambil isi dari record store
			RecordEnumeration enumerator = recStore.enumerateRecords(null, this, false);
			while (enumerator.hasNextElement()) {
// Menuju Record selanjutnya
				byte[] recBytes = enumerator.nextRecord();
				ByteArrayInputStream in = new ByteArrayInputStream(recBytes);
				DataInputStream dIn = new DataInputStream(in);
				int count = dIn.readInt();
				String item = dIn.readUTF();
				recList.append(count + ", " + item, null);
				dIn.close();
				in.close();
			}
			recStore.closeRecordStore();
		} catch (Exception e) {
		}
	}
	public int compare(byte[] rec1, byte[] rec2) {
		String record1 = new String(rec1).toUpperCase();
		String record2 = new String(rec2).toUpperCase();
//Sorting Ascending
		if (record1.compareTo(record2) < 0) {
			return (PRECEDES);
		} else {
			if (record1.compareTo(record2) > 0) {
				return (FOLLOWS);
			} else {
				return (EQUIVALENT);
			}
		}
	}
}
