package CryptoAsymetrique;

import java.security.*;
import java.util.Arrays;
import java.util.Base64;

public class GeneratedRSAkeys {
    public static void main(String[] args) throws Exception {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //generer la cle privee encoder
        PrivateKey privateKey = keyPair.getPrivate();
        //generer la cle prublic encoder
        PublicKey publicKey = keyPair.getPublic();

        System.out.println(privateKey.getEncoded());
        System.out.println(publicKey.getEncoded());

        //j'affiche la cle privee
        System.out.println("******** Cle privee *******" );
        System.out.println(Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        //j'affiche la cle public
        System.out.println("******** Cle public *******");
        System.out.println(Base64.getEncoder().encodeToString(publicKey.getEncoded()));

    }
}