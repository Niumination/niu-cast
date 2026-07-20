package ai;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f212a = "MD5";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f213b = "SHA-1";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f214c = "SHA-256";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f215d = "SHA-384";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f216e = "SHA-512";

    public static String a(String key) {
        return b(key, "SHA-256");
    }

    public static String b(String key, String algorithm) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(key.getBytes());
            return c(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(key.hashCode());
        }
    }

    public static String c(byte[] bytes) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bytes) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public static String d(final String s10) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(s10.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : bArrDigest) {
                String hexString = Integer.toHexString(b10 & 255);
                while (hexString.length() < 2) {
                    hexString = hi.b.f7118g + hexString;
                }
                sb2.append(hexString);
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
