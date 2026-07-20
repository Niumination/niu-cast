package pq;

import lm.a1;
import lm.l2;
import nq.f1;
import vq.t0;

/* JADX INFO: loaded from: classes3.dex */
public interface g0<E> {

    public static final class a {
        public static /* synthetic */ boolean a(g0 g0Var, Throwable th2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i10 & 1) != 0) {
                th2 = null;
            }
            return g0Var.f(th2);
        }

        @f1
        public static /* synthetic */ void b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @lm.k(level = lm.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @a1(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean c(@os.l g0<? super E> g0Var, E e10) throws Throwable {
            Object objW = g0Var.w(e10);
            if (p.m(objW)) {
                return true;
            }
            Throwable thF = p.f(objW);
            if (thF == null) {
                return false;
            }
            throw t0.o(thF);
        }
    }

    boolean J();

    @os.m
    Object L(E e10, @os.l um.d<? super l2> dVar);

    boolean f(@os.m Throwable th2);

    void i(@os.l jn.l<? super Throwable, l2> lVar);

    @os.l
    yq.i<E, g0<E>> m();

    @lm.k(level = lm.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @a1(expression = "trySend(element).isSuccess", imports = {}))
    boolean offer(E e10);

    @os.l
    Object w(E e10);
}
