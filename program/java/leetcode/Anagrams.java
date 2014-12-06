mport java.util.*;

public class Anagrams{
    public static List<String> anagrams(String[] strs){
        if(strs == null)
            return null;
        Map<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        for(int i = 0;i < strs.length;i++){
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String key = new String(tmp);
            ArrayList<String> value = hm.get(key);
            if(value == null){
                value = new ArrayList<String>();
                value.add(strs[i]);
                hm.put(key, value);
            } else{
                value.add(strs[i]);
            }
        }
        List<String> output = new ArrayList<String>();
        Set<String> set = hm.keySet();

        for(String x: set){
            ArrayList<String> tmp = hm.get(x);
            if(tmp.size() > 1)
                output.addAll(tmp);
        }
        return output;
    }
    public static void main(String[] args){
        //String[] strs = {"iceman", "nicema", "more", "mero", "cars"};
        String[] strs = {};
        List<String> rst = new ArrayList<String>();
        rst = anagrams(strs);
        for(String x: rst)
            System.out.print(x + " ");
        System.out.println();
    }
}
