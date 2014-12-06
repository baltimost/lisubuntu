import java.util.*;

public class RomantoInteger{
    /*
    public static int romanToInt(String s){
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("I", 1);
        hm.put("IV", 4);
        hm.put("V", 5);
        hm.put("IX", 9);
        hm.put("X", 10);
        hm.put("XL", 40);
        hm.put("L", 50);
        hm.put("XC", 90);
        hm.put("C", 100);
        hm.put("CD", 400);
        hm.put("D", 500);
        hm.put("CM", 900);
        hm.put("M", 1000);
        int output = 0;
        for(int i = 0;i < s.length();){
            String numeral = "";
            if(i + 2 <= s.length() && hm.get(s.substring(i, i + 2)) != null){
                numeral = s.substring(i,i + 2);
                i += 2;
            } else{
                numeral = s.substring(i,i + 1);
                i++;
            }
            output += hm.get(numeral);
        }
        return output;
    }
    */
    public static int romanToInt(String s){
        if(s == null || s.length() == 0)
            return 0;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int output = hm.get(s.charAt(0));
        for(int i = 1;i < s.length();i++){
            if(hm.get(s.charAt(i)) > hm.get(s.charAt(i - 1)))
                output -= 2 * hm.get(s.charAt(i - 1));
            output += hm.get(s.charAt(i));
        }
        return output;
    }
    public static void main(String[] args){
        String test = "MMMCMXCIX";
        System.out.println(romanToInt(test));
    }
}
