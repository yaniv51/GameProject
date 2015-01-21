package Properties;

import java.io.Serializable;
import java.util.Scanner;

/**
 * <h1>MyProperties<h1><p>
 * including properties to connect server
 */
public class MyProperties implements Serializable{

	private static final long serialVersionUID = -6531095623050704534L;
	int port;
	int numOfClients;
	
	/**
	 * <h1> Constructor <h1> <p> 
	 *  default constructor for serializable 
	 */
	public MyProperties() {
	}
	
	/**
	 * <h1> Constructor <h1> <p> 
	 *  @param numOfClients number of possible clients for server <p>
	 *  @param port local port of server
	 */
	public MyProperties(int numOfClients, int port) {
		this.port = port;
		this.numOfClients = numOfClients;
	}
	
	/**
	 * <h1> getPort <h1> <p> 
	 *  @return Server local port
	 */
	public int getPort() {
		return port;
	}
	
	/**
	 * <h1> setPort <h1> <p> 
	 *  @param port set server local port
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * <h1> getNumOfClients <h1> <p> 
	 *  @return number of possible clients for server
	 */
	//get+set number of clients
	public int getNumOfClients() {
		return numOfClients;
	}
	
	/**
	 * <h1> setNumOfClients <h1> <p> 
	 *  @param numOfClients set server possible clients
	 */
	public void setNumOfClients(int numOfClients) {
		this.numOfClients = numOfClients;
	}

	/**
	 * <h1> newProperties <h1> <p> 
	 *  if failed to load properties, this method will get user opportunity to insert new properties for XML file
	 */
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