public class RemoveNthNodeFromEndofList{
    public static ListNode removeNthFromEnd(ListNode head, int n){
        if(head == null || n < 0)
            return null;
        ListNode output = new ListNode(0);
        output.next = head;
        ListNode prev = output;
        ListNode tmp = head;
        for(int i = 0;i < n && tmp != null ;i++)//tmp != null, in case that n > the length of the List
            tmp = tmp.next;
        while(tmp != null){
            tmp = tmp.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return output.next;
    }
}
