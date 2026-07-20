package sk;

import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public interface v {

    public static final class a {
        @os.m
        public static Object a(@os.l v vVar, @os.l o oVar, @os.l um.d<? super l2> dVar) {
            Object objL = vVar.h().L(oVar, dVar);
            return objL == wm.a.COROUTINE_SUSPENDED ? objL : l2.f10208a;
        }
    }

    @os.m
    Object c(@os.l o oVar, @os.l um.d<? super l2> dVar);

    @os.l
    pq.g0<o> h();
}
