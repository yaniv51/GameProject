package networking;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import model_.Model;
import model_.MyModel;
import model_.Problem;
import model_.Solution;

public class GameClientHandler implements ClientHandler {

	boolean stop = false;
	Model model;
	Solution solution;//
	Problem problam;//
	
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
			int count = 0;
			Problem problam = new Problem();
			
			System.out.println("wait for client problem 0");
			problam = (Problem) new ObjectInputStream(in).readObject();
			System.out.println("Receive new problam");//
			while ((stop == false) && (!(problam.getStatus() == 4))) {
				if (problam.getStatus() == 1){
					System.out.println("run by Status 1");
					model.selectDomain(problam.getGameDomain());
					model.selectAlgorithm(problam.getAi());
					model.setHardLevel(problam.getHardLevel());
					model.solveDomain(problam.getGame());
					solution = model.getSolution();
				}
				if (problam.getStatus() == 2){
					System.out.println("run by Status 2");
					model.solveDomain(problam.getGame());
					solution = model.getSolution();
				}
				
				if (problam.getStatus() == 3){
					System.out.println("run by Status 3");
					model.getHint();
				}				
				// send solution to client
				new ObjectOutputStream(out).writeObject(solution);
				out.flush();

				System.out.println("wait for client problem " + count);
				problam = (Problem) new ObjectInputStream(in).readObject();
				System.out.println("send the problam");//
			}
			
		//	model.saveGame();
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
		

	}

}
