//: ListExample.java

//package g3ds.joop.ch8;

import java.util.*;

public class ListExample{
	public static void main(String[] args){
		//创建List的2个对象
		List list1=new LinkedList();
		List list2=new ArrayList();
		
		list1.add("Hello");
		//集合中不能放基本类型，需要用其包装类
		list1.add(new Integer(5));
		list1.add(new Boolean(true));
		//List中元素允许重复
		list1.add("Hello");
		//在指定位置插入
		list1.add(1, "Insert here.");
		
		list2.add("Hello");
		//集合中不能放基本类型，需要用其包装类
		list2.add(new Integer(5));
		list2.add(new Boolean(true));
		//List中元素允许重复
		list2.add("Hello");
		//在指定位置插入
		list2.add(1, "Insert here.");
		
		System.out.println("LinkedList:"+list1);
		System.out.println("ArrayList:"+list2);
	}
}