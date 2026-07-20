package nq;

/* JADX INFO: loaded from: classes3.dex */
@g2
public interface e1 extends c1 {

    public static final class a {
        @os.m
        @lm.k(level = lm.m.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
        public static Object a(@os.l e1 e1Var, long j10, @os.l um.d<? super lm.l2> dVar) {
            Object objA = c1.a.a(e1Var, j10, dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : lm.l2.f10208a;
        }

        @os.l
        public static n1 b(@os.l e1 e1Var, long j10, @os.l Runnable runnable, @os.l um.g gVar) {
            return c1.a.b(e1Var, j10, runnable, gVar);
        }
    }

    @os.l
    String d(long j10);
}
