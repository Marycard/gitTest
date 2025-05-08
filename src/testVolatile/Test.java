//检测原子性
package testVolatile;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.currentThread;

public class Test {

    /*
    不具有原子性的写法
    public volatile int inc = 0;
    public void increase() {
        inc++;
    }
    */
    public AtomicInteger inc = new AtomicInteger();
    public void increase() {
        inc.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        final Test test = new Test();
        System.out.printf(Thread.currentThread().getName()+ " ");
        Thread[] Thread = new Thread[3];
        for(int i=0;i<3;i++) {
            Thread[i] = new Thread(() -> {
                for(int j=0;j<10000;j++) {
                    test.increase();
                }
                System.out.printf(currentThread().getName()+"循环结束 ");
            });
        }
        /*
        如何确保三个子线程都执行完 1. join()是实例方法  2.yield()是类方法+activeCount():但是这种方法有可能是抢占到的一直是“主线程”
        while (Thread.activeCount()>1) {
            Thread.yield();
        }
        */

        /*
        for (Thread t : Thread) {
            t.start();
            t.join();
        }
        这种特殊的按顺序启动子线程并执行，规避了多线程并发的竞争，但是也限制程序变成单线程启动，降低了高并发的性能
        */

        /*这种分开启动和堵塞的for循环，就会出现多线程竞争的问题，且由于自加操作不是原子操作，出现了线程安全问题*/
        for (Thread t: Thread) {
            t.start();
        }
        for (Thread t: Thread) {
            t.join();
        }
        System.out.println("inc的值是："+test.inc);

    }
}
