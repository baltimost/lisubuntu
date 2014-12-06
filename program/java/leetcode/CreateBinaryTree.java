import java.util.*;

public class CreateBinaryTree{
    static char[] input = {'A','B','C',' ',' ','D','E',' ','G',' ',' ','F',' ',' ',' '}; 
    //static char[] input = {'A'};
    static int i = 0;
    public static TreeNode createBinaryTree(){
        if(input[i] == ' '){
            i++;
            return null;
        }
        else{
            TreeNode node = new TreeNode(input[i]);
            i++;
            node.left = createBinaryTree();
            node.right = createBinaryTree();
            return node;
        }
    }
    public static void main(String[] args){
        TreeNode root = createBinaryTree();
        ArrayList<ArrayList<Integer>> output = levelOrder(root); 
        for(ArrayList<Integer> x:output){
            for(Integer y:x)
                System.out.print((char)y.intValue());
            System.out.println();
        }
    }
}

