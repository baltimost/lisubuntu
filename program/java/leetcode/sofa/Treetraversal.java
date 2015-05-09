import java.util.*; 

public class Solution {
    public static List<Integer> BTpreorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        if(root == null) {
            return output;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode n = s.pop();
            output.add(n.val);
            if(n.right != null) {
                s.push(n.right);
            }
            if(n.left != null) {
                s.push(n.left);
            }
        }
        return output;
    }
    public static List<Integer> BTpreorderTraversalAlt(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        if(root == null) {
            return output;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null) {
            output.add(cur.val);
            if(cur.left != null) {
                pre = cur.left;
                while(pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur = cur.left;
            }
            else {
                cur = cur.right;
            }
        }
        return output;
    }
    public static List<Integer> BTinorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        if(root == null) {
            return output;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode n = root;
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
    public static List<Integer> BTinorderTraversalAlt(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        if(root == null) {
            return output;
        }
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
                    pre.right = null;
                    cur = cur.right;
                }
            }
            else {
                output.add(cur.val);
                cur = cur.right;
            }
        }
        return output;
    }
    public static List<Integer> BTpostorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        if(root == null) {
            return output;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode n = null, pre = null;
        while(!s.isEmpty()) {
            n = s.peek();
            if(n.left == pre) {
                if(n.right == null) {
                    output.add(n.val);
                    s.pop();
                }
                else {
                    s.push(n.right);
                }
            }
            else if(n.right == pre) {
                output.add(n.val);
                s.pop();
            }
            else {
                if(n.left != null) {
                    s.push(n.left);
                }
                else if(n.right != null) {
                    s.push(n.right);
                }
                else {
                    output.add(n.val);
                    s.pop();
                }
            }
            pre = n;
        }
        return output;
    }
    public static void main(String[] args) {
        int[] A = {1,2,' ',' ',3,' ',' '};
        TreeNode head = TreeBuilder.create(A);
        List<Integer> rst = BTpreorderTraversalAlt(head);
        //List<Integer> rst = BTinorderTraversalAlt(head);
        //List<Integer> rst = BTpostorderTraversal(head);
        System.out.println(rst);
    }
}
