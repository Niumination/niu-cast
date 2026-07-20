package vo;

import java.util.List;
import kn.l0;
import nm.h0;
import no.z;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final b f17656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final b f17657b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17658a;

        static {
            int[] iArr = new int[g.values().length];
            iArr[g.NULLABLE.ordinal()] = 1;
            iArr[g.NOT_NULL.ordinal()] = 2;
            f17658a = iArr;
        }
    }

    static {
        dp.c cVar = z.f11818s;
        l0.o(cVar, "ENHANCED_NULLABILITY_ANNOTATION");
        f17656a = new b(cVar);
        dp.c cVar2 = z.f11819t;
        l0.o(cVar2, "ENHANCED_MUTABILITY_ANNOTATION");
        f17657b = new b(cVar2);
    }

    public static final fo.g f(List<? extends fo.g> list) {
        int size = list.size();
        if (size != 0) {
            return size != 1 ? new fo.k((List<? extends fo.g>) h0.V5(list)) : (fo.g) h0.h5(list);
        }
        throw new IllegalStateException("At least one Annotations object expected");
    }

    public static final eo.h g(eo.h hVar, d dVar, o oVar) {
        co.d dVar2 = co.d.f1703a;
        if (!p.a(oVar) || !(hVar instanceof eo.e)) {
            return null;
        }
        if (dVar.f17614b == e.READ_ONLY && oVar == o.FLEXIBLE_LOWER) {
            eo.e eVar = (eo.e) hVar;
            if (dVar2.c(eVar)) {
                return dVar2.a(eVar);
            }
        }
        if (dVar.f17614b != e.MUTABLE || oVar != o.FLEXIBLE_UPPER) {
            return null;
        }
        eo.e eVar2 = (eo.e) hVar;
        if (dVar2.e(eVar2)) {
            return dVar2.b(eVar2);
        }
        return null;
    }

    public static final Boolean h(d dVar, o oVar) {
        if (!p.a(oVar)) {
            return null;
        }
        g gVar = dVar.f17613a;
        int i10 = gVar == null ? -1 : a.f17658a[gVar.ordinal()];
        if (i10 == 1) {
            return Boolean.TRUE;
        }
        if (i10 != 2) {
            return null;
        }
        return Boolean.FALSE;
    }

    public static final boolean i(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        return s.b(wp.q.f19874a, f0Var);
    }
}
