import java.util.*;

public class BinaryTreeZigzagLevelorderTraversal{
    /*
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root){
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return output;
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<TreeNode> stmp = new Stack<TreeNode>();
        TreeNode n = root;
        s.push(n);
        boolean reverse = true;
        while(!s.isEmpty()){
            n = s.pop();
            tmp.add(n.val);
            if(reverse){
                if(n.left != null)
                    stmp.push(n.left);
                if(n.right != null)
                    stmp.push(n.right);
            }
            else{
                if(n.right != null)
                    stmp.push(n.right);
                if(n.left != null)
                    stmp.push(n.left);
            }
            if(s.isEmpty()){
                output.add(tmp);
                tmp = new ArrayList<Integer>();
                s = stmp;
                stmp = new Stack<TreeNode>(); 
                reverse = !reverse;
            }
        }
        return output;
    }
    */
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root){
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return output;
        ArrayList<Integer> entry = new ArrayList<Integer>();
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        Stack<TreeNode> curr = s1, other = s2;
        s1.push(root);
        while(!curr.isEmpty()){
            TreeNode current = curr.pop();
            entry.add(current.val);
            if(curr == s1){
                if(current.left != null)
                    other.push(current.left);
                if(current.right != null)
                    other.push(current.right);
            }
            else{
                if(current.right != null)
                    other.push(current.right);
                if(current.left != null)
                    other.push(current.left);
            }
            if(curr.isEmpty()){
                output.add(new ArrayList<Integer>(entry));
                entry.clear();
                curr = curr == s1 ? s2 : s1;
                other = other == s1 ? s2 : s1;
            }
        }
        return output;
    }
}
