package model_;

import model.algorithm.AI;
import model.algorithm.GameDomain;
import model.algorithm.State;

public class MyModel  implements Model {

	//extends Observable
	
	private AI ai;
	private GameDomain game;
	private algorithmFactory algorithmFactory;
	private GameDomainFactory gameFactory;
	private Solution solution;
	private SolutionManager solutionManager;
	private int hardLevel;
	private String hintGame;
	private int hintDepth;
	
	
	//c'tor
	public MyModel() {
		algorithmFactory = new algorithmFactory();
		gameFactory = new GameDomainFactory();
		solutionManager = SolutionManager.getInstance();
		solution = new Solution();
		hintGame = new String();
		hintDepth = 0;
	}
	
	//get domain name and use domain factory for getting the right domain
	@Override
	public void selectDomain(String domainName) {
		game = this.gameFactory.createGame(domainName);
	}
	
	//get algorithm name and use algorithm factory  for getting the right algorithm
	@Override
	public void selectAlgorithm(String algorithmName) {
		ai = this.algorithmFactory.createAlgorithm(algorithmName);
	}
	
	//solve the domain
	@Override
	public void solveDomain(State state) {
		String newSolution = new String(state.toString()+":"+Integer.toString(hardLevel));
		if (solutionManager.getSolutions(newSolution) == null){
			solution = null;
			solution = new Solution();
			solution.setDescription(newSolution);
			game.getSolution(state,ai);
			solution.setCurrentState(game.getState());
			solutionManager.setSolution(solution);
		}
		
		else {
			solution = solutionManager.getSolutions(newSolution);
			
		}
	}
	
	//get solution
	public Solution getSolution(){
		return solution;
	}

	//return hard level
	public int getHardLevel() {
		return hardLevel;
	}
	
	//get hard level and set at game domain
	public void setHardLevel(int depth) {
		this.hardLevel = depth;
		game.setDepth(this.hardLevel);
	}
	
	
	//return current game state
	public State getState() {
		return game.getState();
	}

	//get hint for user turn
	@Override
	public void getHint() {
		hintGame = game.getHint(this.ai, this.hintDepth);
	}

	//return hint depth
	public int getHintDepth() {
		return hintDepth;
	}

	//set hint depth
	public void setHintDepth(int depth) {
		this.hintDepth = depth;
	}

	//return hint and before return change original data member to empty string
	public String getHintString() {
		String hint = new String();
		if( hintGame.isEmpty() == false)
		 {
			hint = new String(hintGame);
			hintGame = new String();
		}
		return hint;
	}

}
