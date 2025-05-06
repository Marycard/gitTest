package testVolatile;

import static java.lang.Thread.currentThread;

public class Test {
    public volatile int inc = 0;
    public void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final Test test = new Test();
        System.out.printf(Thread.currentThread().getName()+ " ");
        Thread[] Thread = new Thread[10];
        for(int i=0;i<10;i++) {
            Thread[i] = new Thread(() -> {
                for(int j=0;j<10000;j++) {
                    test.increase();
                }
                System.out.printf(currentThread().getName()+"循环结束 ");
            });
        }
        //如何确保三个子线程都执行完 1. join()是实例方法  2.yield()是类方法+activeCount():但是这种方法有可能是抢占到的一直是“主线程”
//        while (Thread.activeCount()>1) {
//            Thread.yield();
//        }
        for (Thread t : Thread) {
            t.start();
            t.join();
        }
        System.out.println("inc的值是："+test.inc);

    }
}
