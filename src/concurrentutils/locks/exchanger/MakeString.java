package concurrentutils.locks.exchanger;

import java.util.concurrent.Exchanger;

public class MakeString implements Runnable{

	Exchanger<String> ex;
	String str;
	
	MakeString(Exchanger<String> c){
		ex = c;
		str = new String();
		new Thread(this).start();
	}
	
	public void run() {
		char ch = 'A';
		
		for(int i = 0; i < 3; i++) {
			
			// fill buffer
			for(int j = 0; j < 5; j++) {
				str += ch++;
				
				try {
					// exchange full buffer for empty one
					str = ex.exchange(str);
				} catch(InterruptedException exc) {
					System.out.println(exc);
				}
			}
		}
	}
}
