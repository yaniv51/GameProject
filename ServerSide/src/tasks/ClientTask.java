package tasks;

import java.net.Socket;

public interface ClientTask {
	
	public void doTask(Socket someclient);
	public void stop();
	

}
