package vp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 {
    @os.m
    public static final a a(@os.l f0 f0Var) {
        kn.l0.p(f0Var, "<this>");
        n1 n1VarJ0 = f0Var.J0();
        if (n1VarJ0 instanceof a) {
            return (a) n1VarJ0;
        }
        return null;
    }

    @os.m
    public static final n0 b(@os.l f0 f0Var) {
        kn.l0.p(f0Var, "<this>");
        a aVarA = a(f0Var);
        if (aVarA == null) {
            return null;
        }
        return aVarA.f17660c;
    }

    public static final boolean c(@os.l f0 f0Var) {
        kn.l0.p(f0Var, "<this>");
        return f0Var.J0() instanceof o;
    }

    public static final e0 d(e0 e0Var) {
        f0 f0Var;
        LinkedHashSet<f0> linkedHashSet = e0Var.f17675b;
        ArrayList arrayList = new ArrayList(nm.z.b0(linkedHashSet, 10));
        Iterator<T> it = linkedHashSet.iterator();
        boolean z10 = false;
        while (true) {
            f0Var = null;
            if (!it.hasNext()) {
                break;
            }
            f0 f0VarF = (f0) it.next();
            if (j1.m(f0VarF)) {
                f0VarF = f(f0VarF.J0(), false, 1, null);
                z10 = true;
            }
            arrayList.add(f0VarF);
        }
        if (!z10) {
            return null;
        }
        f0 f0VarF2 = e0Var.f17674a;
        if (f0VarF2 != null) {
            if (j1.m(f0VarF2)) {
                f0VarF2 = f(f0VarF2.J0(), false, 1, null);
            }
            f0Var = f0VarF2;
        }
        return new e0(arrayList).l(f0Var);
    }

    @os.l
    public static final n1 e(@os.l n1 n1Var, boolean z10) {
        kn.l0.p(n1Var, "<this>");
        o oVarB = o.f17723d.b(n1Var, z10);
        if (oVarB != null) {
            return oVarB;
        }
        n0 n0VarG = g(n1Var);
        return n0VarG == null ? n1Var.N0(false) : n0VarG;
    }

    public static /* synthetic */ n1 f(n1 n1Var, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return e(n1Var, z10);
    }

    public static final n0 g(f0 f0Var) {
        e0 e0VarD;
        a1 a1VarG0 = f0Var.G0();
        e0 e0Var = a1VarG0 instanceof e0 ? (e0) a1VarG0 : null;
        if (e0Var == null || (e0VarD = d(e0Var)) == null) {
            return null;
        }
        return e0VarD.g();
    }

    @os.l
    public static final n0 h(@os.l n0 n0Var, boolean z10) {
        kn.l0.p(n0Var, "<this>");
        o oVarB = o.f17723d.b(n0Var, z10);
        if (oVarB != null) {
            return oVarB;
        }
        n0 n0VarG = g(n0Var);
        return n0VarG == null ? n0Var.N0(false) : n0VarG;
    }

    public static /* synthetic */ n0 i(n0 n0Var, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return h(n0Var, z10);
    }

    @os.l
    public static final n0 j(@os.l n0 n0Var, @os.l n0 n0Var2) {
        kn.l0.p(n0Var, "<this>");
        kn.l0.p(n0Var2, "abbreviatedType");
        return h0.a(n0Var) ? n0Var : new a(n0Var, n0Var2);
    }

    @os.l
    public static final wp.i k(@os.l wp.i iVar) {
        kn.l0.p(iVar, "<this>");
        return new wp.i(iVar.f19855b, iVar.f19856c, iVar.f19857d, iVar.f19858e, iVar.f19859f, true);
    }
}
