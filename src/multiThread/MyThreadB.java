package multiThread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 采用contidional signaling条件唤醒实现多线程，相比抢占式锁，性能更高
public class MyThreadB {

    public static int state = 0;
    static Lock lock = new ReentrantLock();
    static Condition A= lock.newCondition();
    static Condition B= lock.newCondition();
    static Condition C= lock.newCondition();

    static class ThreadA extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (state % 3 != 0) {
                        A.await();
                    }
                    System.out.printf("A");
                    state++;
                    B.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    static class ThreadB extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (state % 3 != 1) {
                        B.await();
                    }
                    System.out.printf("B");
                    state++;
                    C.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }

        }
    }
    static class ThreadC extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (state % 3 != 2) {
                        C.await();
                    }
                    System.out.printf("C");
                    state++;
                    A.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }

        }
    }
    public static void main(String[] args) throws InterruptedException {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
//        ThreadC.join();
        ThreadC threadC = new ThreadC();
        threadC.join();
    }
}
