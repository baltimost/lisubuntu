import java.util.*;

public class SameTree{
    /* Iterative, what if {1,2} vs. {1,#,2}
    public static boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null || q == null)
            return p == null && q == null;
        Stack<TreeNode> sp = new Stack<TreeNode>();
        Stack<TreeNode> sq = new Stack<TreeNode>();
        sp.push(p);
        sq.push(q);
        TreeNode n1 = p;
        TreeNode n2 = q;
        while(!sp.isEmpty() && !sq.isEmpty()){
            n1 = sp.pop();
            n2 = sq.pop();
            if(n1.val != n2.val)
                return false;
            else{
                if(n1.right != null)
                    sp.push(n1.right);
                if(n1.left != null)
                    sp.push(n1.left);
                if(n2.right != null)
                    sq.push(n2.right);
                if(n2.left != null)
                    sq.push(n2.left);
            }
        }
        if(sp.isEmpty() && sq.isEmpty())
            return true;
        else
            return false;
    }
    */
    /* Recursive
    */
    public static boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null || q == null)
            return p == null && q == null;
        else
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
