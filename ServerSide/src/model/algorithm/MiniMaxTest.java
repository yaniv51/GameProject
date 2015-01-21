package model.algorithm;

import static org.junit.Assert.*;
import model.domain.TicTacToeState;

import org.junit.Test;

public class MiniMaxTest {

	/**
	 * <hl>testFirstLayer<hl> <p> 
	 * Generate new board and test algorithm move <p>Next computer move must block player at 2,0<p>
	 */
	@Test
	public void testFirstLayer() {
		//generate new board
		int board[][] = new int[][] {{1,0,0,},{1,2,0},{0,0,0,} };
		TicTacToeState state = new TicTacToeState(2, board, 10, 3, 0);
		MiniMax ai = new MiniMax();
		//set minimum depth for algorithm to see next player move
		int depth = 2;
		int move = ai.firstLayer(state, depth);
		assertEquals(20,move);
	}
	
	/**
	 * <hl>testFirstLayer1<hl> <p> 
	 * Generate new board and test algorithm move <p>Next computer move must win at this turn at 2,1<p>
	 */
	@Test
	public void testFirstLayer1() {
		// generate new board -> next computer move must win at this turn at 2,1
		int board[][] = new int[][] { { 1, 0, 1, }, { 0, 1, 0 }, { 2, 0, 2, } };
		TicTacToeState state = new TicTacToeState(2, board, 10, 3, 0);
		MiniMax ai = new MiniMax();
		// set minimum depth for algorithm to see next player move
		int depth = 2;
		int move = ai.firstLayer(state, depth);
		assertEquals(21, move);
	}

}
