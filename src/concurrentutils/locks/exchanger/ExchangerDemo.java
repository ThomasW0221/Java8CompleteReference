package concurrentutils.locks.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

	public static void main(String[] args) {
		Exchanger<String> exgr = new Exchanger<String>();
		
		new UseString(exgr);
		new MakeString(exgr);
	}
}
