import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();
        t1.setA(10);
        t2.doSome(t1);

        Foo f1 = new Foo();
        f1.doSome(t1);
    }
}

class Test {
    private int a;
    public void setA(int a) {this.a = a;}
    public int getA() { return a; }

    public void doSome(Test test) {
        System.out.println(test.a);
    } 
}

class Foo {
    public void doSome(Test test) {
        System.out.println(test.a);
    } 
}
