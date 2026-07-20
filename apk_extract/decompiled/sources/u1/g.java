package u1;

import android.graphics.Path;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import k3.od;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f5.a f10290a = f5.a.g("ty", "d");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:114:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:16:0x0044  */
    public static r1.b a(v1.e eVar, j1.j jVar) throws v1.b, EOFException {
        q1.a aVarD;
        String strO;
        r1.b aVar;
        q1.a aVarD2;
        String strO2;
        r1.b sVar;
        String strO3;
        String strO4;
        boolean zK = false;
        eVar.c();
        int iM = 2;
        while (true) {
            aVarD = null;
            aVar = null;
            strO4 = null;
            aVar = null;
            strO3 = null;
            strO2 = null;
            aVarD2 = null;
            if (!eVar.i()) {
                strO = null;
                break;
            }
            int iW = eVar.w(f10290a);
            if (iW == 0) {
                strO = eVar.o();
                break;
            }
            if (iW != 1) {
                eVar.A();
                eVar.B();
            } else {
                iM = eVar.m();
            }
        }
        if (strO == null) {
            return null;
        }
        switch (strO) {
            case "el":
                f5.a aVar2 = e.f10282a;
                boolean z2 = iM == 3;
                boolean zK2 = false;
                String strO5 = null;
                q1.e eVarB = null;
                q1.a aVarE = null;
                while (eVar.i()) {
                    int iW2 = eVar.w(e.f10282a);
                    if (iW2 == 0) {
                        strO5 = eVar.o();
                    } else if (iW2 == 1) {
                        eVarB = a.b(eVar, jVar);
                    } else if (iW2 == 2) {
                        aVarE = od.e(eVar, jVar);
                    } else if (iW2 == 3) {
                        zK2 = eVar.k();
                    } else if (iW2 != 4) {
                        eVar.A();
                        eVar.B();
                    } else {
                        z2 = eVar.m() == 3;
                    }
                }
                aVar = new r1.a(strO5, eVarB, aVarE, z2, zK2);
                break;
            case "fl":
                f5.a aVar3 = a0.f10270a;
                boolean zK3 = false;
                boolean zK4 = false;
                int iM2 = 1;
                String strO6 = null;
                q1.a aVarA = null;
                while (eVar.i()) {
                    int iW3 = eVar.w(a0.f10270a);
                    if (iW3 == 0) {
                        strO6 = eVar.o();
                    } else if (iW3 == 1) {
                        aVarA = od.a(eVar, jVar);
                    } else if (iW3 == 2) {
                        aVarD = od.d(eVar, jVar);
                    } else if (iW3 == 3) {
                        zK3 = eVar.k();
                    } else if (iW3 == 4) {
                        iM2 = eVar.m();
                    } else if (iW3 != 5) {
                        eVar.A();
                        eVar.B();
                    } else {
                        zK4 = eVar.k();
                    }
                }
                aVar = new r1.r(strO6, zK3, iM2 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVarA, aVarD == null ? new q1.a(Collections.singletonList(new x1.a(100)), 2) : aVarD, zK4);
                break;
            case "gf":
                f5.a aVar4 = l.f10301a;
                Path.FillType fillType = Path.FillType.WINDING;
                boolean zK5 = false;
                String strO7 = null;
                r1.f fVar = null;
                q1.a aVarC = null;
                q1.a aVarE2 = null;
                q1.a aVarE3 = null;
                while (eVar.i()) {
                    switch (eVar.w(l.f10301a)) {
                        case 0:
                            strO7 = eVar.o();
                            break;
                        case 1:
                            eVar.c();
                            int iM3 = -1;
                            while (eVar.i()) {
                                int iW4 = eVar.w(l.f10302b);
                                if (iW4 == 0) {
                                    iM3 = eVar.m();
                                } else if (iW4 != 1) {
                                    eVar.A();
                                    eVar.B();
                                } else {
                                    aVarC = od.c(eVar, jVar, iM3);
                                }
                            }
                            eVar.h();
                            break;
                        case 2:
                            aVarD2 = od.d(eVar, jVar);
                            break;
                        case 3:
                            fVar = eVar.m() == 1 ? r1.f.LINEAR : r1.f.RADIAL;
                            break;
                        case 4:
                            aVarE2 = od.e(eVar, jVar);
                            break;
                        case 5:
                            aVarE3 = od.e(eVar, jVar);
                            break;
                        case 6:
                            fillType = eVar.m() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                            break;
                        case 7:
                            zK5 = eVar.k();
                            break;
                        default:
                            eVar.A();
                            eVar.B();
                            break;
                    }
                }
                aVar = new r1.d(strO7, fVar, fillType, aVarC, aVarD2 == null ? new q1.a(Collections.singletonList(new x1.a(100)), 2) : aVarD2, aVarE2, aVarE3, zK5);
                break;
            case "gr":
                f5.a aVar5 = b0.f10274a;
                ArrayList arrayList = new ArrayList();
                while (eVar.i()) {
                    int iW5 = eVar.w(b0.f10274a);
                    if (iW5 == 0) {
                        strO2 = eVar.o();
                    } else if (iW5 == 1) {
                        zK = eVar.k();
                    } else if (iW5 != 2) {
                        eVar.B();
                    } else {
                        eVar.a();
                        while (eVar.i()) {
                            r1.b bVarA = a(eVar, jVar);
                            if (bVarA != null) {
                                arrayList.add(bVarA);
                            }
                        }
                        eVar.g();
                    }
                }
                sVar = new r1.s(strO2, zK, arrayList);
                aVar = sVar;
                break;
            case "gs":
                f5.a aVar6 = m.f10303a;
                ArrayList arrayList2 = new ArrayList();
                boolean zK6 = false;
                q1.a aVarD3 = null;
                String strO8 = null;
                r1.f fVar2 = null;
                q1.a aVarC2 = null;
                q1.a aVarE4 = null;
                q1.a aVarE5 = null;
                q1.b bVarB = null;
                r1.v vVar = null;
                r1.w wVar = null;
                q1.b bVar = null;
                float fL = 0.0f;
                while (eVar.i()) {
                    switch (eVar.w(m.f10303a)) {
                        case 0:
                            strO8 = eVar.o();
                            break;
                        case 1:
                            eVar.c();
                            int iM4 = -1;
                            while (eVar.i()) {
                                int iW6 = eVar.w(m.f10304b);
                                if (iW6 == 0) {
                                    iM4 = eVar.m();
                                } else if (iW6 != 1) {
                                    eVar.A();
                                    eVar.B();
                                } else {
                                    aVarC2 = od.c(eVar, jVar, iM4);
                                }
                            }
                            eVar.h();
                            break;
                        case 2:
                            aVarD3 = od.d(eVar, jVar);
                            break;
                        case 3:
                            fVar2 = eVar.m() == 1 ? r1.f.LINEAR : r1.f.RADIAL;
                            break;
                        case 4:
                            aVarE4 = od.e(eVar, jVar);
                            break;
                        case 5:
                            aVarE5 = od.e(eVar, jVar);
                            break;
                        case 6:
                            bVarB = od.b(eVar, jVar, true);
                            break;
                        case 7:
                            vVar = r1.v.values()[eVar.m() - 1];
                            break;
                        case 8:
                            wVar = r1.w.values()[eVar.m() - 1];
                            break;
                        case 9:
                            fL = (float) eVar.l();
                            break;
                        case 10:
                            zK6 = eVar.k();
                            break;
                        case 11:
                            eVar.a();
                            while (eVar.i()) {
                                eVar.c();
                                String strO9 = null;
                                q1.b bVarB2 = null;
                                while (eVar.i()) {
                                    int iW7 = eVar.w(m.f10305c);
                                    if (iW7 == 0) {
                                        strO9 = eVar.o();
                                    } else if (iW7 != 1) {
                                        eVar.A();
                                        eVar.B();
                                    } else {
                                        bVarB2 = od.b(eVar, jVar, true);
                                    }
                                }
                                eVar.h();
                                if (strO9.equals("o")) {
                                    bVar = bVarB2;
                                } else if (strO9.equals("d") || strO9.equals("g")) {
                                    jVar.f5976o = true;
                                    arrayList2.add(bVarB2);
                                }
                            }
                            eVar.g();
                            if (arrayList2.size() == 1) {
                                arrayList2.add((q1.b) arrayList2.get(0));
                            }
                            break;
                        default:
                            eVar.A();
                            eVar.B();
                            break;
                    }
                }
                aVar = new r1.e(strO8, fVar2, aVarC2, aVarD3 == null ? new q1.a(Collections.singletonList(new x1.a(100)), 2) : aVarD3, aVarE4, aVarE5, bVarB, vVar, wVar, fL, arrayList2, bVar, zK6);
                break;
            case "mm":
                f5.a aVar7 = u.f10320a;
                r1.k kVarForId = null;
                while (eVar.i()) {
                    int iW8 = eVar.w(u.f10320a);
                    if (iW8 == 0) {
                        strO3 = eVar.o();
                    } else if (iW8 == 1) {
                        kVarForId = r1.k.forId(eVar.m());
                    } else if (iW8 != 2) {
                        eVar.A();
                        eVar.B();
                    } else {
                        zK = eVar.k();
                    }
                }
                r1.l lVar = new r1.l(strO3, kVarForId, zK);
                jVar.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                aVar = lVar;
                break;
            case "rc":
                f5.a aVar8 = w.f10322a;
                boolean zK7 = false;
                String strO10 = null;
                q1.e eVarB2 = null;
                q1.a aVarE6 = null;
                q1.b bVarB3 = null;
                while (eVar.i()) {
                    int iW9 = eVar.w(w.f10322a);
                    if (iW9 == 0) {
                        strO10 = eVar.o();
                    } else if (iW9 == 1) {
                        eVarB2 = a.b(eVar, jVar);
                    } else if (iW9 == 2) {
                        aVarE6 = od.e(eVar, jVar);
                    } else if (iW9 == 3) {
                        bVarB3 = od.b(eVar, jVar, true);
                    } else if (iW9 != 4) {
                        eVar.B();
                    } else {
                        zK7 = eVar.k();
                    }
                }
                aVar = new r1.o(strO10, eVarB2, aVarE6, bVarB3, zK7);
                break;
            case "rd":
                f5.a aVar9 = y.f10324a;
                String strO11 = null;
                q1.b bVarB4 = null;
                while (eVar.i()) {
                    int iW10 = eVar.w(y.f10324a);
                    if (iW10 == 0) {
                        strO11 = eVar.o();
                    } else if (iW10 == 1) {
                        bVarB4 = od.b(eVar, jVar, true);
                    } else if (iW10 != 2) {
                        eVar.B();
                    } else {
                        zK = eVar.k();
                    }
                }
                if (!zK) {
                    aVar = new r1.p(strO11, bVarB4);
                    break;
                }
                break;
            case "rp":
                f5.a aVar10 = x.f10323a;
                boolean zK8 = false;
                String strO12 = null;
                q1.b bVarB5 = null;
                q1.b bVarB6 = null;
                q1.d dVarA = null;
                while (eVar.i()) {
                    int iW11 = eVar.w(x.f10323a);
                    if (iW11 == 0) {
                        strO12 = eVar.o();
                    } else if (iW11 == 1) {
                        bVarB5 = od.b(eVar, jVar, false);
                    } else if (iW11 == 2) {
                        bVarB6 = od.b(eVar, jVar, false);
                    } else if (iW11 == 3) {
                        dVarA = c.a(eVar, jVar);
                    } else if (iW11 != 4) {
                        eVar.B();
                    } else {
                        zK8 = eVar.k();
                    }
                }
                aVar = new r1.o(strO12, bVarB5, bVarB6, dVarA, zK8);
                break;
            case "sh":
                f5.a aVar11 = c0.f10277a;
                int iM5 = 0;
                boolean zK9 = false;
                q1.a aVar12 = null;
                while (eVar.i()) {
                    int iW12 = eVar.w(c0.f10277a);
                    if (iW12 == 0) {
                        strO4 = eVar.o();
                    } else if (iW12 == 1) {
                        iM5 = eVar.m();
                    } else if (iW12 == 2) {
                        aVar12 = new q1.a(q.a(eVar, jVar, w1.g.c(), z.f10325a, false), 5);
                    } else if (iW12 != 3) {
                        eVar.B();
                    } else {
                        zK9 = eVar.k();
                    }
                }
                sVar = new r1.t(strO4, iM5, aVar12, zK9);
                aVar = sVar;
                break;
            case "sr":
                f5.a aVar13 = v.f10321a;
                boolean z3 = iM == 3;
                boolean zK10 = false;
                String strO13 = null;
                r1.m mVarForValue = null;
                q1.b bVarB7 = null;
                q1.e eVarB3 = null;
                q1.b bVarB8 = null;
                q1.b bVarB9 = null;
                q1.b bVarB10 = null;
                q1.b bVarB11 = null;
                q1.b bVarB12 = null;
                while (eVar.i()) {
                    switch (eVar.w(v.f10321a)) {
                        case 0:
                            strO13 = eVar.o();
                            break;
                        case 1:
                            mVarForValue = r1.m.forValue(eVar.m());
                            break;
                        case 2:
                            bVarB7 = od.b(eVar, jVar, false);
                            break;
                        case 3:
                            eVarB3 = a.b(eVar, jVar);
                            break;
                        case 4:
                            bVarB8 = od.b(eVar, jVar, false);
                            break;
                        case 5:
                            bVarB10 = od.b(eVar, jVar, true);
                            break;
                        case 6:
                            bVarB12 = od.b(eVar, jVar, false);
                            break;
                        case 7:
                            bVarB9 = od.b(eVar, jVar, true);
                            break;
                        case 8:
                            bVarB11 = od.b(eVar, jVar, false);
                            break;
                        case 9:
                            zK10 = eVar.k();
                            break;
                        case 10:
                            z3 = eVar.m() == 3;
                            break;
                        default:
                            eVar.A();
                            eVar.B();
                            break;
                    }
                }
                aVar = new r1.n(strO13, mVarForValue, bVarB7, eVarB3, bVarB8, bVarB9, bVarB10, bVarB11, bVarB12, zK10, z3);
                break;
            case "st":
                f5.a aVar14 = d0.f10280a;
                ArrayList arrayList3 = new ArrayList();
                boolean zK11 = false;
                q1.a aVarD4 = null;
                r1.v vVar2 = null;
                r1.w wVar2 = null;
                String strO14 = null;
                q1.b bVar2 = null;
                q1.a aVarA2 = null;
                q1.b bVarB13 = null;
                float fL2 = 0.0f;
                while (eVar.i()) {
                    switch (eVar.w(d0.f10280a)) {
                        case 0:
                            strO14 = eVar.o();
                            break;
                        case 1:
                            aVarA2 = od.a(eVar, jVar);
                            break;
                        case 2:
                            bVarB13 = od.b(eVar, jVar, true);
                            break;
                        case 3:
                            aVarD4 = od.d(eVar, jVar);
                            break;
                        case 4:
                            vVar2 = r1.v.values()[eVar.m() - 1];
                            break;
                        case 5:
                            wVar2 = r1.w.values()[eVar.m() - 1];
                            break;
                        case 6:
                            fL2 = (float) eVar.l();
                            break;
                        case 7:
                            zK11 = eVar.k();
                            break;
                        case 8:
                            eVar.a();
                            while (eVar.i()) {
                                eVar.c();
                                String strO15 = null;
                                q1.b bVarB14 = null;
                                while (eVar.i()) {
                                    int iW13 = eVar.w(d0.f10281b);
                                    if (iW13 == 0) {
                                        strO15 = eVar.o();
                                    } else if (iW13 != 1) {
                                        eVar.A();
                                        eVar.B();
                                    } else {
                                        bVarB14 = od.b(eVar, jVar, true);
                                    }
                                }
                                eVar.h();
                                strO15.getClass();
                                switch (strO15) {
                                    case "d":
                                    case "g":
                                        jVar.f5976o = true;
                                        arrayList3.add(bVarB14);
                                        break;
                                    case "o":
                                        bVar2 = bVarB14;
                                        break;
                                }
                            }
                            eVar.g();
                            if (arrayList3.size() == 1) {
                                arrayList3.add((q1.b) arrayList3.get(0));
                            }
                            break;
                        default:
                            eVar.B();
                            break;
                    }
                }
                aVar = new r1.x(strO14, bVar2, arrayList3, aVarA2, aVarD4 == null ? new q1.a(Collections.singletonList(new x1.a(100)), 2) : aVarD4, bVarB13, vVar2 == null ? r1.v.BUTT : vVar2, wVar2 == null ? r1.w.MITER : wVar2, fL2, zK11);
                break;
            case "tm":
                f5.a aVar15 = e0.f10283a;
                boolean zK12 = false;
                String strO16 = null;
                r1.y yVarForId = null;
                q1.b bVarB15 = null;
                q1.b bVarB16 = null;
                q1.b bVarB17 = null;
                while (eVar.i()) {
                    int iW14 = eVar.w(e0.f10283a);
                    if (iW14 == 0) {
                        bVarB15 = od.b(eVar, jVar, false);
                    } else if (iW14 == 1) {
                        bVarB16 = od.b(eVar, jVar, false);
                    } else if (iW14 == 2) {
                        bVarB17 = od.b(eVar, jVar, false);
                    } else if (iW14 == 3) {
                        strO16 = eVar.o();
                    } else if (iW14 == 4) {
                        yVarForId = r1.y.forId(eVar.m());
                    } else if (iW14 != 5) {
                        eVar.B();
                    } else {
                        zK12 = eVar.k();
                    }
                }
                aVar = new r1.o(strO16, yVarForId, bVarB15, bVarB16, bVarB17, zK12);
                break;
            case "tr":
                aVar = c.a(eVar, jVar);
                break;
            default:
                w1.b.b("Unknown shape type ".concat(strO));
                break;
        }
        while (eVar.i()) {
            eVar.B();
        }
        eVar.h();
        return aVar;
    }
}
