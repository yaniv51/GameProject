package model.algorithm;

import static org.junit.Assert.*;
import model.domain.TicTacToeState;

import org.junit.Test;

public class MiniMaxAlphaBetaTest {

	@Test
	public void testFirstLayer() {
		// generate new board -> next computer move must block player at 2,2
		int board[][] = new int[][] { { 1, 0, 0, }, { 2, 1, 0 }, { 0, 0, 0, } };
		TicTacToeState state = new TicTacToeState(2, board, 10, 3, 0);
		MiniMaxAlphaBeta ai = new MiniMaxAlphaBeta();
		// set minimum depth for algorithm to see next player move
		int depth = 2;
		int move = ai.firstLayer(state, depth);
		assertEquals(22, move);
	}

	@Test
	public void testFirstLayer1() {
		// generate new board -> next computer move must win at this turn at 0,2
		int board[][] = new int[][] { { 1, 1, 0, }, { 1, 2, 0 }, { 2, 0, 0, } };
		TicTacToeState state = new TicTacToeState(2, board, 10, 3, 0);
		MiniMaxAlphaBeta ai = new MiniMaxAlphaBeta();
		// set minimum depth for algorithm to see next player move
		int depth = 2;
		int move = ai.firstLayer(state, depth);
		assertEquals(2, move);
	}

}