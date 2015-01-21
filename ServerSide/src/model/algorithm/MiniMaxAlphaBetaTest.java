package model.algorithm;

import static org.junit.Assert.*;
import org.junit.Test;
import model.domain.TicTacToeState;
public class MiniMaxAlphaBetaTest {

	/**
	 * <hl>testFirstLayer<hl> <p> 
	 * Generate new board and test algorithm move <p>Next computer move must block player at 2,2<p>
	 */
	@Test
	public void testFirstLayer() {
		// generate new board
		int board[][] = new int[][] { { 1, 0, 0, }, { 2, 1, 0 }, { 0, 0, 0, } };
		TicTacToeState state = new TicTacToeState(2, board, 10, 3, 0);
		MiniMaxAlphaBeta ai = new MiniMaxAlphaBeta();
		// set minimum depth for algorithm to see next player move
		int depth = 2;
		int move = ai.firstLayer(state, depth);
		assertEquals(22, move);
	}

	/**
	 * <hl>testFirstLayer1<hl> <p> 
	 * Generate new board and test algorithm move <p>Next computer move must win at this turn at 0,2<p>
	 */
	@Test
	public void testFirstLayer1() {
		// generate new board
		int board[][] = new int[][] { { 1, 1, 0, }, { 1, 2, 0 }, { 2, 0, 0, } };
		TicTacToeState state = new TicTacToeState(2, board, 10, 3, 0);
		MiniMaxAlphaBeta ai = new MiniMaxAlphaBeta();
		// set minimum depth for algorithm to see next player move
		int depth = 2;
		int move = ai.firstLayer(state, depth);
		assertEquals(2, move);
	}

}