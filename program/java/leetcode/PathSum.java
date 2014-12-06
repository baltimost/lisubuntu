public class PathSum{
    private boolean hasPathSum(TreeNode root, int sum){
        if(root == null) 
            return sum == 0 ? true : false;
        if(sum < 0)
            return false;

            boolean left = helper(root.left, sum - root.val);
            boolean right = helper(root.right, sum - root.val);
            return left || right;
    }
}
