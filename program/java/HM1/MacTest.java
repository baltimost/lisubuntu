import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MacTest{
    public static void main(String[] args){
        String macKey = "The HMAC key";
        String macData = "the data";

        Mac mac = null;
        try{
            mac = Mac.getInstance("HMACSHA1");
        }catch(Exception e){
            ;
        }
        SecretKey secret = new SecretKeySpec(macKey.getBytes(),"HMACSHA1");
        try{
            mac.init(secret);
        }catch(Exception e){
            ;
        }
        byte[] doFinal = mac.doFinal(macData.getBytes());
        for(int i=0;i<doFinal.length;i++){
            System.out.println(doFinal[i]);
        }
        System.out.println("-Length-"+doFinal.length);
    }
}
