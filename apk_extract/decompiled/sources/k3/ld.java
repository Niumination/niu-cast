package k3;

import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public abstract class ld {
    public static String a() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        if (encoded == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b9 : encoded) {
            String hexString = Integer.toHexString(b9 & UByte.MAX_VALUE);
            if (hexString.length() == 1) {
                hexString = "0".concat(hexString);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }
}
