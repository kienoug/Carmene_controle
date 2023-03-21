package Signature;

import java.security.PrivateKey;
import java.security.Signature;
import java.util.Base64;

                public class RSAsign {
                public static void main(String[] args) throws Exception {
                    PrivateKey privateKey = CryptoUtils.getPrivateKeyFromKeyStore("mundiapolis.jks", "123321", "mundiapolis");
                    String document = "Le message en clair";
                    Signature signature = Signature.getInstance("SHA256withRSA");
                    signature.initSign(privateKey);
                    signature.update(document.getBytes());
                    byte[] sign = signature.sign();
                    String encodedSign = Base64.getEncoder().encodeToString(sign);
                    System.out.println(encodedSign);
                }
                }

