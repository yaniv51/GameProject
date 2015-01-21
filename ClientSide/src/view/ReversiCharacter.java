package view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Image;

public class ReversiCharacter {
	final Image reversiRed = new Image(null, "res/redCircle2.png");
	final Image reversiBlue = new Image(null, "res/blueCircle.png");
	
	public ReversiCharacter() {
	}
	
	public void paint(PaintEvent e, int player, int w, int h, int xPos, int yPos) {
		if(player == 1) {
			e.gc.drawImage(reversiBlue, 0, 0, 142, 142,xPos, yPos, w, h);
		}
		else
		{
			e.gc.drawImage(reversiRed, 0, 0, 142, 142,xPos, yPos, w, h);
		}
	}
}
	
