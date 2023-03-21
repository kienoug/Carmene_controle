package CryptoSymetrique;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESDecrypt {
    public static void main(String[] args) throws Exception{
        String encodeEncrypteMsg = "Z0q4t6+HvCqJ3lTyg28rc0OOEZoV6l+GuB8xxSsNHoc=";
        byte[] decodeEncrypteMsg = Base64.getDecoder().decode(encodeEncrypteMsg);
        String secret="carmene_6_kienou";
        SecretKey secretKey = new SecretKeySpec(secret.getBytes(),0,secret.length(),"AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        byte [] decryptMSG = cipher.doFinal(decodeEncrypteMsg);
        System.out.println(new String(decryptMSG));
    }
}
