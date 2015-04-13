import java.util.*;

public class WordLadder{
    public static int ladderLength(String start, String end, Set<String> dict){
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        int count = 2;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                String current = queue.poll();
                char[] currents = current.toCharArray();
                for(int j = 0;j < current.length();j++){
                    char origin = currents[j];
                    for(char k = 'a';k <= 'z';k++){
                        currents[j] = k;
                        String tmp = new String(currents);
                        if(tmp.equals(end))
                            return count;
                        if(dict.contains(tmp)){
                            queue.offer(tmp);
                            dict.remove(tmp);
                        }
                    }
                    currents[j] = origin;
                }
            }
            count++;
        }
        return 0;
    }
    public static void main(String[] args){
        /*
        Set<String> dict = new HashSet<String>();
        System.out.println(ladderLength("mape","mape",dict));
        */
        String start = "hit";
        String end = "cog";
        HashSet<String> hs = new HashSet<String>();
        hs.add("hot");
        hs.add("dot");
        hs.add("dog");
        hs.add("lot");
        hs.add("log");
        System.out.println(ladderLength(start, end, hs));
    }
}
