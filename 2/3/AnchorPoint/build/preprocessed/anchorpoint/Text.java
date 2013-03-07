/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anchorpoint;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 @author bentinata
 */
public class Text extends MIDlet {

	private Display display;
	private TextCanvas canvas;
	private AnchorPtList anchorPt;
	private int anchorPoint = Graphics.BASELINE | Graphics.HCENTER;
	public Text() {
		display = Display.getDisplay(this);
		canvas = new TextCanvas(this);
		anchorPt = new AnchorPtList("Anchor point", List.IMPLICIT, this);
	}
	protected void startApp() {
		showCanvas();
	}
	protected void pauseApp() {
	}
	protected void destroyApp(boolean unconditional) {
	}
	public void showCanvas() {
		display.setCurrent(canvas);
	}
	public void showList() {
		display.setCurrent(anchorPt);
	}
	public int getAnchorPoint() {
		return anchorPoint;
	}
	public void setAnchorPoint(int anchorPoint) {
		this.anchorPoint = anchorPoint;
	}
	public void exitMIDlet() {
		destroyApp(true);
		notifyDestroyed();
	}
}
