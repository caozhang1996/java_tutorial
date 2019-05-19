package tutorial;
/**
 * Test_Class
 * 一、面向对象思想的落地法则:
 * 1、设计类，并设计类的成员（成员变量&成员方法 ）
 * 2、通过类，来创建类的对象（也称作类的实例化）
 * 3、通过“对象.属性”或“对象.方法”来调用，完成相应的功能
 * 
 * 二、创建的多个对象，彼此各自拥有一套类的属性，当对其中一个对象的属性修改时，不会影响
 * 到其他对象的属性值。
 * 
 * 三、类的属性(成员变量)
 *      成员变量 vs 局部变量
 *      相同点:1、遵循变量声明的格式：数据类型 变量名 = 初始化值
 *            2、都有作用域
 *      不同点:1、声明的位置不同，成员变量：声明在类中，方法外。
 *                            局部变量：声明在方法内，方法的形参部分，代码块内。
 *            2、成员变量的修饰符有四个:public,private,protected,缺省
 *              局部变量没有修饰符，与所在方法的修饰符相同。
 *            3、初始化值:一定会有初始化值
 *               成员变量:如果在声明的时候，不显式的赋值，那么不同数据类型会有不同的默认初始化值。
 *               默认初始化值: 
 *                          byte short int long ==>0
 *                          float double ==>0.0
 *                          char ==>空格
 *                          boolean ==>false
 *                          引用类型变量  ==>null
 *               局部变量: 一定要显式的赋值（局部变量没有默认初始化值）
 *            4、二者在内存中存放的位置不同，成员变量存在与堆空间中，局部变量存在与栈空间中
 * 四,类的方法:提供某种功能的实现
 *      1)实例: public void eat(){}
 *              public String getName(){}
 *              public void setName(String n){}
 *        格式: 权限修饰符 返回值类型(void:无返回值/具体的返回值) 方法名(形参){}
 *   
 *      2)关于返回值类型:void:表明此方法不需要返回值
 *                     有返回值的方法:在方法的最后一定有return + 返回值类型对应的变量
 *      3)方法内可以调用本类的其他方法或属性,但是不能在方法内再定义方法!
 */
public class Test_Class{
    public static void main(String[] args) {
        //基本数据类型的申明:数据类型 变量名 = 初始化值
        int i = 10;
        //类的实例化:如下的a1就是一个实实在在的对象
        Animal a1 = new Animal();

        //通过对象调用属性
        a1.name = "花花";
        a1.age = 3;
        System.out.println("name: " + a1.name + "age: " + a1.age);
 
        //通过对象调用方法
        a1.eat();
        a1.sleep();

        //再创建一个类的对象
        Animal a2 = new Animal();
        System.out.println("name: " + a2.name + "age: " + a2.age);//null, 0
        a2.name = "小花";
        System.out.println("name: " + a1.name + "age: " + a1.age);
        System.out.println("name: " + a2.name + "age: " + a2.age);

        //a3不意味着相较于a1重新创建的一个对象，而是a1与a3共用一个对象实体
        Animal a3 = a1;
        System.out.println("name: " + a3.name + "age: " + a3.age);//与a1一样
        a3.name = "维尼熊";
        System.out.println("name: " + a1.name + "age: " + a1.age);

        System.err.println();
        System.err.println();
        System.err.println();

        System.out.println("---------------Test_Person分隔线------------------");
        Person p1 = new Person();
        p1.info();

        p1.name = "Tony Stark";
        p1.age = 44;
        p1.gender = true;
        p1.info();

        p1.setName("Chris Evens");
        p1.info();
    }
}

class Animal{
    //1.属性
    String name;
    int age;

    //2.方法
    public void eat() {
        System.out.println("动物进食");
    }

    public void sleep(){
        System.out.println("动物休眠");
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }
}
/**
 * 补充说明:
 *      1、面向对象的编程关注于类的设计
 *      2、设计类实际上就是设计类的成员
 *      3、基本的类的成员，属性（成员变量或Field）&方法（Method）
 */
class Person{
    //1.属性
    String name;
    int age;
    boolean gender;          //true for male, false for female

    //2.方法
    public void eat(){
        System.out.println("人吃饭");
    }

    public void sleep(){
        System.out.println("人睡觉");
    }

    public void setName(String n) {   //n:局部变量
        name = n;
    }

    public String getName(){
        return name;
    }

    public void info(){
        System.out.println("name: " + name + "age: " + age + "gender: " + gender);
    }
}