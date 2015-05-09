public class RemoveDuplicatesfromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode n1 = dummy;
        ListNode n2 = head;
        while(n2 != null) {
            if(n2.next != null && n2.next.val == n2.val) {
                n2 = n2.next;
            }
            else if(n1.next == n2) {
                n1 = n1.next;
                n2 = n2.next;
            }
            else {
                n1.next = n2.next;
                n2 = n1.next;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3};
        ListNode head = ListBuilder.create(arr);
        ListNode rst = deleteDuplicates(head);
        Tools.print(rst); 
    }
}
