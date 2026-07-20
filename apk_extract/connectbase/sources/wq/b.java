package wq;

import jn.p;
import kn.l0;
import kn.r1;
import kn.u1;
import lm.c1;
import nq.d0;
import nq.u2;
import nq.v3;
import os.l;
import os.m;
import um.d;
import um.g;
import vq.a1;
import vq.q0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nUndispatched.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Undispatched.kt\nkotlinx/coroutines/intrinsics/UndispatchedKt\n+ 2 ProbesSupport.kt\nkotlinx/coroutines/internal/ProbesSupportKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 4 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,127:1\n55#1:128\n56#1,11:130\n55#1:141\n56#1,2:143\n58#1,9:150\n55#1:159\n56#1,2:161\n58#1,9:168\n97#1,4:178\n114#1,6:182\n120#1,5:190\n97#1,4:195\n114#1,6:199\n120#1,5:207\n11#2:129\n11#2:142\n11#2:160\n11#2:177\n95#3,5:145\n95#3,5:163\n61#4,2:188\n61#4,2:205\n61#4,2:212\n61#4,2:214\n*S KotlinDebug\n*F\n+ 1 Undispatched.kt\nkotlinx/coroutines/intrinsics/UndispatchedKt\n*L\n18#1:128\n18#1:130,11\n29#1:141\n29#1:143,2\n29#1:150,9\n42#1:159\n42#1:161,2\n42#1:168,9\n77#1:178,4\n77#1:182,6\n77#1:190,5\n88#1:195,4\n88#1:199,6\n88#1:207,5\n18#1:129\n29#1:142\n42#1:160\n55#1:177\n30#1:145,5\n43#1:163,5\n77#1:188,2\n88#1:205,2\n119#1:212,2\n120#1:214,2\n*E\n"})
public final class b {
    public static final <T> void a(@l jn.l<? super d<? super T>, ? extends Object> lVar, @l d<? super T> dVar) {
        l0.p(dVar, "completion");
        try {
            g context = dVar.getContext();
            Object objC = a1.c(context, null);
            try {
                Object objInvoke = ((jn.l) u1.q(lVar, 1)).invoke(dVar);
                a1.a(context, objC);
                if (objInvoke != wm.a.COROUTINE_SUSPENDED) {
                    c1.a aVar = c1.Companion;
                    dVar.resumeWith(c1.m59constructorimpl(objInvoke));
                }
            } catch (Throwable th2) {
                a1.a(context, objC);
                throw th2;
            }
        } catch (Throwable th3) {
            c1.a aVar2 = c1.Companion;
            w.a.a(th3, dVar);
        }
    }

    public static final <R, T> void b(@l p<? super R, ? super d<? super T>, ? extends Object> pVar, R r10, @l d<? super T> dVar) {
        l0.p(dVar, "completion");
        try {
            g context = dVar.getContext();
            Object objC = a1.c(context, null);
            try {
                Object objInvoke = ((p) u1.q(pVar, 2)).invoke(r10, dVar);
                a1.a(context, objC);
                if (objInvoke != wm.a.COROUTINE_SUSPENDED) {
                    c1.a aVar = c1.Companion;
                    dVar.resumeWith(c1.m59constructorimpl(objInvoke));
                }
            } catch (Throwable th2) {
                a1.a(context, objC);
                throw th2;
            }
        } catch (Throwable th3) {
            c1.a aVar2 = c1.Companion;
            w.a.a(th3, dVar);
        }
    }

    public static final <T> void c(@l jn.l<? super d<? super T>, ? extends Object> lVar, @l d<? super T> dVar) {
        l0.p(dVar, "completion");
        try {
            Object objInvoke = ((jn.l) u1.q(lVar, 1)).invoke(dVar);
            if (objInvoke != wm.a.COROUTINE_SUSPENDED) {
                c1.a aVar = c1.Companion;
                dVar.resumeWith(c1.m59constructorimpl(objInvoke));
            }
        } catch (Throwable th2) {
            c1.a aVar2 = c1.Companion;
            w.a.a(th2, dVar);
        }
    }

    public static final <T> void d(d<? super T> dVar, jn.l<? super d<? super T>, ? extends Object> lVar) {
        l0.p(dVar, "completion");
        try {
            Object objInvoke = lVar.invoke(dVar);
            if (objInvoke != wm.a.COROUTINE_SUSPENDED) {
                c1.a aVar = c1.Companion;
                dVar.resumeWith(c1.m59constructorimpl(objInvoke));
            }
        } catch (Throwable th2) {
            c1.a aVar2 = c1.Companion;
            w.a.a(th2, dVar);
        }
    }

    @m
    public static final <T, R> Object e(@l q0<? super T> q0Var, R r10, @l p<? super R, ? super d<? super T>, ? extends Object> pVar) {
        Object d0Var;
        Object objJ1;
        try {
            d0Var = ((p) u1.q(pVar, 2)).invoke(r10, q0Var);
        } catch (Throwable th2) {
            d0Var = new d0(th2, false, 2, null);
        }
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        if (d0Var == aVar || (objJ1 = q0Var.j1(d0Var)) == u2.f11950b) {
            return aVar;
        }
        if (objJ1 instanceof d0) {
            throw ((d0) objJ1).f11836a;
        }
        return u2.h(objJ1);
    }

    @m
    public static final <T, R> Object f(@l q0<? super T> q0Var, R r10, @l p<? super R, ? super d<? super T>, ? extends Object> pVar) throws Throwable {
        Object d0Var;
        Object objJ1;
        try {
            d0Var = ((p) u1.q(pVar, 2)).invoke(r10, q0Var);
        } catch (Throwable th2) {
            d0Var = new d0(th2, false, 2, null);
        }
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        if (d0Var == aVar || (objJ1 = q0Var.j1(d0Var)) == u2.f11950b) {
            return aVar;
        }
        if (objJ1 instanceof d0) {
            Throwable th3 = ((d0) objJ1).f11836a;
            if (!(th3 instanceof v3) || ((v3) th3).coroutine != q0Var) {
                throw th3;
            }
            if (d0Var instanceof d0) {
                throw ((d0) d0Var).f11836a;
            }
        } else {
            d0Var = u2.h(objJ1);
        }
        return d0Var;
    }

    public static final <T> Object g(q0<? super T> q0Var, jn.l<? super Throwable, Boolean> lVar, jn.a<? extends Object> aVar) throws Throwable {
        Object d0Var;
        Object objJ1;
        try {
            d0Var = aVar.invoke();
        } catch (Throwable th2) {
            d0Var = new d0(th2, false, 2, null);
        }
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        if (d0Var == aVar2 || (objJ1 = q0Var.j1(d0Var)) == u2.f11950b) {
            return aVar2;
        }
        if (!(objJ1 instanceof d0)) {
            return u2.h(objJ1);
        }
        d0 d0Var2 = (d0) objJ1;
        if (lVar.invoke(d0Var2.f11836a).booleanValue()) {
            throw d0Var2.f11836a;
        }
        if (d0Var instanceof d0) {
            throw ((d0) d0Var).f11836a;
        }
        return d0Var;
    }
}
