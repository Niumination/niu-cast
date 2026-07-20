package nq;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public final class p2 {
    public static final void A(@os.l um.g gVar) {
        r2.y(gVar);
    }

    @os.l
    public static final l2 B(@os.l um.g gVar) {
        return r2.z(gVar);
    }

    public static final boolean C(@os.l um.g gVar) {
        return r2.A(gVar);
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

    public static final void e(@os.l l2 l2Var, @os.l String str, @os.m Throwable th2) {
        r2.e(l2Var, str, th2);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void f(um.g gVar) {
        r2.g(gVar, null);
    }

    public static final void g(@os.l um.g gVar, @os.m CancellationException cancellationException) {
        r2.g(gVar, cancellationException);
    }

    @os.m
    public static final Object l(@os.l l2 l2Var, @os.l um.d<? super lm.l2> dVar) {
        return r2.l(l2Var, dVar);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void m(l2 l2Var) {
        r2.o(l2Var, null);
    }

    public static final void o(@os.l l2 l2Var, @os.m CancellationException cancellationException) {
        r2.o(l2Var, cancellationException);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void p(um.g gVar) {
        r2.r(gVar, null);
    }

    public static final void r(@os.l um.g gVar, @os.m CancellationException cancellationException) {
        r2.r(gVar, cancellationException);
    }

    public static final void w(@os.l p<?> pVar, @os.l Future<?> future) {
        q2.a(pVar, future);
    }

    @g2
    @os.l
    public static final n1 x(@os.l l2 l2Var, @os.l Future<?> future) {
        return q2.b(l2Var, future);
    }

    @os.l
    public static final n1 y(@os.l l2 l2Var, @os.l n1 n1Var) {
        return r2.w(l2Var, n1Var);
    }

    public static final void z(@os.l l2 l2Var) {
        r2.x(l2Var);
    }
}
