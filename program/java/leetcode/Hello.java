import java.util.*;

public class Hello{
    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE + "<0?" + (Integer.MIN_VALUE <0));
        System.out.println(Math.abs(Integer.MIN_VALUE) + "<0?" + (Math.abs(Integer.MIN_VALUE) < 0) );

        System.out.println(Integer.MIN_VALUE + 1 + "<0?" + ((Integer.MIN_VALUE + 1) < 0));
        System.out.println(Math.abs(Integer.MIN_VALUE + 1));

        System.out.println(Integer.MIN_VALUE / -1);

        System.out.println((long)Integer.MIN_VALUE - 1);
    }
    static void foo(Node node){
        node.a = 0;
    }
}

class Node{
    int a = 1;
}
