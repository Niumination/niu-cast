package mp;

import kn.l0;
import nm.h0;
import op.h;
import os.l;
import os.m;
import qo.g;
import uo.d0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final g f10860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final oo.g f10861b;

    public c(@l g gVar, @l oo.g gVar2) {
        l0.p(gVar, "packageFragmentProvider");
        l0.p(gVar2, "javaResolverCache");
        this.f10860a = gVar;
        this.f10861b = gVar2;
    }

    @l
    public final g a() {
        return this.f10860a;
    }

    @m
    public final eo.e b(@l uo.g gVar) {
        l0.p(gVar, "javaClass");
        dp.c cVarE = gVar.e();
        if (cVarE != null && gVar.I() == d0.SOURCE) {
            return this.f10861b.d(cVarE);
        }
        uo.g gVarL = gVar.l();
        if (gVarL != null) {
            eo.e eVarB = b(gVarL);
            h hVarV = eVarB == null ? null : eVarB.V();
            eo.h hVarF = hVarV == null ? null : hVarV.f(gVar.getName(), mo.d.FROM_JAVA_LOADER);
            if (hVarF instanceof eo.e) {
                return (eo.e) hVarF;
            }
            return null;
        }
        if (cVarE == null) {
            return null;
        }
        g gVar2 = this.f10860a;
        dp.c cVarE2 = cVarE.e();
        l0.o(cVarE2, "fqName.parent()");
        ro.h hVar = (ro.h) h0.G2(gVar2.a(cVarE2));
        if (hVar == null) {
            return null;
        }
        return hVar.F0(gVar);
    }
}
