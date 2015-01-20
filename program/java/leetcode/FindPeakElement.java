public class FindPeakElement{
    public static int findPeakElementNav(int[] num){
        for(int i = 0;i < num.length;i++){
            if((i == 0 || num[i] > num[i - 1]) && (i == num.length - 1 || num[i] > num[i + 1]))
                return i;
        }
        return 0;
    }
    public static int findPeakElement(int[] num){
        int l = 0;
        int h = num.length - 1;
        int m;
        while(l <= h){
            m = (l + h) / 2;
            if((m == 0 || num[m] > num[m - 1]) && (m == num.length - 1 || num[m] > num[m + 1]))
                return m;
            else if(m != 0 && num[m] < num[m - 1])
                h = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = new int[10000000];
        for(int i = 0;i < arr.length;i++){
            arr[i] = i;
        }
        //System.out.println(findPeakElement(arr));
        long start = System.currentTimeMillis();
        System.out.println(findPeakElement(arr));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
