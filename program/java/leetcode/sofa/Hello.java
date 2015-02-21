public class Hello{
    public ListNode deleteDuplicates(ListNode head){
        if(head == null) return ListNode;
        pre = head;
        cur = head.next;
        while(cur != null){
            if(cur.val == pre.val)
                pre.next = cur.next;
            else
                pre = cur;
            cur = cur.next;
        }
    }
    public static void main(String[] args){
        String a = "hello world ";
        String b = a;
        a = a.trim();
        System.out.println(a == b);
        int i = 0;
        for(int i = 0, j = 3;i < j;i++);
    }
}
/*
1->1->2->3->3
c
*/
