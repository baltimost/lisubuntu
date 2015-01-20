import java.util.*;

public class foo{
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        /*
        pq.add(8);
        pq.add(7);
        pq.add(6);
        pq.add(5);
        pq.add(4);
        */
        pq.add(4);
        pq.add(5);
        pq.add(6);
        pq.add(7);
        pq.add(8);
        for(Integer x : pq)
            System.out.print(x + " ");
        System.out.println();
    }
}
