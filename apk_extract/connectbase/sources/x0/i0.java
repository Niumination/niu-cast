package x0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static y0.c.a f19909a = y0.c.a.a("nm", "c", p6.w.f13020a, p6.o.f13007a, "lc", "lj", "ml", "hd", "d");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y0.c.a f19910b = y0.c.a.a(p6.n.f13005a, "v");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:22:0x0063  */
    public static u0.p a(y0.c cVar, n0.g gVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        float fQ = 0.0f;
        String strA = null;
        t0.b bVar = null;
        t0.a aVarC = null;
        t0.b bVarF = null;
        u0.p.b bVar2 = null;
        u0.p.c cVar2 = null;
        boolean zP = false;
        t0.d dVar = null;
        while (cVar.o()) {
            switch (cVar.e0(f19909a)) {
                case 0:
                    strA = cVar.A();
                    continue;
                case 1:
                    aVarC = d.c(cVar, gVar);
                    continue;
                case 2:
                    bVarF = d.f(cVar, gVar, true);
                    break;
                case 3:
                    dVar = d.h(cVar, gVar);
                    continue;
                case 4:
                    bVar2 = u0.p.b.values()[cVar.t() - 1];
                    break;
                case 5:
                    cVar2 = u0.p.c.values()[cVar.t() - 1];
                    break;
                case 6:
                    fQ = (float) cVar.q();
                    break;
                case 7:
                    zP = cVar.p();
                    continue;
                case 8:
                    cVar.c();
                    while (cVar.o()) {
                        cVar.d();
                        t0.b bVarF2 = null;
                        String strA2 = null;
                        while (cVar.o()) {
                            int iE0 = cVar.e0(f19910b);
                            if (iE0 == 0) {
                                strA2 = cVar.A();
                            } else if (iE0 != 1) {
                                cVar.f0();
                                cVar.g0();
                            } else {
                                bVarF2 = d.f(cVar, gVar, true);
                            }
                        }
                        cVar.k();
                        strA2.getClass();
                        switch (strA2) {
                            case "d":
                            case "g":
                                gVar.w(true);
                                arrayList.add(bVarF2);
                                break;
                            case "o":
                                bVar = bVarF2;
                                break;
                        }
                    }
                    cVar.h();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    } else {
                        continue;
                    }
                    break;
                default:
                    cVar.g0();
                    continue;
            }
            strA = strA;
        }
        String str = strA;
        if (dVar == null) {
            dVar = new t0.d(Collections.singletonList(new a1.a(100)));
        }
        return new u0.p(str, bVar, arrayList, aVarC, dVar, bVarF, bVar2, cVar2, fQ, zP);
    }
}
