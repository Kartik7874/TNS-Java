package threading.threadGroup;

public class SimpleThread extends Thread{

    public SimpleThread(String str) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName()
                    + " Priority = " + getPriority());
        }
        System.out.format("DONE! %s%n", getName());
    }
}
