import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class SwapStrings{
    public static void swapStrings(String s1, String s2){
        HashMap<Character, List<Integer>> order = new HashMap<Character, List<Integer>>();
        for(int i = 0;i < s1.length();i++){
            List<Integer> entry = order.get(s1.charAt(i));
            if(entry == null)
                entry = new ArrayList<Integer>();
            entry.add(i);
            order.put(s1.charAt(i), entry);
        }
        char[] c2 = s2.toCharArray();

        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int[] tag = new int[s2.length()];
        for(int i = 0;i < s2.length();i++){
            Integer entry = count.get(s2.charAt(i));
            count.put(s2.charAt(i), entry == null ? 0 : entry + 1); 
            tag[i] = entry == null ? 0 : entry + 1;
        }


        for(int i = 0;i < c2.length;i++){
            for(int j = 0;j < c2.length - 1 - i;j++){
                Integer curr = order.get(c2[j]).get(tag[j]);
                Integer next = order.get(c2[j + 1]).get(tag[j + 1]);
                if(curr == null || next == null){
                    System.out.println("Cannot convert s1 to s2");
                    return;
                }
                if(curr > next){
                    char tmp1 = c2[j];
                    c2[j] = c2[j + 1];
                    c2[j + 1] = tmp1;
                    int tmp2 = tag[j];
                    tag[j] = tag[j + 1];
                    tag[j + 1] = tmp2;
                    System.out.println(new String(c2));
                }
            }
        }
    }
    public static void main(String[] args){
        swapStrings("apple", "paelp");
        //swapStrings("apbple", "paelpb");
    }
}
