package lambdas.variable_captures;

public class VarCaptureDemo {

	public static void main(String[] args) {
		
		int num = 10;
		
		MyFunc myLambda = (n) -> {
			// this is ok, does not modify num
			int v = num + n;
			
			// illegal because num is modified
			//num++;
			
			return v;
		};
		
		// below line is also error, remove effectively final status
		//num = 9;
	}

}
