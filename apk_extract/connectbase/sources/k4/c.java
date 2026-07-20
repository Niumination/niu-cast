package k4;

import androidx.annotation.NonNull;
import io.netty.handler.codec.http2.Http2CodecUtil;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static byte[] a(long j10, byte[] bArr) {
        byte[] bArrS = s(j10);
        byte[] bArr2 = new byte[bArr.length + bArrS.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(bArrS, 0, bArr2, bArr.length, bArrS.length);
        return bArr2;
    }

    @NonNull
    public static String b(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? "" : new String(bArr, StandardCharsets.UTF_8);
    }

    public static char[] c(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = (char) (bArr[i10] & 255);
        }
        return cArr;
    }

    public static double d(byte[] bArr) {
        return Double.longBitsToDouble(j(bArr));
    }

    public static double e(byte[] bArr) {
        return Double.longBitsToDouble(k(bArr));
    }

    public static float f(byte[] bArr) {
        return Float.intBitsToFloat(h(bArr));
    }

    public static float g(byte[] bArr) {
        return Float.intBitsToFloat(i(bArr));
    }

    public static int h(byte[] bArr) {
        int i10 = bArr[3] & 255;
        int i11 = (bArr[2] & 255) << 8;
        return ((bArr[0] & 255) << 24) | i10 | i11 | ((bArr[1] & 255) << 16);
    }

    public static int i(byte[] bArr) {
        int i10 = bArr[0] & 255;
        int i11 = (bArr[1] & 255) << 8;
        return ((bArr[3] & 255) << 24) | i10 | i11 | ((bArr[2] & 255) << 16);
    }

    public static long j(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 56) | ((((long) bArr[1]) & 255) << 48) | ((((long) bArr[2]) & 255) << 40) | ((((long) bArr[3]) & 255) << 32) | ((((long) bArr[4]) & 255) << 24) | ((((long) bArr[5]) & 255) << 16) | ((((long) bArr[6]) & 255) << 8) | (255 & ((long) bArr[7]));
    }

    public static long k(byte[] bArr) {
        return (((long) bArr[0]) & 255) | ((((long) bArr[1]) & 255) << 8) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[6]) & 255) << 48) | ((255 & ((long) bArr[7])) << 56);
    }

    public static short l(byte[] bArr) {
        return (short) ((bArr[1] & 255) | (bArr[0] << 8));
    }

    public static short m(byte[] bArr) {
        return (short) ((bArr[0] & 255) | (bArr[1] << 8));
    }

    public static byte[] n(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return null;
        }
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = (byte) cArr[i10];
        }
        return bArr;
    }

    public static byte[] o(double d10) {
        return s(Double.doubleToLongBits(d10));
    }

    public static byte[] p(double d10) {
        return t(Double.doubleToLongBits(d10));
    }

    public static byte[] q(int i10) {
        return new byte[]{(byte) ((i10 >> 24) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 8) & 255), (byte) (i10 & 255)};
    }

    public static byte[] r(int i10) {
        return new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 24) & 255)};
    }

    public static byte[] s(long j10) {
        return new byte[]{(byte) ((j10 >> 56) & 255), (byte) ((j10 >> 48) & 255), (byte) ((j10 >> 40) & 255), (byte) ((j10 >> 32) & 255), (byte) ((j10 >> 24) & 255), (byte) ((j10 >> 16) & 255), (byte) ((j10 >> 8) & 255), (byte) (j10 & 255)};
    }

    public static byte[] t(long j10) {
        return new byte[]{(byte) (j10 & 255), (byte) ((j10 >> 8) & 255), (byte) ((j10 >> 16) & 255), (byte) ((j10 >> 24) & 255), (byte) ((j10 >> 32) & 255), (byte) ((j10 >> 40) & 255), (byte) ((j10 >> 48) & 255), (byte) ((j10 >> 56) & 255)};
    }

    public static byte[] u(long j10) {
        return new byte[]{(byte) ((j10 >> 56) & 255), (byte) ((j10 >> 48) & 255), (byte) ((j10 >> 40) & 255), (byte) ((j10 >> 32) & 255), (byte) ((j10 >> 24) & 255), (byte) ((j10 >> 16) & 255), (byte) ((j10 >> 8) & 255), (byte) (j10 & 255)};
    }

    public static byte[] v(long j10) {
        return new byte[]{(byte) (j10 & 255), (byte) ((j10 >> 8) & 255), (byte) ((j10 >> 16) & 255), (byte) ((j10 >> 24) & 255), (byte) ((j10 >> 32) & 255), (byte) ((j10 >> 40) & 255), (byte) ((j10 >> 48) & 255), (byte) ((j10 >> 56) & 255)};
    }

    public static byte[] w(short s10) {
        return new byte[]{(byte) ((s10 >> 8) & 255), (byte) (s10 & Http2CodecUtil.MAX_UNSIGNED_BYTE)};
    }

    public static byte[] x(short s10) {
        return new byte[]{(byte) (s10 & Http2CodecUtil.MAX_UNSIGNED_BYTE), (byte) ((s10 >> 8) & 255)};
    }
}
