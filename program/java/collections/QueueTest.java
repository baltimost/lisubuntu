import java.util.*;

public class QueueTest{
    public static void main(String[] args){
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        q.add(60); 
        q.add(71);
        q.add(49);
        q.add(11);
        q.add(82);
        q.add(49);
        q.add(3);
        q.add(6);
        for(Integer x: q)
            System.out.print(x + " ");
        System.out.println();
        while(!q.isEmpty())
            System.out.print(q.poll() + " ");
        System.out.println();
    }
}
