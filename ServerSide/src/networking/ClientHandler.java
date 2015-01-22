package networking;

import java.net.Socket;

import tasks.ClientTask;

/**
 * <h1>ClientHandler<h1> <p> 
 * Interface for handle with client
 */
public interface ClientHandler extends ClientTask {

	/**
	 * <h1> startConv <h1> <p> 
	 * Start conversation with getted client<p>
	 *  @param someclient 
	 */
	public void startConv(Socket someclient);
	
}
