package x0;

import android.graphics.PointF;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0.c.a f19889a = y0.c.a.a("k", "x", "y");

    public static t0.e a(y0.c cVar, n0.g gVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (cVar.O() == y0.c.b.BEGIN_ARRAY) {
            cVar.c();
            while (cVar.o()) {
                arrayList.add(x.a(cVar, gVar));
            }
            cVar.h();
            r.b(arrayList);
        } else {
            arrayList.add(new a1.a(p.e(cVar, z0.h.e())));
        }
        return new t0.e(arrayList);
    }

    public static t0.m<PointF, PointF> b(y0.c cVar, n0.g gVar) throws IOException {
        cVar.d();
        t0.e eVarA = null;
        t0.b bVarF = null;
        boolean z10 = false;
        t0.b bVarF2 = null;
        while (cVar.O() != y0.c.b.END_OBJECT) {
            int iE0 = cVar.e0(f19889a);
            if (iE0 == 0) {
                eVarA = a(cVar, gVar);
            } else if (iE0 != 1) {
                if (iE0 != 2) {
                    cVar.f0();
                    cVar.g0();
                } else if (cVar.O() == y0.c.b.STRING) {
                    cVar.g0();
                    z10 = true;
                } else {
                    bVarF = d.f(cVar, gVar, true);
                }
            } else if (cVar.O() == y0.c.b.STRING) {
                cVar.g0();
                z10 = true;
            } else {
                bVarF2 = d.f(cVar, gVar, true);
            }
        }
        cVar.k();
        if (z10) {
            gVar.a("Lottie doesn't support expressions.");
        }
        return eVarA != null ? eVarA : new t0.i(bVarF2, bVarF);
    }
}
