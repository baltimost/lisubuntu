import java.util.*;

public class Goldbach{
    public static void goldbach(int number){
        if(number <= 2 || number % 2 != 0){
            System.out.println("Not a even number greater than 2");
            return;
        }
        for(int i = 2;i <= number / 2;i++){
            if(isPrime(i) && isPrime(number - i)){
                //System.out.println(i + "," + (number - i));
                ;
            }
        } 
    }
    private static boolean isPrime(int number){
        if(number == 1) return false;
        for(int i = 2;i <= Math.sqrt(number);i++){
            if(number % i == 0)
                return false;
        }
        return true;
    }
    public static void printPrimePair(int no){
        //find all the primes eratosthenes algo
        Boolean [] isPrime = new Boolean[no+1];
        for(int i=0;i<no;i++){
            isPrime[i]= true;
        }
        Set<Integer> primeSet = new HashSet<Integer>();
        for(int i=2;i*i<no;i++){
            if(isPrime[i]){
                for(int j=i;j*i<no;j++){
                    isPrime[j*i] = false;
                }
            }
        }
        for(int i=2;i<no;i++){
            if(isPrime[i])
                primeSet.add(i);
        }
        //get the goldbach's conjucture 
        for(Integer i:primeSet){
            if(primeSet.contains(no-i)){
                //System.out.println("the pair :"+i+" "+(no-i));
                ;
            }
        }
    }
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        //goldbach(9000000);
        printPrimePair(1000000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
