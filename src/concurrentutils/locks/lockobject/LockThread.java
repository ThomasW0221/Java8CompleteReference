package concurrentutils.locks.lockobject;

import java.util.concurrent.locks.ReentrantLock;

public class LockThread implements Runnable {
	
	String name;
	ReentrantLock lock;
	
	LockThread(ReentrantLock lk, String n){
		lock = lk;
		name = n;
		new Thread(this).start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Starting " + name);
		
		try {
			System.out.println(name + " is waiting to lock count");
			lock.lock();
			System.out.println(name + " is locking count");
			Shared.count++;
			System.out.println(name + ": " + Shared.count);
			// allow context switch if possible (shouldn't be possible)
			System.out.println(name + "is sleeping");
			Thread.sleep(1000);
		} catch (InterruptedException exc) {
			System.out.println(exc);
		} finally {
			System.out.println(name + " is unlocking count");
			lock.unlock();
		}
	}

}
