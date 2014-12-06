import java.util.*;

public class BinaryTreePreorderTraversal{
    /* Recursive
    public static void preorderTraversal(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            preorderTraverse(root.left);
            preorderTraverse(root.right);
        }else
            System.out.println("null");

    }
   
    /* Iterative: textbook 
    public static void preorderTraversal(TreeNode root){
        Stack<TreeNode> s = new Stack<TreeNode>();
        do{
            while(root != null){
                System.out.println(root.val);
                s.push(root);
                root = root.left;
                if(root == null)
                    System.out.println("null");
            }
            if(!s.isEmpty()){
                root = s.pop();
                root = root.right;
                if(root == null)
                    System.out.println("null");
            }
        }
        while( !s.isEmpty() || root != null);
    }
    */
    /* Iterative: standard */
    /*
    public static ArrayList<Integer> preorderTraversal(TreeNode root){
        ArrayList<Integer> output = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        if(root == null)
            return output; 
        s.push(root);
        while(!s.isEmpty()){
            TreeNode n = s.pop();
            output.add(n.val);
            if(n.right != null)
                s.push(n.right);
            if(n.left != null)
                s.push(n.left);
        }
        return output;
    }
    */
    public static ArrayList<Integer> preorderTraversal(TreeNode root){
        ArrayList<Integer> output = new ArrayList<Integer>();
        if(root == null)
            return output;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode n = root;
        s.push(root);
        while(!s.isEmpty()){
            n = s.pop();
            output.add(n.val);
            if(n.right != null)
                s.push(n.right);
            if(n.left != null)
                s.push(n.left);
        }
        return output;
    }
}
