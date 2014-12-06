import java.util.HashMap;

public class SMS{
    public static String outputString(String inputString){
        HashMap<Character, String> hm = new HashMap<Character, String>();
        hm.put('1', null);
        hm.put('2', "ABC2");
        hm.put('3', "DEF3");
        hm.put('4', "GHI4");
        hm.put('5', "JKL5");
        hm.put('6', "MON6");
        hm.put('7', "PQRS7");
        hm.put('8', "TUV8");
        hm.put('9', "WXYZ9");
        hm.put('*', " ");
        hm.put('#', "");
        StringBuilder output = new StringBuilder();
        if(inputString == null || inputString.length() == 1)
            return output.toString();
        int count = 1;
        Character key = inputString.charAt(0);
        String value = hm.get(key); 
        for(int i = 1;i < inputString.length();i++){
            if(inputString.charAt(i) == inputString.charAt(i - 1))
                count++;
            else{
                if(key != '#'){
                    char current = value.charAt((count - 1) % value.length()); 
                    output.append(current);
                }
                key = inputString.charAt(i);
                value = hm.get(key); 
                count = 1;
            }
        }
        char current = value.charAt((count - 1) % value.length()); 
        output.append(current);
        return output.toString();
    }
    public static void main(String[] args){
        //String input = "2222#2";
        String input = "2";
        System.out.println(outputString(input));
        input = "22";
        System.out.println(outputString(input));
        input = "23";
        System.out.println(outputString(input));
        input = "223";
        System.out.println(outputString(input));
        input = "22#2";
        System.out.println(outputString(input));
        input = "3#33";
        System.out.println(outputString(input));
        input = "2222";
        System.out.println(outputString(input));
        input = "2222#2";
        System.out.println(outputString(input));
        input = "22222";
        System.out.println(outputString(input));
        input = "222222";
        System.out.println(outputString(input));
        input = "22223#44*5";
        System.out.println(outputString(input));
    }
}
