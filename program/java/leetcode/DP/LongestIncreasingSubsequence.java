import java.util.*;

public class LongestIncreasingSubsequence{
    /*Solution1: Dynamic Programming
    */
    public static int LISlen(int[] sequence){
        int[] d = new int[sequence.length];
        d[0] = 1;
        int output = 1;
        for(int i = 1;i < sequence.length;i++){
            d[i] = 1;
            for(int j = 0;j < i;j++)
                if(sequence[j] <= sequence[i])
                    d[i] = Math.max(d[i], d[j] + 1);
            output = Math.max(output, d[i]);
        }
        return output;
    }
    public static List<Integer> LIS(int[] sequence){
        List<Integer>[] d = new List[sequence.length];
        d[0] = new ArrayList<Integer>();
        List<Integer> output = new ArrayList<Integer>();
        for(int i = 1;i < sequence.length;i++){
            d[i] = new ArrayList<Integer>();
            List<Integer> tmp = new ArrayList<Integer>();
            for(int j = 0;j < i;j++){
                if(sequence[j] <= sequence[i] && d[j].size() + 1 > d[i].size()){
                    tmp = d[j];
                }
            }
            if(tmp != null){
                d[i].addAll(tmp);
                d[i].add(sequence[i]);
            }
            if(d[i].size() > output.size())
                output = d[i];
        }
        return output;
    }

    public static void main(String[] args){
        //int[] test = {5, 3, 4, 8, 6, 7,0,1,2,3,5};
        int[] test = {5, 3, 4, 8, 6, 7};
        //int[] test = {0,4,6,7,6,6,6,6};
        //int[] test = {1,4,5,4,5};
        List<Integer> rst = LIS(test);
        rst = LIS(test);
        for(Integer x : rst)
            System.out.print(x + " ");
        System.out.println();
    }
} 

    /*Solution2: Binary Search Related
    public static int LISlen(int[] sequence){
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(sequence[0]);
        int tail = 0;
        for(int i = 1;i < sequence.length;i++){
            if(sequence[i] >= al.get(tail)){
                al.add(sequence[i]);
                tail++;
            }
            else{
                int low = 0;
                int high = tail; 
                while(low <= high){
                    int mid = (low + high)/2;
                    if(al.get(mid) <= sequence[i])
                        low = mid + 1;
                    else
                        high = mid - 1;
                }
                al.set(low, sequence[i]);
            }
            for(Integer x: al)
                System.out.print(x + " ");
            System.out.println();
        }
        return al.size();
    }
   */
