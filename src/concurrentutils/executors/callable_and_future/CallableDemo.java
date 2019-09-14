package concurrentutils.executors.callable_and_future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		System.out.println("Starting...");
		Future<Integer> f1 = es.submit(new Sum(10));
		Future<Double> f2 = es.submit(new Hypot(3,4));
		Future<Integer> f3 = es.submit(new Factorial(5));
		
		try {
			System.out.println(f1.get());
			System.out.println(f2.get());
			System.out.println(f3.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		es.shutdown();
		System.out.println("Done");
	}
}
