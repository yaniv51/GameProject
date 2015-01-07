package model_;

import java.io.Serializable;

import model.algorithm.State;
import model.domain.ReversiState;
import model.domain.TicTacToeState;


public class Solution implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4368067978565640582L;
	String description;
	State currentState;
	//new
	int gameOver;
	public int getGameOver() {
		return gameOver;
	}
	public void setGameOver(int gameOver) {
		this.gameOver = gameOver;
	}

	
	
	
	//c'tor
	public Solution() {
		description = new String();
		currentState = null;
	}
	
	//get description
	public String getDescription(){
		return description;
	}
	
	//set description
	public void setDescription(String description) {
		this.description = new String (description);
	}
	
	//return current state
	public State getCurrentState() {
		return currentState;
	}
	
	//set current state
	public void setCurrentState(State currentState) {
		if(currentState instanceof TicTacToeState)
			this.currentState = new TicTacToeState(currentState.getTurn(), currentState.getBoardGame(), currentState.getLastMove(), currentState.getSize(), currentState.getScore());
		else if (currentState instanceof ReversiState)
			this.currentState = new ReversiState(currentState.getTurn(), currentState.getBoardGame(), currentState.getLastMove(), currentState.getSize(), currentState.getScore(), ((ReversiState) currentState).getWhiteScore(), ((ReversiState) currentState).getBlackScore(), ((ReversiState) currentState).getWhiteMoves(), ((ReversiState) currentState).getBlackMoves());
	}
	
	
}
