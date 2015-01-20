public class hello implements Runnable{
    private String name = "heihei";
    public void print(){
        System.out.println(toString());
    }
    public static void main(String[] args){
        hello h = new hello();
        Thread t = new Thread(h);
        t.start();
        System.out.println(Thread.activeCount());
    }
    public void run(){
        print();
    }
}
