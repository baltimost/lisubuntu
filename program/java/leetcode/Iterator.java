import java.util.*;

public class Iterator {
    Stack<TreeNode> s;
    TreeNode cursor;
    public Iterator(TreeNode root) {
        s = new Stack<TreeNode>();
        cursor = root;
    }

    public boolean hasNext() {
        return cursor != null || !s.isEmpty();
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
    public static void main(String[] args) {
        int[] arr = {1,2,4,' ',' ',5,' ',' ',3,6,' ',' ',7,' ',' '};
        TreeNode root = TreeBuilder.create(arr);
        Iterator i = new Iterator(root);
        while(i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
        System.out.println(i.next());
    }
}
