package so;

import eo.e1;
import kn.l0;
import nm.n1;
import oo.k;
import os.l;
import os.m;
import vp.c1;
import vp.s0;
import vp.t0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final dp.c f15184a = new dp.c("java.lang.Class");

    @l
    public static final c1 b(@l e1 e1Var, @l a aVar) {
        l0.p(e1Var, "typeParameter");
        l0.p(aVar, dc.d.f3681l);
        return aVar.f15174a == k.SUPERTYPE ? new vp.e1(t0.b(e1Var)) : new s0(e1Var);
    }

    @l
    public static final a c(@l k kVar, boolean z10, @m e1 e1Var) {
        l0.p(kVar, "<this>");
        return new a(kVar, null, z10, e1Var == null ? null : n1.f(e1Var), null, 18, null);
    }

    public static /* synthetic */ a d(k kVar, boolean z10, e1 e1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            e1Var = null;
        }
        return c(kVar, z10, e1Var);
    }
}
