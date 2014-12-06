import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import javax.crypto.SecretKey;

public class AesWithCbcExample{
    public static void main(String[] args)throws Exception{
        String message = "AAAAAAAAAAAAAAA";
        byte[] b = message.getBytes();
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
        byte[] padded = new byte[16];
        System.out.println("");
        padded = b;
        padded[15] = 89; 
        for(int i=0;i<b.length;i++){
            System.out.println(padded[i]);
        }
    }
}

