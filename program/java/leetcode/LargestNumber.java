import java.util.*;

public class LargestNumber {
    public static String largestNumber(int[] num) {
        StringBuilder output = new StringBuilder();
        MyInteger[] mi = new MyInteger[num.length];
        for(int i = 0;i < num.length;i++) mi[i] = new MyInteger(num[i]);
        Arrays.sort(mi);
        if(mi[0].value == 0)
            return "0";
        for(int i = 0;i < mi.length;i++){
            output.append(mi[i].value);
        }
        return output.toString();
    }
    private static class MyInteger implements Comparable{
        int value;
        public MyInteger(int value){ this.value = value;}

        public int compareTo(Object o){
            MyInteger b = (MyInteger) o;
            String astr = String.valueOf(value);
            //String astr = String.valueOf(this.value);
            String bstr = String.valueOf(b.value);
            String ab = astr + bstr;
            String ba = bstr + astr;
            return ba.compareTo(ab);
        }
    }
    public static void main(String[] args){
        int[] arr = {0, 0, 1};
        //int[] arr = {824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247};
        System.out.println(largestNumber(arr));
    }
}
