package pq;

import lm.a1;
import nq.c3;
import nq.s0;

/* JADX INFO: loaded from: classes3.dex */
@c3
public interface c<E> extends s0, f0<E> {

    public static final class a {
        @os.l
        public static <E> yq.g<E> b(@os.l c<E> cVar) {
            return f0.a.d(cVar);
        }

        @os.m
        @lm.k(level = lm.m.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @a1(expression = "tryReceive().getOrNull()", imports = {}))
        public static <E> E c(@os.l c<E> cVar) {
            return (E) f0.a.h(cVar);
        }

        @an.h
        @os.m
        @lm.k(level = lm.m.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @a1(expression = "receiveCatching().getOrNull()", imports = {}))
        public static <E> Object d(@os.l c<E> cVar, @os.l um.d<? super E> dVar) {
            return f0.a.i(cVar, dVar);
        }
    }

    @os.l
    l<E> a();
}
