package kk;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f6985i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f6986j;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long[] f6987h;

    static {
        Unsafe unsafe = s.f6994a;
        if (8 != unsafe.arrayIndexScale(long[].class)) {
            throw new IllegalStateException("Unexpected long[] element size");
        }
        int i8 = a.f6981c;
        int i9 = i8 + 3;
        f6986j = i9;
        f6985i = unsafe.arrayBaseOffset(long[].class) + (32 << (i9 - i8));
    }

    public c(int i8) {
        super(i8);
        int i9 = (int) (this.f6983a + 1);
        this.f6987h = new long[(i9 << a.f6981c) + 64];
        for (long j8 = 0; j8 < i9; j8++) {
            j(this.f6987h, f6985i + ((this.f6983a & j8) << f6986j), j8);
        }
    }

    public static long i(long[] jArr, long j8) {
        return s.f6994a.getLongVolatile(jArr, j8);
    }

    public static void j(long[] jArr, long j8, long j10) {
        s.f6994a.putOrderedLong(jArr, j8, j10);
    }
}
