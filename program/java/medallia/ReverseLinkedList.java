import java.util.*;

public class ReverseLinkedList {
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val= val;
        }
    }
    public Node createList(int[] arr) {
        Node dummy = new Node(-1);
        Node n = dummy;
        for(int x : arr) {
            n.next = new Node(x);
            n = n.next;
        }
        return dummy.next;
    }
    public Node reverse(Node head, int n) {
        Node dummy = new Node(-1);
        dummy.next = head;
        int len = length(head);
        if(n > len) {
            return head;
        }
        int firstLen = len % n;
        Node curH = head; 
        Node curT = move(curH, firstLen == 0 ? n - 1 : firstLen - 1);
        System.out.println("firstLen:"+firstLen);
        System.out.println("curH:"+curH.val+" curT:"+curT.val);
        while(curT!= null && curT.next != null) {
            Node nexH = curT.next;
            Node nexT = move(nexH, n - 1);
            curT.next = nexT.next;
            nexT.next = dummy.next;
            dummy.next = nexH;
        }
        return dummy.next;
    }
    private int length(Node head) {
        int count = 0;
        Node n = head;
        while(n != null) {
            n = n.next;
            count++;
        }
        return count;
    }
    private Node move(Node head, int n) {
        while(head != null && n > 0) {
            head = head.next;
            n--;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        ReverseLinkedList rll = new ReverseLinkedList();
        Node head = rll.createList(arr);
        //Node n = head;
        Node n = rll.reverse(head, 1);
        while(n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }
}
