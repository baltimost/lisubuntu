public class DaysFromJan{
    public static int daysBetween(int m, int d, int y){
        int[] dinM = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(y % 400 == 0|| (y % 4 == 0 && y % 100 != 0))
            dinM[1] = 29;
        if(m == 1) return d - 1;
        int output = 0;
        for(int i = 0;i < m - 1;i++){
            output += dinM[i];
        }
        output += d;
        return output;
    }
    public static void main(String[] args){
        System.out.println(daysBetween(12,31,1900));
    }
}
