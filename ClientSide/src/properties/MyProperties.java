package properties;

import java.io.Serializable;
import java.util.Scanner;

public class MyProperties implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2227557974022601505L;
	int port;
	String ip;
	Scanner scan = new Scanner(System.in);
	
	public MyProperties() {
		port = 0;
		ip = new String();
	}

	//get + set port
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

	//get+set IP
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = new String(ip);
	}
	
	public void newProperties() {
		
		String newIp;
		int newPort;
		System.out.println("enter new IP ( by default: 127.0.0.1 )");
		newIp = scan.nextLine();
		setIp(newIp);
		System.out.println("enter new port ( by default 2525 )");
		newPort = scan.nextInt();
		setPort(newPort);
	}
	
	
	
}
