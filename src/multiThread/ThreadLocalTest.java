package multiThread;

public class ThreadLocalTest {
    static ThreadLocal tl1 = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread t1 = new Thread(()-> {
            tl1.set("123");
            System.out.println(tl1.get());
        });
        t1.start();
    }
}
