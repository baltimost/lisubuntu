public class test {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null) {
            System.out.println("hao1");
            if(cur.next.next.val == cur.next.val) {
                System.out.println("hao2");
                ListNode tail = cur.next;
                while(tail.next != null && tail.next.val == tail.val)
                    tail = tail.next;
                cur.next = tail.next;
            }
            else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        int[] nums = {1,1};
        ListNode head = ListBuilder.create(nums);
        ListNode n = head;
        while(n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
        n = deleteDuplicates(head);
        while(n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }
}
