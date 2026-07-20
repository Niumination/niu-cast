package j1;

/* JADX INFO: loaded from: classes.dex */
@l
public final class m extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f8442a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f8443b = -4348849565147123417L;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f8444e = -5435081209227447693L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f8445f = -7286425919675154353L;

    @b1.e
    public static long a(byte[] bytes, int offset, int length) {
        if (length <= 32) {
            return length <= 16 ? b(bytes, offset, length) : d(bytes, offset, length);
        }
        return length <= 64 ? e(bytes, offset, length) : f(bytes, offset, length);
    }

    public static long b(byte[] bytes, int offset, int length) {
        if (length >= 8) {
            long j10 = (((long) length) * 2) + f8445f;
            long jB = z.b(bytes, offset) + f8445f;
            long longLittleEndian = z.f8467a.getLongLittleEndian(bytes, (offset + length) - 8);
            return c((Long.rotateRight(longLittleEndian, 37) * j10) + jB, (Long.rotateRight(jB, 25) + longLittleEndian) * j10, j10);
        }
        if (length >= 4) {
            return c(((long) length) + ((((long) z.a(bytes, offset)) & 4294967295L) << 3), ((long) z.a(bytes, (offset + length) - 4)) & 4294967295L, ((long) (length * 2)) + f8445f);
        }
        if (length <= 0) {
            return f8445f;
        }
        return g((((long) ((bytes[offset] & 255) + ((bytes[(length >> 1) + offset] & 255) << 8))) * f8445f) ^ (((long) (length + ((bytes[(length - 1) + offset] & 255) << 2))) * f8443b)) * f8445f;
    }

    public static long c(long u10, long v10, long mul) {
        long j10 = (u10 ^ v10) * mul;
        long j11 = ((j10 ^ (j10 >>> 47)) ^ v10) * mul;
        return (j11 ^ (j11 >>> 47)) * mul;
    }

    public static long d(byte[] bytes, int offset, int length) {
        long j10 = (((long) length) * 2) + f8445f;
        long jB = z.b(bytes, offset) * f8444e;
        z.c cVar = z.f8467a;
        long longLittleEndian = cVar.getLongLittleEndian(bytes, offset + 8);
        int i10 = offset + length;
        long longLittleEndian2 = cVar.getLongLittleEndian(bytes, i10 - 8) * j10;
        return c(Long.rotateRight(longLittleEndian2, 30) + Long.rotateRight(jB + longLittleEndian, 43) + (cVar.getLongLittleEndian(bytes, i10 - 16) * f8445f), Long.rotateRight(longLittleEndian + f8445f, 18) + jB + longLittleEndian2, j10);
    }

    public static long e(byte[] bytes, int offset, int length) {
        long j10 = (((long) length) * 2) + f8445f;
        long jB = z.b(bytes, offset) * f8445f;
        z.c cVar = z.f8467a;
        long longLittleEndian = cVar.getLongLittleEndian(bytes, offset + 8);
        int i10 = offset + length;
        long longLittleEndian2 = cVar.getLongLittleEndian(bytes, i10 - 8) * j10;
        long jRotateRight = Long.rotateRight(longLittleEndian2, 30) + Long.rotateRight(jB + longLittleEndian, 43) + (cVar.getLongLittleEndian(bytes, i10 - 16) * f8445f);
        long jC = c(jRotateRight, longLittleEndian2 + Long.rotateRight(longLittleEndian + f8445f, 18) + jB, j10);
        long longLittleEndian3 = cVar.getLongLittleEndian(bytes, offset + 16) * j10;
        long longLittleEndian4 = cVar.getLongLittleEndian(bytes, offset + 24);
        long longLittleEndian5 = (cVar.getLongLittleEndian(bytes, i10 - 32) + jRotateRight) * j10;
        return c(((cVar.getLongLittleEndian(bytes, i10 - 24) + jC) * j10) + Long.rotateRight(longLittleEndian5, 30) + Long.rotateRight(longLittleEndian3 + longLittleEndian4, 43), Long.rotateRight(longLittleEndian4 + jB, 18) + longLittleEndian3 + longLittleEndian5, j10);
    }

    public static long f(byte[] bytes, int offset, int length) {
        long j10 = 81;
        long j11 = (j10 * f8444e) + 113;
        long jG = g((j11 * f8445f) + 113) * f8445f;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long jB = z.b(bytes, offset) + (j10 * f8445f);
        int i10 = length - 1;
        int i11 = ((i10 / 64) * 64) + offset;
        int i12 = i10 & 63;
        int i13 = i11 + i12;
        int i14 = i13 - 63;
        long j12 = jB;
        int i15 = offset;
        while (true) {
            long j13 = j12 + j11 + jArr[0];
            z.c cVar = z.f8467a;
            long jRotateRight = Long.rotateRight(cVar.getLongLittleEndian(bytes, i15 + 8) + j13, 37) * f8444e;
            long jRotateRight2 = Long.rotateRight(cVar.getLongLittleEndian(bytes, i15 + 48) + j11 + jArr[1], 42) * f8444e;
            long j14 = jRotateRight ^ jArr2[1];
            long longLittleEndian = cVar.getLongLittleEndian(bytes, i15 + 40) + jArr[0] + jRotateRight2;
            long jRotateRight3 = Long.rotateRight(jG + jArr2[0], 33) * f8444e;
            int i16 = i12;
            h(bytes, i15, jArr[1] * f8444e, j14 + jArr2[0], jArr);
            h(bytes, i15 + 32, jRotateRight3 + jArr2[1], cVar.getLongLittleEndian(bytes, i15 + 16) + longLittleEndian, jArr2);
            i15 += 64;
            if (i15 == i11) {
                long j15 = f8444e + ((j14 & 255) << 1);
                long j16 = jArr2[0] + ((long) i16);
                jArr2[0] = j16;
                long j17 = jArr[0] + j16;
                jArr[0] = j17;
                jArr2[0] = jArr2[0] + j17;
                long jRotateRight4 = Long.rotateRight(cVar.getLongLittleEndian(bytes, i13 - 55) + jRotateRight3 + longLittleEndian + jArr[0], 37) * j15;
                long jRotateRight5 = Long.rotateRight(cVar.getLongLittleEndian(bytes, i13 - 15) + longLittleEndian + jArr[1], 42) * j15;
                long j18 = jRotateRight4 ^ (jArr2[1] * 9);
                long longLittleEndian2 = cVar.getLongLittleEndian(bytes, i13 - 23) + (jArr[0] * 9) + jRotateRight5;
                long jRotateRight6 = Long.rotateRight(j14 + jArr2[0], 33) * j15;
                h(bytes, i14, jArr[1] * j15, j18 + jArr2[0], jArr);
                h(bytes, i13 - 31, jRotateRight6 + jArr2[1], cVar.getLongLittleEndian(bytes, i13 - 47) + longLittleEndian2, jArr2);
                return c((g(longLittleEndian2) * f8443b) + c(jArr[0], jArr2[0], j15) + j18, c(jArr[1], jArr2[1], j15) + jRotateRight6, j15);
            }
            i12 = i16;
            jG = j14;
            j11 = longLittleEndian;
            j12 = jRotateRight3;
        }
    }

    public static long g(long val) {
        return val ^ (val >>> 47);
    }

    public static void h(byte[] bytes, int offset, long seedA, long seedB, long[] output) {
        long jB = z.b(bytes, offset);
        z.c cVar = z.f8467a;
        long longLittleEndian = cVar.getLongLittleEndian(bytes, offset + 8);
        long longLittleEndian2 = cVar.getLongLittleEndian(bytes, offset + 16);
        long longLittleEndian3 = cVar.getLongLittleEndian(bytes, offset + 24);
        long j10 = seedA + jB;
        long j11 = longLittleEndian + j10 + longLittleEndian2;
        long jRotateRight = Long.rotateRight(j11, 44) + Long.rotateRight(seedB + j10 + longLittleEndian3, 21);
        output[0] = j11 + longLittleEndian3;
        output[1] = jRotateRight + j10;
    }

    @Override // j1.r
    public int bits() {
        return 64;
    }

    @Override // j1.e, j1.c, j1.r
    public q hashBytes(byte[] input, int off, int len) {
        c1.h0.f0(off, off + len, input.length);
        return q.fromLong(a(input, off, len));
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}
