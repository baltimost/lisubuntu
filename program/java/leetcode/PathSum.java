public class PathSum{
    private boolean hasPathSum(TreeNode root, int sum){
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return sum == root.val;
        }

        boolean left = helper(root.left, sum - root.val);
        boolean right = helper(root.right, sum - root.val);
        return left || right;
    }
}
