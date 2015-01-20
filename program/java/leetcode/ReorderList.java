public class ReorderList{
    /*
    public static void reorderList(ListNode head){
        if(head == null)
            return;
        int len = 0;
        ListNode end = head;
        ListNode curr = head;
        for(ListNode p = head;p != null;p = p.next)
            len++;
        for(int i = 0;i < (len - 1) / 2;i++){
            end = head;
            for(int j = 0;j < len - 1;j++){
                end = end.next;
            }
            end.next = curr.next;
            curr.next = end;
            curr = curr.next.next;
        }
        end = head;
        for(int j = 0;j < len - 1;j++){
            end = end.next;
        }
        end.next = null;
    }
    */
    public static void reorderList(ListNode head){
        if(head == null || head.next == null || head.next.next == null)
            return;
        //Find middle
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner != null){
            walker = walker.next;
            runner = runner.next.next;
        }

        //Reverse right part
        ListNode left = head;
        ListNode right = walker.next; 
        ListNode curr = right.next;
        while(curr != null){
            right.next = curr.next;
            curr.next = walker.next;
            walker.next = curr;
            curr = right.next;
        }
        right = walker.next;
        walker.next = null;

        ListNode k = left;
        k = right;
        
        //merge two parts
        while(right != null){
            ListNode tmp = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = tmp;
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        ListNode head = ListBuilder.create(arr);
        reorderList(head);
        ListBuilder.print(head);
    }
}
