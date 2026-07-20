package wq;

import jn.p;
import kn.r1;
import lm.c1;
import lm.l2;
import nq.g2;
import os.l;
import os.m;
import um.d;
import vq.n;
import wm.c;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nCancellable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cancellable.kt\nkotlinx/coroutines/intrinsics/CancellableKt\n*L\n1#1,68:1\n49#1,6:69\n49#1,6:75\n49#1,6:81\n*S KotlinDebug\n*F\n+ 1 Cancellable.kt\nkotlinx/coroutines/intrinsics/CancellableKt\n*L\n17#1:69,6\n29#1:75,6\n38#1:81,6\n*E\n"})
public final class a {
    public static final void a(d<?> dVar, Throwable th2) throws Throwable {
        c1.a aVar = c1.Companion;
        w.a.a(th2, dVar);
        throw th2;
    }

    public static final void b(d<?> dVar, jn.a<l2> aVar) throws Throwable {
        try {
            aVar.invoke();
        } catch (Throwable th2) {
            a(dVar, th2);
        }
    }

    @g2
    public static final <T> void c(@l jn.l<? super d<? super T>, ? extends Object> lVar, @l d<? super T> dVar) throws Throwable {
        try {
            d dVarE = c.e(c.b(lVar, dVar));
            c1.a aVar = c1.Companion;
            n.e(dVarE, c1.m59constructorimpl(l2.f10208a), null, 2, null);
        } catch (Throwable th2) {
            a(dVar, th2);
        }
    }

    public static final <R, T> void d(@l p<? super R, ? super d<? super T>, ? extends Object> pVar, R r10, @l d<? super T> dVar, @m jn.l<? super Throwable, l2> lVar) throws Throwable {
        try {
            d dVarE = c.e(c.c(pVar, r10, dVar));
            c1.a aVar = c1.Companion;
            n.d(dVarE, c1.m59constructorimpl(l2.f10208a), lVar);
        } catch (Throwable th2) {
            a(dVar, th2);
        }
    }

    public static final void e(@l d<? super l2> dVar, @l d<?> dVar2) throws Throwable {
        try {
            d dVarE = c.e(dVar);
            c1.a aVar = c1.Companion;
            n.e(dVarE, c1.m59constructorimpl(l2.f10208a), null, 2, null);
        } catch (Throwable th2) {
            a(dVar2, th2);
        }
    }

    public static /* synthetic */ void f(p pVar, Object obj, d dVar, jn.l lVar, int i10, Object obj2) throws Throwable {
        if ((i10 & 4) != 0) {
            lVar = null;
        }
        d(pVar, obj, dVar, lVar);
    }
}
