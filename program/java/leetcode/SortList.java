public class SortList{ 
    public static ListNode sortList(ListNode head){
        helper(head, null);
        return head;
    }
    public static void helper(ListNode h, ListNode t){
        if(h == t)
            return;
        ListNode p = h;
        ListNode q = p.next;
        int pivot = h.val;
        while(q != t){
            if(q.val < pivot){
                p = p.next;
                int tmp = p.val;
                p.val = q.val;
                q.val = tmp;
            }
            q = q.next;
        }
        h.val = p.val;
        p.val = pivot;
        helper(h, p);
        helper(p.next, t);
    }
}
