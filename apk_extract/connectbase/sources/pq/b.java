package pq;

import lm.l2;
import nq.c3;
import nq.m0;
import nq.s0;
import nq.t2;
import nq.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    @c3
    @os.l
    public static final <E> g0<E> a(@os.l s0 s0Var, @os.l um.g gVar, int i10, @os.l u0 u0Var, @os.m jn.l<? super Throwable, l2> lVar, @os.l jn.p<? super c<E>, ? super um.d<? super l2>, ? extends Object> pVar) {
        um.g gVarD = m0.d(s0Var, gVar);
        l lVarD = o.d(i10, null, null, 6, null);
        a zVar = u0Var.isLazy() ? new z(gVarD, lVarD, pVar) : new a(gVarD, lVarD, true);
        if (lVar != null) {
            ((t2) zVar).k0(lVar);
        }
        u0Var.invoke(pVar, zVar, (um.d) zVar);
        return (g0<E>) zVar;
    }

    public static /* synthetic */ g0 b(s0 s0Var, um.g gVar, int i10, u0 u0Var, jn.l lVar, jn.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            gVar = um.i.INSTANCE;
        }
        um.g gVar2 = gVar;
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            u0Var = u0.DEFAULT;
        }
        u0 u0Var2 = u0Var;
        if ((i11 & 8) != 0) {
            lVar = null;
        }
        return a(s0Var, gVar2, i12, u0Var2, lVar, pVar);
    }
}
