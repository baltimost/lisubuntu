import java.util.*;

public class PascalsTriangleII{
    /*
    public static List<Integer> getRow(int rowIndex){
        List<Integer> output = new ArrayList<Integer>();
        if(rowIndex == 0)
            return output;
        output.add(1);
        if(rowIndex == 1)
            return output;
        for(int k = 2;k <= rowIndex;k++){
            int i = 1;
            int j = output.size() - 2;
            for(;i <= j;i++, j--){
                output.set(i, output.get(j) + output.get(j + 1));
            }
            if(k % 2 != 0)
                output.set(i, output.get(i) * 2);
            else{
                if(k != 2)
                output.set(i, output.get(i - 1));
            }
            i++;
            for(;i < output.size();i++, j--)
                output.set(i, output.get(j));
            output.add(1);
        }
        return output;
    }
    */
    public static List<Integer> getRow(int rowIndex){
        List<Integer> output = new ArrayList<Integer>();
        int n = rowIndex + 1;
        for(int i = 0;i < n;i++)
            output.add(1);
        for(int i = 2;i < n;i++)
            for(int j = i - 1;j >= 1;j--)
                output.set(j, output.get(j - 1) + output.get(j));
        return output;
    }

    public static void main(String[] args){
        List<Integer> output = getRow(0);
        for(Integer x: output)
            System.out.print(x + " ");
        System.out.println();
    }
}
