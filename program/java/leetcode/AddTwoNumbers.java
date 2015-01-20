public class AddTwoNumbers{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode n = dummy;
        int sum = 0;
        int carry = 0;
        while(l1 != null || l2 != null || carry == 1){
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            n.next = new ListNode(sum % 10);;
            n = n.next;
            l1 = l1 == null ? null :l1.next;
            l2 = l2 == null ? null :l2.next;
        }
        return dummy.next;
    }
}
