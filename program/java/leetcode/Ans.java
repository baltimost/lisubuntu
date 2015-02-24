import java.util.*;

public class Ans {
    public static void populate(TreeNode root) {
        if(root == null)
            return;
        TreeNode head = root;
        while(head.left != null) {
            for(TreeNode n = head, pre = null;n != null;n = n.next) {
                if(pre != null)
                    pre.next = n.left;
                System.out.print("parent:"+n.val+"  ");
                System.out.println(n.left == null ? null : n.left.val);
                n.left.next = n.right;
                pre = n.right;
            }
            head = head.left;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,' ',' ',5,' ',' ',3,6,' ',' ',7,' ',' '};
        TreeNode root = TreeBuilder.create(arr);
        List<Integer> rst = BinaryTreePreorderTraversal.preorderTraversal(root);
        for(Integer x : rst) {
            System.out.print(x + " ");
        }
        System.out.println();

        populate(root);
    }
}
























