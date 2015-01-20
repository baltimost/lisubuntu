import java.util.*;

public class TextJustification{
    public static List<String> fullJustify(String[] words, int L){
        List<String> output = new ArrayList<String>();
        int sumlen = words[0].length();
        int netlen = sumlen; 
        int start = 0;
        for(int i = 1;i < words.length;i++){
            if(sumlen + 1 + words[i].length() <= L){
                sumlen += 1 + words[i].length();
                netlen += words[i].length();
            } else{
                int slot = L - netlen;
                int slotnum = i - start - 1;
                if(slotnum == 0){
                    output.add(words[start] + whiteSpace(L - words[start].length()));
                } else{
                    int slotwidth = slot / slotnum;
                    int remainder = slot % slotnum;
                    StringBuilder sb = new StringBuilder();
                    for(int j = start;j < i - 1;j++){
                        sb.append(words[j]);
                        sb.append(whiteSpace(slotwidth));
                        if(remainder > 0){
                            sb.append(" ");
                            remainder--;
                        }
                    }
                    sb.append(words[i - 1]);
                    output.add(sb.toString());
                }
                start = i;
                sumlen = words[i].length();
                netlen = sumlen;
            }
        }
        StringBuilder sb = new StringBuilder(); 
        for(int i = start;i < words.length - 1;i++){
            sb.append(words[i] + " ");
        }
        sb.append(words[words.length - 1]);
        sb.append(whiteSpace(L - sb.toString().length()));
        output.add(sb.toString());

        return output;
    }
    public static String whiteSpace(int num){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < num;i++)
            sb.append(" ");
        return sb.toString();
    }
    public static void main(String[] args){
        //String[] words = {"This", "is", "an", "example", "of", "text", "justification.","la"};
        //String[] words = {"Hello,", "my", "name", "is", "Zhuren", "Zhou.", "How","are","you","doing?"};
        //String[] words = {"Hello,", "my", "name", "is", "Zhuren", "Zhou.", "How","are","you","doing?"};
        //String[] words = {""};
        //String[] words = {"Hello,", "my", "name", "is", "Zhuren", "Zhou.", "How","are","you","doing?"};
        String[] words = {"a", "b", "c", "d", "e"};
        List<String> rst = fullJustify(words, 3); 
        System.out.println("start");
        for(String x: rst)
            System.out.println("**"+x+"**");
        System.out.println("end");
    }
}
