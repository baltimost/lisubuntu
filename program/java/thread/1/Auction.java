public class Auction{
    public static void main(String[] args){
        BidThread t1 = new BidThread(10,100);
        BidThread t2 = new BidThread(10,100);
        BidRun r3 = new BidRun(10, 100);
        BidRun r4 = new BidRun(10, 100);
        r3.setName("horse");
        r4.setName("lion");
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        t1.setName("panthor");
        t2.setName("antelope");

        t1.setDaemon(true);
        t2.setDaemon(true);
        t3.setDaemon(true);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("End of main Thread");
    }
}
