package deadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock3 {

    private static Lock lockA = new ReentrantLock();
    private static Lock lockB = new ReentrantLock();

    private static volatile boolean aLockFlag = false;
    private static volatile boolean bLockFlag = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {

            try {
                lockA.lock();
                aLockFlag = true;
                while (true) {
                    if (bLockFlag) {
                        System.out.println("A线程尝试获取B锁");
                        lockB.lock();
                        break;
                    }
                }
            } finally {
                System.out.println("A线程执行结束");
            }


        });
        Thread thread2 = new Thread(() -> {
            try {
                lockB.lock();
                bLockFlag = true;
                while (true) {
                    if (aLockFlag) {
                        System.out.println("B线程尝试获取A锁");
                        lockA.lock();
                        break;
                    }
                }
            } finally {
                System.out.println("B线程执行结束");
            }

        });


        thread1.start();
        thread2.start();

    }

}
