import java.util.List;
import java.util.ArrayList;

public class WellOrderedNum{
    public static List<String> wellOrderedNums(int length){
        List<String> output  = new ArrayList<String>();
        StringBuilder entry = new StringBuilder();
        helper(entry, output, 0, length);
        return output;
    }
    private static void helper(StringBuilder entry, List<String> output, int start, int length){
        //if(start == 10 || entry.length() == length){
        if(entry.length() == length){
            if(entry.length() == length)
                output.add(entry.toString());
            return;
        }
        for(int i = start;i < 10;i++){
            entry.append(i);
            helper(entry, output, i + 1, length);
            entry.deleteCharAt(entry.length() - 1);
        }
    }
    public static void main(String[] args){
        List<String> rst = wellOrderedNums(9);
        for(String x : rst)
            System.out.println(x);
    }
}
