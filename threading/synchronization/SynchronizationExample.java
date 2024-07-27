package threading.synchronization;

class Increment {
    int count;
    public synchronized void incrementCount() {
        count++;
    }
}

public class SynchronizationExample {
    public static void main(String[] args) {
        Increment increment = new Increment();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running thread 1");
                for (int i = 0; i < 1000; i++) {
                    increment.incrementCount();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running thread 2");
                for (int i = 0; i < 1000; i++) {
                    increment.incrementCount();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running thread 3");
                for (int i = 0; i < 1000; i++) {
                    increment.incrementCount();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(increment.count);

    }

}
