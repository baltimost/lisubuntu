import java.util.*;

public class PopulatingNextRightPointersinEachNode{
    /* O(n) Extra space
    public static void connect(TreeNode root){
        if(root == null)
            return;
        TreeNode n = root;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(n);
        int size = q.size();
        while(!q.isEmpty()){
            size = q.size();
            for(int i = 0;i < size;i++){
                n = q.poll();
                n.next = q.peek();
                if(n.left != null)
                    q.offer(n.left);
                if(n.right != null)
                    q.offer(n.right);
            }
            n.next = null;
        }
    }
    */
    public static void connect(TreeNode root){
        if(root == null) return;
        TreeNode parent = root;
        TreeNode leftmost = root.left;
        while(leftmost != null){
            TreeNode curr = leftmost;
            while(parent != null){
                curr.next = parent.right;
                curr = curr.next;
                if(parent.next != null)
                    curr.next = parent.next.left;
                curr = curr.next;
                parent = parent.next;
            }
            parent = leftmost;
            leftmost = leftmost.left;
        }
    }
}
