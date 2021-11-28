package encryptor;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SHA {
    public static String customHash512(String input) {
        try {
            String hashtext = "";
            for (int i = 0; i < 3; i++) {
                input = Base64.encode(input);
                input = input + "92478h09-1039rw9huefh";
                input = Base64.encode(input);
                MessageDigest md = MessageDigest.getInstance("sha-512");
                byte[] messageDigest = md.digest(input.getBytes());
                BigInteger no = new BigInteger(1, messageDigest);
                hashtext = no.toString(16);
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }
            }
            return hashtext;
        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
