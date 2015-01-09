package properties;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PropertiesHandler {
	
	final static String fileName = "Properties.xml";

	public MyProperties writeProperties(MyProperties properties) {
		
			XMLEncoder writeXml = null;
			try {
				writeXml = new XMLEncoder((new FileOutputStream(fileName)));
				writeXml.writeObject(properties);
				writeXml.close();
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println("failed to write properties");
			}
					
		return null;

	}
	public MyProperties readProperties () throws FileNotFoundException {
		
			XMLDecoder readXml = null;
			readXml = new XMLDecoder(new FileInputStream(fileName));
			MyProperties properties = (MyProperties) readXml.readObject();
			readXml.close(); 
			return properties;
		}
	}