package tutorial;
/*
 * 接口(interface)是与类并行的一个概念
 * 1.接口可以看做是一个特殊的抽象类，是常量与抽象方法的一个集合，不能包含变量和一般的方法。
 * 2.接口是没有构造器的。
 * 3.接口定义的就是一种功能，此功能能够被类所实现(implements)
 * 	 比如: class CC implements AA
 *        class CC extends DD implements AA(当一个类既继承一个类又实现一个接口)
 * 4.实现接口的类，必须要重写其中的所有的抽象方法，方可实例化，若没有重写所有的抽象方法，则此类仍为一个抽象类
 * 5.类可以实现多个接口，------java中的类的继承是单继承的
 * 6.接口与接口之间也是继承的关系，而且可以实现多继承
 *   -->5,6描述的是java继承的特点
 * 7.接口与具体的实现类之间也存在多态度性
 */
public class TestInterface {
	public static void main(String[] args) {
		AA aa = new AA() {     //new一个接口时必须要重写接口内的方法
			
			@Override
			public void method2() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void method1() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}

interface AA{
	//常量:所有的常量都用public static final修饰
	int I = 12; 
	boolean FLAG = false;
	//抽象方法:所有的都用public abstract修饰
	void method1();
	void method2();
}

interface MM{
	void method3();
}

interface JJ extends MM,AA{    //接口之间仍为继承关系(而且可以多继承)
	void method4();
}

abstract class BB implements AA{     //如果不对AA中的抽象方法重写，则类BB也是抽象的
	
}

class DD{
	
}

class CC extends DD implements AA,MM{
	public void method1() {
		
	}
	public void method2() {
		
	}
	public void method3() {
		
	}
}

class GG implements JJ{
	
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method4() {
		// TODO Auto-generated method stub
		
	}
	
}
