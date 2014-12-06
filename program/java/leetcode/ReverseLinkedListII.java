public class ReverseLinkedListII{
    /*
    public ListNode reverseBetween(ListNode head, int m, int n){
        if(m == n)
            return head;
        ListNode oldstart = head;
        ListNode preoldstart = null;
        ListNode prev;
        ListNode curr;
        ListNode post;
        int count = m + 1;

        for(int i = 0;i < m;i++){
            preoldstart = oldstart;
            oldstart = oldstart.next;
        }
        prev = oldstart;
        curr = oldstart.next;
        post = curr.next;
        while(count <= n){
            curr.next = prev;
            prev = curr;
            curr = post;
            if(curr != null)
                post = curr.next;
            count ++;
        }
        preoldstart.next = prev;
        oldstart.next = curr;
        return head;
    }
    */
    public ListNode reverseBetween(ListNode head, int m, int n){
        if(m == n)
            return head;
        ListNode prevM = head;
        ListNode prev = null;
        ListNode curr = null;
        for(int i = 1;i <= n;i++){
            if(i < m)
                prevM = prevM.next;
            else if(i == m){
                prev = prevM.next;
                curr = prev.next;
            }else{
                prev.next = curr.next;
                curr.next = prevM.next;
                prevM.next = curr;
                curr = prev.next;
            }
        }
        return head;
    }
}
