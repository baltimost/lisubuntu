public class MergeTwoSortedLists{
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode n = dummy;
        ListNode curr = null;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr = l1;
                l1 = l1.next; 
            }else{
                curr = l2;
                l2 = l2.next;
            }
            n.next = curr;
            n = curr;
        }

        curr = l1 == null ? l2 : l1;
        n.next = curr;
        return dummy.next;
    }
    public static void main(String[] args){
        int[] arr1 = {1,3,5,7,9,11};
        int[] arr2 = {2,4,6,8};
        ListNode l1 = ListBuilder.create(arr1);
        ListNode l2 = ListBuilder.create(arr2);
        ListNode head = mergeTwoLists(l1, l2);
        ListBuilder.print(head);
    }
}
