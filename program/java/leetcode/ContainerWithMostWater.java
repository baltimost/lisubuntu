public class ContainerWithMostWater{
    /*
    public static int maxArea(int[] height){
        int output = Integer.MIN_VALUE;
        for(int i = 0;i < height.length;i++){
            for(int j = i + 1;j < height.length;j++){
                output = Math.max(output, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return output;
    }
    */
    /*
   */ 
    public static int maxArea(int[] height){
        if(height == null || height.length < 2)
            return 0;
        int left = 0;
        int right = height.length - 1;
        int output = Math.min(height[left], height[right]) * height.length;
        while(left < right){
            if(height[left] <= height[right]){
                if(height[left + 1] > height[left])
                    output = Math.max(output, Math.min(height[left + 1], height[right]) * (right - left - 1)); 
                left++;
            }else{
                if(height[right - 1] > height[right])
                    output = Math.max(output, Math.min(height[right - 1], height[left]) * (right - 1 - left));
                right++;
            }
        }
        return output;
    }

    public static void main(String[] args){
        //int[] test = {1,2,3,4,5,6,7,8,9};
        int[] test = {3,4,2,1,3,2,1,3,3,1,1,1,2};
        System.out.println(ContainerWithMostWater.maxArea(test));
    }
}
