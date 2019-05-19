package tutorial;
/*
 * static修饰属性（类变量）:
 * 1.由类创建的所有的对象，都共用这一个属性
 * 2.当其中一个对象对此属性进行修改，会导致其他对象对此属性的一个调用。vs 实例变量（非static修饰的属性，每个对象拥有一套副本）
 * 3.类变量随着类的加载而加载的，而且独一份  
 * 4.静态的变量可以直接通过“类.类变量”的形式来调用
 * 5.类变量的加载是要早于对象的，所以当有了对象以后，可以使用“对象.类变量”来调用，但是“类.实例变量”是不行的
 * 6.类变量存在于静态域中
 * 
 * static修饰方法（类方法）:
 * 1.随着类的加载而加载，在内存中也是独一份
 * 2.可以直接通过“类.类方法”的方式调用
 * 3.内部可以调用静态的属性或静态的方法，而不能调用非静态的属性或方法。反之，非静态的方法是可以调用静态的属性或方法的 
 * 	  >>>静态的方法是不可以有this或Super关键字的
 * 注: 静态的结构（static的属性、方法、代码块、内部类）的声明周期要早于非静态的结构，同时被回收也要晚于非静态的结构
 * */

/*
 * 题目练习:
 * 编写一个类实现银行账户的概念，包含的属性有“账号”、“密码”、“存款余额”、“利率”、“最小余额”，
 * 定义封装这些属性的方法，账号要自动生成。编写主类，使用一行账户类，输入，输出3个储户的上述信息。
 * 考虑: 哪些属性可以设计成static属性
 * */
public class TestStatic {
	public static void main(String[] args) {
		Account a1 = new Account(500, "abx123");
		Account a2 = new Account(400, "abx456");
		Account a3 = new Account(600, "abx789");
		a1.setPassword("adad1111");  //修改密码
		System.out.println(a1);        //自动调用toString方法
		System.out.println(a2);
		System.out.println(a3);
	}
}

class Account{
	private int id;    //账号ID
	private String password;  //密码
	private double balance;   //余额
	private static double interestRate = 0.05;  //利率
	private static double minBalance = 1;    //最小余额
	private static int init = 1000;      //ID初始化值
	
	public Account(double balance, String password) {
		this.balance = balance;
		this.password = password;
		id = init++;
	}
	
	public int getId() {
		return id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	@Override
	public String toString() {     //重写Object中的toString方法
		return "Account [id=" + id + ", password=" + password + ", balance=" + balance + "]";
	}
	
}