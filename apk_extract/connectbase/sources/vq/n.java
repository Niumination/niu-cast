package vq;

import java.util.concurrent.CancellationException;
import kn.r1;
import lm.l2;
import nq.g2;
import nq.p3;
import nq.z3;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 2 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,317:1\n297#1,5:325\n302#1,12:331\n314#1:387\n301#1:389\n302#1,12:391\n314#1:420\n217#2,7:318\n224#2:346\n243#2,8:347\n225#2:355\n255#2:356\n256#2,2:367\n258#2:371\n227#2:372\n229#2:388\n1#3:330\n1#3:390\n1#3:421\n200#4,3:343\n203#4,14:373\n200#4,17:403\n200#4,17:422\n107#5,10:357\n118#5,2:369\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n*L\n282#1:325,5\n282#1:331,12\n282#1:387\n287#1:389\n287#1:391,12\n287#1:420\n282#1:318,7\n282#1:346\n282#1:347,8\n282#1:355\n282#1:356\n282#1:367,2\n282#1:371\n282#1:372\n282#1:388\n282#1:330\n287#1:390\n282#1:343,3\n282#1:373,14\n287#1:403,17\n313#1:422,17\n282#1:357,10\n282#1:369,2\n*E\n"})
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final u0 f17867a = new u0("UNDEFINED");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @in.f
    @os.l
    public static final u0 f17868b = new u0("REUSABLE_CLAIMED");

    public static final boolean b(m<?> mVar, Object obj, int i10, boolean z10, jn.a<l2> aVar) {
        nq.r1 r1VarB = p3.f11893a.b();
        if (z10 && r1VarB.U0()) {
            return false;
        }
        if (r1VarB.T0()) {
            mVar.f17865f = obj;
            mVar.f11857c = i10;
            r1VarB.v0(mVar);
            return true;
        }
        r1VarB.F0(true);
        try {
            aVar.invoke();
            do {
            } while (r1VarB.B1());
        } catch (Throwable th2) {
            try {
                mVar.k(th2, null);
            } finally {
                r1VarB.f0(true);
            }
        }
        return false;
    }

    public static boolean c(m mVar, Object obj, int i10, boolean z10, jn.a aVar, int i11, Object obj2) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        nq.r1 r1VarB = p3.f11893a.b();
        if (z10 && r1VarB.U0()) {
            return false;
        }
        if (r1VarB.T0()) {
            mVar.f17865f = obj;
            mVar.f11857c = i10;
            r1VarB.v0(mVar);
            return true;
        }
        r1VarB.F0(true);
        try {
            aVar.invoke();
            do {
            } while (r1VarB.B1());
        } catch (Throwable th2) {
            try {
                mVar.k(th2, null);
            } finally {
                r1VarB.f0(true);
            }
        }
        return false;
    }

    @g2
    public static final <T> void d(@os.l um.d<? super T> dVar, @os.l Object obj, @os.m jn.l<? super Throwable, l2> lVar) {
        if (!(dVar instanceof m)) {
            dVar.resumeWith(obj);
            return;
        }
        m mVar = (m) dVar;
        Object objB = nq.j0.b(obj, lVar);
        if (mVar.f17863d.isDispatchNeeded(mVar.f17864e.getContext())) {
            mVar.f17865f = objB;
            mVar.f11857c = 1;
            mVar.f17863d.dispatch(mVar.f17864e.getContext(), mVar);
            return;
        }
        nq.r1 r1VarB = p3.f11893a.b();
        if (r1VarB.T0()) {
            mVar.f17865f = objB;
            mVar.f11857c = 1;
            r1VarB.v0(mVar);
            return;
        }
        r1VarB.F0(true);
        try {
            nq.l2 l2Var = (nq.l2) mVar.f17864e.getContext().get(nq.l2.f11882k);
            if (l2Var == null || l2Var.isActive()) {
                um.d<T> dVar2 = mVar.f17864e;
                Object obj2 = mVar.f17866g;
                um.g context = dVar2.getContext();
                Object objC = a1.c(context, obj2);
                z3<?> z3VarG = objC != a1.f17796a ? nq.m0.g(dVar2, context, objC) : null;
                try {
                    mVar.f17864e.resumeWith(obj);
                    l2 l2Var2 = l2.f10208a;
                    if (z3VarG == null || z3VarG.V1()) {
                        a1.a(context, objC);
                    }
                } catch (Throwable th2) {
                    if (z3VarG == null || z3VarG.V1()) {
                        a1.a(context, objC);
                    }
                    throw th2;
                }
            } else {
                CancellationException cancellationExceptionO = l2Var.O();
                mVar.b(objB, cancellationExceptionO);
                lm.c1.a aVar = lm.c1.Companion;
                mVar.resumeWith(lm.c1.m59constructorimpl(lm.d1.a(cancellationExceptionO)));
            }
            while (r1VarB.B1()) {
            }
        } catch (Throwable th3) {
            try {
                mVar.k(th3, null);
            } finally {
                r1VarB.f0(true);
            }
        }
    }

    public static /* synthetic */ void e(um.d dVar, Object obj, jn.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        d(dVar, obj, lVar);
    }

    public static final boolean f(@os.l m<? super l2> mVar) {
        l2 l2Var = l2.f10208a;
        nq.r1 r1VarB = p3.f11893a.b();
        if (r1VarB.U0()) {
            return false;
        }
        if (r1VarB.T0()) {
            mVar.f17865f = l2Var;
            mVar.f11857c = 1;
            r1VarB.v0(mVar);
            return true;
        }
        r1VarB.F0(true);
        try {
            mVar.run();
            do {
            } while (r1VarB.B1());
        } catch (Throwable th2) {
            try {
                mVar.k(th2, null);
            } finally {
                r1VarB.f0(true);
            }
        }
        return false;
    }
}
