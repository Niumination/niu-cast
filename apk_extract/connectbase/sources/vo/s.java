package vo;

import ik.y0;
import java.util.Set;
import kn.l0;
import nm.h0;
import nm.p1;
import no.z;
import vp.i1;

/* JADX INFO: loaded from: classes3.dex */
public final class s {
    @os.l
    public static final d a(@os.m g gVar, @os.m e eVar, boolean z10, boolean z11) {
        return (z11 && gVar == g.NOT_NULL) ? new d(gVar, eVar, true, z10) : new d(gVar, eVar, false, z10);
    }

    public static final boolean b(@os.l i1 i1Var, @os.l yp.i iVar) {
        l0.p(i1Var, "<this>");
        l0.p(iVar, y0.a.f8215h);
        dp.c cVar = z.f11818s;
        l0.o(cVar, "ENHANCED_NULLABILITY_ANNOTATION");
        return i1Var.k(iVar, cVar);
    }

    @os.m
    public static final <T> T c(@os.l Set<? extends T> set, @os.l T t10, @os.l T t11, @os.m T t12, boolean z10) {
        T t13;
        l0.p(set, "<this>");
        l0.p(t10, "low");
        l0.p(t11, "high");
        if (!z10) {
            if (t12 != null) {
                set = h0.a6(p1.E(set, t12));
            }
            return (T) h0.i5(set);
        }
        if (set.contains(t10)) {
            t13 = t10;
        } else {
            t13 = set.contains(t11) ? t11 : null;
        }
        if (l0.g(t13, t10) && l0.g(t12, t11)) {
            return null;
        }
        return t12 == null ? t13 : t12;
    }

    @os.m
    public static final g d(@os.l Set<? extends g> set, @os.m g gVar, boolean z10) {
        l0.p(set, "<this>");
        g gVar2 = g.FORCE_FLEXIBILITY;
        return gVar == gVar2 ? gVar2 : (g) c(set, g.NOT_NULL, g.NULLABLE, gVar, z10);
    }
}
