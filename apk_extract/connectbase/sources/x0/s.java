package x0;

import android.graphics.Color;
import android.graphics.Rect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0.c.a f19930a = y0.c.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", p6.w.f13020a, "h", "ip", "op", "tm", "cl", "hd");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y0.c.a f19931b = y0.c.a.a("d", "a");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y0.c.a f19932c = y0.c.a.a("nm");

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19933a;

        static {
            int[] iArr = new int[v0.d.b.values().length];
            f19933a = iArr;
            try {
                iArr[v0.d.b.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19933a[v0.d.b.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static v0.d a(n0.g gVar) {
        Rect rectB = gVar.b();
        return new v0.d(Collections.emptyList(), gVar, "__container", -1L, v0.d.a.PRE_COMP, -1L, null, Collections.emptyList(), new t0.l(), 0, 0, 0, 0.0f, 0.0f, rectB.width(), rectB.height(), null, null, Collections.emptyList(), v0.d.b.NONE, null, false);
    }

    public static v0.d b(y0.c cVar, n0.g gVar) throws IOException {
        ArrayList arrayList;
        float f10;
        v0.d.b bVar = v0.d.b.NONE;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        cVar.d();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        v0.d.b bVar2 = bVar;
        String strA = null;
        t0.l lVarG = null;
        t0.j jVarD = null;
        t0.k kVarA = null;
        t0.b bVarF = null;
        long jT = 0;
        int iE = 0;
        int iE2 = 0;
        int color = 0;
        int iE3 = 0;
        int iE4 = 0;
        boolean zP = false;
        float fQ = 1.0f;
        long jT2 = -1;
        float fQ2 = 0.0f;
        float fQ3 = 0.0f;
        String strA2 = "UNSET";
        String strA3 = null;
        v0.d.a aVar = null;
        float fQ4 = 0.0f;
        while (cVar.o()) {
            switch (cVar.e0(f19930a)) {
                case 0:
                    strA2 = cVar.A();
                    break;
                case 1:
                    jT = cVar.t();
                    break;
                case 2:
                    strA = cVar.A();
                    break;
                case 3:
                    int iT = cVar.t();
                    aVar = v0.d.a.UNKNOWN;
                    if (iT < aVar.ordinal()) {
                        aVar = v0.d.a.values()[iT];
                    }
                    break;
                case 4:
                    jT2 = cVar.t();
                    break;
                case 5:
                    iE = (int) (z0.h.e() * cVar.t());
                    break;
                case 6:
                    iE2 = (int) (z0.h.e() * cVar.t());
                    break;
                case 7:
                    color = Color.parseColor(cVar.A());
                    break;
                case 8:
                    lVarG = c.g(cVar, gVar);
                    break;
                case 9:
                    int iT2 = cVar.t();
                    if (iT2 < v0.d.b.values().length) {
                        bVar2 = v0.d.b.values()[iT2];
                        int i10 = a.f19933a[bVar2.ordinal()];
                        if (i10 == 1) {
                            gVar.a("Unsupported matte type: Luma");
                        } else if (i10 == 2) {
                            gVar.a("Unsupported matte type: Luma Inverted");
                        }
                        gVar.t(1);
                    } else {
                        gVar.a("Unsupported matte type: " + iT2);
                    }
                    break;
                case 10:
                    cVar.c();
                    while (cVar.o()) {
                        arrayList2.add(v.a(cVar, gVar));
                    }
                    gVar.t(arrayList2.size());
                    cVar.h();
                    break;
                case 11:
                    cVar.c();
                    while (cVar.o()) {
                        u0.b bVarA = g.a(cVar, gVar);
                        if (bVarA != null) {
                            arrayList3.add(bVarA);
                        }
                    }
                    cVar.h();
                    break;
                case 12:
                    cVar.d();
                    while (cVar.o()) {
                        int iE0 = cVar.e0(f19931b);
                        if (iE0 == 0) {
                            jVarD = d.d(cVar, gVar);
                        } else if (iE0 != 1) {
                            cVar.f0();
                            cVar.g0();
                        } else {
                            cVar.c();
                            if (cVar.o()) {
                                kVarA = b.a(cVar, gVar);
                            }
                            while (cVar.o()) {
                                cVar.g0();
                            }
                            cVar.h();
                        }
                    }
                    cVar.k();
                    break;
                case 13:
                    cVar.c();
                    ArrayList arrayList4 = new ArrayList();
                    while (cVar.o()) {
                        cVar.d();
                        while (cVar.o()) {
                            if (cVar.e0(f19932c) != 0) {
                                cVar.f0();
                                cVar.g0();
                            } else {
                                arrayList4.add(cVar.A());
                            }
                        }
                        cVar.k();
                    }
                    cVar.h();
                    gVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                    break;
                case 14:
                    fQ = (float) cVar.q();
                    break;
                case 15:
                    fQ3 = (float) cVar.q();
                    break;
                case 16:
                    iE3 = (int) (z0.h.e() * cVar.t());
                    break;
                case 17:
                    iE4 = (int) (z0.h.e() * cVar.t());
                    break;
                case 18:
                    fQ2 = (float) cVar.q();
                    break;
                case 19:
                    fQ4 = (float) cVar.q();
                    break;
                case 20:
                    bVarF = d.f(cVar, gVar, false);
                    break;
                case 21:
                    strA3 = cVar.A();
                    break;
                case 22:
                    zP = cVar.p();
                    break;
                default:
                    cVar.f0();
                    cVar.g0();
                    break;
            }
        }
        cVar.k();
        float f11 = fQ2 / fQ;
        float f12 = fQ4 / fQ;
        ArrayList arrayList5 = new ArrayList();
        if (f11 > 0.0f) {
            arrayList = arrayList5;
            arrayList.add(new a1.a(gVar, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f11)));
            f10 = 0.0f;
        } else {
            arrayList = arrayList5;
            f10 = 0.0f;
        }
        if (f12 <= f10) {
            f12 = gVar.f();
        }
        arrayList.add(new a1.a(gVar, fValueOf, fValueOf, null, f11, Float.valueOf(f12)));
        arrayList.add(new a1.a(gVar, fValueOf2, fValueOf2, null, f12, Float.valueOf(Float.MAX_VALUE)));
        if (strA2.endsWith(".ai") || "ai".equals(strA3)) {
            gVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new v0.d(arrayList3, gVar, strA2, jT, aVar, jT2, strA, arrayList2, lVarG, iE, iE2, color, fQ, fQ3, iE3, iE4, jVarD, kVarA, arrayList, bVar2, bVarF, zP);
    }
}
