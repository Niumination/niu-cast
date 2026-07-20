package oo;

import java.util.Map;
import kn.l0;
import lm.t0;
import nm.d1;
import no.z;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final c f12337a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final dp.f f12338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final dp.f f12339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final dp.f f12340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final Map<dp.c, dp.c> f12341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final Map<dp.c, dp.c> f12342f;

    static {
        dp.f fVarK = dp.f.k("message");
        l0.o(fVarK, "identifier(\"message\")");
        f12338b = fVarK;
        dp.f fVarK2 = dp.f.k("allowedTargets");
        l0.o(fVarK2, "identifier(\"allowedTargets\")");
        f12339c = fVarK2;
        dp.f fVarK3 = dp.f.k("value");
        l0.o(fVarK3, "identifier(\"value\")");
        f12340d = fVarK3;
        dp.c cVar = ao.k.a.F;
        dp.c cVar2 = z.f11803d;
        t0 t0Var = new t0(cVar, cVar2);
        dp.c cVar3 = ao.k.a.I;
        dp.c cVar4 = z.f11805f;
        t0 t0Var2 = new t0(cVar3, cVar4);
        dp.c cVar5 = ao.k.a.K;
        dp.c cVar6 = z.f11808i;
        f12341e = d1.W(t0Var, t0Var2, new t0(cVar5, cVar6));
        f12342f = d1.W(new t0(cVar2, cVar), new t0(cVar4, cVar3), new t0(z.f11807h, ao.k.a.f619y), new t0(cVar6, cVar5));
    }

    public static /* synthetic */ fo.c f(c cVar, uo.a aVar, qo.h hVar, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return cVar.e(aVar, hVar, z10);
    }

    @m
    public final fo.c a(@l dp.c cVar, @l uo.d dVar, @l qo.h hVar) {
        uo.a aVarD;
        l0.p(cVar, "kotlinName");
        l0.p(dVar, "annotationOwner");
        l0.p(hVar, "c");
        if (l0.g(cVar, ao.k.a.f619y)) {
            dp.c cVar2 = z.f11807h;
            l0.o(cVar2, "DEPRECATED_ANNOTATION");
            uo.a aVarD2 = dVar.d(cVar2);
            if (aVarD2 != null || dVar.C()) {
                return new e(aVarD2, hVar);
            }
        }
        dp.c cVar3 = f12341e.get(cVar);
        if (cVar3 == null || (aVarD = dVar.d(cVar3)) == null) {
            return null;
        }
        return f(f12337a, aVarD, hVar, false, 4, null);
    }

    @l
    public final dp.f b() {
        return f12338b;
    }

    @l
    public final dp.f c() {
        return f12340d;
    }

    @l
    public final dp.f d() {
        return f12339c;
    }

    @m
    public final fo.c e(@l uo.a aVar, @l qo.h hVar, boolean z10) {
        l0.p(aVar, "annotation");
        l0.p(hVar, "c");
        dp.b bVarF = aVar.f();
        if (l0.g(bVarF, dp.b.m(z.f11803d))) {
            return new i(aVar, hVar);
        }
        if (l0.g(bVarF, dp.b.m(z.f11805f))) {
            return new h(aVar, hVar);
        }
        if (l0.g(bVarF, dp.b.m(z.f11808i))) {
            return new b(hVar, aVar, ao.k.a.K);
        }
        if (l0.g(bVarF, dp.b.m(z.f11807h))) {
            return null;
        }
        return new ro.e(hVar, aVar, z10);
    }
}
