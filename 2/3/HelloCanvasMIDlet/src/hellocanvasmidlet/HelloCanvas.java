/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellocanvasmidlet;

import javax.microedition.lcdui.*;

/**

 @author bentinata
 */
public class HelloCanvas extends Canvas implements CommandListener {

	private Command exitCommand = new Command("Exit", Command.EXIT, 0);
	private Command menuCommand = new Command("Menu", Command.OK, 0);
	private HelloCanvasMIDlet midlet;
	private String text;
	public HelloCanvas(HelloCanvasMIDlet midlet, String text) {
		this.midlet = midlet;
		this.text = text;
		addCommand(exitCommand);
		setCommandListener(this);
	}
	protected void paint(Graphics g) {
		g.setColor(255, 255, 255);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(0, 0, 0);
		g.drawString(text, getWidth() / 2, getHeight() / 2, Graphics.TOP
			| Graphics.HCENTER);
	}
	public void commandAction(Command c, Displayable d) {
		if (c == exitCommand) {
			midlet.Quit();
		}
	}
}
