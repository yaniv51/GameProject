package Properties;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * <h1> PropertiesHandler <h1> <p> 
 * Class for load properties from XML file or save properties to XML file 
 */
public class PropertiesHandler  {

	final static String fileName = "Data/Properties.xml";

	/**
	 * <h1> writeProperties <h1> <p> 
	 *  Write properties to XML file
	 *  @param properties Current properties to save
	 *  @throws FileNotFoundException If file not found
	 */
	public void writeProperties(MyProperties properties) throws FileNotFoundException {
			XMLEncoder writeXml = null;
			writeXml = new XMLEncoder((new FileOutputStream(fileName)));
			writeXml.writeObject(properties);
			writeXml.close();

	}
	
	/**
	 * <h1> readProperties <h1> <p> 
	 *  Read properties from XML file
	 *  @return properties Current properties that have been loaded
	 *  @throws FileNotFoundException If file not found
	 */
	public MyProperties readProperties () throws FileNotFoundException {
			XMLDecoder readXml = null;
			readXml = new XMLDecoder(new FileInputStream(fileName));
			MyProperties properties = (MyProperties) readXml.readObject();
			readXml.close(); 
			return properties;
	}

	
}