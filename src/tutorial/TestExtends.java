package tutorial;

/*
 * 一、面向对象的特征而，继承性
 * 1.通过“class A extends B”实现类的继承
 * 		子类： A   父类（或基类 SuperClass）： B
 * 
 * 2.子类继承父类以后，父类中申明的属性、方法、子类就可以获取到。
 * 		注意：当父类中有私有的属性或方法时，子类同样可以获取得到，只是由于封装性的设计
 * 			 使得子类不可以直接调用罢了
 * 		extends: 子类是对父类功能的扩展
 * 
 * 3.java的继承只支持单继承，一个子类只能继承一个父类，反之，一个父类可以有多个子类
 * 
 * 二、方法的重写
 * 		当父类中的方法不适用与子类时，可以重写方法，但两者的“修饰符 返回类型 方法名（形参列表）”要一致
 * 三、super的使用
 * 		super可以用来修饰属性、方法、构造器
 * 1）当子类与父类中有同名的属性时，可以通过“super.此属性”显式地调用父类中声明的属性，
 * 	  若要调用子类同名的属性，用“this.此属性”或者直接调用，不用加this
 * 2）当子类重写父类方法以后，在子类中若想显式地调用父类的被重写的方法，就需要使用“super.此方法”
 * 3）super修饰构造器，通过在子类中使用“super(形参列表)”来显式地调用父类中指定的构造器。
 * 	  注意：在构造器内部，“super(形参列表)”必须放在首行！
 * 		   当构造器中不显式地调用“super(形参列表)”时，默认调用的是父类空参的构造器！
 * */
/*
 * 类的继承，方法的重写练习
 * 1.构造一个Circle(圆)类，属性为radius
 * 2.构造一个Cylinder(圆柱体)类 继承Circle类
 * */
public class TestExtends {
	public static void main(String[] args) {
		Circle circle = new Circle(2.0);
		double area = circle.findArea();
		System.out.println("圆的面积为: " + area);
		
		Cylinder cylinder = new Cylinder(3.0, 3.0);
		System.out.println(cylinder.getRadius() + " " + cylinder.getLength());
		
		double cylinder_area = cylinder.findArea();
		double volume = cylinder.findVolume();
		System.out.println("圆柱体表面积为: " + cylinder_area);
		System.out.println("圆柱体体积为: " + volume);
	}
}

class Circle{
	private double radius;
	
	public Circle() {
		radius = 1;
	}
	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	} 

	public double findArea() {
		return Math.PI * radius * radius;
	}
}
 
class Cylinder extends Circle{        //Cylinder类继承Circle类，Circle是父类，Cylinder是子类
	private double length;
	
	public Cylinder() {
		super();
		length = 1;
	}
	public Cylinder(double radius, double length) {
		super(radius);                 //显式调用父类构造器public Circle(double radius)
		this.length = length;
	}
 
	public double getLength() {
		return length;
	}
	
	public double findVolume() {
		return super.findArea() * length;     //继承后可以使用父类中的方法
	}
	
	public double findArea() {         //子类可以对父类中的方法重写 
		return 2 * Math.PI * getRadius() * getLength() + 2 * super.findArea();  
	}
}
