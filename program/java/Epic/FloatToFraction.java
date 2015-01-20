public class FloatToFraction{
    public static String floatToFraction(double number){
        if(number < 0.0001 || number > 0.9999) return null;
        int numerator = (int)(number * 10000);
        int denominator = 10000;
        int common = maxCommonDivisor(denominator, numerator);
        numerator /= common;
        denominator /= common;
        String output = numerator + "/" + denominator; 
        return output;
    }
    private static int maxCommonDivisor(int l, int r){
        while(l % r != 0){
            int tmp = r;
            r = l % r;
            l = tmp;
        }
        return r;
    }
    public static void main(String[] args){
        System.out.println(floatToFraction(0.78));
    }
}
