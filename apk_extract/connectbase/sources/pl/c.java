package pl;

import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public interface c extends k, n {

    public static final class a {
        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static Object a(c cVar, jn.p pVar, um.d dVar) {
            Object objA = k.b.a(cVar, pVar, dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    void j(@os.l nq.l2 l2Var);
}
