public class LinkedListMergeSort{
    public ListNode merge(ListNode l1, ListNode, l2){
        ListNode p = l1;
        ListNode q = l2;
        ListNode dummy = new ListNode(-1);
        ListNode n = dummy;
        ListNode curr = null;
        while(p != null && q != null){
            curr = p.val <= q.val ? p : q;
            if(p.val <= q.val){
                curr = p;
                p = p.next;
            } else{
                curr = q;
                q = q.next;
            }
            curr.next = n.next;
            n.next = curr;
            n = curr;
        }
        curr = p == null ? q : p;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = n.next;
            n.next = curr;
            n = curr;
            curr = tmp;
        }
        return dummy.next;
    }
}
