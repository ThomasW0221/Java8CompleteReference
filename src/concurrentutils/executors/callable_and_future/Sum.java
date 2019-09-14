package concurrentutils.executors.callable_and_future;

import java.util.concurrent.Callable;

public class Sum implements Callable<Integer> {
	
	int stop;
	
	Sum(int v) { stop = v; }

	@Override
	public Integer call() throws Exception {
		
		int sum = 0;
		for(int i = 1; i <= stop; i++) {
			sum += i;
		}
		return sum;
	}

}
