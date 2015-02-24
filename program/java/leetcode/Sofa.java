import java.util.*;

public class Sofa {
    public static ListNode sort(ListNode root) {
        int len = listLen(root);
        System.out.println(len);
        ListNode dummy = new ListNode(-1);
        dummy.next = root;
        for(int sublen = 1;sublen < len;sublen *= 2) {
            mergeonce(dummy, sublen);
        }
        return dummy.next;
    }

    private static int listLen(ListNode root) {
        int count = 0;
        ListNode n = root;
        while(n != null) {
            count++;
            n = n.next;
        }
        return count;
    }

    private static void mergeonce(ListNode dummy, int len) {
        for(ListNode walker = dummy.next;walker != null;) {
            ListNode runner = walker;
            ListNode pre = null;
            for(int i = 0;i < len && runner != null && runner.next != null;i++) {
                walker = walker.next;
                runner = runner.next.next;
            }
            dummy = merge(dummy, walker, runner);
            walker = runner;
        }
    }

    private static ListNode merge(ListNode l, ListNode m, ListNode h) {
        System.out.println("hao");
        ListNode i = l.next, j = m;
        ListNode cur = l;
        ListNode pre = null;
        while(i != m && j != h) {
            if(i.val <= j.val) {
                cur.next = i;
                i = i.next;
            }
            else {
                cur.next = j;
                j = j.next;
            }
            cur = cur.next;
        }
        if(i == m) {
            cur.next = j;
            if(j != null) {
                System.out.println("h:"+ (h == null ? null : h.val) + " j:" + (j == null ? null : j.val));
                while(j != h && j.next != h)
                    j = j.next;
                j.next = h; 
            }
            pre = j;
        }
        if(j == h) {
            cur.next = i;
            if(i != null){
                while(i != m && i.next != m)
                    i = i.next;
                i.next = h;
            }
            pre = i;
        }
        return pre;
    }

    public static void main(String[] args) {
        //int[] arr = {2,1};
        //int[] arr = {4,3,1,2};
        //int[] arr = {1,4,2,3};
        int[] arr = {60,71,49,11,82,49,3,66,7};
        ListNode head = ListBuilder.create(arr);
        ListNode n = head;
        Tools.print(head);

        ListNode rst = sort(head);
        Tools.print(rst);
    }
}
