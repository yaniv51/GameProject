package model_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class SolutionManager {
	
	HashMap<String, Solution> HashSolutions ; // the Hash map will save the description of the state of the solution and the Object Solution
	 private static final String fileName = "solution.bat"; // choose the name of the filename that we'll save the data in to.
	 //make class singleton 
	 private static SolutionManager instance = null;
	 
	 //c'tor
	/*public SolutionManager() { 
		//HashSolutions = new HashMap<String, Solution>();
	}*/
	
	public static SolutionManager getInstance() {
		if (instance == null) {
			instance = new SolutionManager();			
		}
		return instance;
	}
	
	// The method will return the right solution by the description
	public Solution getSolutions (String description){ 
		Solution solution = HashSolutions.get(description);
		return solution;
	}

	// the method will get the solution and add it to the HashMap
	public void setSolution (Solution solution){ 
		if (!(solution == null)){
			HashSolutions.put(solution.getDescription(),solution);
		}
	}
	
	
	// the method will write the HashMap to the HashSolutions
	public void WriteSolutionToFile () throws IOException{ 
		FileOutputStream f = new FileOutputStream(fileName);  
		ObjectOutputStream s = new ObjectOutputStream(f);          
		s.writeObject(getHashSolutions());
		System.out.println("write solutions");
		s.flush();
		s.close();
	}
	
	//throws IOException, ClassNotFoundException
	// the method will write the HashMap to the HashSolutions
	@SuppressWarnings("unchecked")
	public void readSolutionFromFile () { 
		
		FileInputStream f;
		try {
			f = new FileInputStream(fileName);
			ObjectInputStream s = new ObjectInputStream(f);
			HashSolutions = (HashMap<String, Solution>)s.readObject();  
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		
		
		
	}

	public HashMap<String, Solution> getHashSolutions() {
		return HashSolutions;
	}

	public void setHashSolutions(HashMap<String, Solution> hashSolutions) {
		HashSolutions = hashSolutions;
	}

	public static String getFilename() {
		return fileName;
	}

}
