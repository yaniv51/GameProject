package model_;

import java.util.HashMap;

import model.algorithm.AI;
import model.algorithm.MiniMax;
import model.algorithm.MiniMaxAlphaBeta;

public class algorithmFactory {
	
	private HashMap<String, algorithmCreator> algorithms;
	
	public algorithmFactory() {
		//put algorithm  O(n) memory
		algorithms = new HashMap<String, algorithmFactory.algorithmCreator>();
		algorithms.put("MiniMax", new miniMaxCreator());
		algorithms.put("MiniMaxAlphaBeta", new miniMaxAlphaBetaCreator());
	}
	
	public AI createAlgorithm(String algorithmName) {
		//get algorithm in O(1) time
		algorithmCreator creator = algorithms.get(algorithmName);
		AI ai = null;
		if (creator != null )
			ai = creator.create();
		return ai;
		
	}
	
	private interface algorithmCreator {
		public AI create();
	}
	
	//creator for minimax algorithm
	private class miniMaxCreator implements algorithmCreator {
		@Override
		public AI create() {
			return new MiniMax();
		}
	}
	
	//creator for minimaxAlphaBeta algorithm
	private class miniMaxAlphaBetaCreator implements algorithmCreator {
		@Override
		public AI create() {
			return new MiniMaxAlphaBeta();
		}
	}

}
