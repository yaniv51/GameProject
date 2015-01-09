package tasks;

import java.net.Socket;

public class ClientTaskRunnable implements Runnable {

	ClientTask t;
	Socket someclient;
	
	public ClientTaskRunnable(ClientTask task, Socket someclient) {
		t = task;
		this.someclient = someclient;
	}
	
	@Override
	public void run() {
		t.doTask(someclient);
	}
	
	public void stop() {
		t.stop();
	}

}
