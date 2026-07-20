package c1;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public abstract class h {
    public static h compile(String pattern) {
        return g0.a(pattern);
    }

    public static boolean isPcreLike() {
        return g0.h();
    }

    public abstract int flags();

    public abstract g matcher(CharSequence t10);

    public abstract String pattern();

    public abstract String toString();
}
