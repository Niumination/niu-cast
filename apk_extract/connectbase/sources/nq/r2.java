package nq;

import java.util.Iterator;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nJob.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n+ 2 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,685:1\n13#2:686\n1295#3,2:687\n1295#3,2:689\n1295#3,2:691\n1295#3,2:693\n*S KotlinDebug\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n*L\n494#1:686\n521#1:687,2\n535#1:689,2\n629#1:691,2\n653#1:693,2\n*E\n"})
public final /* synthetic */ class r2 {
    public static final boolean A(@os.l um.g gVar) {
        l2 l2Var = (l2) gVar.get(l2.f11882k);
        if (l2Var != null) {
            return l2Var.isActive();
        }
        return true;
    }

    public static final Throwable B(Throwable th2, l2 l2Var) {
        return th2 == null ? new m2("Job was cancelled", null, l2Var) : th2;
    }

    @os.l
    public static final b0 a(@os.m l2 l2Var) {
        return new o2(l2Var);
    }

    @in.i(name = "Job")
    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final l2 b(l2 l2Var) {
        return new o2(l2Var);
    }

    public static b0 c(l2 l2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l2Var = null;
        }
        return new o2(l2Var);
    }

    public static l2 d(l2 l2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l2Var = null;
        }
        return new o2(l2Var);
    }

    public static final void e(@os.l l2 l2Var, @os.l String str, @os.m Throwable th2) {
        l2Var.b(w1.a(str, th2));
    }

    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void f(um.g gVar) {
        g(gVar, null);
    }

    public static final void g(@os.l um.g gVar, @os.m CancellationException cancellationException) {
        l2 l2Var = (l2) gVar.get(l2.f11882k);
        if (l2Var != null) {
            l2Var.b(cancellationException);
        }
    }

    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean h(um.g gVar, Throwable th2) throws Throwable {
        um.g.b bVar = gVar.get(l2.f11882k);
        t2 t2Var = bVar instanceof t2 ? (t2) bVar : null;
        if (t2Var == null) {
            return false;
        }
        t2Var.d0(B(th2, t2Var));
        return true;
    }

    public static void i(l2 l2Var, String str, Throwable th2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            th2 = null;
        }
        e(l2Var, str, th2);
    }

    public static void j(um.g gVar, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        g(gVar, cancellationException);
    }

    public static /* synthetic */ boolean k(um.g gVar, Throwable th2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            th2 = null;
        }
        return h(gVar, th2);
    }

    @os.m
    public static final Object l(@os.l l2 l2Var, @os.l um.d<? super lm.l2> dVar) {
        l2.a.b(l2Var, null, 1, null);
        Object objT = l2Var.t(dVar);
        return objT == wm.a.COROUTINE_SUSPENDED ? objT : lm.l2.f10208a;
    }

    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void m(l2 l2Var) {
        o(l2Var, null);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void n(l2 l2Var, Throwable th2) throws Throwable {
        for (l2 l2Var2 : l2Var.y()) {
            t2 t2Var = l2Var2 instanceof t2 ? (t2) l2Var2 : null;
            if (t2Var != null) {
                t2Var.d0(B(th2, l2Var));
            }
        }
    }

    public static final void o(@os.l l2 l2Var, @os.m CancellationException cancellationException) {
        Iterator<l2> it = l2Var.y().iterator();
        while (it.hasNext()) {
            it.next().b(cancellationException);
        }
    }

    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void p(um.g gVar) {
        r(gVar, null);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void q(um.g gVar, Throwable th2) throws Throwable {
        l2 l2Var = (l2) gVar.get(l2.f11882k);
        if (l2Var == null) {
            return;
        }
        for (l2 l2Var2 : l2Var.y()) {
            t2 t2Var = l2Var2 instanceof t2 ? (t2) l2Var2 : null;
            if (t2Var != null) {
                t2Var.d0(B(th2, l2Var));
            }
        }
    }

    public static final void r(@os.l um.g gVar, @os.m CancellationException cancellationException) {
        gq.m<l2> mVarY;
        l2 l2Var = (l2) gVar.get(l2.f11882k);
        if (l2Var == null || (mVarY = l2Var.y()) == null) {
            return;
        }
        Iterator<l2> it = mVarY.iterator();
        while (it.hasNext()) {
            it.next().b(cancellationException);
        }
    }

    public static /* synthetic */ void s(l2 l2Var, Throwable th2, int i10, Object obj) throws Throwable {
        if ((i10 & 1) != 0) {
            th2 = null;
        }
        n(l2Var, th2);
    }

    public static void t(l2 l2Var, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        o(l2Var, cancellationException);
    }

    public static /* synthetic */ void u(um.g gVar, Throwable th2, int i10, Object obj) throws Throwable {
        if ((i10 & 1) != 0) {
            th2 = null;
        }
        q(gVar, th2);
    }

    public static void v(um.g gVar, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        r(gVar, cancellationException);
    }

    @os.l
    public static final n1 w(@os.l l2 l2Var, @os.l n1 n1Var) {
        return l2Var.k0(new p1(n1Var));
    }

    public static final void x(@os.l l2 l2Var) {
        if (!l2Var.isActive()) {
            throw l2Var.O();
        }
    }

    public static final void y(@os.l um.g gVar) {
        l2 l2Var = (l2) gVar.get(l2.f11882k);
        if (l2Var != null) {
            x(l2Var);
        }
    }

    @os.l
    public static final l2 z(@os.l um.g gVar) {
        l2 l2Var = (l2) gVar.get(l2.f11882k);
        if (l2Var != null) {
            return l2Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + gVar).toString());
    }
}
