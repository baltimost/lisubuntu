import java.util.*;

public class RecoverBinarySearchTree{
    public static void recoverTree(TreeNode root){
        if(root == null)
            return; 
        TreeNode n = root;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        TreeNode first = null;
        TreeNode second = null;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(!s.isEmpty() || n != null){
            if(n != null){
                s.push(n);
                n = n.left;
            } else{
                n = s.pop();
                if(n.val < prev.val){
                    if(first == null)
                        first = prev;
                    second = n;
                }
                prev = n;
                System.out.println("prev=" + prev.val);
                n = n.right;
            }
        }
        //System.out.println("first="+first.val+"second="+second.val);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
