import java.util.*;

public class UniqueBinarySearchTreesII{
    public static List<TreeNode> generateTrees(int n){
        return helper(1, n);
    }
    private static List<TreeNode> helper(int start, int end){
        List<TreeNode> rst = new ArrayList<TreeNode>();
        if(start > end){
            rst.add(null);//It's important!!!
            return rst;
        }
        for(int i = start;i <=end;i++){
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            for(TreeNode l: left)
                for(TreeNode r: right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    rst.add(root);
                }
        }
        return rst;
    }
    public static void main(String[] args){
        List<TreeNode> output = generateTrees(3);
        for(TreeNode x: output){
            List<Integer> rst = BinaryTreeInorderTraversal.inorderTraversal(x);
            for(Integer y: rst)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
