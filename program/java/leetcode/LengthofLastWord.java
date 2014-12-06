public class LengthofLastWord{
    /*
    public static int lengthOfLastWord(String s){
        String[] split = s.split(" ");
        if(split == 0)
            return 0;
        return split[split.length - 1].length();
    }
    */
    public static int lengthOfLastWord(String s){
        int i; 
        for(i = s.length() - 1;i >= 0;i--){
            if(s.charAt(i) != ' ')
               break; 
        }
        if(i < 0)
            return 0;
        int j;
        for(j = i - 1;j >= 0;j--)
            if(s.charAt(j) == ' ')
                break;
        System.out.println("i= " + i+ " j= " + j);
        return i - j;
    }
    public static void main(String[] args){
        //String test = "Hello Brazil World Cup";
        String test = "";
        System.out.println(lengthOfLastWord(test));
    }
}
