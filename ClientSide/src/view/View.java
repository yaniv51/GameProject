package view;


import java.io.IOException;
import tasks.Task;
import model.algorithm.State;

public interface View extends Task {

	public void setUserPoints();
	public void startView() throws IOException;
	public void displayCurrentState(State game);
	public String getUserAction();
	public void gameOver(int gameOver);
	public void printHint(String hint);
	
}
