package threading.runnableInterface;

public class PrintNameRunnableDefaultStart implements Runnable{
    String name;

    public PrintNameRunnableDefaultStart(String name) {
        this.name = name;
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.print(name);
        }
    }
}
