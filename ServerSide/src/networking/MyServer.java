package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tasks.ClientTaskRunnable;
import tasks.ServerTask;

/**
 * <h1>MyServer<h1> <p> 
 * Implement ServerTask for new thread.<p>
 * This class wait for connection from client.
 */
public class MyServer implements ServerTask {

	ExecutorService executors;
	int numOfClients;
	int port;
	private ArrayList <ClientTaskRunnable> clients;
	ServerSocket server;
	ClientHandler ch;
	volatile boolean stop;

	/**
	 * <h1> MyServer constructor <h1> <p> 
	 * initialized all variables<p>
	 *  @param port local port of server
	 *  @param numOfClients number of possible clients
	 */
	public MyServer(int port, int numOfClients) throws IOException {
			server = new ServerSocket(port);
			executors = Executors.newFixedThreadPool(numOfClients);
			System.out.println("server alive");
			stop = false;
			clients = new ArrayList<ClientTaskRunnable>();
	}

	/**
	 * <h1> startServer <h1> <p> 
	 * Main loop of server.<p> after client connected check for what and pass the client for clinetHandler to get what client want.
	 * @throws IOException  Can be errors when: read from client, set timeOut
	 */
	public void startServer() throws IOException {
		String line = null;
		int count = 1;
		this.server.setSoTimeout(10000);

		while (!(stop)) {
			System.out.println("Waiting for client...");
			Socket someclient = null;
			try {
				someclient = server.accept();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
			if (someclient != null) {
				BufferedReader clientIn = new BufferedReader(new InputStreamReader(someclient.getInputStream()));
				while(! (line = clientIn.readLine()).equals("exit")  )
					break;
				System.out.println("Client number "+count+" connected to: "+line+"."+"\nIp: "+someclient.getInetAddress()+" Client Port: "+someclient.getPort()+" Local Port: "+someclient.getLocalPort());
				count++;
				if(line.equals("BoardGame") == true)
				{
					ch = new GameClientHandler();
					ClientTaskRunnable r = new ClientTaskRunnable(ch, someclient);
					Thread t = new Thread(r);
					executors.execute(t);
					clients.add(r);	
				}
			}
		}

	}


	@Override
	public void doTask() {
		try {
			startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	@Override
	public void stop() {
		int i = 0;
		stop = true;
		for (ClientTaskRunnable r : clients){
			r.stop();
			System.out.println("Close client "+i);
			i++;
		}
		executors.shutdown();
		try {
			server.close();
			System.out.println("Server cloed.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
