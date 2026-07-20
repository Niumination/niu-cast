package pq;

import lm.a1;
import nq.s0;

/* JADX INFO: loaded from: classes3.dex */
public interface d0<E> extends s0, g0<E> {

    public static final class a {
        @lm.k(level = lm.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @a1(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean a(@os.l d0<? super E> d0Var, E e10) {
            return g0.a.c(d0Var, e10);
        }
    }

    @os.l
    g0<E> a();
}
