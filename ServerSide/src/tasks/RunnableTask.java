package tasks;

public class RunnableTask implements Runnable{

	ServerTask t;

	public RunnableTask(ServerTask task) {
		t = task;
	}
	
	@Override
	public void run() {
		t.doTask();
	}
	
	public void stop() {
		t.stop();
	}
	
}
