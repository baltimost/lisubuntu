public class BalancedBinaryTree{
    public static boolean isBalanced(TreeNode root){
        return maxDepth(root) == Integer.MAX_VALUE ? false : true;
    }

    private static int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        else{
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            int d = Math.max(l, r) + 1;
            return l - r > 1 || r - l > 1 
                || l == Integer.MAX_VALUE 
                || r == Integer.MAX_VALUE 
                ? Integer.MAX_VALUE : d;
        }
    }
}
