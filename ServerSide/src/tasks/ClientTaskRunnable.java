package tasks;

import java.net.Socket;

public class ClientTaskRunnable implements Runnable {

	ClientTask t;
	Socket someclient;
	
	/**
	 * <hl> ClientTaskRunnable constructor <hl> <p> 
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
	 * <hl> stop <hl> <p> 
	 *  stop client thread
	 */
	public void stop() {
		t.stop();
	}

}
