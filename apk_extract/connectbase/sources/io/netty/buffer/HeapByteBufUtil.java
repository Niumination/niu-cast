package io.netty.buffer;

/* JADX INFO: loaded from: classes2.dex */
final class HeapByteBufUtil {
    private HeapByteBufUtil() {
    }

    public static byte getByte(byte[] bArr, int i10) {
        return bArr[i10];
    }

    public static int getInt(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    public static int getIntLE(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    public static long getLong(byte[] bArr, int i10) {
        return (((long) bArr[i10 + 7]) & 255) | ((((long) bArr[i10]) & 255) << 56) | ((((long) bArr[i10 + 1]) & 255) << 48) | ((((long) bArr[i10 + 2]) & 255) << 40) | ((((long) bArr[i10 + 3]) & 255) << 32) | ((((long) bArr[i10 + 4]) & 255) << 24) | ((((long) bArr[i10 + 5]) & 255) << 16) | ((((long) bArr[i10 + 6]) & 255) << 8);
    }

    public static long getLongLE(byte[] bArr, int i10) {
        return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
    }

    public static short getShort(byte[] bArr, int i10) {
        return (short) ((bArr[i10 + 1] & 255) | (bArr[i10] << 8));
    }

    public static short getShortLE(byte[] bArr, int i10) {
        return (short) ((bArr[i10 + 1] << 8) | (bArr[i10] & 255));
    }

    public static int getUnsignedMedium(byte[] bArr, int i10) {
        return (bArr[i10 + 2] & 255) | ((bArr[i10] & 255) << 16) | ((bArr[i10 + 1] & 255) << 8);
    }

    public static int getUnsignedMediumLE(byte[] bArr, int i10) {
        return ((bArr[i10 + 2] & 255) << 16) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8);
    }

    public static void setByte(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) i11;
    }

    public static void setInt(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) (i11 >>> 24);
        bArr[i10 + 1] = (byte) (i11 >>> 16);
        bArr[i10 + 2] = (byte) (i11 >>> 8);
        bArr[i10 + 3] = (byte) i11;
    }

    public static void setIntLE(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) i11;
        bArr[i10 + 1] = (byte) (i11 >>> 8);
        bArr[i10 + 2] = (byte) (i11 >>> 16);
        bArr[i10 + 3] = (byte) (i11 >>> 24);
    }

    public static void setLong(byte[] bArr, int i10, long j10) {
        bArr[i10] = (byte) (j10 >>> 56);
        bArr[i10 + 1] = (byte) (j10 >>> 48);
        bArr[i10 + 2] = (byte) (j10 >>> 40);
        bArr[i10 + 3] = (byte) (j10 >>> 32);
        bArr[i10 + 4] = (byte) (j10 >>> 24);
        bArr[i10 + 5] = (byte) (j10 >>> 16);
        bArr[i10 + 6] = (byte) (j10 >>> 8);
        bArr[i10 + 7] = (byte) j10;
    }

    public static void setLongLE(byte[] bArr, int i10, long j10) {
        bArr[i10] = (byte) j10;
        bArr[i10 + 1] = (byte) (j10 >>> 8);
        bArr[i10 + 2] = (byte) (j10 >>> 16);
        bArr[i10 + 3] = (byte) (j10 >>> 24);
        bArr[i10 + 4] = (byte) (j10 >>> 32);
        bArr[i10 + 5] = (byte) (j10 >>> 40);
        bArr[i10 + 6] = (byte) (j10 >>> 48);
        bArr[i10 + 7] = (byte) (j10 >>> 56);
    }

    public static void setMedium(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) (i11 >>> 16);
        bArr[i10 + 1] = (byte) (i11 >>> 8);
        bArr[i10 + 2] = (byte) i11;
    }

    public static void setMediumLE(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) i11;
        bArr[i10 + 1] = (byte) (i11 >>> 8);
        bArr[i10 + 2] = (byte) (i11 >>> 16);
    }

    public static void setShort(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) (i11 >>> 8);
        bArr[i10 + 1] = (byte) i11;
    }

    public static void setShortLE(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) i11;
        bArr[i10 + 1] = (byte) (i11 >>> 8);
    }
}
