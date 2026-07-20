package x0;

import android.graphics.Path;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0.c.a f19916a = y0.c.a.a("nm", "g", p6.o.f13007a, "t", p6.s.f13016a, "e", "r", "hd");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y0.c.a f19917b = y0.c.a.a("p", "k");

    public static u0.d a(y0.c cVar, n0.g gVar) throws IOException {
        t0.d dVarH = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strA = null;
        u0.f fVar = null;
        t0.c cVarG = null;
        t0.f fVarI = null;
        t0.f fVarI2 = null;
        boolean zP = false;
        while (cVar.o()) {
            switch (cVar.e0(f19916a)) {
                case 0:
                    strA = cVar.A();
                    break;
                case 1:
                    cVar.d();
                    int iT = -1;
                    while (cVar.o()) {
                        int iE0 = cVar.e0(f19917b);
                        if (iE0 == 0) {
                            iT = cVar.t();
                        } else if (iE0 != 1) {
                            cVar.f0();
                            cVar.g0();
                        } else {
                            cVarG = d.g(cVar, gVar, iT);
                        }
                    }
                    cVar.k();
                    break;
                case 2:
                    dVarH = d.h(cVar, gVar);
                    break;
                case 3:
                    fVar = cVar.t() == 1 ? u0.f.LINEAR : u0.f.RADIAL;
                    break;
                case 4:
                    fVarI = d.i(cVar, gVar);
                    break;
                case 5:
                    fVarI2 = d.i(cVar, gVar);
                    break;
                case 6:
                    fillType = cVar.t() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    zP = cVar.p();
                    break;
                default:
                    cVar.f0();
                    cVar.g0();
                    break;
            }
        }
        return new u0.d(strA, fVar, fillType, cVarG, dVarH == null ? new t0.d(Collections.singletonList(new a1.a(100))) : dVarH, fVarI, fVarI2, null, null, zP);
    }
}
