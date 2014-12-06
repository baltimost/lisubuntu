import java.util.*;

public class RestoreIPAddresses{ 
    public List<String> restoreIpAddresses(String s){
        if(s == null)
            return null;
        List<String> output = new ArrayList<String>();
        String[] address = new String[4];
        helper(output, 0, address, s);
        return output;
    }
    private void helper(List<String> output, int level, String[] address, String s){
        if(level == 4){
            if(s.equals("")){
                String entry = address[0] + "." + address[1] + "." + address[2] + "." + address[3];
                output.add(entry);
            }
            return;
        } 
        String left,right;
        for(int i = 1;i <= 3 && i <= s.length();i++){
            left = s.substring(0,i);
            if(isValid(left)){
                right = s.substring(i);
                address[level] = left;
                helper(output, level + 1, address, right);
            }
        }
    }
    private boolean isValid(String part){
        if(part.length() > 1 && part.charAt(0) == '0')
           return false;
        return Integer.valueOf(part) <= 255; 
    } 
    public static void main(String[] args){
        //String test = "0279245587303";
        //String test = "255255111035";
        String test = "1111";
        RestoreIPAddresses ria = new RestoreIPAddresses();
        List<String> rst = ria.restoreIpAddresses(test); 
        for(String x: rst)
            System.out.println(x);
    }
}
