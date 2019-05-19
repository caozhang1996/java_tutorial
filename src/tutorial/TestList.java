package tutorial;
/*
 * ArrayList: List的主要实现类
 * List中相对于Collection新增加的方法
 * void add(int index, Object ele):在指定的索引位置index添加元素ele
 * boolean addAll(int index, Collection eles):在指定的索引位置处添加一个集合
 * Object get(int index):获取指定索引处的元素
 * int indexOf(Object obj):
 * int lastIndexOf(Object obj)
 * Object remove(int index):删除指定索引位置处的元素
 * Object set(int index, Object ele):设置指定索引位置处的元素为ele
 * List subList(int fromIndex, int toIndex):获取子集
 * 
 * List常用的方法:增（add(Object)）删(remove)改(set(int index, Object ele))
 *              查(get(int index))插(add(int index, Object ele)),长度(size())
 */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class TestList {
	@Test
	public void testList1() {
		List list = new ArrayList();
		list.add(123);
	}
}
