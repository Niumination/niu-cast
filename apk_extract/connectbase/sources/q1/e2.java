package q1;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@o0
public final class e2 {
    public static boolean a(@gm.a Throwable t10, Class<? extends Throwable> expectedClass) {
        return expectedClass.isInstance(t10);
    }

    public static void b(Throwable t10) {
        t10.getClass();
        if (t10 instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
    }
}
