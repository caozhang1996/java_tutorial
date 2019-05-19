package tutorial;
/*
 * Map接口
 *     |------HashMap:Map的主要实现类
 *     |------LinkedHashMap: 使用链表维护添加进Map中的顺序，故遍历Map时，是按添加的顺序遍历的
 *     |------TreeMap:按照添加进Map中的元素的key的指定属性进行排序。要求:key必须是同一个类的对象！
 *             自然排序和定制排序(针对key而言的)
 *     |------HashTable:(不怎么用)
 *         |----Properties: 
 * Map与Collection并列存在。用于保存具有映射关系的数据Key-Value
 * Map中的key和value都可以是任何引用类型的数据
 * Map中的key用Set来存放，不允许重复，即同一个Map对象所对应的类，需重写hashCode和equals()方法。
 * 常用String类作为Map的“键”
 * key与value之间存在单向一对一关系，即通过指定的key总能找到唯一的、确定的value。
 * 
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.naming.InitialContext;

import org.junit.jupiter.api.Test;

public class TestMap {
	/*
	 * Object put(Object key, Object value):向Map中添加一个元素
	 * Object remove(Object key): 按照指定的key删除key-value对，并返回该value
	 * void putAll(Map t): 存放一个新的Map对象 
	 * void clear(): 清空一个Map对象
	 * Object get(Object key): 获得指定key的value值,若无此key,返回null
	 * boolean containsKey(Object key): 判断该Map对象是否存在key-value键值对，以key传入
	 * boolean containsValue(Object value): 判断该Map对象是否存在key-value键值对，以value传入
	 * int size(): 返回map的长度
	 * boolean isEmpty(): 判断该Map对象是否为空
	 * boolean equals(Object obj): 比较两个Map对象是否相等
	 * 
	 * HashMap 
	 * 1.key是用Set来存放的，不可重复，value使用Collection来存放的，可重复
	 *   一个key-value对是一个Entry。所有的Entry使用Set存放的，也是不可重复的。
	 * 2.向HashMap中添加元素时，会调用key所在的equals()方法，判断两个key是否相同，
	 *   若相同则只能添加进后添加的那个元素
	 */
	@Test
	public void testHashMap1() {
		Map map = new HashMap();
		map.put("AA", 123);
		map.put("BB", 456);
		map.put("BB", 456);    //key不能重复
		map.put(123, "CC");
		map.put(null, null);     //对于HashMap而言，是可以存放空置的
		map.put(new Human("zhang san", 23), 89);
		map.put(new Human("zhang san", 23), 78);  //后添加的value会更改以前的value
		System.out.println(map.size());
		System.out.println(map);
		System.out.println(map.remove("BB") + " " + map); 
		System.out.println(map.get(123));
		System.out.println(map.get(1234));   //不存在该key时，返回null
		System.out.println(map.containsKey("AA"));  //以key传入
		System.out.println(map.containsValue(78));  //以value传入 
		
	}
	
	/*
	 * 如何遍历Map
	 * 元视图操作的方法
	 * Set keySet()
	 * Collection values()
	 * Set entrySet()
	 */
	@Test
	public void testHashMap2() {
		Map map = new HashMap(); 
		map.put("AA", 123);
		map.put("BB", 45);
		map.put(123, "CC");
		map.put(null, null);     
		map.put(new Human("zhang san", 23), 89);
		
		System.out.println("Keys:");
		//1.遍历key集，对于HashMap而言，是可以存放空置的
		Set set = map.keySet();   //得到key的Set集合，再用迭代器迭代或者for循环，迭代出的元素是无序的
		for(Object obj: set) {
			System.out.println(obj);
		}
		System.out.println();
		
		System.out.println("values:");
		//2.遍历value集
		Collection values = map.values();
		Iterator it = values.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		
		//3.遍历key-value对（entry）
		//方式一:
		Set set1 = map.keySet();   //得到key的Set集合，getKey()取出value值
		for(Object obj: set1) {
			System.out.println(obj + "---->" + map.get(obj));
		}
		
		//方式二
		Set set2 = map.entrySet();  //得到entry对的Set集合
		for(Object obj: set2) {
			Map.Entry entry = (Map.Entry)obj;  //多态，类型转换，Entry是Map的内置类
			System.out.println(entry);
 		}
	}
	
	/*
	 * LinkedHashMap:与LinkedHashSet一样维护了一个链表
	 */
	@Test
	public void testLinkedHashMap() {
		Map map = new LinkedHashMap();   //遍历时按添加的顺序的到entry值
		map.put("AA", 123);
		map.put("BB", 45);
		map.put(123, "CC");  
		map.put(new Human("zhang san", 23), 89);
		map.put(null, null);  
		
		Set set = map.keySet();   //得到key的Set集合，getKey()取出value值
		for(Object obj: set) {
			System.out.println(obj + "---->" + map.get(obj));
		}
	}
	
	/*
	 * TreeMap: 
	 */
	@Test
	public void testTreeMap() { 
		Map map = new TreeMap();   //key必须是同一个类的对象！
		map.put(new Graduate("zhang san", 23), 89);
		map.put(new Graduate("li si", 21), 78);
		map.put(new Graduate("wang wu", 23), 65);
		map.put(new Graduate("zhang san", 19), 81);
		
		Set set = map.entrySet();
		for(Object o : set) {
			Map.Entry entry = (Map.Entry)o; 
			System.out.println(entry.getKey() + "---->" + entry.getValue());
		}
	}
}

class Graduate implements Comparable{
	private String name;
	private Integer age;
	
	public Graduate() {
		super();
	}
	
	public Graduate(String name, Integer age) {
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
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
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
		Graduate other = (Graduate) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Graduate [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Graduate) {
			Graduate graduate = (Graduate)o;
			int i = this.age.compareTo(graduate.age);
			if(i == 0) {
				return this.name.compareTo(graduate.name);
			}else {
				return i;
			}
		}
		return 0;
	}
}

