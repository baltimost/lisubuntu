import java.util.*;

public class SingleNumber{
    public int singleNumber(int[] A){
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<A.length;i++){
            if(!hm.containsKey(A[i])){
                hm.put(A[i],i);
            }
            else{
                hm.remove(A[i]);
            }
        }
        Iterator j = hm.keySet().iterator();
        return (int)j.next(); 
    }
    /*
    public int singleNumber(int[] A){
        int output=0;
        for(int x:A)
            output = output ^ x;
        return output;
    }
    */

    public static void main(String[] args){
        long bt;
        long at;
        long interval;
        
        int A[] = {0,4,3,0,8,7,11,4,7,3,11};
        int ALim[] = new int[100001]; 
        for(int i=0;i<ALim.length;i++)
            ALim[i] = i%50000;
        ALim[100000] = -1;
                
        SingleNumber sn = new SingleNumber();
        bt = System.currentTimeMillis();
        System.out.println(sn.singleNumber(ALim));
        at = System.currentTimeMillis();
        interval = at - bt;
        System.out.println(interval);
    }
}
