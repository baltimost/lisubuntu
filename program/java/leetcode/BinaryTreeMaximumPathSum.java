public class BinaryTreeMaximumPathSum{
    static int max = 0;
    public static int maxPathSum(TreeNode root){
        helper(root);
        return max;
    }
    public static int helper(TreeNode root){
        if(root == null)
            return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
