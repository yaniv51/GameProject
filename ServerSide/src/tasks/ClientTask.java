package tasks;

import java.io.InputStream;
import java.io.OutputStream;

public interface ClientTask {
	
	public void doTask(InputStream in, OutputStream out);
	public void stop();
	

}
