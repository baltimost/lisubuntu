public class PartitionList{
    public ListNode partition(ListNode head, int x){
        if(head == null)
            return null;
        ListNode leftdummy = new ListNode(-1);
        ListNode rightdummy = new ListNode(-1);
        ListNode left = leftdummy;
        ListNode right = rightdummy;
        ListNode p = head;
        while(p != null){
            if(p.val < x){
                left.next = p;
                left = left.next;
            } else{
                right.next = p;
                right = right.next;
            }
            p = p.next;
        }
        left.next = rightdummy.next;
        right.next = null;
        return leftdummy.next;
    }
}
