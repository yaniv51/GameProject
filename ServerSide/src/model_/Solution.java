package model_;

import java.io.Serializable;
import model.algorithm.State;
import model.domain.ReversiState;
import model.domain.TicTacToeState;

/**
 * <hl> Solution<hl>
 * is serializable class<p> Including state and description
 */
public class Solution implements Serializable{
	private static final long serialVersionUID = -4368067978565640582L;
	String description;
	State currentState;

	/**
	 * <hl> Solution constructor<hl> <p> 
	 * Initialized variables
	 */
	public Solution() {
		description = new String();
		currentState = null;
	}
	
	/**
	 * <hl> getDescription<hl> <p> 
	 * @return description of solution
	 */
	public String getDescription(){
		return description;
	}
	
	/**
	 * <hl> setDescription<hl> <p> 
	 * Set description of a solution
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = new String (description);
	}
	
	/**
	 * <hl> getCurrentState<hl> <p> 
	 * @return currentState game state
	 */
	public State getCurrentState() {
		return currentState;
	}
	
	/**
	 * <hl> setCurrentState<hl> <p> 
	 * Set solution current state from the state that get
	 * @param currentState game state
	 */
	public void setCurrentState(State currentState) {
		if(currentState instanceof TicTacToeState)
			this.currentState = new TicTacToeState(currentState.getTurn(), currentState.getBoardGame(), currentState.getLastMove(), currentState.getSize(), currentState.getScore());
		else if (currentState instanceof ReversiState)
			this.currentState = new ReversiState(currentState.getTurn(), currentState.getBoardGame(), currentState.getLastMove(), currentState.getSize(), currentState.getScore(), ((ReversiState) currentState).getWhiteScore(), ((ReversiState) currentState).getBlackScore(), ((ReversiState) currentState).getWhiteMoves(), ((ReversiState) currentState).getBlackMoves());
	}
	
	
}
