package tasks;

import java.net.Socket;

/**
 * <h1> ClientTask <h1> <p> 
 *  Interface for new client task
 */
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
