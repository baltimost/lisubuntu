import java.util.*;

public class RestoreIPAddresses{ 
    /*
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
    */
    public List<String> restoreIpAddresses(String s){
        List<String> output = new ArrayList<String>();
        if(s == null || s.length() == 0) return output;
        String[] addr= new String[4];
        helper(s, 0, 0, addr, output);
        return output;
    }
    private void helper(String s, int start, int section, String[] addr, List<String> output){
        if(section == 4){
            if(start == s.length()){
                StringBuilder sb = new StringBuilder();
                sb.append(addr[0] + "." + addr[1] + "." + addr[2] + "." + addr[3]);
                output.add(sb.toString());
            }
            return;
        }
        for(int i = 1;i <= 3 && start + i <= s.length();i++){
            if(s.charAt(start) == '0' && i >= 2) break;
            String sub = s.substring(start, start + i);
            int num = Integer.parseInt(sub);
            if(num > 255) break;
            addr[section] = sub;
            helper(s, start + i, section + 1, addr, output);
            addr[section] = null;//not necessary, just for good habit
        }
    }
    public static void main(String[] args){
        String test = "0279245587303";
        //String test = "255255111035";
        //String test = "25525511135";
        //String test = "1111";
        RestoreIPAddresses ria = new RestoreIPAddresses();
        List<String> rst = ria.restoreIpAddresses(test); 
        for(String x: rst)
            System.out.println(x);
    }
}
