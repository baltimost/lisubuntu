import java.util.*;

public class BinaryTreePostorderTraversal{
    public static ArrayList<Integer> postorderTraversal(TreeNode root){
        ArrayList<Integer> output = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        if(root == null)
            return output;
        TreeNode curr = root;
        TreeNode pre = null;
        s.push(root);
        while(!s.isEmpty()){
            curr = s.peek();
            //from up
            if(pre == null || pre.left == curr || pre.right == curr){
                if(curr.left != null)
                    s.push(curr.left);
                else if(curr.right != null)
                    s.push(curr.right);
                //if leaf
                else{
                    output.add(curr.val);
                    s.pop();
                }
                //from down left
            } else if(curr.left == pre){
                if(curr.right != null)
                    s.push(curr.right);
                //if no right
                else{
                    output.add(curr.val);
                    s.pop();
                }
                //from down right
            } else{
                output.add(curr.val);
                s.pop();
            }
            pre = curr;
        }
        return output;
    }
}
