package x0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static y0.c.a f19918a = y0.c.a.a("nm", "g", p6.o.f13007a, "t", p6.s.f13016a, "e", p6.w.f13020a, "lc", "lj", "ml", "hd", "d");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y0.c.a f19919b = y0.c.a.a("p", "k");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y0.c.a f19920c = y0.c.a.a(p6.n.f13005a, "v");

    public static u0.e a(y0.c cVar, n0.g gVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        float fQ = 0.0f;
        String strA = null;
        u0.f fVar = null;
        t0.c cVarG = null;
        t0.f fVarI = null;
        t0.f fVarI2 = null;
        t0.b bVarF = null;
        u0.p.b bVar = null;
        u0.p.c cVar2 = null;
        t0.b bVar2 = null;
        boolean zP = false;
        t0.d dVar = null;
        while (cVar.o()) {
            switch (cVar.e0(f19918a)) {
                case 0:
                    strA = cVar.A();
                    continue;
                case 1:
                    cVar.d();
                    int iT = -1;
                    while (cVar.o()) {
                        int iE0 = cVar.e0(f19919b);
                        if (iE0 == 0) {
                            iT = cVar.t();
                        } else if (iE0 != 1) {
                            cVar.f0();
                            cVar.g0();
                        } else {
                            cVarG = d.g(cVar, gVar, iT);
                        }
                        cVarG = cVarG;
                    }
                    cVar.k();
                    break;
                case 2:
                    dVar = d.h(cVar, gVar);
                    continue;
                case 3:
                    fVar = cVar.t() == 1 ? u0.f.LINEAR : u0.f.RADIAL;
                    break;
                case 4:
                    fVarI = d.i(cVar, gVar);
                    continue;
                case 5:
                    fVarI2 = d.i(cVar, gVar);
                    continue;
                case 6:
                    bVarF = d.f(cVar, gVar, true);
                    break;
                case 7:
                    bVar = u0.p.b.values()[cVar.t() - 1];
                    break;
                case 8:
                    cVar2 = u0.p.c.values()[cVar.t() - 1];
                    break;
                case 9:
                    fQ = (float) cVar.q();
                    break;
                case 10:
                    zP = cVar.p();
                    continue;
                case 11:
                    cVar.c();
                    while (cVar.o()) {
                        cVar.d();
                        String strA2 = null;
                        t0.b bVarF2 = null;
                        while (cVar.o()) {
                            int iE1 = cVar.e0(f19920c);
                            if (iE1 != 0) {
                                t0.b bVar3 = bVar2;
                                if (iE1 != 1) {
                                    cVar.f0();
                                    cVar.g0();
                                } else {
                                    bVarF2 = d.f(cVar, gVar, true);
                                }
                                bVar2 = bVar3;
                            } else {
                                strA2 = cVar.A();
                            }
                        }
                        t0.b bVar4 = bVar2;
                        cVar.k();
                        if (strA2.equals(p6.o.f13007a)) {
                            bVar2 = bVarF2;
                        } else {
                            if (strA2.equals("d") || strA2.equals("g")) {
                                gVar.w(true);
                                arrayList.add(bVarF2);
                            }
                            bVar2 = bVar4;
                        }
                    }
                    t0.b bVar5 = bVar2;
                    cVar.h();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    bVar2 = bVar5;
                    continue;
                default:
                    cVar.f0();
                    cVar.g0();
                    continue;
            }
            strA = strA;
        }
        String str = strA;
        if (dVar == null) {
            dVar = new t0.d(Collections.singletonList(new a1.a(100)));
        }
        return new u0.e(str, fVar, cVarG, dVar, fVarI, fVarI2, bVarF, bVar, cVar2, fQ, arrayList, bVar2, zP);
    }
}
