package f1;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class b0 {
    public static void a(Object key, Object value) {
        if (key == null) {
            throw new NullPointerException(c0.a.a("null key in entry: null=", value));
        }
        if (value != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + key + "=null");
    }

    @t1.a
    public static int b(int value, String name) {
        if (value >= 0) {
            return value;
        }
        throw new IllegalArgumentException(name + " cannot be negative but was: " + value);
    }

    @t1.a
    public static long c(long value, String name) {
        if (value >= 0) {
            return value;
        }
        throw new IllegalArgumentException(name + " cannot be negative but was: " + value);
    }

    public static void d(int value, String name) {
        if (value > 0) {
            return;
        }
        throw new IllegalArgumentException(name + " must be positive but was: " + value);
    }

    public static void e(boolean canRemove) {
        c1.h0.h0(canRemove, "no calls to next() since the last call to remove()");
    }
}
