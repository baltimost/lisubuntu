public class ConvertSortedListtoBinarySearchTree{
    public TreeNode sortedListToBST(ListNode head){
        if(head == null)
            return null;
        return helper(head, null);
    }
    private TreeNode helper(ListNode low, ListNode high){
        if(low == high){
            return null;
        } else{
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
    }
}
