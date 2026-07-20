package li;

import kotlin.ExceptionsKt;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d0 {
    public static final void a(CoroutineContext coroutineContext, Throwable th2) {
        try {
            c0 c0Var = (c0) coroutineContext.get(b0.f7433a);
            if (c0Var != null) {
                c0Var.L(coroutineContext, th2);
            } else {
                qi.g.e(coroutineContext, th2);
            }
        } catch (Throwable th3) {
            if (th2 != th3) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th3);
                ExceptionsKt.addSuppressed(runtimeException, th2);
                th2 = runtimeException;
            }
            qi.g.e(coroutineContext, th2);
        }
    }
}
