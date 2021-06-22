package ds;

public class LambdaExp {

	interface MyInterface{
		double getSum(double a, double b);
	}
    public static void main( String[] args ) {
//    	() -> { System.out.println("Sum is "); 
//    	//code
//    	}
//    	a -> System.out.println("Sum is " + a);
//    	(a, b) -> System.out.println("Sum is " + (a+b));
    	MyInterface ref;
    	double a= 3.6;
    	double b= 4.5;
    	ref = (x, y)-> x+y;
    	
    	System.out.println("Sum is "+ ref.getSum(a, b));
    }
}