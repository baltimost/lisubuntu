import java.util.*;

public class StackTest{
    public static void main(String[] args){
        /*
        Stack<Integer> s = new Stack<Integer>();
        s.push(2);
        s.push(4);
        int top = s.peek();
        System.out.println(top);
        top = s.peek();
        System.out.println(top);
        */
        Stack<Integer> s = new Stack<Integer>();
        s.push(2);
        s.push(4);
        for(Integer x: s)
            System.out.print(x + " ");
        System.out.println();
        
    }
}
