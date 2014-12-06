import java.util.List;
import java.util.ArrayList;

public class SnakeSequence{
    public static List<List<Integer>> largestSequences(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        List<List<Integer>>[][] d = new List[n][m];
        List<List<Integer>> max = new ArrayList<List<Integer>>();
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                int up = (i - 1 >= 0 && Math.abs(matrix[i - 1][j] - matrix[i][j]) == 1) ? d[i - 1][j].get(0).size() : -1;
                int left = (j - 1 >= 0 && Math.abs(matrix[i][j - 1] - matrix[i][j]) == 1) ? d[i][j - 1].get(0).size() : -1;
                if(left == up){
                    if(left == -1){
                        List<Integer> entry = new ArrayList<Integer>();
                        entry.add(matrix[i][j]);
                        d[i][j] = new ArrayList<List<Integer>>();
                        d[i][j].add(entry);
                    } else{
                        d[i][j] = new ArrayList<List<Integer>>();
                        //Have to do this, deep copy
                        for(List<Integer> x : d[i - 1][j])
                            d[i][j].add(new ArrayList<Integer>(x));
                        for(List<Integer> x : d[i][j - 1])
                            d[i][j].add(new ArrayList<Integer>(x));
                        for(List<Integer> x : d[i][j])
                            x.add(matrix[i][j]);
                    }
                } else{
                    List<List<Integer>> tmp = left > up ? d[i][j - 1] : d[i - 1][j];
                    d[i][j] = new ArrayList<List<Integer>>();
                    //Have to do this, deep copy
                    for(List<Integer> x : tmp)
                        d[i][j].add(new ArrayList<Integer>(x));
                    for(List<Integer> x : d[i][j])
                        x.add(matrix[i][j]);
                }
                if(max.size() == 0 || d[i][j].get(0).size() > max.get(0).size())
                   max = d[i][j]; 
            }
        }
        return max;
    }
    public static void main(String[] args){
        /*
        int[][] input = {
            {1,3,2,6,8},
            {1,0,1,2,3},
            {1,5,0,1,4}
        };
        */
        int[][] input = {
            {1,3,2,6,8},
            {-9,7,1,-1,2},
            {1,5,0,1,9}
        };
        List<List<Integer>> rst = largestSequences(input);
        for(List<Integer> x : rst){
            for(Integer y : x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
