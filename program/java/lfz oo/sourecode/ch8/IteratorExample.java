//: IteratorExample.java

//package g3ds.joop.ch8;

import java.util.*;

public class IteratorExample{
    public static void main(String[] args) {
        //创建一个集合，不失一般性，应声明为Collection
        Collection c = new HashSet();
		
		//往集合中添加若干元素
        for(int i = 1; i <= 5; i++)
            c.add( new Double(i));
		
		if ( c.isEmpty() ) 
            System.out.println("集合c为空");

        //Collection的add方法有返回值，如果需要改变返回true。
        boolean added;
        //集合允许添加类型不同的元素
        added = c.add("Hello");
        added = c.add( new Date() );
        System.out.println("Collection的add方法修改成功的返回：" + added);
        
        //如果在HashSet中添加相同的元素则不做修改
        added = c.add("Hello");
        System.out.println("Collection的add方法修改不成功的返回：" + added);
        
        System.out.println("集合c中的元素个数：" + c.size());
		
		//利用迭代器访问集合中的元素
		for(Iterator i = c.iterator(); i.hasNext();)
			System.out.print(i.next() + " ; ");
			
		System.out.println();
    }
}