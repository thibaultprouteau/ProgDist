package engine;

import java.util.Calendar;

public class TComputeEngine extends ComputeEngineNotifier {

	public TComputeEngine() {
		super();
	}

	@SuppressWarnings("unchecked")
	public void run() {
		while(true) {
			try {
				Thread.sleep(20);

				if (!tds.isEmpty()) {
					TaskDescriptor td = tds.peek();
					int diff = td.getTime().get(Calendar.MINUTE) - Calendar.getInstance().get(Calendar.MINUTE);
					if(diff <= 0){ //when data recent
							if(diff <= -1){ //if data is outdated
								System.out.println("Data is outdated, unable to execute the task");
								tds.remove(td); //remove task from queue
							}
							else{
								tds.take(); //take task fro queue
								td.setResult(td.getTask().execute()); //add result
								tn.addTaskObserver(td); //notify
							}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
