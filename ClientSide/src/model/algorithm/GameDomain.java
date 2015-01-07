package model.algorithm;


public interface GameDomain {
	
	public State getState(); //return game state
	
	public void getSolution(State state, AI ai);
	
	public int playerTurn(int row, int column) throws Exception; //set change for player turn
	
	public int computerTurn(AI ai); // set change for computer turn
	
	public int setSolution(State state); // set state from the state we've get, possible if we already have a solution
	
	public String getHint(AI ai, int depth); // return string to help player
	
	public void setDepth(int hardlevel); // set depth for algorithm
	
	public int getDepth(); // return depth

}
