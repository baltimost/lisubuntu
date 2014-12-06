public class RemoveDupfromSortedListII{
    public ListNode deleteDuplicates(ListNode head){
        if(head == null)
            return head;
        ListNode cursor = head;
        ListNode inCursor;
        while(cursor.next != null){
            inCursor = cursor.next;
            while((inCursor.next != null)
                    && (inCursor.next.val == cursor.next.val)){
                inCursor = inCursor.next;
            }
            cursor.next = inCursor.next;
            if(inCursor == cursor.next)
                cursor = cursor.next;
        }
        return head;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}
