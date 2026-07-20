package ro;

import eo.e1;
import eo.h1;
import eo.t0;
import eo.w0;
import java.util.Collection;
import java.util.List;
import kn.l0;
import nm.k0;
import uo.r;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends j {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@os.l qo.h hVar) {
        super(hVar, null, 2, null);
        l0.p(hVar, "c");
    }

    @Override // ro.j
    @os.m
    public w0 A() {
        return null;
    }

    @Override // ro.j
    @os.l
    public j.a I(@os.l r rVar, @os.l List<? extends e1> list, @os.l f0 f0Var, @os.l List<? extends h1> list2) {
        l0.p(rVar, "method");
        l0.p(list, "methodTypeParameters");
        l0.p(f0Var, "returnType");
        l0.p(list2, "valueParameters");
        return new j.a(f0Var, null, list2, list, false, k0.INSTANCE);
    }

    @Override // ro.j
    public void t(@os.l dp.f fVar, @os.l Collection<t0> collection) {
        l0.p(fVar, "name");
        l0.p(collection, "result");
    }
}
