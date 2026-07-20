package x0;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static y0.c.a f19907a = y0.c.a.a("nm", "ind", "ks", "hd");

    public static u0.o a(y0.c cVar, n0.g gVar) throws IOException {
        String strA = null;
        int iT = 0;
        boolean zP = false;
        t0.h hVarK = null;
        while (cVar.o()) {
            int iE0 = cVar.e0(f19907a);
            if (iE0 == 0) {
                strA = cVar.A();
            } else if (iE0 == 1) {
                iT = cVar.t();
            } else if (iE0 == 2) {
                hVarK = d.k(cVar, gVar);
            } else if (iE0 != 3) {
                cVar.g0();
            } else {
                zP = cVar.p();
            }
        }
        return new u0.o(strA, iT, hVarK, zP);
    }
}
