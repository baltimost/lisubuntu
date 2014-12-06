import java.util.*;

public class LargestRectangle{
    public static int largestRectangleArea(int[] height){
        if(height == null || height.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int output = Integer.MIN_VALUE;
        for(int i = 1;i <= height.length;i++){
            int curH = i == height.length ? -1 : height[i];
            while(!stack.isEmpty() && curH <= height[stack.peek()]){
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - left; 
                output = Math.max(output, h * w);
            }
            stack.push(i);
        }
        return output;
    }
    public static void main(String[] args){
        int[] height = {5,5,5,5,4,5,5,5};
        System.out.println(largestRectangleArea(height));
    }
}
