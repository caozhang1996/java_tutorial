package tutorial;
/*
 * 包装类的使用
 * 包装类:8种基本数据类型对应着一个类，此类即为包装类
 * 基本数据类型 包装类 以及String之间的相互转换
 * */

import org.junit.jupiter.api.Test;

public class TestWrapper {
	public static void main(String[] args) {
		
	}
	//基本数据类型与包装类之间的转换
	@Test
	public void test1() {
		int i = 10;
		Integer i1 = new Integer(i); //基本数据类型 ----> 对应的包装类:调用包装类的构造器
		System.out.println(i1.toString());
		
		Float float1 = new Float(12.3f);
		System.out.println(float1);
		
		i1 = new Integer("12");     //也可以传String类型的数据
		System.out.println(i1);
		
		Boolean b = new Boolean("true1aa");  //只要传的值不是true就认为是false
		System.out.println(b);
		//包装类 ---->基本数据类型
		int i2 = i1.intValue();
		System.out.println(i2);
		float float2 = float1.floatValue();
		System.out.println(float2);
	}
	
	//基本数据类型、包装类与String类之间的转换
	@Test
	public void test2() {
		//基本数据类型、包装类 ----> String类:使用String.valueOf()方法
		int i1 = 10;
		String str1 = i1 + "";    //"10",最简洁的方式
		Integer i2 = i1;     //自动装箱
		String str2 = String.valueOf(i1);  //第二种方法，调用String的方法
		String str3 = String.valueOf(i2);  //包装类转换为String类
		String str4 = String.valueOf(true);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		//String类 ----> 基本数据类型、包装类:使用包装类.parseXxx()方法
		System.out.println(Integer.parseInt(str2));
		System.out.println(Boolean.parseBoolean(str4));
	}
}

class StudentScore{
	
}
