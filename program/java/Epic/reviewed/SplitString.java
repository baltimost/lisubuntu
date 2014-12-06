public class SplitString{
    public static String splitString(String str){
        StringBuilder output = new StringBuilder();
        int count = 0;
        boolean hasSpec = false;
        for(int i = 0,j = 0;j <= str.length();j++){
            if(j != str.length() && str.charAt(j) != ' '){
                if(isAlphabet(str.charAt(j)))
                    count++;
                else
                    hasSpec = true;
            }
            else{
                if(count >= 4 && count % 2 == 0){
                    int m;
                    if(!hasSpec)
                        m = (i + j) / 2;
                    else{
                        int half = 0, k;
                        for(k = i;half != count / 2;k++){
                            if(isAlphabet(str.charAt(k)))
                                half++;
                        }
                        m = k;
                    }
                    output.append(str.substring(i, m) + " ");
                    output.append(str.substring(m, j) + " ");
                }
                else
                    output.append(str.substring(i, j) + " ");
                if(j == str.length())
                    output.deleteCharAt(output.length() - 1); 
                i = j + 1;
                count = 0;
                hasSpec = false;
            }
        }
        return output.toString();
    }
    private static boolean isAlphabet(char letter){
        return (letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z');
    }
    public static void main(String[] args){
        System.out.println(splitString("A person can't walk in this street")+"||");
        System.out.println(splitString("A person ca'nt walk in this street")+"||");
        System.out.println(splitString("A person ca'n't walk in this street")+"||");
        System.out.println(splitString("A person can't walk in this street'")+"||");
        System.out.println(splitString(" A person can't walk in this street' ")+"||");
    }
}
