package model_;

import java.util.HashMap;

import model.algorithm.GameDomain;
import model.domain.ReversiGameDomain;
import model.domain.TicTacToeGameDomain;

public class GameDomainFactory {
	private HashMap<String, gameDomainCreator> CreateGameDomain;
	
	//c'tor
	public GameDomainFactory() {
		//put gameDomain -  O(n) memory
		CreateGameDomain = new HashMap<String, GameDomainFactory.gameDomainCreator>();
		CreateGameDomain.put("TicTacToe" , new ticTacToeCreator());
		CreateGameDomain.put("Reversi", new CreatorReversi());
	}
	
	public GameDomain createGame(String gameDomainName) {
		//get gameDomain in O(1) time
		gameDomainCreator creator = CreateGameDomain.get(gameDomainName);
		GameDomain game = null;
		if(creator != null )
			game = creator.create();
		return game;
	}
	
	
	private interface gameDomainCreator {
		public GameDomain create(); 
	}
	
	private class ticTacToeCreator implements gameDomainCreator {
		@Override
		public GameDomain create() {
			return new TicTacToeGameDomain();
		}
	}
	
	private class CreatorReversi implements gameDomainCreator {
		@Override
		public GameDomain create() {
			return new ReversiGameDomain();
		}
	}
	
	
	
}


