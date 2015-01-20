public class RemoveDupfromSortedListII{
    public static ListNode deleteDuplicates(ListNode head){
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
    public static ListNode deleteDuplicatesAlt(ListNode head){
        if(head == null)
            return head;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        p.next = head;
        while(p.next != null && p.next.next != null){
            if(p.next.next.val == p.next.val){
                ListNode n = p.next.next;
                while(n != null && n.val == p.next.val)
                    n = n.next;
                p.next = n;
            }
            else
                p = p.next;
        }
        return dummy.next;
    }
    public static void main(String[] args){
        //int[] arr = {1,1,2,2,2,3,4,4};
        int[] arr = {1,1};
        ListNode root = ListBuilder.create(arr); 
        ListNode n = root;
        while(n != null){
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();

        n = deleteDuplicatesAlt(root);
        while(n != null){
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
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
