public class BidRun implements Runnable{
    int finalBid;
    int increment;
    int delayTime;
    String name;
    public BidRun(int increment, int delayTime){
        this.increment = increment;
        this.delayTime = delayTime;
    }
    public void setName(String name){ this.name = name;}
    public void run(){
        try{
            for(int i = 0;i < 100;i++){
                finalBid += increment;
                System.out.println(name + "BID: " + finalBid);
                Thread.sleep(delayTime);
            }
        } catch(Exception e){
            return;
        }
    }
}
