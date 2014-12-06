import java.util.*;

public class BinaryTreeLevelorderTraversal{
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        if(root != null)
            tmp.add(root.val);
        TreeNode n = root;
        int size = q.size(); 
        while(!q.isEmpty()){
            size = q.size();
            for(int i = 0;i < size;i++){
                n = q.poll();
                tmp.add(n.val);
                if(n.left != null)
                    q.offer(n.left);
                if(n.right != null)
                    q.offer(n.right);
            }
            output.add(tmp);
            tmp = new ArrayList<Integer>();
        }
        return output;
    }
}
