package test.demo;

public interface Hello {
    public void sayHello();
}

class Morning implements Hello {
    public void sayHello() {
        System.out.println("Hello Morning");
    }
}



