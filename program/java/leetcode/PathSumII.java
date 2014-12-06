import java.util.*;

public class PathSumII{
    public static List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> entry = new ArrayList<Integer>();
        helper(root, sum, entry, output); 
        return output;
    }
    private static void helper(
            TreeNode root, 
            int sum, 
            List<Integer> entry,
            List<List<Integer>> output){
        /*
            System.out.println("===");
            for(Integer x: entry)
                System.out.print(x + " ");
            System.out.println("\n===");
            */
        if(root == null)
            return;
        System.out.println(root.val);
        if(root.left == null && root.right == null){
            if(sum == root.val){
                entry.add(root.val);
                output.add(new ArrayList<Integer>(entry));
                entry.remove(entry.size() - 1);
            }
            return;
        }
        entry.add(root.val);
        helper(root.left, sum - root.val, entry, output);
        helper(root.right, sum - root.val, entry, output);
        entry.remove(entry.size() - 1);
    }
}
