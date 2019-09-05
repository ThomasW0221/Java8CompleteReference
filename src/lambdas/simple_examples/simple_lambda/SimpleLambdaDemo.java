package lambdas.simple_examples.simple_lambda;

public class SimpleLambdaDemo {

	public static void main(String[] args) {
		
		MyNumber myNum;
		
		// this lambda is a simple constant expression
		// when assigned to mynum, a class isntance
		// is constructed in which the lambda expression
		// implements getValue() method in MyNumber
		myNum = () -> 123.45;
		
		System.out.println("A fied value: " + myNum.getValue());
		
		// more complex example
		myNum = () -> Math.random() * 100;
		
		System.out.println("A random value: " + myNum.getValue());
		System.out.println("Another random value: " + myNum.getValue());
		
		// below line is an error because it does not match type defined in MyNumber
		//myNum = () -> "123.45";
	}

}
