package test.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Reflection02 {
    /*
    * 获取Class实例所有的methods*/
   public static void main(String[] args) throws Exception {
       Class stdClazz = Student01.class; //使用Student01的静态变量”class“
       System.out.println(stdClazz.getMethod("getAge", Integer.class));//参数类型也是一个 Class 对象，表示方法的参数类型
       System.out.println(stdClazz.getDeclaredMethod("getScore"));
       System.out.println(stdClazz.getMethods());

       //1. 调用方法
//       Student01 std01 = (Student01) stdClazz.newInstance();
//       Method m = stdClazz.getMethod("getAge", Integer.class);
//       Integer age = (Integer)m.invoke(std01, 2); //在std01实例上调用m方法
//       System.out.println(age);
//
//       //2. 调用静态方法和私有方法
//       Method m2 = stdClazz.getDeclaredMethod("getScore");
//       m2.setAccessible(true);
//       Integer score = (Integer)m2.invoke(null);
//       System.out.println(score);

       //3.调用构造函数，newInstance()构造方法只适用于无参构造器
        Constructor constructor = stdClazz.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        Student01 ins1 = (Student01) constructor.newInstance("xiaohong",98);
        System.out.println(ins1);

        //4.调用接口
       Class superClazz = Integer.class.getSuperclass();
       System.out.println(superClazz);
       Class[] interfaces = Integer.class.getInterfaces();
       for (Class intf : interfaces) {
           System.out.println(intf);
           //获取接口Class的父接口应该使用getInterfaces()
           Class superInterface = intf.getSuperclass();
           System.out.println(superInterface);  //返回null
           Class[] interfaces1 = intf.getInterfaces();
           System.out.println(interfaces1);
       }

       //instanceof:判断某个实例是否属于某个类型
       Student01 std02 = new Student01("xiaohong",98);
       boolean isStudent02 = std02 instanceof Student01;
       //isAssignableFrom():判断该类是否属于某个类的父类
       System.out.println(Student01.class.isAssignableFrom(Person01.class));
       System.out.println(Person01.class.isAssignableFrom(Student01.class));

       //静态调用Hello接口
       Hello hello = new Morning();
       hello.sayHello();




   }

}
class Student01 extends Person01 {
    private double height;
    public int age;
    public String name;
    public int grade;
    private static int score = 98;

    public Student01(String name,double height) {
        super(name);
        this.height = height;
    }
    public Student01(String name,int grade) {
        super(name);
        this.name = name;
        this.grade = grade;
    }

    public Integer getAge(Integer age) {
        this.age = age;
        return age;
    }
    private static Integer getScore() {
        return score;
    }
}
class Person01 {
    String name;
    public Person01(String name) {
        this.name = name;
    }
    public String getName(String name) {
        this.name = name;
        return this.name;
    }
}
