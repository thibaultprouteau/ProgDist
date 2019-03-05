package engine;

public class FAPComputeEngine extends ComputeEngineNotifier {

	public FAPComputeEngine() {
		super();
	}

	@SuppressWarnings("unchecked")
	public void run() {
		while(true) {
			try {
				Thread.sleep(20);
				if(!tds.isEmpty()){
					TaskDescriptor td = tds.take(); //retrieve head of queue
					td.setResult(td.getTask().execute()); //add result
					tn.addTaskObserver(td); //notify
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
