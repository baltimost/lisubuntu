public class ReverseLinkedListII{
    public ListNode reverseBetween(ListNode head, int m, int n){
        if(m == n)
            return head;
        ListNode prevM = head;
        ListNode prev, curr;
        for(int i = 1;i <= n;i++){
            if(i < m){
                prevM = prevM.next; 
            }
            else if(i == m){
                prev = prevM.next;
                curr = prev.next; 
            }
            else{
                prev.next = curr.next;
                curr.next = prevM.next;
                prevM.next = curr;
                curr = prev.next;
            }
        }
        return head;
    }
}
