public class SumRoottoLeafNumbers{
    /*
    static int sum = 0;
    public static int sumNumbers(TreeNode root){
        StringBuilder sb = new StringBuilder();
        helper(root, sb); 
        return sum / 2;
    }
    public static void helper(TreeNode root, StringBuilder sb){
        System.out.println("**"+sb.toString()+"**");
        if(root == null){
            sum += Integer.valueOf(sb.toString());
            return;
        }
        sb.append(String.valueOf(root.val));
        helper(root.left, sb);

        helper(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
    */
    /*
    public static int sumNumbers(TreeNode root){
        return helper(root, 0);
    }
    private static int helper(TreeNode root, int prev){
        if(root == null) 
            return 0;
        int cur = root.val + 10 * prev;
        if(root.left == null && root.right == null)
            return cur;
        return helper(root.left, cur) + helper(root.right, cur);
    }
    */
    private static int rst = 0;
    public static int sumNumbers(TreeNode root){
        if(root == null) return 0;
        helper(root, 0);
        return rst;
    }
    private static void helper(TreeNode root, int prev){
        if(root == null) return;
        int cur = root.val + 10 * prev;
        if(root.left == null && root.right == null)
            rst += cur;
        helper(root.left, cur);
        helper(root.right, cur);
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, ' ', ' ', ' '};
        TreeNode root = TreeBuilder.create(arr);
        System.out.println(sumNumbers(root));
    }
}

