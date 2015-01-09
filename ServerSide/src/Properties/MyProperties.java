package Properties;

import java.io.Serializable;
import java.util.Scanner;

public class MyProperties implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6531095623050704534L;
	int port;
	int numOfClients;
	
	//default c'tor for serializable 
	public MyProperties() {
	}
	
	//c'tor
	public MyProperties(int numOfClients, int port) {
		this.port = port;
		this.numOfClients = numOfClients;
	}
	
	//get + set port
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

	//get+set number of clients
	public int getNumOfClients() {
		return numOfClients;
	}
	public void setNumOfClients(int numOfClients) {
		this.numOfClients = numOfClients;
	}

	//get from user new properties if XML file not found
	public void newProperties() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner (System.in);
		int newNumOfClient;
		int newPort;
		System.out.println("enter number of client");
		newNumOfClient = scan.nextInt();
		setNumOfClients(newNumOfClient);
		System.out.println("enter new port ( by default 2525 )");
		newPort = scan.nextInt();
		setPort(newPort);
	}

	
	
	
	
}