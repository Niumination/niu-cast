package com.transsion.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public class EncoderUtil {
    public static final String ALGORITHM_MD5 = "MD5";
    public static final String ALGORITHM_SHA_1 = "SHA-1";
    public static final String ALGORITHM_SHA_256 = "SHA-256";
    public static final String ALGORITHM_SHA_512 = "SHA-512";
    public static final String ALGORITHM__SHA_384 = "SHA-384";

    public static String EncoderByAlgorithm(String str) {
        return EncoderByAlgorithm(str, ALGORITHM_SHA_256);
    }

    private static String bytesToHexString(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b9 : bArr) {
            String hexString = Integer.toHexString(b9 & UByte.MAX_VALUE);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public static String EncoderByAlgorithm(String str, String str2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(str.getBytes());
            return bytesToHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }
}
