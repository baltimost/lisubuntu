import java.util.HashSet;

public class AEIOU{
    public static String replace(String str){
        int leftbound;
        int count = 0;
        HashSet<Character> vowel = new HashSet<Character>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        char[] output = str.toCharArray();
        for(leftbound = 0;leftbound < str.length() && count < 3;leftbound++){
            if(vowel.contains(str.charAt(leftbound))){
                count++;
            }
            output[leftbound] = str.charAt(leftbound);
        }
        count = 0;
        for(int i = str.length() - 1;i > leftbound && count < 4;i--){
            if(vowel.contains(str.charAt(i))){
                count++;
                output[i] = (char)(str.charAt(i) + 'A' - 'a');
            }
            else
                output[i] = str.charAt(i);
        }
        return new String(output);
    }
    public static void main(String[] args){
        System.out.println(replace("aeokkki"));
        System.out.println(replace("ac1;fheojkuvakioka"));
        System.out.println(replace("aei"));
        System.out.println(replace("aeiouia"));
    }
}
