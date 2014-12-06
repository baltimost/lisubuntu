import java.util.*;

public class SingleNumberII{
    /*
    public int singleNumber(int[] A){
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0;i<A.length;i++){
            if(!hm.containsKey(A[i]))
                hm.put(A[i],0);
            else{
                if(hm.get(A[i]) == 1)
                    hm.remove(A[i]);
                else
                    hm.put(A[i],1);
            }
        }
        Iterator j = hm.keySet().iterator();
        return (int)j.next();
    }//35ms
    */
    /*
    public int singleNumber(int[] A){
        int[] countBit = new int[32];
        int output = 0;
        for(int i=0;i<32;i++){
            for(int j=0;j<A.length;j++){
                if(((A[j]>>i)&1) == 1){
                    countBit[i] = (countBit[i] + 1) % 3;
                }
            }
            output |= (countBit[i]<<i);
        }
        return output;
    }//22ms
    */
    /*
    public int singleNumber(int[] A){
        if(A==null)
            return 0;
        int x0 = ~0, x1 = 0, x2 = 0, t;
        for(int i=0;i<A.length;i++){
            t = x2;
            x2 = (x1 & A[i]) | (x2 & ~A[i]);
            x1 = (x0 & A[i]) | (x1 & ~A[i]);
            x0 = (t & A[i]) | (x0 & ~A[i]);
        }
        return x1;
    }//3ms
    */
    public int singleNumber(int[] A){
        if(A==null)
            return 0;
        int ones = 0, twos = 0, threes = 0;
        for(int i = 0;i<A.length;i++){
            twos |= (ones & A[i]);
            ones ^= A[i];
            threes = twos & ones;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }//2ms
    public static void main(String[] args){
        //int A[] = {3,15,73,55,5,15,2,5,55,31,2,3,3,73,5,2,15,73,55};
        long bf; 
        long af;
        long interval;
        //int A[] = {0,1,0,1,0,1,99};
        int ALim[] = new int[150001];
        for(int i = 0;i < ALim.length;i++){
            ALim[i] = i % 50000;
        }    
        ALim[ALim.length-1] = 99;

        SingleNumberII snII = new SingleNumberII();
        //t:
        bf = System.currentTimeMillis();
        //t:

        System.out.println(snII.singleNumber(ALim));

        //t:
        af = System.currentTimeMillis();
        interval = af - bf;
        System.out.println(interval);
        //t:
    }
}

