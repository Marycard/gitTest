package test.demo;


class SuperAnimals {
    static int legs = 4;
    static int tails = 1;  //使用static声明的类变量，或者说静态变量
    private static String owner = "organ"; //私有变量
    protected boolean isWild;
    String name;
    int age = 3;
    String gender; //实例变量，不明确初始化会被赋予默认值

    public SuperAnimals(String name, String gender,int age) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }//构造方法,

    public void getAge() {
        String nation = "China";
        System.out.println(this.age); //局部变量，必须初始化
    }
    public String setName(String prefixName) {
        String newName = this.name + "_"+prefixName;
        return newName;
    }
    public void changeOwner(String newOwner) {
        System.out.println("change owner from " + owner + " to " + newOwner);
    }
    public static void main(String[] args) {
        SuperAnimals lily = new SuperAnimals("lily","female", 5);
        lily.getAge();
        String lilyName = lily.setName("little");
        System.out.println(lilyName);
        lily.changeOwner("xioaMing");
    }
}

class Mammal extends SuperAnimals{
    public Mammal(String name, int age, String gender) {
        super(name, gender, age);
    } //子类必须自己实现构造函数，但是可以在里面用super和参数列表显式调用父类的构造方法
    public boolean isSwimming() {
        return true;
    }
    public void isWild(boolean isWild) {
        System.out.println(isWild);
    }
//    public void hasOwner() {
//        System.out.println("has nation" + owner);
//    } //子类没有权限访问父类定义的private变量
}

class Info{
    public static void showInfo() {
        System.out.println("类变量: " + SuperAnimals.legs + "\n"
        + SuperAnimals.tails );
        SuperAnimals sa = new SuperAnimals("sa","female", 6);
        System.out.println("实例变量：" + sa.name +" "+ sa.isWild);
    }
}
public class Animals {
    public static void main(String[] args) {
        Mammal whale = new Mammal("whale", 18, "female");
        whale.isSwimming();
        whale.changeOwner("mingMing");
        whale.isWild(true);
        Info.showInfo();
    }
}