package sk;

import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public interface r extends q, v {

    public static final class a {
        @os.m
        public static Object a(@os.l r rVar, @os.l um.d<? super o> dVar) {
            return q.a.a(rVar, dVar);
        }

        @os.m
        public static Object b(@os.l r rVar, @os.l o oVar, @os.l um.d<? super l2> dVar) {
            Object objA = v.a.a(rVar, oVar, dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }
}
