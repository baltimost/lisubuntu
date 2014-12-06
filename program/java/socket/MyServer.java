import java.io.*;
import java.net.*;

public class MyServer{
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(5678);
        Socket client = server.accept();
        System.out.println("After server.accept()");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream());
        BufferedReader ss = new BufferedReader(
                new InputStreamReader(System.in));
        while(true){
            System.out.println("Sever Loop");
            String str = in.readLine();
            System.out.println("Client say:"+str);
            if(str.equals("end"))
                break;
            String str2 = ss.readLine();
            out.println(str2);
            out.flush();
        }
    }
}
