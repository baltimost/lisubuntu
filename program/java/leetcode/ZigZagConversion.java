public class ZigZagConversion{
    public static String convert(String s, int nRows){
        if(nRows == 1 || s == null || s.length() <= 1)
            return s;
        StringBuilder output = new StringBuilder();
        int interval = (nRows - 1) * 2;
        for(int i = 0;i < nRows;i++){
            int interval1 = (nRows - i - 1) * 2;  
            for(int j = i;j < s.length();){
                output.append(s.charAt(j));
                if(subinterval == 0 || subinterval == interval)
                    j += interval;
                else{
                    j += subinterval;
                    subinterval = interval - subinterval;
                }
            }
        }
        return output.toString();
    }
    public static void main(String[] args){
        String input = "abcdefghijkj";
        System.out.println(input);
        System.out.println(convert(input, 2));
    }
}
