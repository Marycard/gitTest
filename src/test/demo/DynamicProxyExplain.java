package test.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyExplain {
    public static void main(String[] args) {
        //实现InvocationHandler接口，并实现invoke接口
        InvocationHandler handler = new InvocationHandler() {
            //代理对象调用方法时，会根据具体的invoke重定向方法
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
        //使用Proxy.newProxyInstance创建代理对象
        HelloDynamic hello = (HelloDynamic) Proxy.newProxyInstance(
                Hello.class.getClassLoader(), // 传入ClassLoader
                new Class[] { Hello.class }, // 传入要实现的接口
                handler); // 传入处理调用方法的InvocationHandler
        hello.morning("Bob");
    }
}

interface HelloDynamic {
    void morning(String name);
}

