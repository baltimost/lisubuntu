//: SetExample.java

//package g3ds.joop.ch8;

import java.util.*;

public class SetExample{
   public static void main(String[] args) {
        Collection c = new TreeSet();
        
        String red = "red";
        String green = "green";
        String blue = "blue";
        String magenta = "magenta";
        String yellow = "yellow";
        
        Collection hs1 = new HashSet();
        hs1.add( red );
        hs1.add( green );
        hs1.add( blue );
        hs1.add( magenta );

        Collection hs2 = new HashSet();
        hs2.add( red );
        hs2.add( green );
        hs2.add( yellow );

        //输出源集合的内容
        System.out.println("集合hs1：" + hs1);
        System.out.println("集合hs2：" + hs2);
        
        //创建一个集合intersect使之与hs1内容相同
        Collection intersect = new HashSet(hs1); 
        //并保留hs2中也有的元素，得到双方都有的元素集
        intersect.retainAll(hs2);
     
        System.out.println("集合hs1和hs2都有的元素:" + intersect);

        // 创建另一个集合xor使之与hs1内容相同
        Collection xor = new HashSet(hs1);  
        //往其中加入hs2的所有不同元素
        xor.addAll(hs2); 
        //去掉hs1和hs2都有的元素，得到只有一方有的元素集
        xor.removeAll(intersect);
        
        System.out.println("只包含在集合hs1或hs2中的元素:" + xor);
   }
}