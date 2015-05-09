import java.util.*;

public class LargestRectangle{
    public static int largestRectangleArea(int[] height){
        if(height == null || height.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int output = Integer.MIN_VALUE;
        for(int i = 1;i <= height.length;i++){
            int curH = i == height.length ? 0 : height[i];
            //int curH = i == height.length ? -1 : height[i];
            System.out.println("=====");
            //while(!stack.isEmpty() && curH <= height[stack.peek()]){
            while(!stack.isEmpty() && curH < height[stack.peek()]){
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1; 
                System.out.println("curr area = " + h + "*"+w+"=" + h * w);
                output = Math.max(output, h * w);
            }
            stack.push(i);
        }
        return output;
    }
    public static void main(String[] args){
        //int[] height = {5,5,5,5,4,5,5,5};
        //int[] height = {1,1,1,1,1,1,1};
        //int[] height = {0,2,3,4,6,5};

        //int[] height = {2,1,5,6,2,3};
        //int[] height = {0,2,3,2,2,4,5,6,4,2,3};
        int[] height = {2,3,4,3,1,3,2,1};
        System.out.println(largestRectangleArea(height));
    }
}
