public class InsertionSortList{
    /*
    public static ListNode insertionSortList(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevp = dummy;
        ListNode p = dummy.next;
        ListNode prevq = p;
        ListNode q = p.next; 
        while(q != null){
            p = dummy.next;
            prevp = dummy;
            int sentinel = q.val;
            while(p != q){
                if(sentinel < p.val){
                    prevq.next = q.next;
                    q.next = p;
                    prevp.next = q;
                    q = prevq;
                    break;
                } 
                prevp = p;
                p = p.next;
            }
            if(q == null)
                break;
            prevq = q;
            q = q.next;
        }
        return dummy.next;
    }
    */
    public static ListNode insertionSortList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        while(head != null){
            ListNode p = dummy;
            while(p.next != null && p.next.val < head.val)
                p = p.next;
            ListNode tmp = head.next;
            head.next = p.next;
            p.next = head;
            head = tmp;

            ListNode curr = dummy.next;
            while(curr != null){
                System.out.print(curr.val + " ");
                curr = curr.next;
            }
            System.out.println();
        }
        return dummy.next;
    }
}
