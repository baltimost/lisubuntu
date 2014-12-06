public class AddTwoNumbers{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode n = dummy;
        int sum = 0;
        int carry = 0;
        while(h1 != null && h2 != null){
            sum = h1.val + h2.val + carry;
            carry = sum / 10;
            ListNode newnode = new ListNode(sum % 10);
            newnode.next = n.next;
            n.next = newnode;
            n = newnode;
            h1 = h1.next;
            h2 = h2.next;
        } 
        h1 = h1 == null ? h2 : h1;
        while(h1 != null || carry == 1){
            int digit = h1 == null ? 0 : h1.val; 
            sum = digit + carry;
            carry = sum / 10;
            ListNode newnode = new ListNode(sum % 10);
            newnode.next = n.next;
            n.next = newnode;
            n = newnode;
            if(h1 != null)
                h1 = h1.next;
        }
        return dummy.next;
    }
}
