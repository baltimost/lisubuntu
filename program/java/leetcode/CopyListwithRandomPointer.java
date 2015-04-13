import java.util.*;
class RandomListNode{
    int label;
    RandomListNode next, random;
    RandomListNode(int x){this.label = x;}
}

public class CopyListwithRandomPointer{
    /*
    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        Map<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode p = head;
        RandomListNode q = null;
        RandomListNode n = dummy;
        while(p != null){
            q = new RandomListNode(p.label);
            q.next = n.next;
            n.next = q;
            n = q;
            hm.put(p, q);
            p = p.next;
            q = q.next;
        }
        p = head;
        q = dummy.next;
        while(p != null){
            q.random = hm.get(p.random);
            p = p.next;
        }
        return dummy.next;
    }
    */
    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();
        List<RandomListNode> leftover = new ArrayList<RandomListNode>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode n = dummy;
        while(head != null){
            n.next = new RandomListNode(head.label);
            n = n.next;
            if(head.random != null){
                if(hm.get(head.random) != null)
                    n.random = hm.get(head.random);
                else
                    leftover.add(head);
            }
            hm.put(head, n);
            head = head.next;
        }
        for(RandomListNode x : leftover)
            hm.get(x).random = hm.get(x.random);
        return dummy.next;
    }
    public static void main(String [] args){
        int[] input = {1,2,3,4};
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode n = dummy; 
        for(int x: input){
            n.next = new RandomListNode(x);
            n = n.next;
        }
        RandomListNode q = dummy.next;
        while(q != null){
            System.out.print(q.label + " ");
            if(q.random != null)
                System.out.print("random:" + q.random.label+" ");
            q = q.next;
        }
        System.out.println();

        RandomListNode k = copyRandomList(dummy.next);
        while(k != null){
            System.out.print(k.label + " ");
            if(k.random != null)
                System.out.print("random:" + k.random.label+" ");
            k = k.next;
        }
        System.out.println();
    }
}
