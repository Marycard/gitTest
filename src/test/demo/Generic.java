package test.demo;


public class Generic<T> {
    //声明泛型方法,返回类型是一个泛型”T“，修饰符和返回类型之间的”<T>“声明这是一个泛型方法
    //类型参数声明<T>可以包含一个或多个类型1参数
    public <T> T genericMethod(T[] inputArray) {
        for (T input : inputArray) {
            System.out.println(input);
//            return input;
        }
        return inputArray[0];
    }

    public static void main(String[] args) {
        GenericClass<Integer> int1 = new GenericClass<Integer>(124);
        System.out.println(int1.getKey());
    }
}
 //抽象方法，类型参数在实例化时由外部给定，且只能是类类型，不能是基本类型
class GenericClass<T> {
    private T key;
    public GenericClass(T key) {
        this.key = key;
    }
    public T getKey() {
        return key;
    }
    public static void main(String[] args) {
        GenericClass<String> g1 = new GenericClass<String>("a");
        System.out.println(g1.getKey());
    }
}

