package v4;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f16520a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f16521b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f16522c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f16523d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte f16524e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte f16525f = 6;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f16526g = 7;

    public static byte[] a(int i10) {
        byte[] bArr = new byte[2];
        System.arraycopy(g(i10), 0, bArr, 0, 2);
        return f((byte) 2, 2, bArr);
    }

    public static byte[] b(int i10, int i11, int i12, int i13) {
        byte[] bArr = new byte[8];
        System.arraycopy(g(i10), 0, bArr, 0, 2);
        System.arraycopy(g(i11), 0, bArr, 2, 2);
        System.arraycopy(g(i12), 0, bArr, 4, 2);
        System.arraycopy(g(i13), 0, bArr, 6, 2);
        return f((byte) 1, 8, bArr);
    }

    public static byte[] c(int i10) {
        byte[] bArr = new byte[2];
        System.arraycopy(g(i10), 0, bArr, 0, 2);
        return f((byte) 3, 2, bArr);
    }

    public static byte[] d(int i10, String str, String str2, byte[] bArr) {
        Charset charset = StandardCharsets.UTF_8;
        byte[] bytes = str.getBytes(charset);
        byte[] bytes2 = str2.getBytes(charset);
        byte[] bArr2 = new byte[bytes.length + 16 + bytes2.length + bArr.length];
        System.arraycopy(k4.c.r(i10), 0, bArr2, 0, 4);
        System.arraycopy(k4.c.r(bytes.length), 0, bArr2, 4, 4);
        System.arraycopy(k4.c.r(bytes2.length), 0, bArr2, 8, 4);
        System.arraycopy(k4.c.r(bArr.length), 0, bArr2, 12, 4);
        System.arraycopy(bytes, 0, bArr2, 16, bytes.length);
        System.arraycopy(bytes2, 0, bArr2, bytes.length + 16, bytes2.length);
        System.arraycopy(bArr, 0, bArr2, bytes.length + 16 + bytes2.length, bArr.length);
        return f((byte) 5, 2, bArr2);
    }

    public static byte[] e(int i10, byte b10) {
        byte[] bArr = {0, 0, b10};
        System.arraycopy(g(i10), 0, bArr, 0, 2);
        return f((byte) 4, 2, bArr);
    }

    public static byte[] f(byte b10, int i10, byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 5];
        bArr2[0] = b10;
        byte[] bArrR = k4.c.r(i10);
        System.arraycopy(bArrR, 0, bArr2, 1, bArrR.length);
        System.arraycopy(bArr, 0, bArr2, 5, bArr.length);
        k4.m.e("TAG", Arrays.toString(bArr2));
        return bArr2;
    }

    public static byte[] g(int i10) {
        return new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255)};
    }
}
