package Week3.Thread;

class EvenThread extends Thread {
    public void run() {
        for (int i = 2; i < 100; i += 2) {
            System.out.println("Even :" + i);
        }
    }
}
