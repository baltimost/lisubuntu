import java.util.*;

public class ConvertSortedArraytoBinarySearchTree{
    public static TreeNode sortedArrayToBST(int[] num){
        if(num == null || num.length == 0)
            return null;
        /*
        int mid = (0 + num.length - 1) / 2;
        TreeNode output = new TreeNode(num[mid]);
        output.left = helper(num, 0, mid - 1);
        output.right = helper(num, mid + 1, num.length - 1);
        */
        return helper(num, 0, num.length - 1);
    }
    private static TreeNode helper(int[] num, int low, int high){
        if(low > high)
            return null;
        else{
            int mid = (low + high) / 2;
            System.out.println("mid=" + mid);
            TreeNode node = new TreeNode(num[mid]);
            node.left = helper(num, low, mid - 1);
            node.right = helper(num, mid + 1, high);
            return node;
        }
    }
    public static void main(String[] args){
        int[] test = {3,11,49,49,60,66,71,82};
        TreeNode root = sortedArrayToBST(test);
        ArrayList<Integer> rst = BinaryTreeInorderTraversal.inorderTraversal(root);
        //ArrayList<Integer> rst = BinaryTreePreorderTraversal.preorderTraversal(root);
        for(Integer x: rst)
            System.out.print(x + " ");
        System.out.println();
    }
}
