package jp;

import eo.h0;
import kn.l0;
import lm.t0;
import vp.f0;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends g<t0<? extends dp.b, ? extends dp.f>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final dp.b f8776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final dp.f f8777c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@os.l dp.b bVar, @os.l dp.f fVar) {
        super(new t0(bVar, fVar));
        l0.p(bVar, "enumClassId");
        l0.p(fVar, "enumEntryName");
        this.f8776b = bVar;
        this.f8777c = fVar;
    }

    @Override // jp.g
    @os.l
    public f0 a(@os.l h0 h0Var) {
        l0.p(h0Var, "module");
        eo.e eVarA = eo.x.a(h0Var, this.f8776b);
        if (eVarA == null || !hp.d.A(eVarA)) {
            eVarA = null;
        }
        if (eVarA != null) {
            n0 n0VarQ = eVarA.q();
            l0.o(n0VarQ, "module.findClassAcrossMo…mClassId.$enumEntryName\")");
            return n0VarQ;
        }
        n0 n0VarJ = vp.x.j("Containing class for error-class based enum entry " + this.f8776b + n1.e.f11183c + this.f8777c);
        l0.o(n0VarJ, "createErrorType(\"Contain…mClassId.$enumEntryName\")");
        return n0VarJ;
    }

    @os.l
    public final dp.f c() {
        return this.f8777c;
    }

    @Override // jp.g
    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f8776b.j());
        sb2.append(n1.e.f11183c);
        sb2.append(this.f8777c);
        return sb2.toString();
    }
}
