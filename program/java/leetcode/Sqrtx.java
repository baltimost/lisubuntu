public class Sqrtx{
    public static int sqrt(int x){
        long low = 1;
        long high = x / 2 + 1;
        long mid;
        while(low <= high){
            mid = (low + high) / 2;
            if(mid * mid > x)
                high = mid - 1;
            else if(mid * mid < x)
                low = mid + 1;
            else
                return (int)mid;
        }
        return (int)high;
    }
    public static void main(String[] args){
        System.out.println(sqrt(2147483647));
    }
}
