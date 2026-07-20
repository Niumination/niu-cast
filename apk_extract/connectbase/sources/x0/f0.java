package x0;

import android.graphics.Path;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0.c.a f19902a = y0.c.a.a("nm", "c", p6.o.f13007a, "fillEnabled", "r", "hd");

    public static u0.m a(y0.c cVar, n0.g gVar) throws IOException {
        t0.d dVar = null;
        String strA = null;
        t0.a aVarC = null;
        boolean zP = false;
        boolean zP2 = false;
        int iT = 1;
        while (cVar.o()) {
            int iE0 = cVar.e0(f19902a);
            if (iE0 == 0) {
                strA = cVar.A();
            } else if (iE0 == 1) {
                aVarC = d.c(cVar, gVar);
            } else if (iE0 == 2) {
                dVar = d.h(cVar, gVar);
            } else if (iE0 == 3) {
                zP = cVar.p();
            } else if (iE0 == 4) {
                iT = cVar.t();
            } else if (iE0 != 5) {
                cVar.f0();
                cVar.g0();
            } else {
                zP2 = cVar.p();
            }
        }
        if (dVar == null) {
            dVar = new t0.d(Collections.singletonList(new a1.a(100)));
        }
        return new u0.m(strA, zP, iT == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVarC, dVar, zP2);
    }
}
