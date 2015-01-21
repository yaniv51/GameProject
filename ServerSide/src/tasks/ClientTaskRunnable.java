package tasks;

import java.net.Socket;

public class ClientTaskRunnable implements Runnable {

	ClientTask t;
	Socket someclient;
	
	/**
	 * <h1> ClientTaskRunnable constructor <h1> <p> 
	 *  @param task client task for threads
	 *  @param someClient new client for threads
	 */
	public ClientTaskRunnable(ClientTask task, Socket someClient) {
		t = task;
		this.someclient = someClient;
	}
	

	@Override
	public void run() {
		t.doTask(someclient);
	}
	
	/**
	 * <h1> stop <h1> <p> 
	 *  stop client thread
	 */
	public void stop() {
		t.stop();
	}

}
