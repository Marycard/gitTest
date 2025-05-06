package multiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread {
    public static int state = 0;
    public static final Lock lock = new ReentrantLock();

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                lock.lock();
                try {
                    if (state % 3 == 0) {
                        System.out.printf("A");
//                        System.out.println(state);
                        state++;
//                        i++;
                        System.out.println(i);
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

        static class ThreadB extends Thread {
            @Override
            public void run() {
                for (int i = 0; i < 10;) {
                    lock.lock();
                    try {
                        if (state % 3 == 1) {
                            System.out.printf("B");
//                            System.out.println(state);
                            state++;
//                            i++;
                            System.out.println(i);

                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        static class ThreadC extends Thread {
            @Override
            public void run() {
                for (int i = 0; i < 10;) {
                    lock.lock();
                    try {
                        if (state % 3 == 2) {
                            System.out.printf("C");
//                            System.out.println(state);
                            state++;
//                            i++;
                            System.out.println(i);
                        }
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
        }
    }
}

//��ռʽ: ����state�ж��߼���ǿ�Ƴ�����ABC˳��ִ�У���ʹ�������߳���ռ����������state������Ҳ��ֱ���ͷ�

