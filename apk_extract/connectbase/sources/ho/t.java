package ho;

import vp.f1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t implements eo.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f7451a = new a();

    public static final class a {
        public a() {
        }

        @os.l
        public final op.h a(@os.l eo.e eVar, @os.l f1 f1Var, @os.l wp.g gVar) {
            kn.l0.p(eVar, "<this>");
            kn.l0.p(f1Var, "typeSubstitution");
            kn.l0.p(gVar, "kotlinTypeRefiner");
            t tVar = eVar instanceof t ? (t) eVar : null;
            if (tVar != null) {
                return tVar.B(f1Var, gVar);
            }
            op.h hVarN = eVar.N(f1Var);
            kn.l0.o(hVarN, "this.getMemberScope(\n   …ubstitution\n            )");
            return hVarN;
        }

        @os.l
        public final op.h b(@os.l eo.e eVar, @os.l wp.g gVar) {
            kn.l0.p(eVar, "<this>");
            kn.l0.p(gVar, "kotlinTypeRefiner");
            t tVar = eVar instanceof t ? (t) eVar : null;
            if (tVar != null) {
                return tVar.Z(gVar);
            }
            op.h hVarX = eVar.X();
            kn.l0.o(hVarX, "this.unsubstitutedMemberScope");
            return hVarX;
        }

        public a(kn.w wVar) {
        }
    }

    @os.l
    public abstract op.h B(@os.l f1 f1Var, @os.l wp.g gVar);

    @os.l
    public abstract op.h Z(@os.l wp.g gVar);
}
