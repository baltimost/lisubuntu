public class JoinTest{
    public static void main(String[] args){
        MyThread t1 = new MyThread("jack"); 
        MyThread t2 = new MyThread("rose"); 
        MyThread t3 = new MyThread("linda"); 
    }
}

class MyThread extends Thread{
    public MyThread(String name){
        super(name);
        start();
    }
    public void run(){
        for(int i = 0;i < 5;i++){
            System.out.println(toString() + " " + i);
        }
    }
}
