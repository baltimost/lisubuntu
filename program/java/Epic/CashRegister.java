import java.util.List;
import java.util.ArrayList;

public class CashRegister{
    public static List<Integer> balance(double pay, double cost){
        int[] bills = {1, 5, 10, 25, 100, 500, 1000, 2000, 10000};
        int balance = (int)(pay * 100) - (int)(cost * 100);
        List<Integer>[] d = new List[balance + 1];
        d[0] = new ArrayList<Integer>();
        for(int i = 1;i < d.length;i++){
            int min = Integer.MAX_VALUE;
            int bill = 0;
            List<Integer> minList = new ArrayList<Integer>();
            for(int j = 0;j < bills.length && i - bills[j] >= 0;j++){
                if(d[i - bills[j]].size() < min){
                    min = d[i - bills[j]].size();
                    minList = d[i - bills[j]];
                    bill = bills[j];
                }
            }
            d[i] = new ArrayList<Integer>(minList);
            d[i].add(bill); 
        } 
        return d[balance];
    }
    public static void main(String[] args){
        //List<Integer> rst = balance(200, 10.25);
        List<Integer> rst = balance(10, 9.97);
        for(Integer x : rst)
            System.out.print(x + " ");
        System.out.println();
    }
}
