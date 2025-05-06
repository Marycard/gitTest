package another.demo;


//class Bird extends SuperAnimals {
//} //外部包内不可见default修饰的类

import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;

public class AnotherAnimals {
    static void methodStr() {
        String fs;
        fs = String.format("Hi,%s", "王力");
        System.out.println(fs);
        fs = String.format("Hi %s: %s and %s","各位","A","B");
        System.out.println(fs);

    }
    static void methodGeneric() {
        String[] ss = new String[] { "Orange", "Apple", "Pear" };
        Arrays.sort(ss); //sort调用了CompareTo方法
        System.out.println(Arrays.toString(ss));
        //待排序的String元素已经实现了Comparable<String>泛型接口
        /*
        * */
        Person[] ps = new Person[]{
                new Person("Bob", 61),
                new Person("Alice", 88),
                new Person("Lily", 75),
        };
        Arrays.sort(ps);
        System.out.println(Arrays.toString(ps));
    }

    static void methodList() {
        ArrayList<String> sites = new ArrayList<>(); //在编译时可以避免增加了非string类型
        //实际上在调用ArrayList方法时指明了泛型的具体类型
        sites.add("Java");
        sites.add("C++");
        sites.add("Python");
        //当定义泛型类型<String>后，没有了编译警告，也不需要强制转型


        List<String> listString = new ArrayList<>(); //定义了一个指向List接口的对象引用，实际上是一个List对象
        listString.add("Java");
    }
    public static void main(String[] args) {
//        AnotherAnimals.methodStr();
        AnotherAnimals.methodGeneric();
        HashMap<Integer,String> map = new HashMap<Integer,String>();

    }
}

//可以在接口中定义泛型，但是实现此接口的类必须正确实现接口中的抽象方法
class Person implements Comparable<Person> {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return name + " " + age;
    }
    @Override
    public int compareTo(Person o) {
        return 0;
    }
}

class BRRead{
    static void readChar() throws IOException{
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符，按下'q'键退出");
        do {
            c = (char) br.read();
            System.out.println(c);
        }while(c != 'q');
    }
    static void readString() throws IOException{
        String s;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符串，输入\"end\"退出");
        do {
            s = br.readLine();
            System.out.println(s);
        }while (!s.equals("end"));
    }
    public static void main(String[] args) throws IOException {
//        BRRead.readChar();
        BRRead.readString();
    }
}

class ScannerTest{
    static void nextTest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("next方法接收：");
        if(scanner.hasNextLine()){
            String str1 = scanner.next();
            System.out.println(str1);
        }
        scanner.close();
    }
    static void nextLineTest() {
        Scanner scan = new Scanner(System.in);
        System.out.println("nextLine方法接收：");
        if(scan.hasNextLine()){
            String str1 = scan.nextLine();
            System.out.println("接收一个字符串"+str1);
            int a = scan.nextInt();
            System.out.println("接收一个整型" + a);
//            float b = scan.nextFloat();
//            System.out.println("You entered float " + b);
        }
        scan.close();
    }
    public static void main(String[] args) {
//        ScannerTest.nextTest();



    }



    }
