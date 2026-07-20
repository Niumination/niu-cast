package yq;

import lm.a1;
import nq.a2;

/* JADX INFO: loaded from: classes3.dex */
public interface c<R> {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static <R, P, Q> void a(@os.l c<? super R> cVar, @os.l i<? super P, ? extends Q> iVar, @os.l jn.p<? super Q, ? super um.d<? super R>, ? extends Object> pVar) {
            cVar.a(iVar, null, pVar);
        }

        @an.h
        @lm.k(level = lm.m.ERROR, message = "Replaced with the same extension function", replaceWith = @a1(expression = "onTimeout", imports = {"kotlinx.coroutines.selects.onTimeout"}))
        @a2
        public static <R> void b(@os.l c<? super R> cVar, long j10, @os.l jn.l<? super um.d<? super R>, ? extends Object> lVar) {
            b.a(cVar, j10, lVar);
        }
    }

    <P, Q> void a(@os.l i<? super P, ? extends Q> iVar, P p10, @os.l jn.p<? super Q, ? super um.d<? super R>, ? extends Object> pVar);

    void b(@os.l e eVar, @os.l jn.l<? super um.d<? super R>, ? extends Object> lVar);

    <P, Q> void c(@os.l i<? super P, ? extends Q> iVar, @os.l jn.p<? super Q, ? super um.d<? super R>, ? extends Object> pVar);

    <Q> void e(@os.l g<? extends Q> gVar, @os.l jn.p<? super Q, ? super um.d<? super R>, ? extends Object> pVar);

    @an.h
    @lm.k(level = lm.m.ERROR, message = "Replaced with the same extension function", replaceWith = @a1(expression = "onTimeout", imports = {"kotlinx.coroutines.selects.onTimeout"}))
    @a2
    void h(long j10, @os.l jn.l<? super um.d<? super R>, ? extends Object> lVar);
}
