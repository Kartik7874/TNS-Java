package threading;
class ExtendThreadClassTest1 extends Thread{
    //start method in side constructor
    public ExtendThreadClassTest1(String name) {
        super(name);
        start();
    }
    public void run(){
        System.out.println("run() method of the " + this.getName() + " thread is called" );

        for (int i = 0; i < 10; i++) {
            System.out.print(this.getName());
        }
    }
}


public class ExtendThreadClassTest0  extends Thread{

    public ExtendThreadClassTest0(String name) {
        super(name);
    }
    public void run(){
        System.out.println("\nrun() method of the " + this.getName() + " thread is called" );

        for (int i = 0; i < 10; i++) {
            System.out.print(this.getName());
        }
    }

    public static void main(String[] args) {
        ExtendThreadClassTest0 pnt1 = new ExtendThreadClassTest0("A");
        System.out.println("Calling start() method of " + pnt1.getName() + " thread");
        pnt1.start();

        ExtendThreadClassTest0 pnt2 = new ExtendThreadClassTest0("B");
        System.out.println("Calling start() method of " + pnt2.getName() + " thread");
        pnt2.start();

        ExtendThreadClassTest0 pnt3 = new ExtendThreadClassTest0("C");
        System.out.println("Calling start() method of " + pnt1.getName() + " thread");
        pnt3.start();

        ExtendThreadClassTest1 defaultStart = new ExtendThreadClassTest1("D");
    }
}
