package view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Image;

public class TicTacToeGameCharcter {

	final Image xImage = new Image(null, "res/tttX.png");
	final Image oImage = new Image(null, "res/tttO.png");

	public void paint(PaintEvent e, int player, int w, int h, int xPos, int yPos) {
		if (player == 1)
			e.gc.drawImage(xImage, 0, 0, 193, 193,xPos, yPos, w, h);
		else //player==2
			e.gc.drawImage(oImage, 0, 0, 193, 193,xPos, yPos, w, h);
	}
}
