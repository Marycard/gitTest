package multiThread;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class TestKitchenSemaphore {

    //信号量-3把锅
    private  static Semaphore threeWoks = new Semaphore(3);

    public static void main(String[] args) throws InterruptedException {

        //模拟5个人抢占3把锅的场景
        for(int i=0;i < 5;i++){
            Thread.sleep(1000); //模拟进入厨房的先后顺序，存在时间间隔

            new Thread(() -> {
                try {
                    threeWoks.acquire();  //获取一个permit，信号量计数器减1
                    System.out.println(Thread.currentThread().getName()
                            + "拿走了一把锅，还剩" + threeWoks.availablePermits() + "把锅");
                    Thread.sleep(new Random().nextInt(5000)); //模拟使用锅的时长

                    threeWoks.release();//释放permit，信号量计数器加1
                    System.out.println(Thread.currentThread().getName()
                            + "还回一把锅，还剩" + threeWoks.availablePermits() + "把锅");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}

