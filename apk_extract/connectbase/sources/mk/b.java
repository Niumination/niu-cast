package mk;

import fl.t0;
import java.util.List;
import lm.l2;
import nm.k0;
import nq.a1;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends e0 {

    public static final class a {
        @os.m
        public static Object a(@os.l b bVar, @os.l g gVar, @os.l um.d<? super l2> dVar) {
            Object objB = e0.a.b(bVar, gVar, dVar);
            return objB == wm.a.COROUTINE_SUSPENDED ? objB : l2.f10208a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void b(b bVar, List list, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
            }
            if ((i10 & 1) != 0) {
                list = k0.INSTANCE;
            }
            bVar.I1(list);
        }
    }

    void B1(long j10);

    @t0
    void I1(@os.l List<? extends w<?>> list);

    @os.l
    a1<mk.a> Q0();

    long b0();

    void c1(long j10);

    long j0();
}
