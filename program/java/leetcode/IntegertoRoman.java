import java.util.*;

public class IntegertoRoman{
    /*
    public static String intToRoman(int num){
        int[] arabic = {1000,500,100,50,10,5,1}; 
        String[] roman = {"M","D","C","L","X","V","I"};
        String output = "";
        for(int i = 0;i < arabic.length;i += 2){
            int count = num / arabic[i];
            num -= count * arabic[i];
            switch(count){
                case 1:
                case 2:
                case 3:
                    for(int j = 0;j < count;j++)
                        output += roman[i];
                    break;
                case 4:
                    output += roman[i] + roman[i - 1];
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    output += roman[i - 1];
                    for(int j = 0;j < count - 5;j++)
                        output += roman[i];
                    break;
                case 9:
                    output += roman[i] + roman[i - 2];
                    break;
            }
        }
        return output;
    }
    */
    public static String intToRoman(int num){
        int[] arabic = {1000,900,500,400,100,90,50,40,10,9,5,4,1}; 
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder output = new StringBuilder(); 
        for(int i = 0;i < arabic.length;i++){
            int count = num / arabic[i];
            num %= arabic[i];
            for(int j = 0;j < count;j++)
                output.append(roman[i]);
        }
        return output.toString();
    }
    public static void main(String[] args){
        System.out.println(args.length);
        System.out.println(intToRoman(Integer.parseInt(args[0])));
    }
}
