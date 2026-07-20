package x0;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static y0.c.a f19891a = y0.c.a.a("a");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static y0.c.a f19892b = y0.c.a.a("fc", "sc", "sw", "t");

    public static t0.k a(y0.c cVar, n0.g gVar) throws IOException {
        cVar.d();
        t0.k kVarB = null;
        while (cVar.o()) {
            if (cVar.e0(f19891a) != 0) {
                cVar.f0();
                cVar.g0();
            } else {
                kVarB = b(cVar, gVar);
            }
        }
        cVar.k();
        return kVarB == null ? new t0.k(null, null, null, null) : kVarB;
    }

    public static t0.k b(y0.c cVar, n0.g gVar) throws IOException {
        cVar.d();
        t0.a aVarC = null;
        t0.a aVarC2 = null;
        t0.b bVarF = null;
        t0.b bVarF2 = null;
        while (cVar.o()) {
            int iE0 = cVar.e0(f19892b);
            if (iE0 == 0) {
                aVarC = d.c(cVar, gVar);
            } else if (iE0 == 1) {
                aVarC2 = d.c(cVar, gVar);
            } else if (iE0 == 2) {
                bVarF = d.f(cVar, gVar, true);
            } else if (iE0 != 3) {
                cVar.f0();
                cVar.g0();
            } else {
                bVarF2 = d.f(cVar, gVar, true);
            }
        }
        cVar.k();
        return new t0.k(aVarC, aVarC2, bVarF, bVarF2);
    }
}
