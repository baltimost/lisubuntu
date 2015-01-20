import java.util.*;

public class FlattenBinaryTreetoLinkedList{
    private static TreeNode lastNode = null;

    public static void flatten(TreeNode root){
        if(root == null)
            return;
        if(lastNode != null){
            lastNode.left = null;
            lastNode.right = root;
        }
        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }

    public static void flattenAlt(TreeNode root){
        if(root == null) return;
        TreeNode n = root;
        while(n.right != null){
            TreeNode l = n;
            while(l.left != null)
                l = l.left;
            TreeNode r = n.right;
            n.right = null;
            n = r;
            l.left = n;
        }
        n = root;
        while(n != null){
            n.right = n.left;
            n.left = null;
            n = n.right;
        }
    }

    public static void main(String[] args){
        //int[] arr = {1,2,3,' ',' ',4,' ',' ',5,' ',6,' ',' '};
        int[] arr = {1,2,' ',3,' ',' ',' '};
        TreeNode root = TreeBuilder.create(arr);
        flatten(root);
        List<Integer> rst = BinaryTreePreorderTraversal.preorderTraversal(root);
        for(Integer x : rst)
            System.out.print(x + " ");
        System.out.println();
    }
}
