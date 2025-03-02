package Week3.Thread;

public class EvenOdd extends Thread {
	public static void main(String[] args) {

		EvenThread thread1 = new EvenThread();
		OddThread thread2 = new OddThread();
		thread1.start();
		thread2.start();
	}
}

