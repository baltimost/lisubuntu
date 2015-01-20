public class ThreadList{
    public static void main(String[] args){
        ThreadList obj = new ThreadList();
        obj.new MyThread("Zhang3").start();
        obj.new MyThread("Li4").start();
        obj.new MyThread("Wang5").start();

        try{
            Thread.sleep(200);
            //System.gc();
        }catch(InterruptedException e){}
        showThreads();
    }


    private class MyThread extends Thread{
        public MyThread(String name){
            super(name);
        }
        public void run(){
            try{
                Thread.sleep(100);
            }catch(Exception e){}
        }
    }
    public static void showThreads(){
        Thread[] t = new Thread[Thread.activeCount()];
        Thread.enumerate(t);
        for(Thread x : t){
            System.out.print(x.getName() + " ");
        }
        System.out.println();
    } 

}

