public class ZigZagConversion{
    public static String convert(String s, int nRows){
        if(nRows == 1)
            return s;
        StringBuilder output = new StringBuilder();
        int interval = (nRows - 1) * 2;
        for(int i = 0;i < nRows;i++){
            int count = 0;
            int interval1 = (nRows - i - 1) * 2;  
            int interval2 = interval - interval1;
            for(int j = i;j < s.length();){
                output.append(s.charAt(j));
                if(interval1 == 0 || interval2 == 0)
                    j += interval;
                else if(count % 2 == 0)
                    j += interval1;
                else
                    j += interval2;
                count++;
            }
            /*
            for(int j = i;j < s.length();){
                output.append(s.charAt(j));
                j += interval1;
                if(interval1 != 0 && interval2 != 0){
                    output.append(s.charAt(j));
                }
                j += interval2;
            }
            */
        }
        return output.toString();
    }
    public static void main(String[] args){
        String input = "ab";
        System.out.println(input);
        System.out.println(convert(input, 3));
    }
}
