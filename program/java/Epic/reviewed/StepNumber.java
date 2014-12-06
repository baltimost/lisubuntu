import java.util.ArrayList;
import java.util.List;

public class StepNumber{
    public static List<Integer> stepNumbers(int start, int end){
        List<Integer> output = new ArrayList<Integer>();
        char s= String.valueOf(start).charAt(0);
        char e= String.valueOf(end).charAt(0);
        for(char i = s;i <= e;i++){
            StringBuilder sb = new StringBuilder();
            sb.append((char)i);
            helper(start, end, sb, output);
        }
        return output;
    }
    private static void helper(int start, int end, StringBuilder entry, List<Integer> output){
        int current = Integer.parseInt(entry.toString());

        if(current >= start && current <= end){
            output.add(current);
        } 
        if(current >= end)
            return;
        if(entry.charAt(entry.length() - 1) < '9'){
            entry.append((char)(entry.charAt(entry.length() - 1) + 1));
            helper(start, end, entry, output);
            entry.deleteCharAt(entry.length() - 1);
        }

        if(entry.charAt(entry.length() - 1) > '0'){
            entry.append((char)(entry.charAt(entry.length() - 1) - 1));
            helper(start, end, entry, output);
            entry.deleteCharAt(entry.length() - 1);
        }
    }
    public static void main(String[] args){
        List<Integer> rst = stepNumbers(1,900000);
        for(Integer x : rst)
            System.out.println(x);
    }
}
