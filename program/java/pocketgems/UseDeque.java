import java.util.*;

public class UseDeque {
    public static void main(String[] args) {
        Deque<String> deq = new LinkedList<String>();
        deq.offer("e 1");
        deq.offer("e 2");
        deq.offerFirst("e 3");

        while(!deq.isEmpty()) {
            System.out.println(deq.poll());
        }
    }
}
