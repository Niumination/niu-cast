package pl;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class y {
    @os.l
    public static final Throwable a(@os.l Throwable th2) {
        kn.l0.p(th2, "<this>");
        Throwable th3 = th2;
        while (th3 instanceof CancellationException) {
            if (kn.l0.g(th3, th3.getCause())) {
                return th2;
            }
            Throwable cause = th3.getCause();
            if (cause == null) {
                return th3;
            }
            th3 = cause;
        }
        return th3;
    }
}
