package model_;

import model.algorithm.State;

public interface Model{
	
	void selectDomain(String domainName);
	void selectAlgorithm(String algorithmName);
	void solveDomain();
	Solution getSolution();
	public void setHardLevel(int depth);
	public void gameManager(int row, int colum);
	public int getGameOver();
	public void getHint();
	public String getHintString();
	public void setHintDepth(int depth);
	State getState();
	

	

}
