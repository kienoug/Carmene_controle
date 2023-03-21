package CryptoSymetrique;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AESCrypt {
    public static void main(String[] args) throws Exception {
        String message = "Message en clair";
        String secret = "carmene_6_kienou";
        SecretKey secretKey = new SecretKeySpec(secret.getBytes(),0,secret.length(),"AES");
        Cipher cipher= Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        byte[]encrypteMsg = cipher.doFinal(message.getBytes());
        String encodedEncryptMsg = Base64.getEncoder().encodeToString(encrypteMsg);
        System.out.println(encodedEncryptMsg);
    }
}
