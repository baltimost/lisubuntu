import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class PhoneCombination{
    public static List<String> phoneCombination(String phone){
        List<String> output = new ArrayList<String>();
        StringBuilder entry = new StringBuilder();
        HashMap<Character, String> hs = new HashMap<Character, String>();
        hs.put('2',"ABC");
        hs.put('3',"DEF");
        hs.put('4',"GHI");
        hs.put('5',"JKL");
        hs.put('6',"MNO");
        hs.put('7',"PQRS");
        hs.put('8',"TUV");
        hs.put('9',"WXYZ");
        helper(phone, hs, 0, entry, output);
        return output;
    }
    private static void helper(String phone, HashMap<Character, String> hs, int start, StringBuilder entry, List<String> output){
        if(start == phone.length()){
            output.add(entry.toString());
            return;
        }
        String pad = hs.get(phone.charAt(start));
        for(int i = 0;i < pad.length();i++){
            entry.append(pad.charAt(i));
            helper(phone, hs, start + 1, entry, output);
            entry.deleteCharAt(entry.length() - 1);
        }
    }
    public static void main(String[] args){
       // List<String> rst = phoneCombination("234");
        List<String> rst = phoneCombination("4438544967");
        for(String x : rst)
            System.out.println(x);
    }
}
