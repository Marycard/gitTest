package deadLock;

import java.util.Date;

public class DeadLock1 {
    private static String obj1 = "lock1";
    private static String obj2 = "lock2";

    static class ThreadA extends Thread {
        public void run() {
            while (true) {
                synchronized (obj1) {
                    try {
                        System.out.print(new Date()+ "线程A获取lock1");
                        Thread.sleep(1000); //加一个休眠，保证另一个锁会被对方获取
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj2) {
                        System.out.print("线程A获取lock2");
                    }
                }
            }

        }
    }
    static class ThreadB extends Thread {
        public void run() {
            while (true) {
                synchronized (obj2) {
                    try {
                        System.out.print(new Date()+"线程B获取lock2");
                        Thread.sleep(1000);//加一个休眠，保证另一个锁会被对方获取
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj1) {
                        System.out.print("线程B获取lock1");
                    }
                }
            }
       }
    }
    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
    }
}
