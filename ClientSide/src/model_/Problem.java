package model_;

import java.io.Serializable;

import model.algorithm.State;

public class Problem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2707782663110394514L;
	State game;
	String gameDomain;
	String ai;
	String problem;
	int hardLevel;
	
	public String getGameDomain() {
		return gameDomain;
	}


	public void setGameDomain(String gameDomain) {
		this.gameDomain = new String(gameDomain);
	}


	public String getAi() {
		return ai;
	}


	public void setAi(String ai) {
		this.ai = new String (ai);
	}


	//c'tor
	public Problem() {
		problem = new String();
		hardLevel = 0;
		gameDomain = new String();
		ai = new String();
		
	}
	
	
	public int getHardLevel() {
		return hardLevel;
	}

	public void setHardLevel(int hardLevel) {
		this.hardLevel = hardLevel;
	}

	public State getGame() {
		return game;
	}

	public void setGame(State game) {
		this.game = game;
	}
	
	//add string to current problem
	public void addString(String line) {
		problem = new String(problem+" "+line);
	}
	
	//make new empty problem
	public void bZero() {
		problem = new String();
	}

	
	//get + set
	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}
	
}
