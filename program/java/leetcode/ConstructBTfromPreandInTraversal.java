import java.util.*;

public class ConstructBTfromPreandInTraversal{
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0;i < inorder.length;i++)
            hm.put(inorder[i], i);
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, hm);
            
    }
    private static TreeNode helper(
            int[] preorder,
            int[] inorder,
            int pstart,
            int pend,
            int istart,
            int iend,
            HashMap<Integer, Integer> hm
            ){
        if(istart > iend){
            return null;
        }
        TreeNode node = new TreeNode(preorder[pstart]);
        int position = hm.get(node.val);
        node.left = helper(preorder, inorder, pstart + 1, pstart + position - istart , istart, position - 1, hm); 
        node.right = helper(preorder, inorder, pend - iend + position + 1, pend, position + 1, iend, hm); 
        return node;
    }
    public static void main(String[] args){
        //int[] preorder = {1,2,4,5,3,6,8,7};
        //int[] inorder =  {4,2,5,1,6,8,3,7};
        int[] preorder = {1,2,3};
        int[] inorder =  {2,3,1};
        TreeNode root = buildTree(preorder, inorder); 
        //ArrayList<Integer> output = BinaryTreePreorderTraversal.preorderTraversal(root);
        ArrayList<Integer> output = BinaryTreeInorderTraversal.inorderTraversal(root);
        for(Integer x:output)
            System.out.print(x + " ");
        System.out.println();
    }
}
