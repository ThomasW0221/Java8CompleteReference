package concurrentutils.locks.exchanger;

import java.util.concurrent.Exchanger;

public class UseString implements Runnable{
	
	Exchanger<String> ex;
	String str;
	
	UseString(Exchanger<String>c ){
		ex = c;
		new Thread(this).start();
	}
	
	public void run() {
		for(int i = 0; i < 3; i++) {
			try {
				// exchange empty string for full one
				str = ex.exchange(new String());
				System.out.println("got: " + str);
			} catch(InterruptedException exc) {
				System.out.println(exc);
			}
		}
	}

}
