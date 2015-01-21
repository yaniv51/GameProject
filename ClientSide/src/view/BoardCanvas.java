package view;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import model.algorithm.State;

public abstract class BoardCanvas extends Canvas{
	
	public BoardCanvas(Composite parent, int style) {
		super(parent, style);
	}
	public abstract void PaintSolution(State game);

}
