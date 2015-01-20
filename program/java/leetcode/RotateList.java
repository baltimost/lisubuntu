public class RotateList{
    /*
    public static ListNode rotateRight(ListNode head, int n){
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
    */
    public static ListNode rotateRight(ListNode head, int n){
        if(n == 0 || head == null) return head;
        ListNode runner = head;
        int len = 0;
        while(n > 0 && runner != null){
            runner = runner.next;
            n--;
            len++;
        }
        if(runner == null){
            n %= len;
            if(n == 0) return head;
            runner = head;
            while(n > 0){
                runner = runner.next;
                n--;
            }
        }
        ListNode walker = head;
        while(runner.next != null){
            walker = walker.next;
            runner = runner.next;
        }
        ListNode newhead = walker.next;
        walker.next = null;
        runner.next = head;
        return newhead;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        ListNode head = ListBuilder.create(arr);
        ListNode rst = rotateRight(head, 5); 
        ListBuilder.print(rst);

        rst = rotateRight(head, 10); 
        ListBuilder.print(rst);

        rst = rotateRight(head, 12); 
        ListBuilder.print(rst);
    }
}
