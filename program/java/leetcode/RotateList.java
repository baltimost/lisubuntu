public class RotateList{
    public ListNode rotateRight(ListNode head, int n){
        if(head == null)
            return head;
        ListNode end = head;
        ListNode start = head;
        int len = 1;
        int position;
        while(end.next != null){
            end = end.next;
            len++;
        }
        position = n % len;
        if(position == 0)
            return head;
        for(int i = 1;i < len - position;i++)
            start = start.next;
        ListNode tmp = start.next;
        start.next = null;
        end.next = head;
        head = tmp; 
        return head;
    }
}
