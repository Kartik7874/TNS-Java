package threading.runnableInterface;

public class PrintNameRunnable implements Runnable {

    String name;

    public PrintNameRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.print(name);
        }
    }

}
