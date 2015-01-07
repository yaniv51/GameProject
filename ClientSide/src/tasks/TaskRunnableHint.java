package tasks;

public class TaskRunnableHint implements Runnable {

	private Task t;
	
	
	public TaskRunnableHint(Task t) {
		this.t = t;
	}
	@Override
	public void run() {
		t.doTask();
	}
}
