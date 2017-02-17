public class NextNode {
    public TreeNode next(TreeNode cur) {
        TreeNode next;
        if(cur.right != null) {
            next = cur.right;
            while(next.left != null) {
                next = next.left;
            }
        }
        else {
            next = cur.parent;
            TreeNode pre = cur;
            while(next != null && next.left != cur) {
                pre = next;
                next = next.parent;
            }
        }
        return next;
    }
}
