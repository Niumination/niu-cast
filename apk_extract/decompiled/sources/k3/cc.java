package k3;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public abstract class cc {
    public static final void a(ni.f0 f0Var, Throwable th2) {
        CancellationException cancellationExceptionA = th2 instanceof CancellationException ? (CancellationException) th2 : null;
        if (cancellationExceptionA == null) {
            cancellationExceptionA = li.l0.a("Channel was consumed, consumer had failed", th2);
        }
        f0Var.h(cancellationExceptionA);
    }
}
