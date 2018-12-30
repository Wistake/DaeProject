package util;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Encryptor {
    private static final String loggerName = "util.Encryptor";
    
    public static String hash(String plainText, String algorithm) {
        char[] encoded = null;
        
        try {
            ByteBuffer hashedBytes = Charset.defaultCharset().encode(CharBuffer.wrap(plainText));
            byte[] bytes = hashedBytes.array();
            
            MessageDigest mdEnc = MessageDigest.getInstance(algorithm);
            mdEnc.update(bytes, 0, plainText.toCharArray().length);
            
            encoded = new BigInteger(1, mdEnc.digest()).toString(16).toCharArray();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(loggerName).log(Level.SEVERE, null, ex);
        }
        
        return new String(encoded);
    }
    
    public static String sha256(String plainText) {
        return hash(plainText, "SHA-256");
    }
}
