package threading.runnableInterface;

public class Main {
    public static void main(String[] args) {
        PrintNameRunnable test1 = new PrintNameRunnable("A");
        Thread t1 = new Thread(test1);
        t1.start();

        PrintNameRunnable test2 = new PrintNameRunnable("B");
        Thread t2 = new Thread(test2);
        t2.start();

        PrintNameRunnable test3 = new PrintNameRunnable("C");
        Thread t3 = new Thread(test3);
        t3.start();

        PrintNameRunnableDefaultStart defaultStart = new PrintNameRunnableDefaultStart("D");

    }
}
