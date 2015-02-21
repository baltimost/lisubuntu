//: MapExample.java

//package g3ds.joop.ch8;

import java.util.*;

public class MapExample{
    //创建一个映射表
	Map phoneBook = new HashMap();

    //构造方法
	public MapExample(String[] numbers, String[] names) {
		for(int i=0; i< numbers.length; i++) 
			phoneBook.put( numbers[i], names[i] );
    }

	public static void main(String[] args) {
		//准备数据
		String[] names = { "张三", "李四", "王小二", "赵老大" };
		String[] numbers = { "63124567", "54667890", "33456238", "23456789"};

       //创建实例
		MapExample ex = new MapExample( numbers, names);

       //输出表中内容
       System.out.println("Map:  " + ex.phoneBook);

       //返回映射表的视图集
       Set s = ex.phoneBook.entrySet();

       //利用迭代器遍历视图集的内容
       for (Iterator i = s.iterator(); i.hasNext(); ) {
           Map.Entry me = (Map.Entry) i.next();
           Object ok = me.getKey();
           Object ov = me.getValue();
           System.out.println("object：" + me );
           System.out.print("key：" + ok + "\t");
           System.out.println("value：" + ov );
       }
   }
}