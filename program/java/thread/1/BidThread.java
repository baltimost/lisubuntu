public class BidThread extends Thread{
    int finalBid;
    int increment;
    int delayTime;
    BidThread(int increment, int delayTime){
        this.increment = increment;
        this.delayTime = delayTime;
    }
    public void run(){
        try{
            for(int i = 0;i < 100;i++){
                finalBid += increment;
                System.out.println(toString() + "BID: " + finalBid);
                Thread.sleep(delayTime);
            }
        } catch(Exception e){
            return;
        }
    }
}
