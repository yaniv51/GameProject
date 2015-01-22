package networking;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import model_.MyModel;
import model_.Problem;
import model_.Solution;

/**
 * <h1>GameClientHandler<h1> <p> 
 * This class will handle with the client, get Problem and send back Solution
 */
public class GameClientHandler implements ClientHandler {

	boolean stop = false;
	MyModel model;
	Solution solution;//
	Problem problam;//
	
	/**
	 * <h1> GameClientHandler constructor <h1> <p> 
	 * Initialized all variables<p>
	 */
	public GameClientHandler() {
		stop = false;
		model = new MyModel();
		solution = new Solution();//
		problam = new Problem();
	}

	@Override
	public void startConv(Socket someclient) {
		try {
			InputStream in = someclient.getInputStream();
			OutputStream out = someclient.getOutputStream();
			Problem problam = new Problem();
			problam = (Problem) new ObjectInputStream(in).readObject();
			while ((stop == false) && (!(problam.getStatus() == 4))) {
				//check problem status -> 1 new game, 2 current game, 3 hint, 4 disconnect
				if (problam.getStatus() == 1){
					model.selectDomain(problam.getGameDomain());
					model.selectAlgorithm(problam.getAi());
					model.setHardLevel(problam.getHardLevel());
					model.solveDomain(problam.getGame());
					solution = model.getSolution();
				}
				if (problam.getStatus() == 2){
					model.solveDomain(problam.getGame());
					solution = model.getSolution();
				}
				
				if (problam.getStatus() == 3){
					model.getHint();
				}				
				// send solution to client
				if (problam.getStatus() != 3) {
					new ObjectOutputStream(out).writeObject(solution);
					out.flush();
				}
				else
				{
					String hint = model.getHintString();
					new ObjectOutputStream(out).writeObject(hint);
				}
				
				problam = (Problem) new ObjectInputStream(in).readObject();
			}
			
		//	model.saveGame();
			System.out.println("client disconnected");
			someclient.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}

	@Override
	public void doTask(Socket someclient) {
		startConv(someclient);
	}

	@Override
	public void stop() {
		stop = true;
	}

}
