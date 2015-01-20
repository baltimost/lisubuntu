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
    /*
    public static ListNode reverseBetween(ListNode head, int m, int n){
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
    */
    public static ListNode reverseBetween(ListNode head, int m, int n){
        if(m >= n || m < 0) return head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        prev.next = head;
        ListNode curr = head;
        int len = n - m;
        while(m > 1){
            prev = curr;
            curr = curr.next;
            m--;
        }
        while(len > 0 && curr != null && curr.next != null){
            ListNode subhead = prev.next;
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = subhead;
            len--;
        }
        return dummy.next;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        ListNode head = ListBuilder.create(arr);
        ListNode rst = reverseBetween(head, 2, 4);
        ListBuilder.print(rst);

        head = ListBuilder.create(arr);
        rst = reverseBetween(head, 2, 3);
        ListBuilder.print(rst);

        head = ListBuilder.create(arr);
        rst = reverseBetween(head, 2, 30);
        ListBuilder.print(rst);
    }
}
