package reverseLinked;

public class parasPass {


    static class User {
        int age;
        String name;

        public void setAge(int age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void pass(User user) {
//        user = new User();
        user.setAge(10);
        user.setName("Alice");
        System.out.println("print in pass,user is" + user.name + user.age);
        //print in pass,user isAlice10  按照预想输出了改变后的值，因为此时新建了user对象，虚拟机会重新开辟一个新的内存空间
        //所以对新空间的更改，不会影响到原始对象


        //当注释新定义的user对象时，输出print in pass,user isAlice10  print in main,user isAlice10
        //当传递对象时引用类型时，传递的是参数对象的地址副本，后续修改参数对象的值，也会影响原始对象

    }

    public static void pass_String(String str) {
        str = "hello";
        System.out.println("print in pass,str is" + str);
        //print in pass,str ishello，输出了改变后的值，因为str = "hello"; 这一行代码会通过字面量方式新建一个对象。此时同理new User()
        //所以对新空间的更改，不会影响到原始对象
    }
    public static void main(String[] args) {
        User user_pass = new User();
        user_pass.setName("Bob");
        user_pass.setAge(20);
        pass(user_pass);
        System.out.println("print in main,user is" + user_pass.name + user_pass.age);

        String str_pass = "hello_pass";
        pass_String(str_pass);
        System.out.println("print in main,str is" + str_pass);
    }

}
