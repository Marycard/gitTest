package deadLock;

public class DeadLock2 {
    private static String lock1 = "lock1";
    private static String lock2 = "lock2";
    static Thread t1 = new Thread(()->{
        while (true) {
        synchronized (lock1) {
            try {
                System.out.println("A get lock1");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println("A get lock2");
            }
        }
        }
    });
    static Thread t2 = new Thread(()->{
        while (true) {
            synchronized (lock2) {
                try {
                    System.out.println("B get lock2");
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("B get lock1");
                }
            }
        }
    });
    public static void main(String[] args) {
//        DeadLock2 deadLock2 = new DeadLock2();
//        deadLock2.t1.start();
//        deadLock2.t2.start();
        t1.start();
        t2.start();

    }
}
