public class SwapNodesinPairs {
    /*
    public static ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = dummy;
        ListNode prev = start.next;
        ListNode curr = prev.next;
        while(prev != null && prev.next != null){
            prev.next = prev.next.next;
            curr.next = start.next;
            start.next = curr;
            start = prev;
            prev = prev.next;
            if(prev != null)
                curr = prev.next;
        }
        return dummy.next;
    }
    */
    public static ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        prev.next = head;
        ListNode curr = head;
        while(curr !=  null && curr.next != null){
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = curr;
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
    //Almost the same 2015.2.23
    public static ListNode swapPairsAlt(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy.next;
        while(left.next != null && right.next != null) {
            left.next = left.next.next;
            right.next = right.next.next;
            left.next.next = right;
            left = right;
            right = right.next;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        int[] arr = {1};
        ListNode head = ListBuilder.create(arr);
        ListNode rst = swapPairs(head);
        ListBuilder.print(rst);
    }
}
