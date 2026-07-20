package vq;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class z0 {
    public static final int a(@os.l String str, int i10, int i11, int i12) {
        return (int) b(str, i10, i11, i12);
    }

    public static final long b(@os.l String str, long j10, long j11, long j12) {
        String strB = y0.b(str);
        if (strB == null) {
            return j10;
        }
        Long lZ0 = jq.d0.Z0(strB);
        if (lZ0 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strB + '\'').toString());
        }
        long jLongValue = lZ0.longValue();
        if (j11 <= jLongValue && jLongValue <= j12) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j11 + ".." + j12 + ", but is '" + jLongValue + '\'').toString());
    }

    @os.l
    public static final String c(@os.l String str, @os.l String str2) {
        String strB = y0.b(str);
        return strB == null ? str2 : strB;
    }

    public static final boolean d(@os.l String str, boolean z10) {
        String strB = y0.b(str);
        return strB != null ? Boolean.parseBoolean(strB) : z10;
    }

    public static int e(String str, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 1;
        }
        if ((i13 & 8) != 0) {
            i12 = Integer.MAX_VALUE;
        }
        return a(str, i10, i11, i12);
    }

    public static long f(String str, long j10, long j11, long j12, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j11 = 1;
        }
        long j13 = j11;
        if ((i10 & 8) != 0) {
            j12 = Long.MAX_VALUE;
        }
        return b(str, j10, j13, j12);
    }
}
