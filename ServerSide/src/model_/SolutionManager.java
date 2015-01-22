package model_;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * <h1> SolutionManager<h1> <p> 
 * In this class the program will save all solutions that already solved.<p>
 * Can use read\write to save and load solutions from file.
 */
public class SolutionManager {
	HashMap<String, Solution> HashSolutions ; // the Hash map will save the description of the state of the solution and the Object Solution
	 private static final String fileName = "solution.bat"; // choose the name of the filename that we'll save the data in to.
	 private static SolutionManager instance = null; //make class singleton 
	
	/**
	 * <h1> SolutionManager getInstance()  <h1> <p> 
	 * For singleton classes<p>
	 * @return instance of solution manager
	 */
	public static SolutionManager getInstance() {
		if (instance == null) {
			instance = new SolutionManager();			
		}
		return instance;
	}
	
	/**
	 * <h1> getSolutions <h1> <p> 
	 * The method will return the right solution by the description<p>
	 * @param description String of solution description
	 * @return solution for the current description
	 */
	public Solution getSolutions (String description){ 
		Solution solution = HashSolutions.get(description);
		return solution;
	}

	/**
	 * <h1> setSolution <h1> <p> 
	 * 	the method will get solution and add it to the HashMap<p>
	 * @param solution current solution
	 */
	public void setSolution (Solution solution){ 
		if (!(solution == null)){
			HashSolutions.put(solution.getDescription(),solution);
		}
	}
	
	/**
	 * <h1> WriteSolutionToFile <h1> <p> 
	 * Method for write the HashMap to file<p>
	 * @throws IOException If error occurred when writting to file
	 */
	public void WriteSolutionToFile () throws IOException{ 
		//create new file input stream
		FileOutputStream f = new FileOutputStream(fileName);  
		ObjectOutputStream s = new ObjectOutputStream(f);
		//write object
		s.writeObject(HashSolutions);
		System.out.println("write solutions");
		s.flush();
		//close output
		s.close();
	}
	
	/**
	 * <h1> readSolutionFromFile <h1> <p> 
	 * 	Method for read solutions from file and save in HashMap<p>
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void readSolutionFromFile () throws IOException, ClassNotFoundException {
		//create new file input
		FileInputStream f;
		f = new FileInputStream(fileName);
		ObjectInputStream s = new ObjectInputStream(f);
		//read from file
		HashSolutions = (HashMap<String, Solution>)s.readObject();  
		//close file
		s.close();	
	}

}
