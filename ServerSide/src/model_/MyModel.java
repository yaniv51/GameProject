package model_;

import model.algorithm.AI;
import model.algorithm.GameDomain;
import model.algorithm.State;

public class MyModel {
	private AI ai;
	private GameDomain game;
	private algorithmFactory algorithmFactory;
	private GameDomainFactory gameFactory;
	private Solution solution;
	private SolutionManager solutionManager;
	private int hardLevel;
	private String hintGame;
	private int hintDepth;
	
	
	/**
	 * <hl> MyModel constructor <hl> <p> 
	 * Initialized all variables<p>
	 */
	public MyModel() {
		algorithmFactory = new algorithmFactory();
		gameFactory = new GameDomainFactory();
		solutionManager = SolutionManager.getInstance();
		solution = new Solution();
		hintGame = new String();
	}
	
	/**
	 * <hl>selectDomain<hl> <p> 
	 * Get domain name and use domain factory for getting the right domain<p>
	 * @param domainName
	 */
	public void selectDomain(String domainName) {
		game = this.gameFactory.createGame(domainName);
	}
	
	/**
	 * <hl> selectAlgorithm<hl> <p> 
	 * Get algorithm name and use algorithm factory  for getting the right algorithm<p>
	 * @param algorithmName
	 */
	public void selectAlgorithm(String algorithmName) {
		ai = this.algorithmFactory.createAlgorithm(algorithmName);
	}
	
	/**
	 * <hl> solveDomain<hl> <p> 
	 * Get state and find solution for next turn<p>
	 * First check if solution is exist, if no find solution and save to HashMap
	 * @param state for solve
	 */
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
	
	/**
	 * <hl> getSolution<hl> <p> 
	 * @return solution
	 */
	public Solution getSolution(){
		return solution;
	}

	/**
	 * <hl> setHardLevel<hl> <p> 
	 * Get hard level and set at game domain<p>
	 * @param depth depth for algorithm represent hardLevel
	 */
	public void setHardLevel(int depth) {
		this.hardLevel = depth;
		game.setDepth(this.hardLevel);
	}
	
	/**
	 * <hl> getHint<hl> <p> 
	 * Get hint for user turn
	 */
	public void getHint() {
		hintDepth = 3;
		this.hintGame = game.getHint(this.ai, this.hintDepth);
	}

	/**
	 * <hl> getHintString<hl> <p> 
	 * Return hint and before return change original data member to empty string
	 * @return hint
	 */
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
