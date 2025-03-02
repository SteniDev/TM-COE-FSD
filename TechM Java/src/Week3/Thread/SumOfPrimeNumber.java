package Week3.Thread;

public class SumOfPrimeNumber {
    public static void main(String[] args) {
        int range = 100;
        int mid = range / 2;

        // Create two threads to divide the work
        SumOfPrimeThread t1 = new SumOfPrimeThread(2, mid);
        SumOfPrimeThread t2 = new SumOfPrimeThread(mid + 1, range);

        // Start both threads
        t1.start();
        t2.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Sum results from both threads
        int totalSum = t1.getSum() + t2.getSum();
        System.out.println(" Sum of Prime Numbers up to " + range + " is: " + totalSum);
    }
}
