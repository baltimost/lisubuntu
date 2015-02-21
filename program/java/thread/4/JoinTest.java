public class JoinTest{
    public static void main(String[] args){
        MyThread t1 = new MyThread("jack", 100); 
        MyThread t2 = new MyThread("rose", 100); 
        MyThread t3 = new MyThread("linda", 100); 
        try{
            t1.join();
            //t2.join();
            //t3.join();
        } catch(Exception e){}
        System.out.println("main");
    }
}

class MyThread extends Thread{
    int delay;
    public MyThread(String name, int delay){
        super(name);
        this.delay = delay;
        start();
    }
    public void run(){
        try{
            Thread.sleep(delay);
        }catch(Exception e){}
        System.out.println(toString());
    }
}
