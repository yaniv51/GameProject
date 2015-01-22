package model.algorithm;

/**
 * <h1>AI<h1> <p> 
 * Artificial intelligence interface.
 */
public interface AI {
	/**
	 * <h1> firstLayer <h1> <p>
	 * 
	 * the method will Calculate the first layer of the algorithm and returns the best move that has found
	 * 
	 * @param state
	 * @param maxDepth
	 * @return integer with the best score 
	 */
	public int firstLayer(State state, int maxDepth);
	

}
