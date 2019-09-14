package concurrentutils.locks.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread implements Runnable{

	CyclicBarrier cbar;
	String name;
	
	MyThread(CyclicBarrier c, String n){
		cbar = c;
		name = n;
		new Thread(this).start();
	}
	
	public void run() {
		System.out.println(name);
		try {
			cbar.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
