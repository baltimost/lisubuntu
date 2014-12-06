import java.util.*;

public class WordLadder{
    public static int ladderLength(String start, String end, Set<String> dict){
        Queue<String> queue = new LinkedList<String>();
        String current = start;
        int count = 1;
        queue.offer(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                current = queue.poll();
                for(int j = 0;j < current.length();j++){
                    for(char k = 'a';k <= 'z';k++){
                        char[] currents = current.toCharArray();
                        currents[j] = k;
                        String tmp = new String(currents);
                        System.out.print(tmp + " ");
                        if(tmp.equals(end))
                            return count + 1;
                        if(dict.contains(tmp)){
                            System.out.print(".");
                            queue.offer(tmp);
                            dict.remove(tmp);
                        }
                    }
                    System.out.println();
                }
            }
            count++;
        }
        return 0;
    }
    /*TLE
    public static boolean isNeighbor(String x, String y){
        int count = 0;
        for(int i = 0;i < x.length();i++){
            if(x.charAt(i) != y.charAt(i))
                count++;
            if(count >= 2)
                return false;
        }
        return true;
    } 
    */
    public static void main(String[] args){
        Set<String> dict = new HashSet<String>();
        System.out.println(ladderLength("mape","mape",dict));
    }
}
