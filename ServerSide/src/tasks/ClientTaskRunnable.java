package tasks;

import java.io.InputStream;
import java.io.OutputStream;

public class ClientTaskRunnable implements Runnable {

	ClientTask t;
	OutputStream output;
	InputStream input;
	
	public ClientTaskRunnable(ClientTask task, OutputStream out, InputStream in) {
		t = task;
		output = out;
		input = in;
	}
	
	@Override
	public void run() {
		t.doTask(input, output);
	}
	
	public void stop() {
		t.stop();
	}

}
