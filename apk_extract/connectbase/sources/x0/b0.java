package x0;

import android.graphics.PointF;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static y0.c.a f19893a = y0.c.a.a("nm", "p", p6.s.f13016a, "r", "hd");

    public static u0.j a(y0.c cVar, n0.g gVar) throws IOException {
        String strA = null;
        t0.m<PointF, PointF> mVarB = null;
        t0.f fVarI = null;
        t0.b bVarF = null;
        boolean zP = false;
        while (cVar.o()) {
            int iE0 = cVar.e0(f19893a);
            if (iE0 == 0) {
                strA = cVar.A();
            } else if (iE0 == 1) {
                mVarB = a.b(cVar, gVar);
            } else if (iE0 == 2) {
                fVarI = d.i(cVar, gVar);
            } else if (iE0 == 3) {
                bVarF = d.f(cVar, gVar, true);
            } else if (iE0 != 4) {
                cVar.g0();
            } else {
                zP = cVar.p();
            }
        }
        return new u0.j(strA, mVarB, fVarI, bVarF, zP);
    }
}
