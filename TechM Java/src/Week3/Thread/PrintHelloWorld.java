package Week3.Thread;

public class PrintHelloWorld extends Thread{
public static void main(String[] args) {
	PrintHelloWorld a =new PrintHelloWorld();
	a.start();
}

public void run() {
	System.out.println("Hello World is ");
}
}