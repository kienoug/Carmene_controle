package Signature;

import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

   public class RSAVerify {
    public static void main(String[] args) throws Exception {
        PublicKey publicKey = CryptoUtils.getPublicKeyFromCertificate("certificate.cert");
        String receivedDocSign = "Le message en clair"+"-__-"+"vtLSOOnzOiMIVsP6ej9GIb3zx15TpQ8YI3jYxZ0TlqzTfVTeyG1Z+S6x2P7nwy036tlo9ssbipYHeG2EaJVg9N7O08ULC2+JhJY+IiAw6HcaAcJIdbLjFOID9fh7mf637Ghe0do8Lg1AL+FebPc2+/Ke6AxDSbAcCmT0sEZyvt5VbMgydfMuQIvobXTxZ34LdoCpuRsNO5F2ftX2NkmqZ9+2JhneB84ttjGFiqKCA/8705NW+y0y17ExFbNNGvmiRlxsr77VD8K+lTiV5KeBLNWb1+BGZ37GBPVcdXsDyVsMS1LEWhxydaX9aveRXtE8sMEw81jq9f9NGIxzfuPfIw==";
        String []splitedDoc = receivedDocSign.split("-__-");
        String receivedSign = splitedDoc[1];
        String receivedDoc = splitedDoc[0];
        Signature signature1 = Signature.getInstance("SHA256withRSA");
        signature1.initVerify(publicKey);
        signature1.update(receivedDoc.getBytes());
        byte [] decodeSign = Base64.getDecoder().decode(receivedSign);
        boolean verify = signature1.verify(decodeSign);
        System.out.println(verify? "Signature OK " : "Signature Non OK");
    }
   }
