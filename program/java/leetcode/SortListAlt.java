import java.util.*;

public class SortListAlt{
    public static ListNode mergesort(ListNode head) {
        int len = 0;
        ListNode n = head;
        while(n != null) {
            n = n.next;
            len++;
        }
        for(int sublen = 1;sublen < len;sublen *= 2) {
            head = mergeonce(head, sublen);
        }
        return head;
    }
    public static ListNode mergeonce(ListNode head, int len) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for(ListNode n = head;n != null;) {
            ListNode m = move(n, len);
            ListNode h = move(m, len); 
            ListNode[] rst = merge(n, m, h);
            tail.next = rst[0]; 
            tail = rst[1]; 
            n = h;
        }
        return dummy.next;
    }
    public static ListNode move(ListNode head, int steps) {
        while(head != null && steps > 0) {
            head = head.next;
            steps--;
        }
        return head;
    }
    public static ListNode[] merge(ListNode l, ListNode m, ListNode h) {
        ListNode[] output = new ListNode[2];
        ListNode dummy = new ListNode(-1);
        ListNode n = dummy;
        ListNode n1 = l, n2 = m;
        while(n1 != m && n2 != h) {
            if(n1.val < n2.val) {
                n.next = n1;
                n1 = n1.next;
            }
            else {
                n.next = n2;
                n2 = n2.next;
            }
            n = n.next;
        }
        if(n2 == h) {
            n.next = n1;
            while(n.next != m) {
                n = n.next;
            }
            n.next = h;

        }
        if(n1 == m) {
            n.next = n2;
            while(n.next != h) {
                n = n.next;
            }
        }
        output[0] = dummy.next; //return head for link;
        output[1] = n; //return tail for traverse; 
        return output;
    }

    public static void main(String[] args) {
        int[] arr = {10,8,6,4,2,7,9,5,3,1};
        //int[] arr = {2,1,3,4};
        ListNode head = ListBuilder.create(arr);
        Tools.print(head);

        ListNode rst = mergesort(head);
        Tools.print(rst);
    }
}
