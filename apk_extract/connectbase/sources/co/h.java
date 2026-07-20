package co;

import eo.h0;
import eo.j0;
import java.io.InputStream;
import java.util.List;
import kn.l0;
import kn.w;
import nm.y;
import os.l;
import os.m;
import rp.k;
import rp.o;
import rp.q;
import rp.r;
import rp.u;
import up.n;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends rp.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final a f1734f = new a();

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@l n nVar, @l wo.n nVar2, @l h0 h0Var, @l j0 j0Var, @l go.a aVar, @l go.c cVar, @l k kVar, @l wp.l lVar, @l np.a aVar2) {
        super(nVar, nVar2, h0Var);
        l0.p(nVar, "storageManager");
        l0.p(nVar2, "finder");
        l0.p(h0Var, "moduleDescriptor");
        l0.p(j0Var, "notFoundClasses");
        l0.p(aVar, "additionalClassPartsProvider");
        l0.p(cVar, "platformDependentDeclarationFilter");
        l0.p(kVar, "deserializationConfiguration");
        l0.p(lVar, "kotlinTypeChecker");
        l0.p(aVar2, "samConversionResolver");
        rp.n nVar3 = new rp.n(this);
        sp.a aVar3 = sp.a.f15197n;
        rp.d dVar = new rp.d(h0Var, j0Var, aVar3);
        u.a aVar4 = u.a.f14772a;
        q qVar = q.f14766a;
        l0.o(qVar, "DO_NOTHING");
        mo.c.a aVar5 = mo.c.a.f10855a;
        r.a aVar6 = r.a.f14767a;
        List listO = y.O(new bo.a(nVar, h0Var), new e(nVar, h0Var, null, 4, null));
        rp.i.f14724a.getClass();
        i(new rp.j(nVar, h0Var, kVar, nVar3, dVar, this, aVar4, qVar, aVar5, aVar6, listO, j0Var, rp.i.a.f14726b, aVar, cVar, aVar3.f14100a, lVar, aVar2, null, 262144, null));
    }

    @Override // rp.a
    @m
    public o d(@l dp.c cVar) {
        l0.p(cVar, "fqName");
        InputStream inputStreamC = this.f14681b.c(cVar);
        if (inputStreamC == null) {
            return null;
        }
        return sp.c.f15199z.a(cVar, this.f14680a, this.f14682c, inputStreamC, false);
    }
}
