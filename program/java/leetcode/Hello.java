import java.util.*;

public class Hello{
    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
    }
    static void foo(Node node){
        node.a = 0;
    }
}

class Node{
    int a = 1;
}
