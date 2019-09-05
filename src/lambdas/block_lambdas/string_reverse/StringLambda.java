package lambdas.block_lambdas.string_reverse;

public class StringLambda {

	public static void main(String[] args) {
		
		// this block reverses characters in a string
		StringFunc reverse = (str) -> {
			String result = "";
			
			for(int i = str.length() - 1; i >= 0; i--) {
				result += str.charAt(i);
			}
			return result;
		};
		
		System.out.println("Lambda backwards is " + reverse.func("lambda"));
		System.out.println("Expression backwards is " + reverse.func("expression"));
	}
	
	
}
