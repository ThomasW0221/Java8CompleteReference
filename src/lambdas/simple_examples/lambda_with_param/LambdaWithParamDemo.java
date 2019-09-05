package lambdas.simple_examples.lambda_with_param;

public class LambdaWithParamDemo {

	public static void main(String[] args) {
		
		// lambda to test if number is even
		NumericTest isEven = (n) -> n % 2 == 0;
		
		if (isEven.test(10)) {
			System.out.println("10 is even");
		}
		if(!isEven.test(9)) {
			System.out.println("9 is not even");
		}
		
		// now use lambda to test that num is non negative
		NumericTest isNonNeg = (n) -> n >= 0;
		
		if(isNonNeg.test(1)) {
			System.out.println("1 is non negative");
		}
		if(!isNonNeg.test(-1)) {
			System.out.println("-1 is negative");
		}
	}

}
