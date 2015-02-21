import java.util.*;

public class ReverseWords{
    public static String reverse(String str){
        if(str == null || str.length() == 0) return str;
        str = str.trim(); 
        StringBuilder sb = new StringBuilder();
        int i = str.length() - 1, j;
        //while(i >= 0 && str.charAt(i) == ' ') i--;
        for(;i >= 0;i--){
            if(str.charAt(i) == ' ' && str.charAt(i + 1) == ' ') continue;
            sb.append(str.charAt(i));
        }
        for(i = 0, j = 1;j <= sb.length();){
            if(j == sb.length() || sb.charAt(j) == ' '){
                reverseword(sb, i, j - 1);
                i = j + 1;
                j = i + 1;
            }
            else
                j++;
        }
        return sb.toString();
    } 

    private static void reverseword(StringBuilder sb, int s, int e){
        for(int i = s, j = e;i < j;i++, j--){
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j)); 
            sb.setCharAt(j, tmp);
        }
    }
    public static void main(String[] args){
        //System.out.println(reverse("hello  world heihei"));
        System.out.println("*" + reverse("h ") + "*");
        System.out.println("*" + reverse(" ") + "*");
        System.out.println("*" + reverse(" 1") + "*");
    }
}
