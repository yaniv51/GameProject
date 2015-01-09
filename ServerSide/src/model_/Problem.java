package model_;

import java.io.Serializable;

import model.algorithm.State;

public class Problem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2707782663110394514L;
	State gameState;
	String gameDomain;
	String ai; // algorithm
	int status; // 1. new game, 2.computer turn, 3. hint, 4. exit
	int hardLevel;
	
	public String getGameDomain() {
		return gameDomain;
	}

	//c'tor
	public Problem() {
		status = 1;
		hardLevel = 0;
		gameDomain = new String();
		ai = new String();
		
	}
	
	//set game domain name
	public void setGameDomain(String gameDomain) {
		this.gameDomain = new String(gameDomain);
	}

	//get + set algorithm name name
	public String getAi() {
		return ai;
	}
	public void setAi(String ai) {
		this.ai = new String (ai);
	}
	
	//get and set hard level
	public int getHardLevel() {
		return hardLevel;
	}
	public void setHardLevel(int hardLevel) {
		this.hardLevel = hardLevel;
	}
	
	//get and set game state
	public State getGame() {
		return gameState;
	}
	public void setGame(State game) {
		this.gameState = game;
	}
	
	//get + set
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
