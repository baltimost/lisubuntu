import java.util.*;

public class GrayCode{
    public static List<Integer> grayCode(int n){
        if(n < 0) {
            return null;
        }
        ArrayList<Integer> output = new ArrayList<Integer>();
        output.add(0);
        if(n == 0) {
            return output;
        }
        output.add(1);

        /*
        for(int i = 1;i < n;i++){
            for(int j = (int)Math.pow(2,i) - 1;j >= 0;j--)
                output.add(output.get(j) + (int)Math.pow(2,i));
        }//grayCode(20) 430ms
        */
        for(int i = 1;i < n;i++) {
            for(int j = (1 << i) - 1;j >= 0;j--) {
                output.add(output.get(j) + (1 << i));
            }
        }//grayCode(20) 165ms
        /*
        for(Integer x: output)
            System.out.print(x + " ");
        System.out.println();
        */
        return output;
    }
    public static List<Integer> grayCodeAlt(int n){
        List<Integer> output = new ArrayList<Integer>();
        if(n < 0) {
            return null;
        }
        output.add(0);
        for(int i = 0;i < n;i++) {
            for(int j = output.size() - 1;j >= 0;j--) {
                output.add(output.get(j) + (1 << i));
            } 
        }
        return output;
    }
    public static void main(String[] args){
        List<Integer> rst = grayCode(3);
        Tools.print(rst);
        rst = grayCodeAlt(3);
        Tools.print(rst);
    } 
}
