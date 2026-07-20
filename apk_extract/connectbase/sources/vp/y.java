package vp;

import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class y {
    @os.m
    public static final yp.i a(@os.l i1 i1Var, @os.l yp.i iVar) {
        kn.l0.p(i1Var, "<this>");
        kn.l0.p(iVar, "inlineClassType");
        return b(i1Var, iVar, new HashSet());
    }

    public static final yp.i b(i1 i1Var, yp.i iVar, HashSet<yp.o> hashSet) {
        yp.i iVarB;
        yp.o oVarS0 = i1Var.s0(iVar);
        if (!hashSet.add(oVarS0)) {
            return null;
        }
        yp.p pVarR0 = i1Var.r0(oVarS0);
        if (pVarR0 != null) {
            iVarB = b(i1Var, i1Var.I(pVarR0), hashSet);
            if (iVarB == null) {
                return null;
            }
            if (!i1Var.P(iVarB) && i1Var.g0(iVar)) {
                return i1Var.z0(iVarB);
            }
        } else {
            if (!i1Var.R(oVarS0)) {
                return iVar;
            }
            yp.i iVarN0 = i1Var.n0(iVar);
            if (iVarN0 == null || (iVarB = b(i1Var, iVarN0, hashSet)) == null) {
                return null;
            }
            if (i1Var.P(iVar)) {
                if (i1Var.P(iVarB)) {
                    return iVar;
                }
                return ((iVarB instanceof yp.k) && i1Var.L((yp.k) iVarB)) ? iVar : i1Var.z0(iVarB);
            }
        }
        return iVarB;
    }
}
