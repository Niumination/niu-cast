package nq;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 {
    @os.l
    public static final s0 a(@os.l um.g gVar) {
        if (gVar.get(l2.f11882k) == null) {
            gVar = gVar.plus(r2.c(null, 1, null));
        }
        return new vq.h(gVar);
    }

    @os.l
    public static final s0 b() {
        return new vq.h(m3.c(null, 1, null).plus(k1.e()));
    }

    public static final void c(@os.l s0 s0Var, @os.l String str, @os.m Throwable th2) {
        d(s0Var, w1.a(str, th2));
    }

    public static final void d(@os.l s0 s0Var, @os.m CancellationException cancellationException) {
        l2 l2Var = (l2) s0Var.getCoroutineContext().get(l2.f11882k);
        if (l2Var != null) {
            l2Var.b(cancellationException);
        } else {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + s0Var).toString());
        }
    }

    public static /* synthetic */ void e(s0 s0Var, String str, Throwable th2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            th2 = null;
        }
        c(s0Var, str, th2);
    }

    public static /* synthetic */ void f(s0 s0Var, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        d(s0Var, cancellationException);
    }

    @os.m
    public static final <R> Object g(@os.l jn.p<? super s0, ? super um.d<? super R>, ? extends Object> pVar, @os.l um.d<? super R> dVar) {
        vq.q0 q0Var = new vq.q0(dVar.getContext(), dVar);
        Object objE = wq.b.e(q0Var, q0Var, pVar);
        if (objE == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objE;
    }

    @os.m
    public static final Object h(@os.l um.d<? super um.g> dVar) {
        return dVar.getContext();
    }

    public static final Object i(um.d<? super um.g> dVar) {
        throw null;
    }

    public static final void j(@os.l s0 s0Var) {
        r2.y(s0Var.getCoroutineContext());
    }

    public static final boolean k(@os.l s0 s0Var) {
        l2 l2Var = (l2) s0Var.getCoroutineContext().get(l2.f11882k);
        if (l2Var != null) {
            return l2Var.isActive();
        }
        return true;
    }

    public static /* synthetic */ void l(s0 s0Var) {
    }

    @os.l
    public static final s0 m(@os.l s0 s0Var, @os.l um.g gVar) {
        return new vq.h(s0Var.getCoroutineContext().plus(gVar));
    }
}
