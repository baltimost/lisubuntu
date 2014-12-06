import java.security.MessageDigest;

public class Sha1Test{
    public static void main(String[] args){
        String message = "AaaaaaaAAA";
        MessageDigest md = null;
        try{
            md = MessageDigest.getInstance("SHA1");
        }catch(Exception e){
            ;
        }
        byte[] output = md.digest(message.getBytes());
        for(byte i:output){
            System.out.println(i);
        }
        System.out.println("Length:"+output.length);
    }
}
