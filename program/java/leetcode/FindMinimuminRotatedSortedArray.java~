public class FindMinimuminRotatedSortedArray{
    public static int findMin(int[] num){
        int l = 0;
        int h = num.length - 1;
        int m = (l + h) / 2;
        //while(h - l > 1){
        while(l < h){
            if(num[l] < num[h])
                return num[l];
            m = (l + h) / 2;
            if(num[m] >= num[l])
                l = m + 1; 
            else
                h = m;
        }
        //return Math.min(num[l], num[h]); 
        return num[l];
    }
    public static void main(String[] args){
        //int[] arr = {4,5,6,7,0,1,3};
        int[] arr = {7,8,9,10,2,3,4,5,6};
        System.out.println(findMin(arr));
    }
}
