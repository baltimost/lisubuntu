import java.util.*;

public class Solution {
    public int maxRec(int[] h) {
        if(h == null || h.length == 0) {
            return 0;
        }
        int output = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<Integer>();
        s.push(h[0]);
        for(int i = 2;i < h.length;i++) {
            int curH = i == height.length ? 0 : h[i];
            while(!s.isEmpty() && curH < h[s.peek()]) {
                int h = s.pop();
                int w = s.isEmpty() ? i : i - s.peek() - 1;
                output = Math.max(output, h * w);
            } 
        }
        return output;
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        System.out.println(s.peek());
    }
}
