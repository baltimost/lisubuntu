public class SortList{ 
    public static ListNode sortListAlt(ListNode head){
        helper(head, null);
        return head;
    }
    static int count = 1;
    public static void helper(ListNode h, ListNode t){
        if(h == t)
            return;
        ListNode p = h;
        ListNode q = p.next;
        int pivot = h.val;
        while(q != t){
            if(count==1){
                ListBuilder.print(h);
            }
            if(q.val < pivot){
                p = p.next;
                int tmp = p.val;
                p.val = q.val;
                q.val = tmp;
            }
            q = q.next;
        }
        count = 0;
        h.val = p.val;
        p.val = pivot;
        helper(h, p);
        helper(p.next, t);
    }
    public static ListNode sortList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null){
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode right = walker.next;
        walker.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(right);
        return merge(l1, l2);
    }
    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode n = dummy;
        ListNode curr = null;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr = l1;
                l1 = l1.next;
            }
            else{
                curr = l2;
                l2 = l2.next;
            }
            n.next = curr;
            n = curr;
        }
        if(l1 == null)
            n.next = l2;
        else if(l2 == null)
            n.next = l1;
        return dummy.next;
    }
    public static void main(String[] args){
        int[] arr = {5,2,3,8,6,7,0,4};
        ListNode head = ListBuilder.create(arr);
        ListNode rst = sortList(head);
        ListBuilder.print(rst);
    }
}
