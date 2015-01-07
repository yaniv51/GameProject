package networking;

import java.io.InputStream;
import java.io.OutputStream;
import tasks.ClientTask;



public interface ClientHandler extends ClientTask {

	public void startConv(InputStream in, OutputStream out);
	
}
