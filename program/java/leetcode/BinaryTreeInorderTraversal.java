import java.util.*;

public class BinaryTreeInorderTraversal{
/* Iterative: inorder */
    public static ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> output = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        if(root == null)
            return output;
        TreeNode n = root;
        while(!s.isEmpty() || n != null){
            if( n != null){
                s.push(n);
                n = n.left;
            }
            else{
                n = s.pop();
                output.add(n.val);
                n = n.right;
            }
        }
        return output;
    }
}
