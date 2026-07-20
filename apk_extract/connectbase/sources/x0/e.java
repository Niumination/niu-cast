package x0;

import android.graphics.PointF;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static y0.c.a f19898a = y0.c.a.a("nm", "p", p6.s.f13016a, "hd", "d");

    public static u0.a a(y0.c cVar, n0.g gVar, int i10) throws IOException {
        boolean z10 = i10 == 3;
        boolean zP = false;
        String strA = null;
        t0.m<PointF, PointF> mVarB = null;
        t0.f fVarI = null;
        while (cVar.o()) {
            int iE0 = cVar.e0(f19898a);
            if (iE0 == 0) {
                strA = cVar.A();
            } else if (iE0 == 1) {
                mVarB = a.b(cVar, gVar);
            } else if (iE0 == 2) {
                fVarI = d.i(cVar, gVar);
            } else if (iE0 == 3) {
                zP = cVar.p();
            } else if (iE0 != 4) {
                cVar.f0();
                cVar.g0();
            } else {
                z10 = cVar.t() == 3;
            }
        }
        return new u0.a(strA, mVarB, fVarI, z10, zP);
    }
}
