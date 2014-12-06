import java.util.List;
import java.util.ArrayList;

public class FourDigits{
    public static List<String> permFour(int n){
        StringBuilder entry = new StringBuilder();
        List<String> output = new ArrayList<String>();
        helper(n, entry, output);
        return output;
    }

    private static void helper(int n, StringBuilder entry, List<String> output){
        if(entry.length() == n){
            output.add(entry.toString());
            return;
        }
        if(entry.length() == 3 && entry.charAt(0) == '4'){
            if(entry.charAt(entry.length() - 1) != '4'){
                entry.append('4');
                output.add(entry.toString());
                entry.deleteCharAt(entry.length() - 1);
            }
            return;
        }
        for(char i = '0';i <= '9';i++){
            if(entry.length() == 0 && i == '0' || entry.length() >= 1 && i == entry.charAt(entry.length() - 1))
                continue;
            entry.append((char)i);
            helper(n, entry, output);
            entry.deleteCharAt(entry.length() - 1);
        }
    }
    public static void main(String[] args){
        List<String> rst = permFour(4); 
        for(String x : rst)
            System.out.print(x + " ");
        System.out.println();
    }
}
