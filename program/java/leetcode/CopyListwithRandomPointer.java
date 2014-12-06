import java.util.*;
class RandomListNode{
    int label;
    RandomListNode next, random;
    RandomListNode(int x){this.label = x;}
}

public class CopyListwithRandomPointer{
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
    public static void main(String [] args){
        int[] input = {1,2,2,2};
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode n = dummy; 
        RandomListNode q = null;
        for(int x: input){
            q = new RandomListNode(x);
            q.next = n.next;
            n.next = q;
            n = q;
        }
        q = dummy.next;
        while(q != null){
            System.out.print(q.label + " ");
            q = q.next;
        }
        System.out.println();

        RandomListNode k = copyRandomList(dummy.next);
        while(k != null){
            System.out.print(k.label + " ");
            k = k.next;
        }
        System.out.println();
    }
}
