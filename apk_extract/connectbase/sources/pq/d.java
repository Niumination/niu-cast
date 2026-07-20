package pq;

import java.util.concurrent.CancellationException;
import lm.a1;
import nq.c3;

/* JADX INFO: loaded from: classes3.dex */
@lm.k(level = lm.m.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
@c3
public interface d<E> extends g0<E> {

    public static final class a {
        public static /* synthetic */ void a(d dVar, CancellationException cancellationException, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                cancellationException = null;
            }
            dVar.b(cancellationException);
        }

        public static /* synthetic */ boolean b(d dVar, Throwable th2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                th2 = null;
            }
            return dVar.c(th2);
        }

        @lm.k(level = lm.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @a1(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean c(@os.l d<E> dVar, E e10) {
            return g0.a.c(dVar, e10);
        }
    }

    void b(@os.m CancellationException cancellationException);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility only")
    /* synthetic */ boolean c(Throwable th2);

    @os.l
    f0<E> v();
}
