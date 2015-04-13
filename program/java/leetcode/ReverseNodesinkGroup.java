import java.util.*;

public class ReverseNodesinkGroup{
    /*
    public static ListNode reverseKGroup(ListNode head, int k){
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
    */
    public static ListNode reverseKGroup(ListNode head, int k){
        if(head == null || k <= 1) return head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        prev.next = head;
        ListNode curr = head;
        while(curr != null){
            int count = 1;
            ListNode pioneer = curr;
            while(pioneer != null && count < k){
                pioneer = pioneer.next;
                count++;
            }
            if(pioneer == null) break;
            for(int i = 1;i < k;i++){
                ListNode subhead = prev.next;
                prev.next = curr.next;
                curr.next = curr.next.next;
                prev.next.next = subhead;
            }
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ListNode head = ListBuilder.create(arr);
        ListNode rst = reverseKGroup(head, 1);
        ListBuilder.print(rst);
    }
}
