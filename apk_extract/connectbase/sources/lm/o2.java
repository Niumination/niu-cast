package lm;

/* JADX INFO: loaded from: classes3.dex */
@in.i(name = "UnsignedKt")
public final class o2 {
    @z0
    public static final int a(double d10) {
        if (Double.isNaN(d10) || d10 <= f(0)) {
            return 0;
        }
        if (d10 >= f(-1)) {
            return -1;
        }
        return d10 <= 2.147483647E9d ? w1.m((int) d10) : w1.m((int) (d10 - ((double) Integer.MAX_VALUE))) + Integer.MAX_VALUE;
    }

    @z0
    public static final long b(double d10) {
        if (Double.isNaN(d10) || d10 <= j(0L)) {
            return 0L;
        }
        if (d10 >= j(-1L)) {
            return -1L;
        }
        return d10 < 9.223372036854776E18d ? a2.m((long) d10) : a2.m((long) (d10 - 9.223372036854776E18d)) - Long.MIN_VALUE;
    }

    @z0
    public static final int c(int i10, int i11) {
        return kn.l0.t(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE);
    }

    @z0
    public static final int d(int i10, int i11) {
        return w1.m((int) ((((long) i10) & 4294967295L) / (((long) i11) & 4294967295L)));
    }

    @z0
    public static final int e(int i10, int i11) {
        return w1.m((int) ((((long) i10) & 4294967295L) % (((long) i11) & 4294967295L)));
    }

    @z0
    public static final double f(int i10) {
        return (((double) ((i10 >>> 31) << 30)) * ((double) 2)) + ((double) (Integer.MAX_VALUE & i10));
    }

    @z0
    public static final int g(long j10, long j11) {
        return kn.l0.u(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
    }

    @z0
    public static final long h(long j10, long j11) {
        if (j11 < 0) {
            return Long.compareUnsigned(j10, j11) < 0 ? a2.m(0L) : a2.m(1L);
        }
        if (j10 >= 0) {
            return a2.m(j10 / j11);
        }
        long j12 = ((j10 >>> 1) / j11) << 1;
        return j12 + ((long) (Long.compareUnsigned(a2.m(j10 - (j12 * j11)), j11) < 0 ? 0 : 1));
    }

    @z0
    public static final long i(long j10, long j11) {
        if (j11 < 0) {
            return Long.compareUnsigned(j10, j11) < 0 ? j10 : a2.m(j10 - j11);
        }
        if (j10 >= 0) {
            return a2.m(j10 % j11);
        }
        long j12 = j10 - ((((j10 >>> 1) / j11) << 1) * j11);
        if (Long.compareUnsigned(a2.m(j12), j11) < 0) {
            j11 = 0;
        }
        return j12 - j11;
    }

    @z0
    public static final double j(long j10) {
        return ((j10 >>> 11) * ((double) 2048)) + (j10 & 2047);
    }

    @os.l
    public static final String k(long j10) {
        return l(j10, 10);
    }

    @os.l
    public static final String l(long j10, int i10) {
        if (j10 >= 0) {
            String string = Long.toString(j10, jq.d.a(i10));
            kn.l0.o(string, "toString(...)");
            return string;
        }
        long j11 = i10;
        long j12 = ((j10 >>> 1) / j11) << 1;
        long j13 = j10 - (j12 * j11);
        if (j13 >= j11) {
            j13 -= j11;
            j12++;
        }
        StringBuilder sb2 = new StringBuilder();
        String string2 = Long.toString(j12, jq.d.a(i10));
        kn.l0.o(string2, "toString(...)");
        sb2.append(string2);
        String string3 = Long.toString(j13, jq.d.a(i10));
        kn.l0.o(string3, "toString(...)");
        sb2.append(string3);
        return sb2.toString();
    }
}
