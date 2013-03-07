/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudut;

import javax.microedition.lcdui.*;

/**

 @author bentinata
 */
public class HelloCanvas4 extends Canvas implements CommandListener {

	private Command exitCommand = new Command("Exit", Command.EXIT, 1);
	private Sudut angle;
	public HelloCanvas4(Sudut angle) {
		this.angle = angle;
		addCommand(exitCommand);
		setCommandListener(this);
	}
	protected void paint(Graphics g) {
		g.setColor(255, 255, 255);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(255, 0, 0);
		g.drawArc(18, 18, 50, 50, 0, 360);
		g.setColor(0, 255, 0);
		g.drawArc(40, 40, 100, 120, 0, 180);
		g.setColor(0, 0, 255);
		g.fillArc(100, 200, 80, 100, 0, 90);
	}
	public void commandAction(Command c, Displayable d) {
		if (c == exitCommand) {
			angle.Quit();
		}
	}
}
