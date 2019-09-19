package concurrentutils.forkjoin.simple_example;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo {

	public static void main(String[] args) {
		// use common pool
		ForkJoinPool fjp = ForkJoinPool.commonPool();
		
		double[] nums = new double[100000];
		
		for(int i = 0; i < nums.length; i++) {
			nums[i] = (double) i;
		}
		
		System.out.println("portion of original sequence: ");
		
		for (int i = 0; i < 10; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println("\n");
		
		SqrtTransform task = new SqrtTransform(nums, 0, nums.length);
		
		// start main fork join task
		fjp.invoke(task);
		
		System.out.println("A portion of transformed sequence (to 4 decimal places)");
		for(int i=0; i < 10; i++) {
			System.out.format("%.4f ", nums[i]);
		}
		System.out.println();
	}
}
