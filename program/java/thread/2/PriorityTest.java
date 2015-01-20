public class PriorityTest{
    public static void main(String[] args){
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

//        Counter hi = new Counter(Thread.MAX_PRIORITY + 2);
 //       Counter lo = new Counter(Thread.MAX_PRIORITY - 2);
        Counter hi = new Counter(Thread.MAX_PRIORITY);
        Counter lo = new Counter(Thread.MIN_PRIORITY);

        lo.start();
        hi.start();

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){}

        lo.stop();
        hi.stop();

        try{
            hi.t.join();
            lo.t.join();
        }catch(InterruptedException e){}

        System.out.println("Low  :" + lo.count);
        System.out.println("High :" + hi.count);

    }
}
    
class Counter implements Runnable{
    int count = 0;
    Thread t;

    private volatile boolean running = true;

    public Counter(int p){
        t = new Thread(this);
        t.setPriority(p);
    }

    public void run(){
        while(running)
            count++;
    }
    
    public void start(){
        t.start();
    }

    public void stop(){
        running = false;
    }
}
