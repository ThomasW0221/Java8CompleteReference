package lambdas.simple_examples.lambdas_with_multiple_param;

public class LambdaWithMultipleParamsDemo {

	public static void main(String[] args) {
		
		// lambda to determine is second arg is factor of first arg
		NumbericTest2 isFactor = (n, d) -> n % d == 0;
		
		if(isFactor.test(10, 2)) {
			System.out.println("2 is a factor of 10");
		}
		
		if(!isFactor.test(10, 3)) {
			System.out.println("3 is not a factor of 10");
		}
	}

}
