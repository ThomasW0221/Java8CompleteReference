package concurrentutils.locks.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CDLDemo {

	public static void main(String[] args) {
		
		CountDownLatch cdl = new CountDownLatch(5);
		
		System.out.println("Starting");
		
		new MyThread(cdl);
		
		try {
			// causes execution of main thread to wait until cdl has been countDown()'ed
			// 5 times
			cdl.await();
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		
		System.out.println("Done");
	}

}
