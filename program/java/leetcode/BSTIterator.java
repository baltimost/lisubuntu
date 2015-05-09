import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BSTIterator{
    /*
    TreeNode cursor;
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root){
        cursor = root;
        s = new Stack<TreeNode>();
    }
    public boolean hasNext(){
        return !s.isEmpty() || cursor != null;
    }

    public int next() {
        if(!hasNext()) {
            return 0;
        }
        while(cursor != null) {
            s.push(cursor);
            cursor = cursor.left;
        }
        cursor = s.pop();
        int output = cursor.val;
        cursor = cursor.right;
        return output; 
    }
    */
    private TreeNode cursor;
    
    public BSTIterator(TreeNode root) {
        cursor = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cursor != null;
    }

    /** @return the next smallest number */
    public int next() {
        if(!hasNext()) {
            return 0;
        }
        
       while(true) {
            if(cursor.left != null) {
                TreeNode pre = cursor.left;
                while(pre.right != null && pre.right != cursor) {
                    pre = pre.right;
                }
                if(pre.right == null) {
                    pre.right = cursor;
                    cursor = cursor.left;
                }
                else {
                    int output = cursor.val;
                    cursor = cursor.right;
                    pre.right = null;
                    return output;
                }
            }
            else {
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
