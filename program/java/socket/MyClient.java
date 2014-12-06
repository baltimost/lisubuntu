import java.net.*;
import java.io.*;

public class MyClient{
    public Socket server;
    public BufferedReader in;
    public PrintWriter out;
    public BufferedReader cs;

    public MyClient(){
        try{
            server = new Socket("127.0.0.1",5678);
            in = new BufferedReader(
                    new InputStreamReader(server.getInputStream()));
            out = new PrintWriter(server.getOutputStream());
            cs = new BufferedReader(
                    new InputStreamReader(System.in));
        }catch(Exception e){
            System.out.println("MyClient Error");
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        MyClient myclient = new MyClient();
        Write write = new Write(myclient);
        Thread writer = new Thread(write);
        writer.start();
        Read read = new Read(myclient);
        Thread reader = new Thread(read);
        reader.start();
    }
}
class Write implements Runnable{
    private MyClient myclient;
    public Write(MyClient myclient){
        this.myclient = myclient;
    }
    public void run(){
        while(true){
            String str = null;
            try{
                str = myclient.cs.readLine();
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("I say:"+str);
            myclient.out.println(str);
            myclient.out.flush();
            if(str.equals("end"))
                break;
        }
    }
}

class Read implements Runnable{
    private MyClient myclient;
    public Read(MyClient myclient){
        this.myclient = myclient;
    }
    public void run(){
        while(true){
            String str = null;
            try{
                str = myclient.in.readLine();
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("He/She say:"+str);
        }
    }
}
