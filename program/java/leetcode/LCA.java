public class LCA {
    TreeNode output;
    public static TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2) {
        helper(root, n1, n2);
        return output;
    }
    public static boolean helper(TreeNode root, TreeNode n1, TreeNode n2) {
        if(root == null) {
            return false;
        }
        if(root == n1 && root == n2) {
            output = root;
            return true;
        }
        boolean left = helper(root.left, n1, n2);
        boolean right = helper(root.right, n1, n2);
        if(left && right) {
            output = root;
            return true;
        }
        else if(left || right) {
            if(root == n1 || root == n2) {
                output = root;
            }
            return true;
        }
        else {
            return root == n1 || root == n2;
        }
    }
}
