package x4;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private e() {
        throw new UnsupportedOperationException();
    }

    public static void checkArgument(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    @Deprecated
    public static <T> T checkNotNull(T t3) {
        t3.getClass();
        return t3;
    }
}
