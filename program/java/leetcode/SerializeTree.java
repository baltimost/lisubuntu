import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.HashSet;

public class SerializeTree {
    public static List<int[]> serialize(TreeNode root) {
        List<int[]> output = new ArrayList<int[]>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode cur = s.pop();
            int[] entry = new int[2];
            entry[0] = cur.val;
            if(cur.left != null) {
                s.push(cur.right);
                s.push(cur.left);
                entry[1] = 2;
            }
            output.add(entry);
        }
        return output;
    }  

    public static TreeNode reconstruct(List<int[]> l) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode root = new TreeNode(l.get(0)[0]);
        s.push(root);
        int i = 0;
        while(!s.isEmpty()) {
            TreeNode cur = s.pop();
            cur.val = l.get(i)[0];
            if(l.get(i)[1] == 2) {
                TreeNode left = new TreeNode(-1);
                TreeNode right = new TreeNode(-1);
                s.push(right);
                s.push(left);
            }
            i++;
        }
        return root;
    }

    public static HashSet<Integer> serializeAlt(TreeNode root) {
        HashSet<Integer> output = new HashSet<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        root.val = 1;
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode cur = s.pop();
            if(cur.left != null) {
                cur.right.val = cur.val * 2 + 1;
                cur.left.val = cur.val * 2;
                s.push(cur.right);
                s.push(cur.left);
                output.add(cur.val);
            }
        }
        return output;
    } 

    public static TreeNode reconstruct(HashSet<Integer> hs) {
        TreeNode root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        if(hs.contains(1)) {
            root = new TreeNode(1);
            s.push(root);
        }
        else {
            return null;
        }
        while(!s.isEmpty()) {
            TreeNode cur = s.pop();
            if(hs.contains(cur.val)) {
                TreeNode right = new TreeNode(cur.val * 2 + 1);
                TreeNode left  = new TreeNode(cur.val * 2);
                cur.left = left;
                cur.right = right;
                s.push(right);
                s.push(left);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {9,3,' ',' ',4,2,15,' ',' ',0,' ',' ',1,' ',' '};
        TreeNode root = TreeBuilder.create(arr);
        List<Integer> rst = BinaryTreePreorderTraversal.preorderTraversal(root);
        System.out.println(rst);
        List<int[]> l = serialize(root);
        HashSet<Integer> hs = serializeAlt(root);
        TreeNode newroot = reconstruct(l);
        rst = BinaryTreePreorderTraversal.preorderTraversal(root);
        System.out.println(rst);

        newroot = reconstruct(hs);
        rst = BinaryTreePreorderTraversal.preorderTraversal(root);
        System.out.println(rst);
    }
}
