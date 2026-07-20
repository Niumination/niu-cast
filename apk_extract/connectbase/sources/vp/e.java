package vp;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final e f17673a = new e();

    public final boolean a(yp.r rVar, yp.k kVar, yp.k kVar2) {
        if (rVar.j(kVar) == rVar.j(kVar2) && rVar.Y(kVar) == rVar.Y(kVar2)) {
            if ((rVar.q0(kVar) == null) == (rVar.q0(kVar2) == null) && rVar.V(rVar.b(kVar), rVar.b(kVar2))) {
                if (rVar.u(kVar, kVar2)) {
                    return true;
                }
                int iJ = rVar.j(kVar);
                int i10 = 0;
                while (i10 < iJ) {
                    int i11 = i10 + 1;
                    yp.n nVarO = rVar.O(kVar, i10);
                    yp.n nVarO2 = rVar.O(kVar2, i10);
                    if (rVar.w0(nVarO) != rVar.w0(nVarO2)) {
                        return false;
                    }
                    if (!rVar.w0(nVarO) && (rVar.p0(nVarO) != rVar.p0(nVarO2) || !c(rVar, rVar.o(nVarO), rVar.o(nVarO2)))) {
                        return false;
                    }
                    i10 = i11;
                }
                return true;
            }
        }
        return false;
    }

    public final boolean b(@os.l yp.r rVar, @os.l yp.i iVar, @os.l yp.i iVar2) {
        kn.l0.p(rVar, "context");
        kn.l0.p(iVar, "a");
        kn.l0.p(iVar2, "b");
        return c(rVar, iVar, iVar2);
    }

    public final boolean c(yp.r rVar, yp.i iVar, yp.i iVar2) {
        if (iVar == iVar2) {
            return true;
        }
        yp.k kVarD = rVar.d(iVar);
        yp.k kVarD2 = rVar.d(iVar2);
        if (kVarD != null && kVarD2 != null) {
            return a(rVar, kVarD, kVarD2);
        }
        yp.g gVarB0 = rVar.b0(iVar);
        yp.g gVarB1 = rVar.b0(iVar2);
        if (gVarB0 == null || gVarB1 == null) {
            return false;
        }
        return a(rVar, rVar.e(gVarB0), rVar.e(gVarB1)) && a(rVar, rVar.g(gVarB0), rVar.g(gVarB1));
    }
}
