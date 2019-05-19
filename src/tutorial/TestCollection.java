package tutorial;
/*
 * 1.存储对象可以考虑，①数组②集合
 * 2.数组存储对象的特点: Student[] stu = new Student[20]; stu[0] = new Student;....
 *   ---->弊端:①一旦创建，其长度不可变；②真实的数组存放的对象的个数是不可知的。
 * 3.集合
 *    Collection接口
 *        |--------List接口，存储有序的，可以重复的元素
 *              |------ArrayList(主要的实现类)
 *              |------LinkedList（对于频繁的插入、删除操作，建议选择它）
 *              |------vector(该类年代久远,线程安全的，但效率低于ArrayList)
 *        |--------Set接口，存储无序的，不可重复的元素，Set中常用的方法都是Collection下定义的
 *              |------HashSet(主要实现类)
 *              |------LinkedHashSet（使用链表维护了一个添加进集合中的顺序）
 *              |------TreeSet
 *    Map接口，存储键值对的数据
 *        |--------HashMap、LinkedHashMap、TreeMap、HashTable(子类: Properties)
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class TestCollection {
	@Test
	public void testArrayList1() {
		Collection coll= new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add("AAA");
		coll.add("BB");
		//1.size(): 返回集合中元素的个数
		System.out.println(coll.size());
		
		//2.add(Object obj): 向集合中添加一个元素
		Human human = new Human("zhang san", 23);
		coll.add(human);
		System.out.println(coll);
		System.out.println();
		
		//3.addAll(Collection coll): 将形参coll中包含的所有元素添加到当前集合中
		Collection coll1 = new ArrayList();
		coll1.add(123);
		coll1.add("AAA");
		
		coll.addAll(coll1);   //List接口存放有序的，重复的元素
		   
		//查看集合元素
		System.out.println(coll);   //重写了toString()方法
		//4.isEmpty():判断集合是否为空
		System.out.println(coll.isEmpty());
		//5.clear(): 清空集合元素
		coll.clear();
		System.out.println(coll);
	}
	
	@Test
	public void testArrayList2() {
		Collection coll= new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add("AAA");
		coll.add("BB");
		coll.add(new Human("zhang san", 23));
		//6.contains(Object obj):判断集合中是否包含指定的obj元素，如果包含，返回true，反之返回
		//  false,判断依据: 根据元素所在的类的equals()方法进行判断
		//明确一点: 如果存入集合中的元素是自定义类的对象，要求自定义类要重写equals()方法！
		System.out.println(coll.contains(123));
		System.out.println(coll.contains(new Human("zhang san", 23)));    //若不重写equals()方法，则比较的是地址
		
		//7.containsAll(Collection coll): 判断当前集合中是否包含coll中所有的元素
		Collection coll1 = new ArrayList();
		coll1.add(123); 
		coll1.add("BB");
		coll1.add(new Human("zhang san", 23));
		System.out.println(coll.containsAll(coll1));
		
		//8.retainAll(Collection coll): 求当前集合与coll的共有的元素，返回给当前集合(交集), 返回true
		Collection coll2 = new ArrayList();
		coll2.add(123);
		coll2.add("AAA");
		coll2.add("BB");
		coll2.add(12.09);
		coll2.add(new Human("li si", 24));
		System.out.println(coll.retainAll(coll2));
		System.out.println(coll);
		
		
		//9.remove(Object obj): 删除集合中的obj元素，若删除成功，返回true否者返回false
		coll2.remove("BB");
		System.out.println(coll2);
		
		Collection coll3 = new ArrayList();
		coll3.add(123);
		coll3.add("AAA");
		//10.removeAll(Collection coll): 从当前集合中删除包含在coll中的元素。
		coll2.removeAll(coll3);
		System.out.println(coll2); 
		
		Collection coll4 = new ArrayList();
		coll4.add(123);
		coll4.add("AAA");
		coll4.add("BB");
		coll4.add(12.09);
		coll4.add(new Human("li si", 24));
		Collection coll5 = new ArrayList();
		coll5.add(123);
		coll5.add("AAA");
		coll5.add("BB");
		coll5.add(12.09);
		coll5.add(new Human("li si", 24));
		//11.equals(主要Collextion coll): 判断两个集合中的元素是否完全相同
		System.out.println(coll4.equals(coll5));
		
		//12.toArray(): 将集合转化为数组,因为集合中存储的是各种类的对象，所以要用Object对象接收（因为所有类都继承于Object类）
		Object[] obj = coll4.toArray(); 
		for(int i = 0; i < obj.length; i++) {
			System.out.print(obj[i] + "\t");
		}
		System.out.println();
		
		//13.iterator(): 遍历集合元素(迭代器)
		Iterator iterator = coll4.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		} 
	}
}

class Human{
	private String name;
	private int age;
	
	public Human() {
		super();
	}
	
	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override 
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human other = (Human) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false; 
		} else if (!name.equals(other.name))    //调用String类的equals()方法
			return false;
		return true;
	} 

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + "]";
	}
	
}