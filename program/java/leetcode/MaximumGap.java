public class MaximumGap{
    public static int maximumGap(int[] num){
        if(num == null || num.length <= 1) return 0;
        if(num.length == 2) return Math.abs(num[0] - num[1]);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int x : num){
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        //int bucket_len = Math.ceil((max - min) / num.length);
        int bucket_len = (max - min) / num.length + 1;
        int bucket_num = (max - min) / bucket_len + 1;
        Bucket[] buckets = new Bucket[bucket_num];
        for(int x : num){
            int idx = (x - min) / bucket_len;
            if(buckets[idx] == null) buckets[idx] = new Bucket();
            buckets[idx].min = Math.min(buckets[idx].min, x);
            buckets[idx].max = Math.max(buckets[idx].max, x);
        }
        int maxgap = 0;
        Bucket prev = buckets[0];
        for(int i = 1;i < buckets.length;i++){
            if(buckets[i] != null){
                maxgap = Math.max(maxgap, buckets[i].min - prev.max);
                prev = buckets[i];
            }
        }
        return maxgap;
    }
    public static void main(String[] args){
        int[] arr = {2,1,4,7,4,8,3,6,4,7};
        System.out.println(maximumGap(arr));
    }
    private static class Bucket{
        int min;
        int max;
        public Bucket(){
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
        }
    }
}
