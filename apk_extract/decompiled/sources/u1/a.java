package u1;

import java.util.ArrayList;
import k3.od;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f5.a f10269a = f5.a.g("k", "x", "y");

    public static se.e a(v1.e eVar, j1.j jVar) {
        ArrayList arrayList = new ArrayList();
        if (eVar.s() == v1.c.BEGIN_ARRAY) {
            eVar.a();
            while (eVar.i()) {
                arrayList.add(new m1.l(jVar, p.b(eVar, jVar, w1.g.c(), f.e, eVar.s() == v1.c.BEGIN_OBJECT, false)));
            }
            eVar.g();
            q.b(arrayList);
        } else {
            arrayList.add(new x1.a(o.b(eVar, w1.g.c())));
        }
        return new se.e(arrayList, 15);
    }

    public static q1.e b(v1.e eVar, j1.j jVar) {
        eVar.c();
        se.e eVarA = null;
        q1.b bVarB = null;
        boolean z2 = false;
        q1.b bVarB2 = null;
        while (eVar.s() != v1.c.END_OBJECT) {
            int iW = eVar.w(f10269a);
            if (iW == 0) {
                eVarA = a(eVar, jVar);
            } else if (iW != 1) {
                if (iW != 2) {
                    eVar.A();
                    eVar.B();
                } else if (eVar.s() == v1.c.STRING) {
                    eVar.B();
                    z2 = true;
                } else {
                    bVarB = od.b(eVar, jVar, true);
                }
            } else if (eVar.s() == v1.c.STRING) {
                eVar.B();
                z2 = true;
            } else {
                bVarB2 = od.b(eVar, jVar, true);
            }
        }
        eVar.h();
        if (z2) {
            jVar.a("Lottie doesn't support expressions.");
        }
        return eVarA != null ? eVarA : new q1.c(bVarB2, bVarB);
    }
}
