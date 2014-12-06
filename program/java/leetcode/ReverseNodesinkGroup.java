import java.util.*;

public class ReverseNodesinkGroup{
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = dummy;
        ListNode prev = dummy.next;
        ListNode curr = prev.next; 
        while(prev != null){
            int i = 0;
            for(ListNode pioneer = prev;i < k && pioneer != null;i++)
                pioneer = pioneer.next;
            if(i != k)
                break;
            for(int j = 0;j < k - 1;j++){ 
                prev.next = curr.next;
                curr.next = start.next;
                start.next = curr;
                curr = prev.next; 
            }
            start = prev;
            prev = curr;
            if(curr != null)
                curr = curr.next;
        }
        return dummy.next;
    }
}
