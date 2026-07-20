package yq;

import lm.c1;
import lm.d1;
import lm.l2;
import lm.z0;
import nq.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class p {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void c(nq.p<? super T> pVar, T t10) {
        n0 n0Var = (n0) pVar.getContext().get(n0.Key);
        if (n0Var != null) {
            pVar.G(n0Var, t10);
        } else {
            c1.a aVar = c1.Companion;
            pVar.resumeWith(c1.m59constructorimpl(t10));
        }
    }

    public static final void d(nq.p<?> pVar, Throwable th2) {
        n0 n0Var = (n0) pVar.getContext().get(n0.Key);
        if (n0Var != null) {
            pVar.l(n0Var, th2);
        } else {
            c1.a aVar = c1.Companion;
            pVar.resumeWith(c1.m59constructorimpl(d1.a(th2)));
        }
    }

    @os.m
    @z0
    public static final <R> Object e(@os.l jn.l<? super c<? super R>, l2> lVar, @os.l um.d<? super R> dVar) {
        d dVar2 = new d(dVar);
        try {
            lVar.invoke(dVar2);
        } catch (Throwable th2) {
            dVar2.Q(th2);
        }
        Object objP = dVar2.P();
        if (objP == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objP;
    }

    @z0
    public static final <R> Object f(jn.l<? super c<? super R>, l2> lVar, um.d<? super R> dVar) {
        d dVar2 = new d(dVar);
        try {
            lVar.invoke(dVar2);
        } catch (Throwable th2) {
            dVar2.Q(th2);
        }
        Object objP = dVar2.P();
        if (objP == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objP;
    }

    @os.m
    @z0
    public static final <R> Object g(@os.l jn.l<? super c<? super R>, l2> lVar, @os.l um.d<? super R> dVar) {
        s sVar = new s(dVar);
        try {
            lVar.invoke(sVar);
        } catch (Throwable th2) {
            sVar.R(th2);
        }
        Object objS = sVar.S();
        if (objS == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objS;
    }

    @z0
    public static final <R> Object h(jn.l<? super c<? super R>, l2> lVar, um.d<? super R> dVar) {
        s sVar = new s(dVar);
        try {
            lVar.invoke(sVar);
        } catch (Throwable th2) {
            sVar.R(th2);
        }
        Object objS = sVar.S();
        if (objS == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objS;
    }
}
