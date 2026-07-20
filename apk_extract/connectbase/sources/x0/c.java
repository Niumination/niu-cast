package x0;

import android.graphics.PointF;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0.c.a f19894a = y0.c.a.a("a", "p", p6.s.f13016a, "rz", "r", p6.o.f13007a, "so", "eo", "sk", "sa");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y0.c.a f19895b = y0.c.a.a("k");

    public static boolean a(t0.e eVar) {
        return eVar == null || (eVar.k() && eVar.m().get(0).f6b.equals(0.0f, 0.0f));
    }

    public static boolean b(t0.m<PointF, PointF> mVar) {
        return mVar == null || (!(mVar instanceof t0.i) && mVar.k() && mVar.m().get(0).f6b.equals(0.0f, 0.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean c(t0.b bVar) {
        return bVar == null || (bVar.k() && ((Float) ((a1.a) bVar.m().get(0)).f6b).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(t0.g gVar) {
        return gVar == null || (gVar.k() && ((a1.k) ((a1.a) gVar.m().get(0)).f6b).a(1.0f, 1.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean e(t0.b bVar) {
        return bVar == null || (bVar.k() && ((Float) ((a1.a) bVar.m().get(0)).f6b).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean f(t0.b bVar) {
        return bVar == null || (bVar.k() && ((Float) ((a1.a) bVar.m().get(0)).f6b).floatValue() == 0.0f);
    }

    public static t0.l g(y0.c cVar, n0.g gVar) throws IOException {
        boolean z10;
        boolean z11 = false;
        boolean z12 = cVar.O() == y0.c.b.BEGIN_OBJECT;
        if (z12) {
            cVar.d();
        }
        t0.b bVar = null;
        t0.e eVarA = null;
        t0.m<PointF, PointF> mVarB = null;
        t0.g gVarJ = null;
        t0.b bVarF = null;
        t0.b bVarF2 = null;
        t0.d dVarH = null;
        t0.b bVarF3 = null;
        t0.b bVarF4 = null;
        while (cVar.o()) {
            switch (cVar.e0(f19894a)) {
                case 0:
                    boolean z13 = z11;
                    cVar.d();
                    while (cVar.o()) {
                        if (cVar.e0(f19895b) != 0) {
                            cVar.f0();
                            cVar.g0();
                        } else {
                            eVarA = a.a(cVar, gVar);
                        }
                    }
                    cVar.k();
                    z11 = z13;
                    continue;
                case 1:
                    mVarB = a.b(cVar, gVar);
                    continue;
                case 2:
                    gVarJ = d.j(cVar, gVar);
                    continue;
                case 3:
                    gVar.a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVarH = d.h(cVar, gVar);
                    continue;
                case 6:
                    bVarF3 = d.f(cVar, gVar, z11);
                    continue;
                case 7:
                    bVarF4 = d.f(cVar, gVar, z11);
                    continue;
                case 8:
                    bVarF = d.f(cVar, gVar, z11);
                    continue;
                case 9:
                    bVarF2 = d.f(cVar, gVar, z11);
                    continue;
                default:
                    cVar.f0();
                    cVar.g0();
                    continue;
            }
            t0.b bVarF5 = d.f(cVar, gVar, z11);
            if (bVarF5.m().isEmpty()) {
                bVarF5.m().add(new a1.a(gVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(gVar.f())));
            } else {
                if (((a1.a) bVarF5.m().get(0)).f6b == 0) {
                    z10 = false;
                    bVarF5.m().set(0, new a1.a(gVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(gVar.f())));
                }
                z11 = z10;
                bVar = bVarF5;
            }
            z10 = false;
            z11 = z10;
            bVar = bVarF5;
        }
        if (z12) {
            cVar.k();
        }
        t0.e eVar = a(eVarA) ? null : eVarA;
        t0.m<PointF, PointF> mVar = b(mVarB) ? null : mVarB;
        t0.b bVar2 = c(bVar) ? null : bVar;
        if (d(gVarJ)) {
            gVarJ = null;
        }
        return new t0.l(eVar, mVar, gVarJ, bVar2, dVarH, bVarF3, bVarF4, f(bVarF) ? null : bVarF, e(bVarF2) ? null : bVarF2);
    }
}
