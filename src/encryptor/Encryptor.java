package encryptor;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Encryptor {

    public static String encrypt(String input, String keyStr) throws Exception {
        keyStr = SHA.customHash512(keyStr);
        input = encryptor.Base64.encode(input);
        SecretKeySpec secretKey;
        MessageDigest sha = null;
        String encryptedString = "";
        byte[] key;
        try {
            key = keyStr.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] passin = cipher.doFinal(input.trim().getBytes("UTF-8"));

            Base64 base64 = new Base64();
            encryptedString = base64.encodeToString(passin);
            encryptedString = encryptor.Base64.encode(encryptedString);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return encryptedString;
    }
}
