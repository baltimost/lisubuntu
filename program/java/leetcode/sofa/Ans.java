import java.util.*;

public class Ans {
    public static int maxproduct(int[] arr) {
        if(arr == null || arr.length == 0)
            return Integer.MIN_VALUE;
        int max = arr[0];
        int min = arr[0];
        int output = arr[0];
        for(int i = 1;i < arr.length;i++) {
            int max_copy = max;
            max = Math.max(arr[i], Math.max(max * arr[i], min * arr[i]));
            min = Math.min(arr[i], Math.min(tmp * arr[i], min * arr[i]));
            output = Math.max(output, max);
        }
        return output;
    }
}

