import java.util.*;

public class HeapLib {
    public static void main(String[] args) {
        Queue<Integer> a = new PriorityQueue<Integer>(2, new MyComparator());
        a.offer(60);
        a.offer(71);
        a.offer(82);
        a.offer(49);
        a.offer(11);
        a.offer(82);
        a.offer(3);
        a.offer(66);
        System.out.println(a.poll());
        System.out.println(a.poll());
    }

    public static class MyComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }
}
