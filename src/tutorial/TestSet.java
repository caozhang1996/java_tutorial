package tutorial;
/*
 * Collection接口
 *        |--------List接口，存储有序的，可以重复的元素
 *              |------ArrayList(主要的实现类)
 *              |------LinkedList（对于频繁的插入、删除操作，建议选择它）
 *              |------vector(该类年代久远,线程安全的，但效率低于ArrayList)
 *        |--------Set接口，存储无序的，不可重复的元素,Set中常用的方法都是Collection接口中的
 *              |------HashSet(主要实现类)
 *              |------LinkedHashSet（使用链表维护了一个添加进集合中的顺序）
 *              |------TreeSet(按照指定的顺序向集合中添加元素)
 */

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

import org.junit.jupiter.api.Test;

public class TestSet {  
	/*
	 * Set: 存储的元素是无序的，不可重复的！
	 * 1、无序性: 无序性！=随机性,真正的无序性指的是元素在底层存储的位置是无序的
	 * 2、不可重复性，当向set中添加进相同的元素的时候，后面的这个是不能添加进去的
	 * 
	 * 说明: 要求添加进Set中的元素所在的类一定要重写equals()和hashCode()方法。
	 *      进而保证Set中元素的不可重复性！ 
	 * Set中的元素是如何存储的呢？使用了哈希算法。
	 * 当向Set中添加对象时，首先调用此对象所在类的hashCode()方法，计算此对象的哈希值，此哈希值
	 * 决定了此对象在Set中的存储位置。若此对象之前没有对象存储，则这个对象直接存储到此位置。若此位置
	 * 已有对象存储，再通过equals()比较这两个对象是否相同。如果相同，后一个对象就不能再添加进来。
	 * 
	 * --->要求: hashCode()方法要与equals()方法一致，一致的意思是: 当两个对象的hashCode值一样，
	 *          尽量它们的属性也是一样的，或者这样说:当两个对象的属性不一样时，两者的hashCode值也不一样
	 */
	@Test
	public void testHashSet() {
		Set set = new HashSet();
		set.add(123);
		set.add(456);
		set.add("AA");  
		set.add("AA");         //AA添加不进去，Set中是不能存放重复元素的
		set.add("BB");
		set.add(null);        //HashSet的特别之处，可以添加null，也是一个元素,只不过为空
		System.out.println(set.size());
		System.out.println(set);
		Human human1 = new Human("zhang san", 23);
		Human human2 = new Human("zhang san", 23);  //当两个对象的属性一样时，得到的hashCode值一样，反之，只要有一个属性不一样,hashCode不一样
		System.out.println(human1.hashCode());
		System.out.println(human2.hashCode());
		System.out.println(human1 == human2);    //虽然两个对象的内容一样，但是地址值不一样
		System.out.println(human1);
		System.out.println(human2);
	}
	
	/*
	 * LinkedHashSet: 使用链表维护了一个添加进集合中的顺序，导致当我们遍历LinkedHashSet集合
	 *                元素时，是按照添加进去的顺序遍历的！
	 *                
	 * LinkedHashSet是HashSet的子类
	 * LinkedHashSet根据元素的hashCode值来决定元素的存储位置，但它同时使用链表维护元素的次序，这
	 * 使得元素看起来是以插入顺序保存的。
	 * LinkedHashSet插入性能略低于HashSet，但在迭代访问Set里的全部元素时有很好的性能。
	 * LinkedHashSet不允许集合元素重复
	 */
	@Test
	public void testLinkedHashSet() {
		Set<String> set = new LinkedHashSet<String>();         //泛型的使用
		set.add("AA");
		set.add("BB");
		set.add("CC");
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + "\t");
		}
	}
	/*
	 * TreeSet:
	 * 1.向TreeSet中添加的元素必须是同一个类的。
	 * 2.可以按照添加进集合中的指定的顺序遍历。像String，包装类等默认按照从小到大的顺序遍历。
	 * 3.当向TreeSet中添加自定义类的对象时，有两种排序方法: ①自然排序②定制排序
	 * 4.自然排序: 要求自定义类实现java.lang.Comparable接口并重写compareTo(Object obj)方法
	 *   在此方法中，要指明按照自定义类的哪个属性进行排序
	 * 5.向TreeSet中添加元素时，首先按照compareTo()进行比较，一旦返回0，虽然仅是两个对象的此属性值
	 *   相同，但是程序会认为这两个对象是相同的，进而后一个对象就不能添加进来
	 *     ---->TreeSet中的顺序是:先上来就compareTo，compareTo不一样了再hashCode，然后equals
	 * 要求compareTo()与hashCode()以及equals()方法一致
	 */
	@Test
	public void testTreeSet1() {    //自然排序
		TreeSet set = new TreeSet();
//		set.add("AA");
//		set.add("BB");
//		set.add("CC");
//		set.add("DD");
//		set.add(1);        //添加不同类型的对象会报错
		
		//当Customer类没有实现Comparable接口时，当向TreeSet中添加Customer对象时，报ClassCastException错误
		set.add(new Customer("zhang san", 1001));
		set.add(new Customer("zhang san", 1002));
		set.add(new Customer("zhang san", 1004));
		set.add(new Customer("zhang san", 1003));
		
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Object object = (Object) it.next();
			System.out.println(object);
		}
	}
	
	/*
	 * TreeSet的定制排序:
	 */
	@Test
	public void testTreeSet2() {   //定制排序
		//1.创建一个实现了Comparator接口的类对象（与Comparable接口不一样)
		Comparator comparator = new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Human && o2 instanceof Human) {
					Human hm1 = (Human)o1;
					Human hm2 = (Human)o2;
					int i = hm1.getAge() - hm2.getAge();
					if(i == 0) {
						return hm1.getName().compareTo(hm2.getName());
					}else {
						return i;
					}
				}
				return 0;
			}
		};
		
		//2.在TreeSet构造器中传入comparator
		TreeSet set = new TreeSet(comparator);
		//3.添加类对象
		set.add(new Human("zhang san", 23));
		set.add(new Human("li si", 23));
		set.add(new Human("zhang san", 26));
		set.add(new Human("zhang san", 21));
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}

class Customer implements Comparable{
	private String name;
	private Integer id;
	
	public Customer() {
		super();
	}
	
	public Customer(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Customer other = (Customer) obj;
		if (id != other.id)
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
		return "Customer [name=" + name + ", id=" + id + "]";
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Customer) {
			Customer customer = (Customer)o;
			int i = this.id.compareTo(customer.id);
			if(i == 0) {
				return this.name.compareTo(customer.name); 
			}else {
				return i;
			} 
		}
		return 0;
	}
}

