import java.util.*;
import java.util.Map.Entry;

public class MostFrequency {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,3,3,4,4};
        List<Integer> rst = mostFrequent(arr, 2);
        System.out.println(rst);
    }
    public static List<Integer> mostFrequent(int[] arr, int k) {
        List<Integer> output = new ArrayList<Integer>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int x : arr) {
            hm.put(x, hm.containsKey(x) ? hm.get(x) + 1 : 1);
        }
        if(hm.size() < k) {
            return output;
        }

        Queue<Entry<Integer, Integer>> q = new PriorityQueue<Entry<Integer, Integer>>(k, new FreqComparator());
        for(Entry<Integer, Integer> entry : hm.entrySet()) {
            if(q.size() < k) {
                q.offer(entry);
            }
            else if(entry.getValue() > q.peek().getValue()) {
                q.poll();
                q.offer(entry);
            }
        }

        for(Entry<Integer, Integer> entry : q) {
            output.add(entry.getKey());
        }
        return output;
    }

    private static class FreqComparator implements Comparator<Entry<Integer, Integer>> {
        public int compare(Entry<Integer, Integer> a, Entry<Integer, Integer> b) {
            return a.getValue() - b.getValue(); 
        }
    }
}
