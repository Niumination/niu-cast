package mk;

import java.util.List;
import lm.a1;
import lm.l2;
import nq.s0;

/* JADX INFO: loaded from: classes2.dex */
public interface e0 extends s0 {

    public static final class a {
        @f
        public static /* synthetic */ void a() {
        }

        @os.m
        public static Object b(@os.l e0 e0Var, @os.l g gVar, @os.l um.d<? super l2> dVar) {
            Object objL = e0Var.h().L(gVar, dVar);
            return objL == wm.a.COROUTINE_SUSPENDED ? objL : l2.f10208a;
        }
    }

    long F0();

    void T0(boolean z10);

    @os.m
    Object U0(@os.l g gVar, @os.l um.d<? super l2> dVar);

    boolean b2();

    @os.l
    pq.f0<g> d();

    @os.l
    List<w<?>> f0();

    @os.l
    pq.g0<g> h();

    @os.m
    Object p0(@os.l um.d<? super l2> dVar);

    @lm.k(message = "Use cancel() instead.", replaceWith = @a1(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    void q();

    void w0(long j10);
}
