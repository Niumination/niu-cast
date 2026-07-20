package k3;

/* JADX INFO: loaded from: classes.dex */
public abstract class cb {
    public static int a(int i8, int i9) {
        if (i9 <= 1073741823) {
            return Math.min(Math.max(i8, i9), 1073741823);
        }
        throw new IllegalArgumentException(w8.a("min (%s) must be less than or equal to max (%s)", Integer.valueOf(i9), 1073741823));
    }

    public static int b(long j8) {
        if (j8 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j8 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j8;
    }
}
