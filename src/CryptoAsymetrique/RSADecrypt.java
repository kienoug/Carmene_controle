package CryptoAsymetrique;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class RSADecrypt {
    public static void main(String[] args) throws Exception {
        String encodedCryptedMsg = "ThhfsI4SeadoW3d8PgF4l0skH+5y4cCSr4R0NOpcAXjQWi7AYRq7Wp1FNgJR0LPhgqdpat7NRzXiRcqpAzYrtg==";
        byte [] decodedMSG = Base64.getDecoder().decode(encodedCryptedMsg);
        String encodedPrivateKey = "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAksQIs8oZ/VIIyTmALmAF7NAtE/AudCzsm9JUXBnnIgKPiQIArcEfL4H4NJrbAEXbdD7tlb+MUT82/Ox6efQhJQIDAQABAkAKdfTa1Q0Hgb6E59d2NruQDAHShHwtz/qTW/6i9pOuAvM+tq3ZuIah85AjOx5fH6MqP+x4l3qcKMdoZkxGjj0HAiEA2ILR/z/9FfgEAsI+BHNoPrZPHbTDiKFSpVgCvFThZacCIQCtiLedhFMS+SHdShFEN/ksEgwf5sKIK0RqocvUCbv0UwIgEMrctLpmy7xnuzsLilbVIAAN1NT/UWqJuW9BDxBaRwMCIBnneblawmfnpqV45ADx9hEdFJBCizF2e/0K7/lUBqmfAiBNBvmSbBbu3hZkDCWoTtS/6lAoYdyM66fgZ/Y/xg2oHw==";
        byte [] decodedPrivateKey = Base64.getDecoder().decode(encodedPrivateKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodedPrivateKey));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte [] decryptedMSG = cipher.doFinal(decodedMSG);
        System.out.println(new String(decryptedMSG) );
    }
}
