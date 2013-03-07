/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellojeni;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 @author bentinata
 */
public class HelloJENI extends MIDlet {

	private Display display;
	HelloCanvas1 canvas;
	public void startApp() {
		if (display == null) {
			canvas = new HelloCanvas1(this);
			display = Display.getDisplay(this);
		}
		display.setCurrent(canvas);
	}
	public void pauseApp() {
	}
	public void destroyApp(boolean unconditional) {
	}
	protected void Quit() {
		destroyApp(true);
		notifyDestroyed();
	}
}
class HelloCanvas1 extends Canvas implements CommandListener {

	private Command exitCommand = new Command("Exit", Command.EXIT, 0);
	private HelloJENI jeni;
	public HelloCanvas1(HelloJENI jeni) {
		this.jeni = jeni;
		addCommand(exitCommand);
		setCommandListener(this);
	}
	protected void paint(Graphics g) {
		g.setColor(255, 255, 255);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(255, 0, 0);
		g.drawString("JENI", getWidth() / 2, getHeight() / 2, Graphics.TOP
			| Graphics.HCENTER);
		g.setColor(0, 0, 255);
		Font font = g.getFont();
		g.drawString("JAVA EDUCATION NETWORKINDONESIA", getWidth() / 2, getHeight() / 2 + font.getHeight(), Graphics.TOP | Graphics.HCENTER);
	}
	public void commandAction(Command c, Displayable d) {
		if (c == exitCommand) {
			jeni.Quit();
		}
	}
}
