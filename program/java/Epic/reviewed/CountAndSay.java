public class CountAndSay{
    public static void countAndSay(char str){
        if(str < '0' || str > '9') return;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for(int k = 0;k < 10;k++){
            String prev = sb.toString();
            sb = new StringBuilder();
            System.out.println(prev);
            int i, j;
            for(i = 0, j = 1;j < prev.length();j++){
                if(prev.charAt(j) != prev.charAt(j - 1)){
                    sb.append(j - i);
                    sb.append(prev.charAt(i));
                    i = j;
                }
            }
            sb.append(j - i);
            sb.append(prev.charAt(i));
        }
    }
    public static void main(String[] args){
        countAndSay('2');
    }
}
