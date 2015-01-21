package networking;


import java.net.Socket;

import tasks.ClientTask;



public interface ClientHandler extends ClientTask {

	/**
	 * <hl> startConv <hl> <p> 
	 * Start conversation with getted client<p>
	 *  @param someclient 
	 */
	public void startConv(Socket someclient);
	
}
