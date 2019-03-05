package engine;

public class DComputeEngine implements ComputeEngine {

	public <T> T execute(TaskDescriptor<T> td) {
			T result = td.getTask().execute(); //execute task
			td.setResult(result); //add result
			return result;
	}

}
