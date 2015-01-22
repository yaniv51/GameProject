package tasks;

/**
 * <h1> RunnableTask<h1> <p> 
 *  Class implement Runnable, include run() for new server task
 */
public class RunnableTask implements Runnable{

	ServerTask t;

	/**
	 * <h1> RunnableTask constructor <h1> <p> 
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
	 * <h1> stop <h1> <p> 
	 *  stop server thread
	 */
	public void stop() {
		t.stop();
	}
	
}
