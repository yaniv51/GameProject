package networking;


import java.net.Socket;

import tasks.ClientTask;



public interface ClientHandler extends ClientTask {

	public void startConv(Socket someclient);
	
}
