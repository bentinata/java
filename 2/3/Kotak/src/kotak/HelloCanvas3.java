/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kotak;

import javax.microedition.lcdui.*;

/**

 @author bentinata
 */
public class HelloCanvas3 extends Canvas implements CommandListener {

	private Command exitCommand = new Command("Exit", Command.EXIT, 7);
	private Kotak segiempat;
	public HelloCanvas3(Kotak segiempat) {
		this.segiempat = segiempat;
		addCommand(exitCommand);
		setCommandListener(this);
	}
	protected void paint(Graphics g) {
		g.setColor(255, 255, 255);
		g.fillRect(0, 0, getWidth(), getHeight());
//menggambar kotak bewarna kuning
		g.setColor(0, 0, 0);
		g.drawRect(8, 8, 64, 32);
		g.setColor(255, 255, 0);
		g.fillRect(8, 8, 64, 32);
//menggambar berbagai macam jenis kotak
		g.setColor(0, 0, 0);
		g.drawRect(8, 50, 88, 44);
		g.drawRoundRect(108, 50, 88, 44, 18, 18);
		g.fillRect(8, 120, 88, 44);
		g.fillRoundRect(108, 120, 88, 44, 18, 18);
	}
	public void commandAction(Command c, Displayable d) {
		if (c == exitCommand) {
			segiempat.Quit();
		}
	}
}
