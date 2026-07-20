package x0;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static y0.c.a f19896a = y0.c.a.a("nm", "c", p6.o.f13007a, "tr", "hd");

    public static u0.k a(y0.c cVar, n0.g gVar) throws IOException {
        String strA = null;
        t0.b bVarF = null;
        t0.b bVarF2 = null;
        t0.l lVarG = null;
        boolean zP = false;
        while (cVar.o()) {
            int iE0 = cVar.e0(f19896a);
            if (iE0 == 0) {
                strA = cVar.A();
            } else if (iE0 == 1) {
                bVarF = d.f(cVar, gVar, false);
            } else if (iE0 == 2) {
                bVarF2 = d.f(cVar, gVar, false);
            } else if (iE0 == 3) {
                lVarG = c.g(cVar, gVar);
            } else if (iE0 != 4) {
                cVar.g0();
            } else {
                zP = cVar.p();
            }
        }
        return new u0.k(strA, bVarF, bVarF2, lVarG, zP);
    }
}
