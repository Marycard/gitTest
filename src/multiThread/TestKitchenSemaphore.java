package multiThread;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class TestKitchenSemaphore {

    //�ź���-3�ѹ�
    private  static Semaphore threeWoks = new Semaphore(3);

    public static void main(String[] args) throws InterruptedException {

        //ģ��5������ռ3�ѹ��ĳ���
        for(int i=0;i < 5;i++){
            Thread.sleep(1000); //ģ�����������Ⱥ�˳�򣬴���ʱ����

            new Thread(() -> {
                try {
                    threeWoks.acquire();  //��ȡһ��permit���ź�����������1
                    System.out.println(Thread.currentThread().getName()
                            + "������һ�ѹ�����ʣ" + threeWoks.availablePermits() + "�ѹ�");
                    Thread.sleep(new Random().nextInt(5000)); //ģ��ʹ�ù���ʱ��

                    threeWoks.release();//�ͷ�permit���ź�����������1
                    System.out.println(Thread.currentThread().getName()
                            + "����һ�ѹ�����ʣ" + threeWoks.availablePermits() + "�ѹ�");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}

