public class MergeTwoSortedLists{
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode p = l1;
        ListNode q = l2;
        ListNode n = dummy;
        ListNode curr = null;
        while(p != null && q != null){
            if(p.val <= q.val){
                curr = p;
                p = p.next; 
            }else{
                curr = q;
                q = q.next;
            }
            n.next = curr;
            n = curr;
        }

        curr = p == null ? q : p;
        n.next = curr;
        return dummy.next;
    }
}
