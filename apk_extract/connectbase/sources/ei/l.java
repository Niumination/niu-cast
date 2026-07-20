package ei;

import bi.s;
import bi.x;

/* JADX INFO: loaded from: classes2.dex */
public class l extends a {
    @Override // ei.n
    public void a(Object obj) {
        bi.j jVarC = c();
        s sVarX = jVarC.x();
        bi.g gVarZ = jVarC.z();
        try {
            if (gVarZ.contains(obj)) {
                x xVarA = c().A();
                if (xVarA != null) {
                    xVarA.a();
                    return;
                }
                return;
            }
            jVarC.e(new bi.g(gVarZ));
            jVarC.z().add(obj);
            bi.d dVarA = bi.d.a(d(obj));
            x xVarH = jVarC.H();
            for (bi.e eVar : dVarA != null ? dVarA.c() : null) {
                sVarX.a(eVar.e());
                if (jVarC.n(eVar) && eVar.n().booleanValue()) {
                    Object objA = eVar.a(obj);
                    if (!jVarC.z().contains(objA)) {
                        n nVarB = jVarC.b(eVar, objA);
                        if (!(nVarB instanceof g) || !((g) nVarB).b().booleanValue()) {
                            if (xVarH.e()) {
                                jVarC.E();
                            }
                            xVarH.d();
                            jVarC.u(eVar.b());
                        }
                        xVarH.b(eVar.b());
                        nVarB.a(objA);
                    }
                }
                sVarX.d();
            }
            jVarC.D();
            jVarC.e((bi.g) jVarC.z().a());
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (InstantiationException e11) {
            e11.printStackTrace();
        }
    }

    public Class d(Object obj) {
        return obj.getClass();
    }
}
