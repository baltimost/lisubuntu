import java.util.*;

public class helloworld{
    public void test(){
        System.out.println(a);
    }
    int a = 3;
    int b = a + 1;

    public static long factorial(int n){
        long output = 1;
        while(n > 0)
            output *= n--;
        return output;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(Integer.MIN_VALUE == Integer.MIN_VALUE * -1);
        System.out.println(Integer.MIN_VALUE == Integer.MIN_VALUE / -1);
        /*
        System.out.println(Math.sqrt(-100));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(1/0);
        */
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2,32));
        System.out.println(Math.pow(2,32) / 2);
        HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
        hm.put(0.0, 22);
        hm.put(-0.0, 33);
        System.out.println(hm.get(0.0));
        System.out.println(hm.get(-0.0));
        System.out.println(0.0 == -0.0);

        for(int i = 0;i < 50;i++){
            System.out.println(i + ":" + factorial(i));
        }

        System.out.println((double)1/(double)2);
    }
}

