package model_;

import model.algorithm.State;

public interface Model {
	
	void selectDomain(String domainName);
	void selectAlgorithm(String algorithmName);
	void solveDomain(State state);
	Solution getSolution();
	public void setHardLevel(int depth);
	public void getHint();
	public String getHintString();
	public void setHintDepth(int depth);
	//void saveGame() throws Exception;

	

}
