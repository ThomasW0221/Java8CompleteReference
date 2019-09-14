package concurrentutils.locks.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		// CyclicBarier-suspends until specified number of threads has reached barrier point
		CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
		
		System.out.println("Starting");
		new MyThread(cb, "A");
		new MyThread(cb, "B");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new MyThread(cb, "C");
	}

}
