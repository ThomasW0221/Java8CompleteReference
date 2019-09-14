package concurrentutils.executors.simple_example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExecutorDemo {

	public static void main(String[] args) {
		CountDownLatch cd1 = new CountDownLatch(5);
		CountDownLatch cd2 = new CountDownLatch(5);
		CountDownLatch cd3 = new CountDownLatch(5);
		CountDownLatch cd4 = new CountDownLatch(5);
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		System.out.println("Starting");
		
		es.execute(new MyThread(cd1, "A"));
		es.execute(new MyThread(cd2, "B"));
		es.execute(new MyThread(cd3, "C"));
		es.execute(new MyThread(cd4, "D"));
		
		try {
			cd1.await();
			cd2.await();
			cd3.await();
			cd4.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		es.shutdown();
		System.out.println("Done");
	}
}
