package no;

import eo.t0;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements hp.e {
    @Override // hp.e
    @os.l
    public hp.e.a a() {
        return hp.e.a.BOTH;
    }

    @Override // hp.e
    @os.l
    public hp.e.b b(@os.l eo.a aVar, @os.l eo.a aVar2, @os.m eo.e eVar) {
        l0.p(aVar, "superDescriptor");
        l0.p(aVar2, "subDescriptor");
        if (!(aVar2 instanceof t0) || !(aVar instanceof t0)) {
            return hp.e.b.UNKNOWN;
        }
        t0 t0Var = (t0) aVar2;
        t0 t0Var2 = (t0) aVar;
        if (!l0.g(t0Var.getName(), t0Var2.getName())) {
            return hp.e.b.UNKNOWN;
        }
        if (ro.c.a(t0Var) && ro.c.a(t0Var2)) {
            return hp.e.b.OVERRIDABLE;
        }
        return (ro.c.a(t0Var) || ro.c.a(t0Var2)) ? hp.e.b.INCOMPATIBLE : hp.e.b.UNKNOWN;
    }
}
