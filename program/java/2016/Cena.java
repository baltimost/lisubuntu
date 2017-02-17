public class Cena {
    public static int jump(int[] nums) {
        if(nums == null || nums.length <= 1)
            return 0;
        int output = 1;
        for(int i = 0;i < nums.length - 1;) {
            int max = nums[i];
            int nextIndex = nums[i] + i;
            System.out.println("i:" + i);
            System.out.println("max:" + nextIndex);
            System.out.println("nextIndex:" + nextIndex);
            if(nextIndex >= nums.length - 1)
                break;
            for(int j = i;j < nums[i] + i;j++) {
                if(nums[j] > max) {
                    max = nums[j];
                    nextIndex = j;
                }
                max--;
            }
            i = nextIndex;
            output++;
        }
        return output;
    }
    public static void main(String[] args) {
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        System.out.println(jump(nums));
    }
}
