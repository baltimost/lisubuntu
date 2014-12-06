import java.util.*;

public class Hello{
    public static void main(String[] args){
        Node node = new Node();
        System.out.println(node.a);
        Hello.foo(node);
        System.out.println(node.a);
    }
    static void foo(Node node){
        node.a = 0;
    }
}

class Node{
    int a = 1;
}
