import java.util.*;

public class BinaryTreePostorderTraversal{
    public static ArrayList<Integer> postorderTraversal(TreeNode root){
        ArrayList<Integer> output = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        if(root == null)
            return output;
        TreeNode curr = root;
        TreeNode prev = null;
        s.push(root);
        while(!s.isEmpty()){
            curr = s.peek();
            //from up
            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left != null)
                    s.push(curr.left);
                else if(curr.right != null)
                    s.push(curr.right);
                //if leaf
                else{
                    output.add(curr.val);
                    s.pop();
                }
                //from down left
            } else if(curr.left == prev){
                if(curr.right != null)
                    s.push(curr.right);
                //if no right
                else{
                    output.add(curr.val);
                    s.pop();
                }
                //from down right
            } else{
                output.add(curr.val);
                s.pop();
            }
            prev = curr;
        }
        return output;
    }
    public static List<Integer> postorderTraversalAlt(TreeNode root){
        ArrayList<Integer> output = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        if(root == null)
            return output;
        TreeNode curr = root;
        TreeNode prev = root;
        s.push(root);
        while(!s.isEmpty()){
            curr = s.peek();
            if(curr.left == prev){
                if(curr.right != null)
                    s.push(curr.right);
                else{
                    output.add(curr.val);
                    s.pop();
                }
            } else if(curr.right == prev){
                output.add(curr.val);
                s.pop();
            } else{
                System.out.println("hao");
                if(curr.left != null)
                    s.push(curr.left);
                else if(curr.right != null)
                    s.push(curr.right);
                else{
                    output.add(curr.val);
                    s.pop();
                }
            }
            prev = curr;
        }
        return output;
    }
    public static List<Integer> postorderTraversalLst(TreeNode root){
        List<Integer> output = new LinkedList<Integer>();
        if(root == null) return output;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode n = s.pop();
            output.add(0, n.val);
            if(n.left != null)
                s.push(n.left);
            if(n.right != null)
                s.push(n.right);
        }
        return output;
    }
   
    public static void main(String[] args){
        int[] input = {1,2,3,' ',' ',35,4,' ',6,' ',' ',5,' ',' ',7,' ',8,' ',' '};
        //int[] input = {1,2,' ',' ',3,' ',' '};
        //int[] input = {1,2,' ',' ',' '};
        TreeNode root = TreeBuilder.create(input);
        List<Integer> rst = postorderTraversalAlt(root); 
        for(Integer x : rst)
            System.out.print(x + " ");
        System.out.println();

        List<Integer> rst2 = postorderTraversalLst(root); 
        for(Integer x : rst2)
            System.out.print(x + " ");
        System.out.println();
/*
        rst = postorderTraversalAlt(root); 
        for(Integer x : rst)
            System.out.print(x + " ");
        System.out.println();
        */
    }
}
