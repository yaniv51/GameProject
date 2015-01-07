package networking;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import model_.Model;
import model_.MyModel;
import model_.Problem;

public class GameClientHandler implements ClientHandler {

	boolean stop = false;
	Model model;

	public GameClientHandler() {
		stop = false;
		model = new MyModel();
	}

	@Override
	public void startConv(InputStream in, OutputStream out) {

		try {
			int count = 0;
			Problem prob = new Problem();
			System.out.println("wait for client problem 0");
			prob = (Problem) new ObjectInputStream(in).readObject();
			while ((stop == false) && (!(prob.getProblem().equals("exit")))) {
				if (count == 0) {
					model.selectAlgorithm(prob.getAi());
					model.selectDomain(prob.getGameDomain());
					model.setHardLevel(prob.getHardLevel());
				}
				model.solveDomain(prob.getGame());
				// send solution to client
				new ObjectOutputStream(out).writeObject(model.getSolution());
				out.flush();

				count++;
				System.out.println("wait for client problem " + count);
				prob = (Problem) new ObjectInputStream(in).readObject();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}

	@Override
	public void doTask(InputStream in, OutputStream out) {
		startConv(in, out);
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
