import java.util.List;
import java.util.ArrayList;

public class SubstringPal{
    public static List<String> allPal(String str){
        List<String> output = new ArrayList<String>();
        int n = str.length();
        if(n == 0 || n < 3)
            return output;
        boolean[][] d = new boolean[n][n];
        for(int i = n - 1;i >= 0;i--){
            for(int j = n - 1;j >= i;j--){
                if(str.charAt(i) == str.charAt(j)){
                    if(j - i <= 1 || d[i + 1][j - 1]){
                        d[i][j] = true;
                        if(j - i + 1 >= 3)
                            output.add(str.substring(i, j + 1));
                    }
                }
                else
                    d[i][j] = false;
            }
        }
        for(boolean[] x : d){
            for(boolean y : x)
                if(y) System.out.print("1 ");
                else System.out.print("0 ");
            System.out.println();
        }
        return output;
    }
    public static void main(String[] args){
        List<String> rst = allPal("abaxynitincaac");
        for(String x : rst)
            System.out.println(x);
    }
}
