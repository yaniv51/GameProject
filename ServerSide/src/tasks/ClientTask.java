package tasks;

import java.net.Socket;

public interface ClientTask {
	
	/**
	 * <h1> doTask <h1> <p> 
	 *  @param someclient current client for new task
	 */
	public void doTask(Socket someclient);
	/**
	 * <h1> stop <h1> <p> 
	 *  stop thread
	 */
	public void stop();
	

}
