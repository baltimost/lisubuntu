import java.util.*;

public class BinaryTreeVerticalTraversal {
    public static void verticalTraversal(TreeNode root) {
        HashMap<Integer, List<TreeNode>> hm = new HashMap<Integer, List<TreeNode>>();
        int i = helper(root, 0, hm);
        System.out.println(i);
        int n = hm.size();
        for(int k = 0;k < hm.size();k++, i++) {
            for(TreeNode node : hm.get(i)) {
                System.out.print(node.val + " ");
            }
            System.out.println();
        }
    }

    public static int helper(TreeNode root, int pos, HashMap<Integer, List<TreeNode>> hm) {
        if(root == null) {
            return Integer.MAX_VALUE; 
        }
        if(hm.containsKey(pos)) {
            hm.get(pos).add(root);
        }
        else {
            List<TreeNode> entry = new ArrayList<TreeNode>();
            entry.add(root);
            hm.put(pos, entry);
        }
        int l = helper(root.left, pos - 1, hm);
        int r = helper(root.right, pos + 1, hm);
        return Math.min(pos, Math.min(l, r));
    }

    public static void main(String[] args) {
        //int[] arr = {1,2,4,' ',' ',5,' ',' ',3,6,' ',8,' ',' ',7,' ',9,' ',' '};
        //int[] arr = {1,2,' ',4,' ',5,' ',6,' ',' ',3,' ',' '};
        int[] arr = {1,2,' ',4,' ',5,20,21,22,' ',' ',' ',' ',6,' ',' ',3,' ',' '};
        TreeNode root = TreeBuilder.create(arr);
        verticalTraversal(root);
    }
}
