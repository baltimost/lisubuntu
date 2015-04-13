import java.util.*;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null) {
            if(cur.left != null) {
                pre = cur.left;
                while(pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if(pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                else {
                    output.add(cur.val);
                    cur = cur.right;
                    pre.right = null;
                }
            }
            else {
                output.add(cur.val);
                cur = cur.right;
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        TreeNode n;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(n != null || !s.isEmpty()) {
            if(n != null) {
                s.push(n);
                n = n.left;
            }
            else {
                n = s.pop();
                output.add(n.val);
                n = n.right;
            }
        }
        return output;
    }
}
