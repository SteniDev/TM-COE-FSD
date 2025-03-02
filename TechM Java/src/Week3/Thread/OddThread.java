package Week3.Thread;

class OddThread extends Thread {

    public void run() {
        for (int i = 1; i < 100; i += 2) {
            System.out.println("Odd no is :" + i);
        }
    }
}
