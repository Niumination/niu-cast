package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class m3 {
    @os.l
    public static final b0 a(@os.m l2 l2Var) {
        return new l3(l2Var);
    }

    @in.i(name = "SupervisorJob")
    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final l2 b(l2 l2Var) {
        return new l3(l2Var);
    }

    public static b0 c(l2 l2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l2Var = null;
        }
        return new l3(l2Var);
    }

    public static l2 d(l2 l2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l2Var = null;
        }
        return new l3(l2Var);
    }

    @os.m
    public static final <R> Object e(@os.l jn.p<? super s0, ? super um.d<? super R>, ? extends Object> pVar, @os.l um.d<? super R> dVar) {
        k3 k3Var = new k3(dVar.getContext(), dVar);
        Object objE = wq.b.e(k3Var, k3Var, pVar);
        if (objE == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objE;
    }
}
