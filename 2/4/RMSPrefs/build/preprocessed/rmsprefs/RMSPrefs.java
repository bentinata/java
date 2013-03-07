/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmsprefs;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.*;
import java.io.*;

/**
 @author bentinata
 */
public class RMSPrefs extends MIDlet implements RecordFilter {

	String searchName = null;
	public boolean matches(byte[] candidate) {
		boolean isaMatch = false;
		try {
			ByteArrayInputStream bIn = new ByteArrayInputStream(candidate);
			DataInputStream dIn = new DataInputStream(bIn);
			String item = dIn.readUTF();
			if (searchName != null) {
				if (searchName.indexOf(item) != -1) {
					isaMatch = true;
				}
			}
			dIn.close();
			bIn.close();
		} catch (Exception e) {
		}
		return (isaMatch);
	}
	public String readVar(RecordStore recStore, String name, String defaultValue) {
		String value = defaultValue;
		searchName = name;
		try {
// Load contents of Record Store
			RecordEnumeration enumerator = recStore.enumerateRecords(this, null, false);
// get only the first matching record
			if (enumerator.hasNextElement()) {
// Get the next record
				byte[] recBytes = enumerator.nextRecord();
				ByteArrayInputStream in = new ByteArrayInputStream(recBytes);
				DataInputStream dIn = new DataInputStream(in);
				String sname = dIn.readUTF();
				value = dIn.readUTF();
				dIn.close();
				in.close();
			}
		} catch (Exception e) {
		}
		return (value);
	}
	public void writeString(RecordStore recStore, String name, String value) {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			DataOutputStream dOut = new DataOutputStream(out);
// Store the name
			dOut.writeUTF(name);
// Store the value
			dOut.writeUTF(value);
			byte[] bytes = out.toByteArray();
// Write the Record into the Store
			recStore.addRecord(bytes, 0, bytes.length);
			dOut.close();
			out.close();
		} catch (Exception e) {
		}
	}
	public void startApp() {
	}
	public void pauseApp() {
	}
	public void destroyApp(boolean unconditional) {
	}
}
