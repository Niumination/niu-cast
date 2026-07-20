package x1;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private a() {
        throw new UnsupportedOperationException();
    }

    public static void checkArgument(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    @Deprecated
    public static <T> T checkNotNull(T t10) {
        t10.getClass();
        return t10;
    }
}
