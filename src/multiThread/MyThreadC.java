package multiThread;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadC {
    private AtomicInteger count = new AtomicInteger(0);
    void inc() {
        count.incrementAndGet();
    }


    public static void main(String[] args) {

    }

}
