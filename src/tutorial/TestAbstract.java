package tutorial;
/*
 * 抽象类的使用
 * abstract: 抽象的，可以用来修饰类，方法
 * 
 * 1.abstract修饰类: 抽象类
 * 1)不可被实例化
 * 2)抽象类有构造器（凡是类都有构造器）
 * 3)抽象方法所在的类一定是抽象类
 * 4)抽象类中可以没有抽象方法
 * 
 * 2.abstract修饰方法: 抽象方法
 * 1)格式: 没有方法体，包括{}。如: public abstract void eat(); 
 * 2)抽象方法只保留方法的功能，而具体的执行，交给抽象类的子类，由子类重写此抽象方法
 * 3)若子类继承抽象类，并重写了所有的抽象方法，则此类是一个“实体类”，既可以实体化
 * 4)若子类继承抽象类，没有重写所有的抽象方法，意味着此类中仍有抽象方法，则此类必须声明为抽象的（如下面的Worker类）
 */
public class TestAbstract {
	public static void main(String[] args) {
		Student student = new Student("LiMeiMei");
		student.eat();
		student.walk();
		System.out.println();
		
		FactoryWorker factoryWorker = new FactoryWorker("LiLei");
		factoryWorker.eat();
		factoryWorker.walk();
	}
}

abstract class Creator{
	public abstract void breath();
}


abstract class People extends Creator{
	protected String name;
	public People(){
		
	}
	public People(String name){
		this.name = name;
	}
	public abstract void eat();              //抽象方法，保留功能，具体执行交给抽象类的子类
	public abstract void walk();
	public abstract String getName();
	public abstract void setName(String name);
}

class Student extends People{
	public Student(String name) {
		super(name);
	}
	@Override
	public void breath() {
		System.out.println("学生呼吸！");
	};
	@Override
	public void eat() {
		System.out.println("学生吃饭！");
	}
	@Override
	public void walk() {
		System.out.println("学生走路！");
	}
	public String getName() {
		return name;
	};
	public void setName(String name) {
		this.name = name;
	}
}

abstract class Worker extends People{          //Worker继承了父类People，但没有重写抽象方法，所以它也是一个抽象类
	public Worker(String name) {
		this.name = name;
	}
	public void eat() {
		System.out.println("工人吃饭！");
	}
}

class FactoryWorker extends Worker{

	public FactoryWorker(String name) {
		super(name);
	}
	@Override
	public void walk() {
		System.out.println("工厂工人快速走路！");
	}
	@Override
	public String getName() { 
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void breath() {
		System.out.println("工厂工人呼吸！");
	}	
}


