package model_;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observable;

import properties.MyProperties;
import properties.PropertiesHandler;
import model.algorithm.AI;
import model.algorithm.GameDomain;
import model.algorithm.State;
import model.domain.ReversiState;

public class BoardGameModel extends Observable implements Model {

	@SuppressWarnings("unused")
	private AI ai;
	private GameDomain game;
	private algorithmFactory algorithmFactory;
	private GameDomainFactory gameFactory;
	private Solution solution;
	private int hardLevel;
	private int gameOver;
	private String hintGame;
	private Problem prob;
	private InputStream input;
	private OutputStream output;
	private MyProperties properties;
	private PropertiesHandler properHendler;
	private Socket myServer;
	private boolean firstConnection;
	private boolean haveConnection;
	private boolean propertiesLoaded;
	
	// c'tor
	public BoardGameModel() {
		algorithmFactory = new algorithmFactory();
		gameFactory = new GameDomainFactory();
		this.gameOver = -1;
		solution = new Solution();
		hintGame = new String();
		prob = new Problem();
		properties = new MyProperties();
		properHendler = new PropertiesHandler();
		firstConnection = true;
		haveConnection = false;
		propertiesLoaded = false;
	}
	
	//load properties
	public void loadProperties() throws FileNotFoundException {
		if(propertiesLoaded == false) {
			properties = properHendler.readProperties();
			propertiesLoaded = true;
		}
	}

	// get domain name and use domain factory for getting the right domain
	@Override
	public void selectDomain(String domainName) {
		game = this.gameFactory.createGame(domainName);
		if(prob.getStatus() != 1) // if client choose to start again a game after finished, initialized new Problem
			prob = new Problem();
		prob.setGameDomain(domainName);
		firstConnection = true;
	}

	// get algorithm name and use algorithm factory for getting the right
	@Override
	public void selectAlgorithm(String algorithmName) {
		ai = this.algorithmFactory.createAlgorithm(algorithmName);
		//set problem algorithm
		prob.setAi(algorithmName);
	}

	// manage game
	public void gameManager(int row, int column) throws Exception {
		// set player turn
		gameOver = game.playerTurn(row, column);
		// have a solution - notify
		this.setChanged();
		this.notifyObservers("Computer Turn");
	}

	@Override
	public void solveDomain() throws IOException, ClassNotFoundException {
		if((firstConnection == true) && (haveConnection == false)) {
			//load properties and connect to server
			System.out.println("connect to server and load properties");
			connectToServer();
		}
		
		if(game instanceof ReversiState)
		{
			ReversiState tempGame = (ReversiState) game.getState();
			//if computer has no more moves -> skip turn
			if(tempGame.getWhiteMoves().isEmpty() == true){
				System.out.println("no white moves");
				this.setChanged();
				this.notifyObservers();
			}
		}
		//set problem state to be the current state
		prob.setGame(game.getState());
		if(firstConnection == false) 
			prob.setStatus(2);
		// send server a problem
		new ObjectOutputStream(output).writeObject(prob);
		output.flush();
		// wait for a solution
		solution = null;
		solution = (Solution) new ObjectInputStream(input).readObject();
		gameOver = game.setSolution(solution.getCurrentState());
		//disconnect from server
		firstConnection = false;
		// have a solution - notify
		
		if(game instanceof ReversiState)
		{
			ReversiState tempGame = (ReversiState) game.getState();
			//if player has no more moves -> start automaticly computer turn
			if(tempGame.getBlackMoves().isEmpty() == true){
				System.out.println("no black moves");
				this.setChanged();
				this.notifyObservers("Computer Turn");
			}
		}
		
		this.setChanged();
		this.notifyObservers();
	}

	// when user enter "exit" -> send to server finish connection
	public void saveGame() throws IOException  {
		//make new problem to be the smallest that possible
		prob = new Problem();
		prob.setStatus(4);
		new ObjectOutputStream(output).writeObject(prob);
		disconnect();
		properHendler.writeProperties(properties);
	}

	// get solution
	public Solution getSolution() {
		return solution;
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
	public void getHint() throws Exception {
		// send server client want an hint
		if(haveConnection == false)
			throw new Exception("You are not connected to the server");
		if(firstConnection == true)
			throw new Exception("You are not connected to the server");
		prob.setStatus(3);
		prob.setGame(game.getState());
		
		new ObjectOutputStream(output).writeObject(prob);
		output.flush();
		
		//wait for solution
		hintGame = (String)new ObjectInputStream(input).readObject();
		
		//notify presenter
		this.setChanged();
		this.notifyObservers();
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

	@Override
	public void connectToServer() {
		//connect new server
		try {
			System.out.println(properties.getIp());
			System.out.println(properties.getPort());
			myServer = new Socket(properties.getIp(), properties.getPort());
		} catch (IOException e) {
			setChanged();
			notifyObservers(e.getMessage());
		}
		
		try {
			input = myServer.getInputStream();
			output = myServer.getOutputStream();
		} catch (IOException e) {
			setChanged();
			notifyObservers(e.getMessage());
		}
		System.out.println("connected to server");
		PrintWriter outToServer;
		outToServer = new PrintWriter(new OutputStreamWriter(output));
		outToServer.println("BoardGame");
		outToServer.flush();
		haveConnection = true;
	}

	@Override
	public void disconnect() throws IOException {
		//disconnect after finished
		input.close();
		output.close();
		myServer.close();
	}

	//get file destination from view and load xml file
	@Override
	public void loadPropertiesFromFile(String dest) throws FileNotFoundException {
		if(propertiesLoaded == false){
			properHendler.readPropertiesFromFile(dest);
			System.out.println("load sucsesfull");
			propertiesLoaded = true;
		}
	}
		
}
