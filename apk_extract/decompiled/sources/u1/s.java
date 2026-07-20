package u1;

import af.r5;
import android.graphics.Color;
import android.view.animation.Interpolator;
import com.transsion.message.bank.MessageBank;
import java.util.ArrayList;
import java.util.Collections;
import k3.od;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f5.a f10313a = f5.a.g("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", MessageBank.KEY_OP, "tm", "cl", "hd", "ao", "bm");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f5.a f10314b = f5.a.g("d", "a");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f5.a f10315c = f5.a.g("ty", "nm");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:196:0x038c  */
    /* JADX WARN: Code duplicated, block: B:197:0x038f  */
    /* JADX WARN: Code duplicated, block: B:231:0x0464  */
    /* JADX WARN: Code duplicated, block: B:253:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:89:0x01e0  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v47 */
    public static s1.i a(v1.e eVar, j1.j jVar) {
        q1.d dVar;
        String str;
        boolean z2;
        String str2;
        s1.g gVar;
        q1.b bVar;
        q1.b bVar2;
        q1.b bVar3;
        q1.b bVar4;
        ?? r7;
        boolean z3 = true;
        s1.h hVar = s1.h.NONE;
        r1.h hVar2 = r1.h.NORMAL;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        eVar.c();
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        String strO = "UNSET";
        long jM = 0;
        boolean z5 = false;
        long jM2 = -1;
        int iC = 0;
        int iC2 = 0;
        int color = 0;
        boolean zK = false;
        boolean z10 = false;
        s1.h hVar3 = hVar;
        r1.h hVar4 = hVar2;
        float fL = 0.0f;
        float fL2 = 0.0f;
        float fL3 = 0.0f;
        float fL4 = 0.0f;
        float fL5 = 0.0f;
        float fL6 = 1.0f;
        String strO2 = null;
        s1.g gVar2 = null;
        String strO3 = null;
        q1.a aVar = null;
        tc.d dVar2 = null;
        q1.b bVarB = null;
        o5.c cVar = null;
        r5 r5Var = null;
        q1.d dVar3 = null;
        while (eVar.i()) {
            switch (eVar.w(f10313a)) {
                case 0:
                    gVar2 = gVar2;
                    z5 = z5;
                    strO = eVar.o();
                    z5 = z5;
                    gVar2 = gVar2;
                    break;
                case 1:
                    jM = eVar.m();
                    z3 = z3;
                    z5 = z5;
                    gVar2 = gVar2;
                    break;
                case 2:
                    gVar2 = gVar2;
                    z5 = z5;
                    strO3 = eVar.o();
                    z5 = z5;
                    gVar2 = gVar2;
                    break;
                case 3:
                    boolean z11 = z5;
                    boolean z12 = z3;
                    String str3 = strO2;
                    int iM = eVar.m();
                    s1.g gVar3 = s1.g.UNKNOWN;
                    if (iM >= gVar3.ordinal()) {
                        strO2 = str3;
                        z3 = z12;
                        z5 = z11;
                        gVar2 = gVar3;
                    } else {
                        z3 = z12;
                        z5 = z11;
                        strO2 = str3;
                        gVar2 = s1.g.values()[iM];
                    }
                    break;
                case 4:
                    jM2 = eVar.m();
                    z3 = z3;
                    z5 = z5;
                    gVar2 = gVar2;
                    break;
                case 5:
                    iC = (int) (w1.g.c() * eVar.m());
                    z3 = z3;
                    z5 = z5;
                    gVar2 = gVar2;
                    break;
                case 6:
                    iC2 = (int) (w1.g.c() * eVar.m());
                    z3 = z3;
                    z5 = z5;
                    gVar2 = gVar2;
                    break;
                case 7:
                    gVar2 = gVar2;
                    z5 = z5;
                    color = Color.parseColor(eVar.o());
                    z5 = z5;
                    gVar2 = gVar2;
                    break;
                case 8:
                    gVar2 = gVar2;
                    z5 = z5;
                    dVar3 = c.a(eVar, jVar);
                    z5 = z5;
                    gVar2 = gVar2;
                    break;
                case 9:
                    str = strO2;
                    gVar2 = gVar2;
                    z2 = z5;
                    int iM2 = eVar.m();
                    if (iM2 < s1.h.values().length) {
                        hVar3 = s1.h.values()[iM2];
                        int i8 = r.f10312a[hVar3.ordinal()];
                        if (i8 == 1) {
                            jVar.a("Unsupported matte type: Luma");
                        } else if (i8 == 2) {
                            jVar.a("Unsupported matte type: Luma Inverted");
                        }
                        jVar.p++;
                        z3 = true;
                        z5 = z2;
                        strO2 = str;
                        gVar2 = gVar2;
                    } else {
                        jVar.a("Unsupported matte type: " + iM2);
                        z5 = z2;
                        strO2 = str;
                        gVar2 = gVar2;
                        z3 = true;
                    }
                    break;
                case 10:
                    str = strO2;
                    gVar2 = gVar2;
                    eVar.a();
                    while (eVar.i()) {
                        eVar.c();
                        r1.i iVar = null;
                        q1.a aVar2 = null;
                        q1.a aVarD = null;
                        boolean zK2 = false;
                        while (eVar.i()) {
                            String strS = eVar.S();
                            strS.getClass();
                            switch (strS) {
                                case "o":
                                    aVarD = od.d(eVar, jVar);
                                    break;
                                case "pt":
                                    aVar2 = new q1.a(q.a(eVar, jVar, w1.g.c(), z.f10325a, false), 5);
                                    break;
                                case "inv":
                                    zK2 = eVar.k();
                                    break;
                                case "mode":
                                    String strO4 = eVar.o();
                                    strO4.getClass();
                                    switch (strO4) {
                                        case "a":
                                            iVar = r1.i.MASK_MODE_ADD;
                                            break;
                                        case "i":
                                            jVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                                            iVar = r1.i.MASK_MODE_INTERSECT;
                                            break;
                                        case "n":
                                            iVar = r1.i.MASK_MODE_NONE;
                                            break;
                                        case "s":
                                            iVar = r1.i.MASK_MODE_SUBTRACT;
                                            break;
                                        default:
                                            w1.b.b("Unknown mask mode " + strS + ". Defaulting to Add.");
                                            iVar = r1.i.MASK_MODE_ADD;
                                            break;
                                    }
                                    break;
                                default:
                                    eVar.B();
                                    break;
                            }
                        }
                        eVar.h();
                        arrayList.add(new r1.j(iVar, aVar2, aVarD, zK2));
                    }
                    z2 = false;
                    jVar.p += arrayList.size();
                    eVar.g();
                    z5 = z2;
                    strO2 = str;
                    gVar2 = gVar2;
                    z3 = true;
                    break;
                case 11:
                    str = strO2;
                    gVar2 = gVar2;
                    eVar.a();
                    while (eVar.i()) {
                        r1.b bVarA = g.a(eVar, jVar);
                        if (bVarA != null) {
                            arrayList2.add(bVarA);
                        }
                    }
                    eVar.g();
                    z2 = false;
                    z5 = z2;
                    strO2 = str;
                    gVar2 = gVar2;
                    z3 = true;
                    break;
                case 12:
                    String str4 = strO2;
                    eVar.c();
                    while (eVar.i()) {
                        int iW = eVar.w(f10314b);
                        if (iW == 0) {
                            str2 = str4;
                            gVar = gVar2;
                            aVar = new q1.a(q.a(eVar, jVar, w1.g.c(), h.f10291a, false), 6);
                        } else if (iW != 1) {
                            eVar.A();
                            eVar.B();
                        } else {
                            eVar.a();
                            if (eVar.i()) {
                                f5.a aVar3 = b.f10271a;
                                eVar.c();
                                r5 r5Var2 = null;
                                dj.m mVar = null;
                                while (eVar.i()) {
                                    int iW2 = eVar.w(b.f10271a);
                                    if (iW2 == 0) {
                                        eVar.c();
                                        r1.z zVar = null;
                                        q1.a aVar4 = null;
                                        q1.a aVarD2 = null;
                                        q1.a aVarD3 = null;
                                        while (eVar.i()) {
                                            int iW3 = eVar.w(b.f10272b);
                                            if (iW3 != 0) {
                                                String str5 = str4;
                                                if (iW3 == 1) {
                                                    aVarD2 = od.d(eVar, jVar);
                                                } else if (iW3 == 2) {
                                                    aVarD3 = od.d(eVar, jVar);
                                                } else if (iW3 != 3) {
                                                    eVar.A();
                                                    eVar.B();
                                                } else {
                                                    int iM3 = eVar.m();
                                                    int i9 = 1;
                                                    if (iM3 == 1) {
                                                        if (iM3 == i9) {
                                                            zVar = r1.z.PERCENT;
                                                        } else {
                                                            zVar = r1.z.INDEX;
                                                        }
                                                    } else if (iM3 != 2) {
                                                        jVar.a("Unsupported text range units: " + iM3);
                                                        zVar = r1.z.INDEX;
                                                    } else {
                                                        i9 = 1;
                                                        if (iM3 == i9) {
                                                            zVar = r1.z.PERCENT;
                                                        } else {
                                                            zVar = r1.z.INDEX;
                                                        }
                                                    }
                                                }
                                                str4 = str5;
                                            } else {
                                                aVar4 = od.d(eVar, jVar);
                                            }
                                        }
                                        String str6 = str4;
                                        eVar.h();
                                        if (aVar4 == null && aVarD2 != null) {
                                            aVar4 = new q1.a(Collections.singletonList(new x1.a(0)), 2);
                                        }
                                        mVar = new dj.m(aVar4, aVarD2, aVarD3, zVar);
                                        str4 = str6;
                                        gVar2 = gVar2;
                                    } else if (iW2 != 1) {
                                        eVar.A();
                                        eVar.B();
                                    } else {
                                        eVar.c();
                                        q1.a aVarA = null;
                                        q1.a aVarA2 = null;
                                        q1.b bVarB2 = null;
                                        q1.b bVarB3 = null;
                                        q1.a aVarD4 = null;
                                        while (eVar.i()) {
                                            int iW4 = eVar.w(b.f10273c);
                                            if (iW4 == 0) {
                                                aVarA = od.a(eVar, jVar);
                                            } else if (iW4 == 1) {
                                                aVarA2 = od.a(eVar, jVar);
                                            } else if (iW4 == 2) {
                                                bVarB2 = od.b(eVar, jVar, true);
                                            } else if (iW4 == 3) {
                                                bVarB3 = od.b(eVar, jVar, true);
                                            } else if (iW4 != 4) {
                                                eVar.A();
                                                eVar.B();
                                            } else {
                                                aVarD4 = od.d(eVar, jVar);
                                            }
                                        }
                                        eVar.h();
                                        r5Var2 = new r5(aVarA, aVarA2, bVarB2, bVarB3, aVarD4, 10);
                                    }
                                }
                                str2 = str4;
                                gVar = gVar2;
                                eVar.h();
                                tc.d dVar4 = new tc.d();
                                dVar4.f10209a = r5Var2;
                                dVar4.f10210b = mVar;
                                dVar2 = dVar4;
                            } else {
                                str2 = str4;
                                gVar = gVar2;
                            }
                            while (eVar.i()) {
                                eVar.B();
                            }
                            eVar.g();
                        }
                        str4 = str2;
                        gVar2 = gVar;
                    }
                    eVar.h();
                    strO2 = str4;
                    z5 = false;
                    z3 = true;
                    break;
                case 13:
                    String str7 = strO2;
                    eVar.a();
                    ArrayList arrayList3 = new ArrayList();
                    while (eVar.i()) {
                        eVar.c();
                        while (eVar.i()) {
                            int iW5 = eVar.w(f10315c);
                            if (iW5 == 0) {
                                int iM4 = eVar.m();
                                if (iM4 == 29) {
                                    f5.a aVar5 = d.f10278a;
                                    cVar = null;
                                    while (eVar.i()) {
                                        if (eVar.w(d.f10278a) != 0) {
                                            eVar.A();
                                            eVar.B();
                                        } else {
                                            eVar.a();
                                            while (eVar.i()) {
                                                eVar.c();
                                                o5.c cVar2 = null;
                                                while (true) {
                                                    boolean z13 = false;
                                                    while (true) {
                                                        if (eVar.i()) {
                                                            int iW6 = eVar.w(d.f10279b);
                                                            if (iW6 != 0) {
                                                                if (iW6 != z3) {
                                                                    eVar.A();
                                                                    eVar.B();
                                                                } else if (z13) {
                                                                    cVar2 = new o5.c(od.b(eVar, jVar, z3));
                                                                } else {
                                                                    eVar.B();
                                                                }
                                                            } else if (eVar.m() == 0) {
                                                                z13 = z3;
                                                            }
                                                        } else {
                                                            eVar.h();
                                                            if (cVar2 != null) {
                                                                cVar = cVar2;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            eVar.g();
                                        }
                                    }
                                } else if (iM4 == 25) {
                                    i iVar2 = new i();
                                    while (eVar.i()) {
                                        if (eVar.w(i.f) != 0) {
                                            eVar.A();
                                            eVar.B();
                                        } else {
                                            eVar.a();
                                            while (eVar.i()) {
                                                eVar.c();
                                                String strO5 = "";
                                                while (eVar.i()) {
                                                    int iW7 = eVar.w(i.f10293g);
                                                    if (iW7 == 0) {
                                                        strO5 = eVar.o();
                                                    } else if (iW7 == z3) {
                                                        strO5.getClass();
                                                        switch (strO5.hashCode()) {
                                                            case 353103893:
                                                                if (!strO5.equals("Distance")) {
                                                                    r7 = -1;
                                                                } else {
                                                                    r7 = 0;
                                                                }
                                                                break;
                                                            case 397447147:
                                                                if (!strO5.equals("Opacity")) {
                                                                    r7 = -1;
                                                                } else {
                                                                    r7 = z3;
                                                                }
                                                                break;
                                                            case 1041377119:
                                                                if (!strO5.equals("Direction")) {
                                                                    r7 = -1;
                                                                } else {
                                                                    r7 = 2;
                                                                }
                                                                break;
                                                            case 1379387491:
                                                                if (!strO5.equals("Shadow Color")) {
                                                                    r7 = -1;
                                                                } else {
                                                                    r7 = 3;
                                                                }
                                                                break;
                                                            case 1383710113:
                                                                if (!strO5.equals("Softness")) {
                                                                    r7 = -1;
                                                                } else {
                                                                    r7 = 4;
                                                                }
                                                                break;
                                                            default:
                                                                r7 = -1;
                                                                break;
                                                        }
                                                        switch (r7) {
                                                            case 0:
                                                                iVar2.f10297d = od.b(eVar, jVar, z3);
                                                                break;
                                                            case 1:
                                                                iVar2.f10295b = od.b(eVar, jVar, false);
                                                                break;
                                                            case 2:
                                                                iVar2.f10296c = od.b(eVar, jVar, false);
                                                                break;
                                                            case 3:
                                                                iVar2.f10294a = od.a(eVar, jVar);
                                                                break;
                                                            case 4:
                                                                iVar2.e = od.b(eVar, jVar, z3);
                                                                break;
                                                            default:
                                                                eVar.B();
                                                                break;
                                                        }
                                                    } else {
                                                        eVar.A();
                                                        eVar.B();
                                                    }
                                                }
                                                eVar.h();
                                            }
                                            eVar.g();
                                        }
                                    }
                                    q1.a aVar6 = iVar2.f10294a;
                                    r5Var = (aVar6 == null || (bVar = iVar2.f10295b) == null || (bVar2 = iVar2.f10296c) == null || (bVar3 = iVar2.f10297d) == null || (bVar4 = iVar2.e) == null) ? null : new r5(aVar6, bVar, bVar2, bVar3, bVar4, 11);
                                }
                            } else if (iW5 != z3) {
                                eVar.A();
                                eVar.B();
                            } else {
                                arrayList3.add(eVar.o());
                            }
                            z3 = true;
                        }
                        eVar.h();
                        z3 = true;
                    }
                    eVar.g();
                    jVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList3);
                    strO2 = str7;
                    z5 = false;
                    z3 = true;
                    break;
                case 14:
                    fL6 = (float) eVar.l();
                    z5 = false;
                    break;
                case 15:
                    fL2 = (float) eVar.l();
                    z5 = false;
                    break;
                case 16:
                    fL3 = (float) (eVar.l() * ((double) w1.g.c()));
                    strO2 = strO2;
                    z5 = false;
                    break;
                case 17:
                    fL4 = (float) (eVar.l() * ((double) w1.g.c()));
                    strO2 = strO2;
                    z5 = false;
                    break;
                case 18:
                    fL = (float) eVar.l();
                    strO2 = strO2;
                    break;
                case 19:
                    fL5 = (float) eVar.l();
                    strO2 = strO2;
                    break;
                case 20:
                    bVarB = od.b(eVar, jVar, z5);
                    break;
                case 21:
                    strO2 = eVar.o();
                    break;
                case 22:
                    zK = eVar.k();
                    break;
                case 23:
                    z10 = eVar.m() == z3 ? z3 : z5;
                    break;
                case 24:
                    int iM5 = eVar.m();
                    if (iM5 >= r1.h.values().length) {
                        jVar.a("Unsupported Blend Mode: " + iM5);
                        hVar4 = r1.h.NORMAL;
                    } else {
                        hVar4 = r1.h.values()[iM5];
                    }
                    break;
                default:
                    eVar.A();
                    eVar.B();
                    str = strO2;
                    gVar2 = gVar2;
                    z2 = z5;
                    z5 = z2;
                    strO2 = str;
                    gVar2 = gVar2;
                    z3 = true;
                    break;
            }
        }
        String str8 = strO2;
        s1.g gVar4 = gVar2;
        eVar.h();
        ArrayList arrayList4 = new ArrayList();
        if (fL > 0.0f) {
            arrayList4.add(new x1.a(jVar, fValueOf, fValueOf, (Interpolator) null, 0.0f, Float.valueOf(fL)));
        }
        if (fL5 <= 0.0f) {
            fL5 = jVar.f5974m;
        }
        arrayList4.add(new x1.a(jVar, fValueOf2, fValueOf2, (Interpolator) null, fL, Float.valueOf(fL5)));
        arrayList4.add(new x1.a(jVar, fValueOf, fValueOf, (Interpolator) null, fL5, Float.valueOf(Float.MAX_VALUE)));
        if (strO.endsWith(".ai") || "ai".equals(str8)) {
            jVar.a("Convert your Illustrator layers to shape layers.");
        }
        boolean z14 = z10;
        if (z14) {
            if (dVar3 == null) {
                dVar3 = new q1.d();
            }
            q1.d dVar5 = dVar3;
            dVar5.f8940j = z14;
            dVar = dVar5;
        } else {
            dVar = dVar3;
        }
        return new s1.i(arrayList2, jVar, strO, jM, gVar4, jM2, strO3, arrayList, dVar, iC, iC2, color, fL6, fL2, fL3, fL4, aVar, dVar2, arrayList4, hVar3, bVarB, zK, cVar, r5Var, hVar4);
    }
}
