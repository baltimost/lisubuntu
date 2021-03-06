import java.util.*;

public class ConstructTreeFromExpression{
    public static TreeNode construct(String exp){
        if(exp == null || exp.length() == 0) return null;
        TreeNode root = new TreeNode(exp.charAt(0));
        TreeNode n = root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        for(int i = 1;i < exp.length();i += 2){
            if(exp.charAt(i) == '?'){
                s.push(n);
                n.left = new TreeNode(exp.charAt(i + 1));
                n = n.left;
            }
            else{
                n = s.pop();
                n.right = new TreeNode(exp.charAt(i + 1));
                n = n.right;
            }
        } 
        return root;
    }
    public static void main(String[] args){
        String exp = "a?b?c:d:e?f:g";
        TreeNode root = construct(exp);
        List<Integer> output = BinaryTreePreorderTraversal.preorderTraversal(root);
        for(Integer x : output)
            System.out.print(x + " ");
        System.out.println();
    }
}
