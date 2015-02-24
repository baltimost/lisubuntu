public class Ans {
    public void populate(TreeNode root) {
        if(root == null)
            return;
        TreeNode parent = root;
        TreeNode leftmost = root.left == null ? root.right : root.left;
        TreeNode cur = leftmost;
        while(leftmost != null) {
            while(cur != null) {
                if(cur = parent.left && parent.right != null) {
                    cur.next = parent.right;
                    cur = cur.next;
                }
                parent = getCUwithC(TreeNode parent.next);
                if(parent != null) {
                    cur.next = parent.left == null ? parent.right : parent.left;
                    cur = cur.next;
                }
            }
        }
    }
    private TreeNode getCUwithC(TreeNode root) {
        while(root != null) {
            if(root.left != null || root.right != null)
                return root;
            root = root.next;
        }
        return null;
    }
}
