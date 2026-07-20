package fl;

/* JADX INFO: loaded from: classes2.dex */
public final class u1 {
    @os.m
    public static final Throwable a(@os.l Throwable th2) {
        kn.l0.p(th2, "<this>");
        while (true) {
            if ((th2 == null ? null : th2.getCause()) == null) {
                return th2;
            }
            th2 = th2.getCause();
        }
    }

    @t0
    public static /* synthetic */ void b(Throwable th2) {
    }
}
