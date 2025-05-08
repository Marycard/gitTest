package testVolatile;

public class TestOrder {
    Element element;
    static class Element {

    }
    public TestOrder(Element element) {
        this.element = element;
    }

    static Thread t1 = new Thread(()->{
        Element element1 = new Element();
        boolean flag = false;
    });

    static Thread t2 = new Thread(()->{
        boolean flag = true;
        while (!flag) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        new TestOrder(element1);
        //尝试写一个关于volatile指令重排序的的线程安全问题。但是jvm应该对这个问题进行了优化，在编译过程中就会报错

    });



    public static void main(String[] args) {

        t1.start();
        t2.start();
    }

}
