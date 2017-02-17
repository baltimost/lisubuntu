import java.util.*;

public class MissingRange {
    public static List<String> findRange(int[] arr, int start, int end) {
        List<String> ranges = new ArrayList<String>();
        int pre = start - 1;
        for(int i = 0;i <= arr.length;i++) {
            int cur = i == arr.length ? end + 1 : arr[i]; 
            if(cur - pre >= 2) {
                ranges.add(createRange(pre + 1, cur - 1));
            }
            pre = cur;
        }
        return ranges;
    }
    public static String createRange(int from, int to) {
        return to == from ? String.valueOf(from) : String.valueOf(from) + " => " + String.valueOf(to);
    }

    public static void main(String[] args) {
        MissingRange test = new MissingRange();
        List<String> rst = test.findRange(new int[]{1,2,3,50,75}, 0, 99);
        for(String x : rst) {
            System.out.println(x);
        }
    }
}
