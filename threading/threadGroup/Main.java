package threading.threadGroup;

public class Main {
    public static void main(String[] args) {
        SimpleThread st1 = new SimpleThread("Ahmedabad");
        st1.start();
        st1.setPriority(1);

        SimpleThread st2 = new SimpleThread("Pune");
        st2.start();
        st2.setPriority(5);

        SimpleThread st3 = new SimpleThread("Delhi");
        st3.start();
        st3.setPriority(10);

//        SimpleThread st4 = new SimpleThread("Mumbai");
//        st4.start();
//        st4.setPriority(10);

        ThreadGroup group = Thread.currentThread().getThreadGroup();
        System.out.println("Number of active threads in this thread group = "
                + group.activeCount());

        // Display the names of the threads in the current
        // ThreadGroup.

        Thread[] tArray = new Thread[10];
        int actualSize = group.enumerate(tArray);
        for (int i=0; i<actualSize;i++){
            System.out.println("Thread " + tArray[i].getName()
                    + " in thread group " + group.getName());
        }
    }
}
