public class FindMinimuminRotatedSortedArrayII{
    public static int findMin(int[] num){
        int l = 0;
        int h = num.length - 1;
        int m = (l + h) / 2;
        while(h - l > 1){
            m = (l + h) / 2;
            if(num[m] >= num[l] && num[m] <= num[h])
                return num[l];
            else if(num[m] > num[l])
                l = m; 
            else if(num[m] < num[l])
                h = m;
            else
                l++;
        }
        return Math.min(num[l], num[h]); 
    }
    public static void main(String[] args){
        //int[] arr = {4,5,6,7,0,1,3};
        //int[] arr = {7,8,9,10,2,3,4,5,6};
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(findMin(arr));
    }
}
