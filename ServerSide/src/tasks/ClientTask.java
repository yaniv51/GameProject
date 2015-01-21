package tasks;

import java.net.Socket;

public interface ClientTask {
	
	/**
	 * <hl> doTask <hl> <p> 
	 *  @param someclient current client for new task
	 */
	public void doTask(Socket someclient);
	/**
	 * <hl> stop <hl> <p> 
	 *  stop thread
	 */
	public void stop();
	

}
