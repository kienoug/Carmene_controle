package CryptoAsymetrique;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class RSACrypt {
    public static void main(String[] args) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        String encodedPK = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJLECLPKGf1SCMk5gC5gBezQLRPwLnQs7JvSVFwZ5yICj4kCAK3BHy+B+DSa2wBF23Q+7ZW/jFE/Nvzsenn0ISUCAwEAAQ==";
        byte [] decodedPK = Base64.getDecoder().decode(encodedPK);
        PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(decodedPK));
        String message = "Le message en clair";
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        byte[] encryptedMessage = cipher.doFinal(message.getBytes());
        String encodedMSG = Base64.getEncoder().encodeToString(encryptedMessage);
        System.out.println(encodedMSG);
    }
}
