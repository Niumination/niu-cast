package x0;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class v {
    public static u0.g a(y0.c cVar, n0.g gVar) throws IOException {
        cVar.d();
        u0.g.a aVar = null;
        t0.h hVarK = null;
        t0.d dVarH = null;
        boolean zP = false;
        while (cVar.o()) {
            String strY = cVar.y();
            strY.getClass();
            switch (strY) {
                case "o":
                    dVarH = d.h(cVar, gVar);
                    break;
                case "pt":
                    hVarK = d.k(cVar, gVar);
                    break;
                case "inv":
                    zP = cVar.p();
                    break;
                case "mode":
                    String strA = cVar.A();
                    strA.getClass();
                    switch (strA) {
                        case "a":
                            aVar = u0.g.a.MASK_MODE_ADD;
                            break;
                        case "i":
                            gVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            aVar = u0.g.a.MASK_MODE_INTERSECT;
                            break;
                        case "n":
                            aVar = u0.g.a.MASK_MODE_NONE;
                            break;
                        case "s":
                            aVar = u0.g.a.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            z0.d.e("Unknown mask mode " + strY + ". Defaulting to Add.");
                            aVar = u0.g.a.MASK_MODE_ADD;
                            break;
                    }
                    break;
                default:
                    cVar.g0();
                    break;
            }
        }
        cVar.k();
        return new u0.g(aVar, hVarK, dVarH, zP);
    }
}
