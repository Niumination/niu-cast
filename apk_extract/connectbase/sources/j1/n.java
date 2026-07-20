package j1;

/* JADX INFO: loaded from: classes.dex */
@l
public final class n extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f8446a = new n();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f8447b = -6505348102511208375L;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f8448e = -8261664234251669945L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f8449f = -4288712594273399085L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f8450g = -4132994306676758123L;

    @b1.e
    public static long a(byte[] bytes, int offset, int length) {
        long jD;
        if (length <= 32) {
            jD = e(bytes, offset, length, -1397348546323613475L);
        } else {
            jD = length <= 64 ? d(bytes, offset, length) : b(bytes, offset, length);
        }
        long jB = f8447b;
        long jB2 = length >= 8 ? z.b(bytes, offset) : -6505348102511208375L;
        if (length >= 9) {
            jB = z.b(bytes, (offset + length) - 8);
        }
        long jC = c(jD + jB, jB2);
        return (jC == 0 || jC == 1) ? jC - 2 : jC;
    }

    public static long b(byte[] bytes, int offset, int length) {
        long jB = z.b(bytes, offset);
        int i10 = offset + length;
        z.c cVar = z.f8467a;
        long longLittleEndian = cVar.getLongLittleEndian(bytes, i10 - 16) ^ f8448e;
        long longLittleEndian2 = cVar.getLongLittleEndian(bytes, i10 - 56) ^ f8447b;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long j10 = length;
        g(bytes, i10 - 64, j10, longLittleEndian, jArr);
        g(bytes, i10 - 32, j10 * f8448e, f8447b, jArr2);
        long jF = (f(jArr[1]) * f8448e) + longLittleEndian2;
        long jRotateRight = Long.rotateRight(jB + jF, 39) * f8448e;
        long jRotateRight2 = Long.rotateRight(longLittleEndian, 33) * f8448e;
        int i11 = offset;
        int i12 = (length - 1) & (-64);
        while (true) {
            long j11 = jRotateRight + jRotateRight2 + jArr[0];
            z.c cVar2 = z.f8467a;
            long jRotateRight3 = Long.rotateRight(cVar2.getLongLittleEndian(bytes, i11 + 16) + j11, 37) * f8448e;
            long jRotateRight4 = Long.rotateRight(jRotateRight2 + jArr[1] + cVar2.getLongLittleEndian(bytes, i11 + 48), 42) * f8448e;
            long j12 = jArr2[1] ^ jRotateRight3;
            long j13 = jRotateRight4 ^ jArr[0];
            long jRotateRight5 = Long.rotateRight(jF ^ jArr2[0], 33);
            g(bytes, i11, jArr[1] * f8448e, j12 + jArr2[0], jArr);
            g(bytes, i11 + 32, jRotateRight5 + jArr2[1], j13, jArr2);
            i11 += 64;
            i12 -= 64;
            if (i12 == 0) {
                return c((f(j13) * f8448e) + c(jArr[0], jArr2[0]) + j12, c(jArr[1], jArr2[1]) + jRotateRight5);
            }
            jF = j12;
            jRotateRight2 = j13;
            jRotateRight = jRotateRight5;
        }
    }

    @b1.e
    public static long c(long high, long low) {
        long j10 = (low ^ high) * f8450g;
        long j11 = (high ^ (j10 ^ (j10 >>> 47))) * f8450g;
        return (j11 ^ (j11 >>> 47)) * f8450g;
    }

    private static long d(byte[] bytes, int offset, int length) {
        long jB = z.b(bytes, offset + 24);
        z.c cVar = z.f8467a;
        int i10 = length + offset;
        int i11 = i10 - 16;
        long longLittleEndian = ((cVar.getLongLittleEndian(bytes, i11) + ((long) length)) * f8447b) + cVar.getLongLittleEndian(bytes, offset);
        long jRotateRight = Long.rotateRight(longLittleEndian + jB, 52);
        long jRotateRight2 = Long.rotateRight(longLittleEndian, 37);
        long longLittleEndian2 = cVar.getLongLittleEndian(bytes, offset + 8) + longLittleEndian;
        long jRotateRight3 = Long.rotateRight(longLittleEndian2, 7) + jRotateRight2;
        int i12 = offset + 16;
        long longLittleEndian3 = longLittleEndian2 + cVar.getLongLittleEndian(bytes, i12);
        long j10 = jB + longLittleEndian3;
        long jRotateRight4 = Long.rotateRight(longLittleEndian3, 31) + jRotateRight + jRotateRight3;
        long longLittleEndian4 = cVar.getLongLittleEndian(bytes, i12) + cVar.getLongLittleEndian(bytes, i10 - 32);
        long longLittleEndian5 = cVar.getLongLittleEndian(bytes, i10 - 8);
        long jRotateRight5 = Long.rotateRight(longLittleEndian4 + longLittleEndian5, 52);
        long jRotateRight6 = Long.rotateRight(longLittleEndian4, 37);
        long longLittleEndian6 = cVar.getLongLittleEndian(bytes, i10 - 24) + longLittleEndian4;
        long jRotateRight7 = Long.rotateRight(longLittleEndian6, 7) + jRotateRight6;
        long longLittleEndian7 = cVar.getLongLittleEndian(bytes, i11) + longLittleEndian6;
        return f((f(((longLittleEndian5 + longLittleEndian7 + jRotateRight4) * f8447b) + ((Long.rotateRight(longLittleEndian7, 31) + jRotateRight5 + jRotateRight7 + j10) * f8449f)) * f8447b) + jRotateRight4) * f8449f;
    }

    @b1.e
    public static long e(byte[] bytes, int offset, int length, long seed) {
        int i10 = length & (-8);
        int i11 = length & 7;
        long jC = seed ^ (((long) length) * f8450g);
        for (int i12 = 0; i12 < i10; i12 += 8) {
            jC = (jC ^ (f(z.b(bytes, offset + i12) * f8450g) * f8450g)) * f8450g;
        }
        if (i11 != 0) {
            jC = (z.c(bytes, offset + i10, i11) ^ jC) * f8450g;
        }
        return f(f(jC) * f8450g);
    }

    private static long f(long val) {
        return val ^ (val >>> 47);
    }

    private static void g(byte[] bytes, int offset, long seedA, long seedB, long[] output) {
        long jB = z.b(bytes, offset);
        z.c cVar = z.f8467a;
        long longLittleEndian = cVar.getLongLittleEndian(bytes, offset + 8);
        long longLittleEndian2 = cVar.getLongLittleEndian(bytes, offset + 16);
        long longLittleEndian3 = cVar.getLongLittleEndian(bytes, offset + 24);
        long j10 = seedA + jB;
        long j11 = longLittleEndian + j10 + longLittleEndian2;
        long jRotateRight = Long.rotateRight(j11, 23) + Long.rotateRight(seedB + j10 + longLittleEndian3, 51);
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
        return "Hashing.fingerprint2011()";
    }
}
