public class ContinuousAlphabet{
    public static void printContinuousAlphabet(String str){
        if(str == null || str.length() <=1)
            return;
        String tmp = str.toLowerCase();
        int i, j;
        for(i = 0, j = 1;j < tmp.length();){
            char pre = tmp.charAt(j - 1);
            char cur = tmp.charAt(j);
            if(cur - pre == 1 && pre != 'z' && cur != 'a')
                j++;
            else{
                if(j - i >= 2)
                    System.out.println(tmp.substring(i, j));
                i = j;
                j++;
            }
        }
        if(j - i >= 2)
            System.out.println(tmp.substring(i, j));
    }
    public static void main(String[] args){
        //String input = "abcdefljdflsjflmnopflsjflasjftuvwxyz";
        //String input = "AbcDefljdflsjflmnopflsjflasjftuvWxYz";
        String input = "Z[`ab7cdz{";
        printContinuousAlphabet(input);
    }
}
