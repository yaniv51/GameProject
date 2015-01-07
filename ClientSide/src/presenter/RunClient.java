package presenter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import model_.MyModel;
import tasks.TaskRunnable;
import view.MyConsolView;


public class RunClient {
	
	public static void main(String[] args) throws IOException {

		System.out.println("client  side");
		@SuppressWarnings("resource")
		Socket myServer=new Socket("127.0.0.1", 2315);
		System.out.println("connected to server");
		PrintWriter outToServer=new PrintWriter(new OutputStreamWriter(myServer.getOutputStream()));
		//send server what we want
		outToServer.println("BoardGame");
		outToServer.flush();
		
		MyModel model = new MyModel(myServer.getInputStream(), myServer.getOutputStream());
		MyConsolView view = new MyConsolView();
		Presenter presenter = new Presenter(model, view);

		model.addObserver(presenter);
		view.addObserver(presenter);

		Thread t = new Thread(new TaskRunnable(view));

		t.start();
		//have to check where to make connection to server
		
		// have to add an option to stop all with: 
		//t.stop();	


	}
}
