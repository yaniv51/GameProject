package networking;

import java.io.IOException;
import java.util.Scanner;

import tasks.RunnableTask;

public class Run {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		MyServer server = new MyServer();
		RunnableTask r = new RunnableTask(server);
		Thread t = new Thread(r);
		//start new server
		t.start();
		
		
		String s;
		System.out.println("enter 'stop' to stop server");
		do {
			s = scan.nextLine();
			if(s.equals("stop"))
				r.stop();
		}while(!(s.equals("stop")));
		System.out.println("server down");
		
	}

}
