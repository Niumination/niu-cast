package vo;

import eo.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import lm.i0;
import nm.y;
import nm.z;
import vp.a1;
import vp.c0;
import vp.c1;
import vp.f0;
import vp.g0;
import vp.h0;
import vp.j1;
import vp.l1;
import vp.m0;
import vp.n0;
import vp.n1;
import vp.o1;
import vp.q0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final qo.d f17605a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.m
        public final f0 f17606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17607b;

        public a(@os.m f0 f0Var, int i10) {
            this.f17606a = f0Var;
            this.f17607b = i10;
        }

        public final int a() {
            return this.f17607b;
        }

        @os.m
        public final f0 b() {
            return this.f17606a;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.m
        public final n0 f17608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f17610c;

        public b(@os.m n0 n0Var, int i10, boolean z10) {
            this.f17608a = n0Var;
            this.f17609b = i10;
            this.f17610c = z10;
        }

        public final boolean a() {
            return this.f17610c;
        }

        public final int b() {
            return this.f17609b;
        }

        @os.m
        public final n0 c() {
            return this.f17608a;
        }
    }

    public c(@os.l qo.d dVar) {
        l0.p(dVar, "javaResolverSettings");
        this.f17605a = dVar;
    }

    public static /* synthetic */ b c(c cVar, n0 n0Var, jn.l lVar, int i10, o oVar, boolean z10, boolean z11, int i11, Object obj) {
        return cVar.b(n0Var, lVar, i10, oVar, (i11 & 8) != 0 ? false : z10, (i11 & 16) != 0 ? false : z11);
    }

    @os.m
    public final f0 a(@os.l f0 f0Var, @os.l jn.l<? super Integer, d> lVar, boolean z10) {
        l0.p(f0Var, "<this>");
        l0.p(lVar, "qualifiers");
        return d(f0Var.J0(), lVar, 0, z10).f17606a;
    }

    public final b b(n0 n0Var, jn.l<? super Integer, d> lVar, int i10, o oVar, boolean z10, boolean z11) {
        eo.h hVarD;
        boolean z12;
        a aVar;
        c1 c1VarT;
        jn.l<? super Integer, d> lVar2 = lVar;
        boolean zA = p.a(oVar);
        boolean z13 = (z11 && z10) ? false : true;
        f0 f0Var = null;
        if ((zA || !n0Var.F0().isEmpty()) && (hVarD = n0Var.G0().d()) != null) {
            d dVarInvoke = lVar2.invoke(Integer.valueOf(i10));
            eo.h hVarG = r.g(hVarD, dVarInvoke, oVar);
            Boolean boolH = r.h(dVarInvoke, oVar);
            a1 a1VarG0 = hVarG == null ? n0Var.G0() : hVarG.i();
            l0.o(a1VarG0, "enhancedClassifier?.typeConstructor ?: constructor");
            int i11 = i10 + 1;
            List<c1> listF0 = n0Var.F0();
            List<e1> parameters = a1VarG0.getParameters();
            l0.o(parameters, "typeConstructor.parameters");
            List<e1> list = parameters;
            Iterator<T> it = listF0.iterator();
            Iterator<T> it2 = list.iterator();
            ArrayList arrayList = new ArrayList(Math.min(z.b0(listF0, 10), z.b0(list, 10)));
            while (it.hasNext() && it2.hasNext()) {
                Object next = it.next();
                e1 e1Var = (e1) it2.next();
                c1 c1Var = (c1) next;
                if (z13) {
                    z12 = z13;
                    if (!c1Var.a()) {
                        aVar = d(c1Var.getType().J0(), lVar2, i11, z11);
                    } else if (lVar2.invoke(Integer.valueOf(i11)).f17613a == g.FORCE_FLEXIBILITY) {
                        n1 n1VarJ0 = c1Var.getType().J0();
                        aVar = new a(g0.d(c0.c(n1VarJ0).N0(false), c0.d(n1VarJ0).N0(true)), 1);
                    } else {
                        aVar = new a(null, 1);
                    }
                } else {
                    z12 = z13;
                    aVar = new a(f0Var, 0);
                }
                i11 += aVar.f17607b;
                f0 f0Var2 = aVar.f17606a;
                if (f0Var2 != null) {
                    o1 o1VarC = c1Var.c();
                    l0.o(o1VarC, "arg.projectionKind");
                    c1VarT = zp.a.e(f0Var2, o1VarC, e1Var);
                } else if (hVarG == null || c1Var.a()) {
                    c1VarT = hVarG != null ? j1.t(e1Var) : null;
                } else {
                    f0 type = c1Var.getType();
                    l0.o(type, "arg.type");
                    o1 o1VarC2 = c1Var.c();
                    l0.o(o1VarC2, "arg.projectionKind");
                    c1VarT = zp.a.e(type, o1VarC2, e1Var);
                }
                arrayList.add(c1VarT);
                lVar2 = lVar;
                z13 = z12;
                f0Var = null;
            }
            int i12 = i11 - i10;
            if (hVarG == null && boolH == null) {
                if (!arrayList.isEmpty()) {
                    Iterator it3 = arrayList.iterator();
                    do {
                        if (it3.hasNext()) {
                        }
                    } while (((c1) it3.next()) == null);
                }
                return new b(null, i12, false);
            }
            fo.g annotations = n0Var.getAnnotations();
            vo.b bVar = r.f17657b;
            if (hVarG == null) {
                bVar = null;
            }
            boolean z14 = false;
            fo.g gVarF = r.f(y.Q(annotations, bVar, boolH != null ? r.f17656a : null));
            List<c1> listF1 = n0Var.F0();
            Iterator it4 = arrayList.iterator();
            Iterator<T> it5 = listF1.iterator();
            ArrayList arrayList2 = new ArrayList(Math.min(z.b0(arrayList, 10), z.b0(listF1, 10)));
            while (it4.hasNext() && it5.hasNext()) {
                Object next2 = it4.next();
                c1 c1Var2 = (c1) it5.next();
                c1 c1Var3 = (c1) next2;
                if (c1Var3 != null) {
                    c1Var2 = c1Var3;
                }
                arrayList2.add(c1Var2);
            }
            n0 n0VarJ = g0.j(gVarF, a1VarG0, arrayList2, boolH == null ? n0Var.H0() : boolH.booleanValue(), null, 16, null);
            if (dVarInvoke.f17615c) {
                n0VarJ = e(n0VarJ);
            }
            if (boolH != null && dVarInvoke.f17616d) {
                z14 = true;
            }
            return new b(n0VarJ, i12, z14);
        }
        return new b(null, 1, false);
    }

    public final a d(n1 n1Var, jn.l<? super Integer, d> lVar, int i10, boolean z10) {
        n1 n1VarD;
        n0 n0Var;
        f0 f0VarE = null;
        if (h0.a(n1Var)) {
            return new a(null, 1);
        }
        if (!(n1Var instanceof vp.z)) {
            if (!(n1Var instanceof n0)) {
                throw new i0();
            }
            b bVarC = c(this, (n0) n1Var, lVar, i10, o.INFLEXIBLE, false, z10, 8, null);
            return new a(bVarC.f17610c ? l1.e(n1Var, bVarC.f17608a) : bVarC.f17608a, bVarC.f17609b);
        }
        boolean z11 = n1Var instanceof m0;
        vp.z zVar = (vp.z) n1Var;
        b bVarB = b(zVar.f17773b, lVar, i10, o.FLEXIBLE_LOWER, z11, z10);
        b bVarB2 = b(zVar.f17774c, lVar, i10, o.FLEXIBLE_UPPER, z11, z10);
        int i11 = bVarB.f17609b;
        int i12 = bVarB2.f17609b;
        n0 n0Var2 = bVarB.f17608a;
        if (n0Var2 != null || bVarB2.f17608a != null) {
            if (bVarB.f17610c || bVarB2.f17610c) {
                n0Var = n0Var2;
                n0 n0Var3 = bVarB2.f17608a;
                n0 n0Var4 = n0Var2;
                if (n0Var3 == null) {
                    l0.m(n0Var2);
                    n1VarD = n0Var2;
                } else {
                    if (n0Var2 == null) {
                        n0Var4 = n0Var3;
                    }
                    n1VarD = g0.d(n0Var4, n0Var3);
                }
                f0VarE = l1.e(n1Var, n1VarD);
            } else if (z11) {
                n0 n0Var5 = n0Var2;
                if (n0Var2 == null) {
                    n0Var5 = zVar.f17773b;
                }
                n0 n0Var6 = bVarB2.f17608a;
                if (n0Var6 == null) {
                    n0Var6 = zVar.f17774c;
                }
                f0VarE = new so.f(n0Var5, n0Var6);
            } else {
                if (n0Var2 == null) {
                    n0Var = zVar.f17773b;
                }
                n0 n0Var7 = bVarB2.f17608a;
                if (n0Var7 == null) {
                    n0Var7 = zVar.f17774c;
                }
                f0VarE = g0.d(n0Var, n0Var7);
            }
        }
        return new a(f0VarE, bVarB.f17609b);
    }

    public final n0 e(n0 n0Var) {
        return this.f17605a.a() ? q0.h(n0Var, true) : new f(n0Var);
    }
}
