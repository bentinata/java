/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gariswarna;

import javax.microedition.lcdui.*;

/**

 @author bentinata
 */
public class HelloCanvas2 extends Canvas implements CommandListener {

	private Command exitCommand = new Command("Exit", Command.EXIT, 0);
	private GarisWarna line;
	public HelloCanvas2(GarisWarna line) {
		this.line = line;
		addCommand(exitCommand);
		setCommandListener(this);
	}
	protected void paint(Graphics g) {
		g.setColor(255, 255, 255);
		g.fillRect(0, 0, getHeight(), getWidth());
		g.setColor(255, 0, 0);
		g.drawLine(0, 0, getWidth() - 1, getHeight() - 1);
		g.setColor(0, 255, 0);
		g.drawLine(0, getHeight() / 2, getWidth() - 1, getHeight() / 2);
		g.setColor(0, 0, 255);
		g.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
		g.setColor(0, 0, 0);
		g.drawLine(0, getHeight() - 1, getWidth() - 1, 0);
	}
	public void commandAction(Command c, Displayable d) {
		if (c == exitCommand) {
			line.Quit();
		}
	}
}
