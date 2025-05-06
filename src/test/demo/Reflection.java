package test.demo;

import javax.xml.namespace.QName;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Reflection {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("Xiaoming");
        Class clazz = s1.getClass();
        Field f1 = clazz.getDeclaredField("name");
        f1.setAccessible(true);
        f1.set(s1,"Xiaohong");
        System.out.println(f1.get(s1));
        System.out.println(f1.getName());
}
    static void getFields() throws Exception {
        /* 获取Field的四个方法*/
        //通过类的静态变量class获取一个Class实例
        Class stdClass = Student.class;
        //获取指定字段
        System.out.println(stdClass.getField("score"));
        System.out.println(stdClass.getField("name"));
        System.out.println(stdClass.getDeclaredField("grade"));

        System.out.println(Arrays.toString(stdClass.getFields())); //获取public字段
        System.out.println(Arrays.toString(stdClass.getDeclaredFields()));//获取当前类的字段，不包含父类
    }
}


class Student extends Person {
    public int score;
    private int grade;
    private String name;
    public Student(String name) {
        this.name = name;
    }
}

class Person {
    public String name;

}

