import java.util.*;

public class Hello{
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.poll();
        q.poll();
        q.poll();
        q.poll();
        q.poll();
        LinkedList<Integer> ll = new LinkedList<Integer>();
        Iterator i = ll.iterator();
        System.out.println(i.hasNext());
        System.out.println(i.next());
    }
}
