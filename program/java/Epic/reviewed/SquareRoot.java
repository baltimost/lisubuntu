public class SquareRoot{
    public static double sqrt(double number){
        double l, h, m;
        l = 0;
        h = number;
        m = 0;
        while(m != (l + h) / 2){
            m = (l + h) / 2;
            if(m * m < number)
                l = m;
            else if(m * m > number)
                h = m;
        }
        return h;
    } 
    public static void main(String[] args){
        double input = 256;
        System.out.println(sqrt(input));
        System.out.println(Math.sqrt(input));
    }
}

