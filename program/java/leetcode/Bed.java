import java.util.*;

public class Bed{
    public static void nextPerm(int[] num){
        int i = num.length - 1;
        while(i > 0 && num[i] < num[i - 1])
            i--;
        int j = i;
        i--;
        while(j < num.length && num[j] > num[i])
            j++;
        j--;
        Tools.swap(num, i, j);
        reverse(num, i + 1, num.length - 1);
    }
    private static void reverse(int[] num, int s, int e){
        for(int i = s, j = e; i < j;i++, j--)
            Tools.swap(num, i, j);
    }
    public static void main(String[] args){
        int[] num = {6,5,4,3,2,1};
        Tools.print(num);
        nextPerm(num);
        Tools.print(num);
    }
}
