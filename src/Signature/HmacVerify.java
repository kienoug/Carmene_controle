package Signature;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HmacVerify {
    public static void main(String[] args) throws Exception {
        String receivedDoc = "Le message en clair"+"-__-"+"pk8nrOrk9nBiM57LBgRpgp1xtEom2kZ5s3rXdyIM1z8=";
        String [] splitedDoc = receivedDoc.split("-__-");
        String receivedSignature = splitedDoc[1];//la signature
        String document = splitedDoc[0];
        String secret1 = "123321";
        SecretKeySpec secretKeySpec1 = new SecretKeySpec(secret1.getBytes(), "HmacSHA256");//crer une cle secret a l'aide de la cle partager
        Mac mac1 = Mac.getInstance("HmacSHA256");
        mac1.init(secretKeySpec1);

        byte[] signature1 = mac1.doFinal(document.getBytes());
        String calculatedsignature = Base64.getEncoder().encodeToString(signature1);
        System.out.println(receivedSignature.equals(calculatedsignature)? "Signature OK" : "Signature Non OK"); //equals pour comparer deux chaine de caracteres


    }

}
