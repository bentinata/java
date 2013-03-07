/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anchorpoint;

import javax.microedition.lcdui.*;

/**

 @author bentinata
 */
public class TextCanvas extends Canvas implements CommandListener {

	private Command cmExit;
	private Command cmGetAnchorPt;
	private Text midlet;
	public TextCanvas(Text midlet) {
		this.midlet = midlet;
		cmExit = new Command("Exit", Command.EXIT, 1);
		cmGetAnchorPt = new Command("Anchor", Command.SCREEN, 2);
		addCommand(cmExit);
		addCommand(cmGetAnchorPt);
		setCommandListener(this);
	}
	protected void paint(Graphics g) {
		int xcenter = getWidth() / 2,
			ycenter = getHeight() / 2;
		g.setColor(255, 255, 255);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(0, 0, 0);
		g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN,
			Font.SIZE_MEDIUM));
		g.drawLine(xcenter, ycenter, xcenter, ycenter);
		g.drawString("Test Anchor Point", xcenter, ycenter, midlet.getAnchorPoint());
	}
	public void commandAction(Command c, Displayable d) {
		if (c == cmExit) {
			midlet.exitMIDlet();
		} else if (c == cmGetAnchorPt) {
// panggil method untuk menampilkan list
			midlet.showList();
		}
	}
}
class AnchorPtList extends List implements CommandListener {

	private Text midlet;
	public AnchorPtList(String title, int listType, Text midlet) {
		super(title, listType);
		this.midlet = midlet;
		append("Top/Left", null);
		append("Top/HCenter", null);
		append("Top/Right", null);
		append("Baseline/Left", null);
		append("Baseline/HCenter", null);
		append("Baseline/Right", null);
		append("Bottom/Left", null);
		append("Bottom/HCenter", null);
		append("Bottom/Right", null);
		setCommandListener(this);
	}
	public void commandAction(Command c, Displayable s) {
		switch (getSelectedIndex()) {
		case 0:
			midlet.setAnchorPoint(Graphics.TOP | Graphics.LEFT);
			break;
		case 1:
			midlet.setAnchorPoint(Graphics.TOP | Graphics.HCENTER);
			break;
		case 2:
			midlet.setAnchorPoint(Graphics.TOP | Graphics.RIGHT);
			break;
		case 3:
			midlet.setAnchorPoint(Graphics.BASELINE | Graphics.LEFT);
			break;
		case 4:
			midlet.setAnchorPoint(Graphics.BASELINE | Graphics.HCENTER);
			break;
		case 5:
			midlet.setAnchorPoint(Graphics.BASELINE | Graphics.RIGHT);
			break;
		case 6:
			midlet.setAnchorPoint(Graphics.BOTTOM | Graphics.LEFT);
			break;
		case 7:
			midlet.setAnchorPoint(Graphics.BOTTOM | Graphics.HCENTER);
			break;
		case 8:
			midlet.setAnchorPoint(Graphics.BOTTOM | Graphics.RIGHT);
			break;
		default:
			midlet.setAnchorPoint(Graphics.BASELINE | Graphics.HCENTER);
		}
		midlet.showCanvas();
	}
}
