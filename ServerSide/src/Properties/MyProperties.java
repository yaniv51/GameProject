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
	
	/**
	 * <hl> Constructor <hl> <p> 
	 *  default constructor for serializable 
	 */
	public MyProperties() {
	}
	
	/**
	 * <hl> Constructor <hl> <p> 
	 *  
	 *  @param numOfClients number of possible clients for server <p>
	 *  @param port local port of server
	 */
	public MyProperties(int numOfClients, int port) {
		this.port = port;
		this.numOfClients = numOfClients;
	}
	
	/**
	 * <hl> getPort <hl> <p> 
	 *  @return Server local port
	 */
	public int getPort() {
		return port;
	}
	
	/**
	 * <hl> setPort <hl> <p> 
	 *  @param port set server local port
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * <hl> getNumOfClients <hl> <p> 
	 *  @return number of possible clients for server
	 */
	//get+set number of clients
	public int getNumOfClients() {
		return numOfClients;
	}
	
	/**
	 * <hl> setNumOfClients <hl> <p> 
	 *  @param numOfClients set server possible clients
	 */
	public void setNumOfClients(int numOfClients) {
		this.numOfClients = numOfClients;
	}

	/**
	 * <hl> newProperties <hl> <p> 
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