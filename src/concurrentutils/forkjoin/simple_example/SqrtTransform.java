package concurrentutils.forkjoin.simple_example;

import java.util.concurrent.RecursiveAction;

//simple example of basic divide-conquer strategy

public class SqrtTransform extends RecursiveAction {
	final int seqThreshold = 1000;
	
	double[] data;
	
	// determines what data to process
	int start,end;
	
	SqrtTransform(double[] vals, int s, int e){
		data = vals;
		start = s;
		end = e;
	}

	@Override
	protected void compute() {
		
		// if # of elements is below sequential threshold, process sequentially
		if((end - start) < seqThreshold) {
			for(int i = start; i < end; i++) {
				data[i] = Math.sqrt(data[i]);
			}
		} else {
			// otherwise, break data into smaller pieces
			
			// find midpoint
			int middle = (start + end ) / 2;
			
			// invoke new tasks, using subdivided data
			invokeAll(new SqrtTransform(data, start, middle),
					new SqrtTransform(data, middle, end));
		}
	}
	
	

}
