public class CountandSay{
    /*
    public static String countAndSay(int n){
        String output = "";
        String tmp = "1"; 
        for(int i = 0; i < n; i++){
            output = tmp;
            tmp = "";
            int length = output.length();
            for(int j = 0;j < length;){
                char number = output.charAt(j);
                int count = 0;
                while(j < length && (output.charAt(j) == number) ){
                    count++;
                    j++;
                }
                tmp = tmp + Integer.toString(count) + number;
            } 
        } 
        return output;
    }
    */
    /* Accepted Code
    public static String countAndSay(int n){
        String output = "1";
        String prev = ""; 
        for(int i = 1; i < n; i++){
            prev = output;
            output = "";
            int length = prev.length();
            for(int j = 0;j < length;){
                char number = prev.charAt(j);
                int count = 0;
                while(j < length && (prev.charAt(j) == number) ){
                    count++;
                    j++;
                }
                output = output + Integer.toString(count) + number;
            } 
        } 
        return output;
    }
    */
    /* Accepted code but we can merge last into the loop
    public static String countAndSay(int n){
        StringBuilder output = new StringBuilder("1");
        for(int k = 1;k < n;k++){
            String prev = output.toString();
            output = new StringBuilder();
            int i, j;
            for(i = 0, j = 1;j < prev.length();j++){
                if(prev.charAt(j) != prev.charAt(j - 1)){
                    output.append(j - i);
                    output.append(prev.charAt(i));
                    i = j;
                }
            }
            output.append(j - i);
            output.append(prev.charAt(i));
        }
        return output.toString();
    }
    */
    public static String countAndSay(int n) {
        String prev = "1";
        for(int k = 1;k < n;k++){
            StringBuilder curr = new StringBuilder();
            for(int i = 0, j = 1;j <= prev.length();j++){
                if(j == prev.length() || prev.charAt(j) != prev.charAt(j - 1)){
                    curr.append(j - i);
                    curr.append(prev.charAt(i));
                    i = j;
                }
            }
            prev = curr.toString();
        }
        return prev;
    }
    public static void main(String[] args){
        int n = 7;
        String result = countAndSay(n); 
        System.out.println(result);
    } 

}
