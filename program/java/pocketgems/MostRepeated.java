import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

public class MostRepeated {
    public static void main(String[] args) {
        int[] arr = {0,0,0,1,1,1,2,2,3,3,3, 7,7,7,7};
        List<Integer> result = kth(arr, 3);
        for(Integer x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static List<Integer> kth(int[] arr, int k){
        List<Integer> result = new ArrayList<Integer>();
        if(arr == null || arr.length==0){
            System.out.println("invalid input");
            return result;
        }
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        for(int e : arr){
            int temp = 0;
            if(!table.containsKey(e)){
                temp++;
            }else{
                temp = table.get(e)+1;
            }
            table.put(e, temp);
        }
        if(k > table.size()){
            System.out.println("invalid input");
            return result;
        }

        Comparator<Entry<Integer, Integer>> cmp = new Comparator<Entry<Integer, Integer>>(){
            public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2){
                return e2.getValue() - e1.getValue();
            }
        };
        Queue<Entry<Integer, Integer>> q = new PriorityQueue<Entry<Integer, Integer>>(k, cmp);
        Set<Integer> ks = table.keySet();
        Iterator<Integer> it = ks.iterator();
        while(it.hasNext()){
            int key = it.next();
            int value = table.get(key);
            Entry<Integer, Integer> en = new SimpleEntry<Integer, Integer>(key, value);
            q.add(en);
        }
        while(k > 0){
            result.add(q.poll().getKey());
            k--;
        }
        return result;
    }
}
