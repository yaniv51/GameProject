 package model.algorithm;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

@SuppressWarnings("serial")
public abstract class State implements Serializable {
	
	protected int[][] boardGame;
	int score;
	protected int size;
	int turn;
	int lastMove;
	
	//c'tor
	public State(int size) {
		this.size = size;
		boardGame = new int[this.size][this.size];
		for(int row=0 ; row<this.size; row++)
			for(int column=0; column<this.size; column++)
				boardGame[row][column] = 0;
		score = 0;
		turn = 0;
		lastMove = 0;
	}
	
	//default c'tor for serializable
	public State() {
		score = 0;
		turn = 0;
		lastMove = 0;
		this.size = 0;
	}
	
	//c'tor
	public State(int turn, int[][] board,int lastMove, int size, int score) {
		setBoardGame(board);
		this.lastMove = lastMove;
		this.turn = turn;
		this.size = size;
		this.score = score;
	}
	
	//return board game
	public int[][] getBoardGame() {
		return boardGame;
	}

	//copy board game
	public void setBoardGame(int[][] boardGame) {
		int size = boardGame.length;
		this.boardGame = new int[size][size];
		for(int row=0 ; row<size; row++)
			for(int column=0; column<size; column++)
				this.boardGame[row][column] = boardGame[row][column];
	}
	
	//Generate new string for hash code
	public int hashcode() {
		return toString().hashCode();
	}
	
	//heuristic function for a state - check player turn and current state and make a function
	public abstract int Hfunc(int agent);
	
	//get a current state and return all possible moves
	public abstract HashMap<String, State> getAllPossibleMoves();
	
	//make string from array for putting at hash map
	public String toString() {
		String a = " ";
		for(int[] is : this.boardGame)
			a+=Arrays.toString(is);
		return a;
	}
	
	//check if the game is over
	public abstract int gameOver(); 

	//print board
	public abstract void print ();

	
	//getters & setters
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getLastMove() {
		return lastMove;
	}

	public int getCell(int row,int column)
	{
		return boardGame[row][column];
	}
	
	public abstract void setCell(int row, int column, int val);

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setLastMove(int lastMove) {
		this.lastMove = lastMove;
	}

}
