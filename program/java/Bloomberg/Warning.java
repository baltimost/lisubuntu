import java.util.*;

public class Warning{
    static Queue<Long> q = new LinkedList<Long>();
    static int count = 0;
    int interval;
    int n;
    public Warning(int interval, int n){
        this.interval = interval;
        this.n = n;
    }

    public void callee(){
        long curr = System.currentTimeMillis();
        if(q.isEmpty() || (curr - q.peek() <= interval)){
            count++;
            q.add(curr);
            if(count >= n){
                System.out.println("Warning! Visit too frequently!" + " " + count);
            }
        }
        else{
            while(!q.isEmpty() && curr - q.peek() > interval){
                q.poll();
                count--;
            }
            q.add(curr);
            count++;
        } 
    }
    public static void main(String[] args){
        Warning warning = new Warning(1000,4);
        warning.callee();
        warning.callee();
        warning.callee();
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            ;
        }
        warning.callee();
        warning.callee();
        warning.callee();
        warning.callee();
        warning.callee();
    }
}
