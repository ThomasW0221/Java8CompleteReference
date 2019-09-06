package lambdas.exceptions;

public interface DoubleNumberArrayFunc {

	double func(double[] n) throws EmptyArrayException;
}

class EmptyArrayException extends Exception{
	EmptyArrayException(){
		super("Array Empty");
	}
}
