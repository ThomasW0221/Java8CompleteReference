package concurrentutils.locks.cyclicbarrier;

public class BarAction implements Runnable {

	@Override
	public void run() {
		
		System.out.println("Barrier reached!");
	}

}
