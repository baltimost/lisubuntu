import java.util.*;

public class Triangle{
    /* DFS TLE
    static int min = Integer.MAX_VALUE;
    public static int minimumTotal(List<List<Integer>> triangle){
        helper(triangle.get(0).get(0), 1, 0, triangle);
        return min;
    }
    private static void helper(
           int sum,
           int level,
           int root,
           List<List<Integer>> triangle){
        if(level == triangle.size()){
            min = Math.min(min, sum);
        }
        for(int i = level;i < triangle.size();i++){
            for(int j = 0;j < 2;j++){
                int cur = triangle.get(level).get(root + j);
                sum += cur; 
                helper(sum, level + 1, root + j, triangle);
                sum -= cur;
            }
        }
    }
    */
    public static int minimumTotal(List<List<Integer>> triangle){
        int output = Integer.MAX_VALUE;
        for(int i = 1;i < triangle.size();i++){
            List<Integer> entry = triangle.get(i);
            List<Integer> prev = triangle.get(i - 1);
            entry.set(0, entry.get(0) + prev.get(0)); 
            for(int j = 1;j < entry.size() - 1;j++){
                entry.set(j, entry.get(j) + Math.min(prev.get(j - 1),prev.get(j)));
            }
            int end = entry.size() - 1;
            entry.set(end, entry.get(end) +  prev.get(end - 1));
        }
        List<Integer> last = triangle.get(triangle.size() - 1);
        for(int i = 0;i < triangle.size();i++)
           output = Math.min(output, last.get(i)); 
        return output;
    }
    public static int minimumTotalBetter(List<List<Integer>> triangle) {
        if(triangle == null || triangle.get(0) == null)
            return 0;
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        int[] d = new int[m];
        for(int i = n - 1;i >= 0;i--) {
            for(int j = 0;j < triangle.get(i).size();j++) {
                if(i == n - 1) {
                    d[j] = triangle.get(i).get(j);
                }
                else {
                    d[j] = Math.min(d[j], d[j + 1]) + triangle.get(i).get(j);
                }
            }
        }
        return d[0];
    }
    public static void main(String[] args){
        List<List<Integer>> input = new ArrayList<List<Integer>>();
        List<Integer> entry = new ArrayList<Integer>();
        entry.add(2);
        input.add(new ArrayList<Integer>(entry));
        entry.clear();

        entry.add(3);
        entry.add(4);
        input.add(new ArrayList<Integer>(entry));
        entry.clear();

        entry.add(6);
        entry.add(5);
        entry.add(7);
        input.add(new ArrayList<Integer>(entry));
        entry.clear();

        entry.add(4);
        entry.add(1);
        entry.add(8);
        entry.add(3);
        input.add(new ArrayList<Integer>(entry));
        entry.clear();

        System.out.println(minimumTotal(input));
    }
}
