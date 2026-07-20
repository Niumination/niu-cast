package f6;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5847a = "MD5";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5848b = "SHA-1";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5849c = "SHA-256";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5850d = "SHA-384";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5851e = "SHA-512";

    public static String a(String str) {
        return b(str, "SHA-256");
    }

    public static String b(String str, String str2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(str.getBytes());
            return c(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    public static String c(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }
}
