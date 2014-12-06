public class DecodeWays{
    public static int numDecodings(String s){
        if(s.length() == 0)
            return 0;
        int[] d = new int[s.length() + 1];
        d[0] = 1;
        d[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2;i < s.length() + 1;i++){
            int single = s.charAt(i - 1) - '0';
            int pair = Integer.parseInt(s.substring(i - 1 - 1, i));
            if(single >= 1 && single <= 9)
                d[i] = d[i - 1];
            if(pair >= 10 && pair <= 26)
                d[i] += d[i - 2];
        }
        return d[s.length()];
    }
    /*
    public static int numDecodings(String s){
        int len = s.length();
        if(len == 0)
            return 0;
        int[] ways = new int[len + 10];
        ways[0] = 1;
        ways[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 1;i < len; i++){
            int parsed = Integer.parseInt(s.substring(i, i + 1));
            if(parsed >= 1 && parsed <= 9)
                ways[i + 1] += ways[i];
            parsed = Integer.parseInt(s.substring(i - 1, i + 1));
            if(parsed >= 10 && parsed <= 26)
                ways[i + 1] += ways[i - 1];
        }
        return ways[len];
    }
    */

    public static void main(String[] args){
        System.out.println(numDecodings("0"));
    }
}
