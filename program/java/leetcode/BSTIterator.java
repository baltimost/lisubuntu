import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BSTIterator{
    TreeNode cursor;
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root){
        cursor = root;
        s = new Stack<TreeNode>();
    }
    public boolean hasNext(){
        return !s.isEmpty() || cursor != null;
    }
    public int next(){
        while(true){
            if(cursor != null){
                s.push(cursor);
                cursor = cursor.left;
            }
            else{
                cursor = s.pop();
                int output = cursor.val;
                cursor = cursor.right;
                return output;
            }
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,' ',' ',4,' ',' ',5,' ',' '};
        TreeNode root = TreeBuilder.create(arr);
        List<Integer> rst = BinaryTreeInorderTraversal.inorderTraversal(root);
        for(Integer x : rst)
            System.out.print(x + " ");
        System.out.println();

        BSTIterator i = new BSTIterator(root);
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
