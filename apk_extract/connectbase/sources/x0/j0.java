package x0;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static y0.c.a f19913a = y0.c.a.a(p6.s.f13016a, "e", p6.o.f13007a, "nm", p6.m.f13003a, "hd");

    public static u0.q a(y0.c cVar, n0.g gVar) throws IOException {
        String strA = null;
        u0.q.a aVarForId = null;
        t0.b bVarF = null;
        t0.b bVarF2 = null;
        t0.b bVarF3 = null;
        boolean zP = false;
        while (cVar.o()) {
            int iE0 = cVar.e0(f19913a);
            if (iE0 == 0) {
                bVarF = d.f(cVar, gVar, false);
            } else if (iE0 == 1) {
                bVarF2 = d.f(cVar, gVar, false);
            } else if (iE0 == 2) {
                bVarF3 = d.f(cVar, gVar, false);
            } else if (iE0 == 3) {
                strA = cVar.A();
            } else if (iE0 == 4) {
                aVarForId = u0.q.a.forId(cVar.t());
            } else if (iE0 != 5) {
                cVar.g0();
            } else {
                zP = cVar.p();
            }
        }
        return new u0.q(strA, aVarForId, bVarF, bVarF2, bVarF3, zP);
    }
}
