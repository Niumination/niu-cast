package ni;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import li.l0;
import li.o1;
import li.p1;

/* JADX INFO: loaded from: classes3.dex */
public class a extends r implements b {
    public a(CoroutineContext coroutineContext, m mVar, boolean z2) {
        super(coroutineContext, mVar, false, z2);
        Y((p1) coroutineContext.get(o1.f7483a));
    }

    @Override // li.x1
    public final boolean U(Throwable th2) {
        li.d0.a(this.f7429c, th2);
        return true;
    }

    @Override // li.x1
    public final void j0(Throwable th2) {
        CancellationException cancellationExceptionA = null;
        if (th2 != null) {
            cancellationExceptionA = th2 instanceof CancellationException ? (CancellationException) th2 : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = l0.a(getClass().getSimpleName().concat(" was cancelled"), th2);
            }
        }
        this.f8323d.h(cancellationExceptionA);
    }
}
