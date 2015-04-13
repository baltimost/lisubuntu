import java.util.HashMap;

public class Fraction2RecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder output = new StringBuilder();
        long numeratorl = numerator;
        long denominatorl = denominator;
        if(numeratorl > 0 && denominatorl < 0 || numeratorl < 0 && denominatorl > 0)
            output.append("-");
        numeratorl = Math.abs(numeratorl);
        denominatorl = Math.abs(denominatorl);

        long intPart = numeratorl / denominatorl;
        output.append(intPart);
        numeratorl %= denominatorl;
        if(numeratorl == 0) return output.toString();
       
        output.append("."); 
        
        StringBuilder decimal = new StringBuilder();
        HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
        hm.put(numeratorl, 0);
        int i = 1;
        while(true){
            numeratorl *= 10;
            decimal.append(numeratorl / denominatorl);
            numeratorl %= denominatorl;
            if(numeratorl == 0 || hm.get(numeratorl) != null) 
                break;
            hm.put(numeratorl, i);
            i++;
        }
        if(numeratorl == 0)
            output.append(decimal.toString());
        else{
            decimal.insert(hm.get(numeratorl), "(");
            decimal.append(")");
            output.append(decimal.toString());
        }
        return output.toString();
    }
    public static void main(String[] args){
        /*
        System.out.println(fractionToDecimal(-50, 8) + " " + -50.0/8);
        System.out.println(fractionToDecimal(7, 1000) + " " + 7.0/1000);
        System.out.println(fractionToDecimal(1, 3) + " " + 1.0/3.0);
        System.out.println(fractionToDecimal(5, 3) + " " + 5.0/3.0);
        System.out.println(fractionToDecimal(1, 2) + " " + 1.0/2.0);
        System.out.println(fractionToDecimal(1, 99) + " " + 1.0/99.0);
        System.out.println(fractionToDecimal(1, 123) + " " + 1/123.0);
        System.out.println(fractionToDecimal(1, 6) + " " + 1/6.0);
        System.out.println(fractionToDecimal(1, 900) + " " + 1/900.0);


        System.out.println(fractionToDecimal(-1, Integer.MIN_VALUE) + " " + -1.0/Integer.MIN_VALUE);
        System.out.println(fractionToDecimal(2, 1) + " " + 2/1.0);
        */
        System.out.println(fractionToDecimal(1, 3) + " " + 1.0/3.0);
    }
}
