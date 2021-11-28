package encryptor;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Decryptor {

    public static String decrypt(String input, String keyStr) throws Exception {
        keyStr = SHA.customHash512(keyStr);
        input = encryptor.Base64.decode(input);
        byte[] key;
        String decryptedString = "";
        SecretKeySpec secretKey;

        MessageDigest sha = null;
        try {
            key = keyStr.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] passin = input.trim().getBytes();
            decryptedString = (new String(cipher.doFinal(Base64.decodeBase64(passin))));
            decryptedString = encryptor.Base64.decode(decryptedString);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return decryptedString;
    }
}
