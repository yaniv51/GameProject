package model_;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Observable;

import model.algorithm.AI;
import model.algorithm.GameDomain;
import model.algorithm.State;

public class MyModel extends Observable implements Model {

	@SuppressWarnings("unused")
	private AI ai;
	private GameDomain game;
	private algorithmFactory algorithmFactory;
	private GameDomainFactory gameFactory;
	private Solution solution;
	private int hardLevel;
	private int gameOver;
	private String hintGame;
	private int hintDepth;
	private Problem prob;
	private InputStream input;
	private OutputStream output;

	// c'tor
	public MyModel(InputStream in, OutputStream out) {
		algorithmFactory = new algorithmFactory();
		gameFactory = new GameDomainFactory();
		this.gameOver = -1;
		solution = new Solution();
		hintGame = new String();
		hintDepth = 0;
		prob = new Problem();
		input = in;
		output = out;
	}

	// get domain name and use domain factory for getting the right domain
	@Override
	public void selectDomain(String domainName) {
		game = this.gameFactory.createGame(domainName);
		prob.setGameDomain(domainName);
	}

	// get algorithm name and use algorithm factory for getting the right
	// algorithm
	@Override
	public void selectAlgorithm(String algorithmName) {
		ai = this.algorithmFactory.createAlgorithm(algorithmName);
		prob.setAi(algorithmName);
	}

	// manage game
	public void gameManager(int row, int column) {
		// set player turn
		try {
			gameOver = game.playerTurn(row, column);
			System.out.println("end of player turn. now computer");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// if not a valid move - give user another opportunity
			gameOver = -1;
			this.setChanged();
			this.notifyObservers();
		}

		// check if winner
		// if is - notify observers
		if (gameOver != -1) {
			this.setChanged();
			this.notifyObservers();
		} else {
			prob.setGame(game.getState());
			// solve domain - send problem to server
			this.solveDomain();
		}
		// have a solution - notify
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void solveDomain() {
		// send server a problem
		try {
			new ObjectOutputStream(output).writeObject(prob);
			output.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// wait for a solution
		solution = null;
		try {
			solution = (Solution) new ObjectInputStream(input).readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		gameOver = game.setSolution(solution.getCurrentState());
	}

	// when user enter "exit" -> send to server finish connection
	public void saveGame() throws Exception {
		// have to change problem to exit
	}

	// get solution
	public Solution getSolution() {
		return solution;
	}

	// return hard level
	public int getHardLevel() {
		return hardLevel;
	}

	// get hard level and set at game domain
	public void setHardLevel(int depth) {
		this.hardLevel = depth;
		game.setDepth(this.hardLevel);
		prob.setHardLevel(depth);
	}

	// return if there is a winner/draw/more moves
	public int getGameOver() {
		return this.gameOver;
	}

	// return current game state
	public State getState() {
		return game.getState();
	}

	// get hint for user turn
	@Override
	public void getHint() {
		// send server client want an hint
		// clientOut.println("hint "+Integer.toString(hintDepth));

		// wait for solution
		/*
		 * try { hintGame = (String) clientIn.readObject(); } catch
		 * (ClassNotFoundException | IOException e) { e.printStackTrace(); }
		 */
		this.setChanged();
		this.notifyObservers();
	}

	// return hint depth
	public int getHintDepth() {
		return hintDepth;
	}

	// set hint depth
	public void setHintDepth(int depth) {
		this.hintDepth = depth;
	}

	// return hint and before return change original data member to empty string
	public String getHintString() {
		String hint = new String();
		if (hintGame.isEmpty() == false) {
			hint = new String(hintGame);
			hintGame = new String();
		}
		return hint;
	}

}
