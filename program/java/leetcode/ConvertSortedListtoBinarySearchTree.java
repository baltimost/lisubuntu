import java.util.List;
import java.util.ArrayList;

public class ConvertSortedListtoBinarySearchTree{
    /*
    public static TreeNode sortedListToBST(ListNode head){
        return helper(head, null);
    }
    private static TreeNode helper(ListNode low, ListNode high){
        if(low == high)
            return null;
        ListNode walker = low;
        ListNode runner = low;
        while(runner != high && runner.next != high){
            walker = walker.next;
            runner = runner.next.next;
        }
        TreeNode node = new TreeNode(walker.val);
        node.left = helper(low, walker);
        node.right = helper(walker.next, high);
        return node;
    }
    */
    static ListNode start = null;
    public static TreeNode sortedListToBST(ListNode head){
        start = head;
        ListNode curr = head;
        int h = 0;
        while(curr.next != null){
            curr = curr.next;
            h++;
        }
        return helper(0, h);
    }
    private static TreeNode helper(int l, int h){
        if(l > h)
            return null;
        int m = (l + h) / 2;
        TreeNode left = helper(l, m - 1);
        TreeNode root = new TreeNode(start.val);
        start = start.next;
        root.left = left;
        root.right = helper(m + 1, h);
        return root;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        ListNode head = ListBuilder.create(arr);
        TreeNode root = sortedListToBST(head); 
        List<Integer> rst = BinaryTreeInorderTraversal.inorderTraversal(root);
        for(Integer x : rst)
            System.out.print(x + " ");
        System.out.println();
    }
}
