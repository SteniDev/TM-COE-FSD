package Week3.ExceptionHandlings;

public class ExceptionHandlingExample {
public static void main(String[] args) {

	try {
		int n=10/0;
	} catch (ArithmeticException e) {
		// TODO: handle exception
		System.out.println("Cant "+e.getMessage());
	}
}
}
