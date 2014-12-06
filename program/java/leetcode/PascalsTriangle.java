import java.util.*;

public class PascalsTriangle{
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(numRows == 0)
            return output;
        List<Integer> entry = new ArrayList<Integer>();
        entry.add(1);
        output.add(entry);
        for(int i = 1;i < numRows;i++){
            entry = new ArrayList<Integer>();
            entry.add(1);
            for(int j = 0;j < output.get(i - 1).size() - 1;j++){
                entry.add(output.get(i - 1).get(j) + output.get(i - 1).get(j + 1));
            }
            entry.add(1);
            output.add(entry);
        }
        return output;
    }
    public static void main(String[] args){
        List<List<Integer>> output = generate(0);
        for(List<Integer> x: output){
            for(Integer y: x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
