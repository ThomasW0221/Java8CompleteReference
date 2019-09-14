package concurrentutils.locks.semaphore;

import java.util.concurrent.Semaphore;

public class DecThread implements Runnable{

	String name;
	Semaphore sem;
	
	DecThread(Semaphore s, String n) {
		this.sem = s;
		this.name = n;
		new Thread(this).start();
	}
	
	public void run() {
		System.out.println("Starting " + this.name);
		try {
			// aquire permit
			System.out.println(name + " is waiting for a permit.");
			sem.acquire();
			System.out.println(name + " gets a permit");
			
			// now get shared resource
			for(int i = 0; i < 5; i++) {
				Shared.count--;
				System.out.println(name + ": " + Shared.count);
				
				// Now, allow context switch -- if possible
				Thread.sleep(10);
			}
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		
		System.out.println(name + " releases the permit.");
		sem.release();
	}
}
