package tasks;

public class RunnableTask implements Runnable{

	ServerTask t;

	/**
	 * <hl> RunnableTask constructor <hl> <p> 
	 *  @param task server task for threads
	 */
	public RunnableTask(ServerTask task) {
		t = task;
	}
	
	@Override
	public void run() {
		t.doTask();
	}
	
	/**
	 * <hl> stop <hl> <p> 
	 *  stop server thread
	 */
	public void stop() {
		t.stop();
	}
	
}
