package x0;

import android.graphics.PointF;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0.c.a f19890a = y0.c.a.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd");

    public static u0.i a(y0.c cVar, n0.g gVar) throws IOException {
        String strA = null;
        u0.i.a aVarForValue = null;
        t0.b bVarF = null;
        t0.m<PointF, PointF> mVarB = null;
        t0.b bVarF2 = null;
        t0.b bVarF3 = null;
        t0.b bVarF4 = null;
        t0.b bVarF5 = null;
        t0.b bVarF6 = null;
        boolean zP = false;
        while (cVar.o()) {
            switch (cVar.e0(f19890a)) {
                case 0:
                    strA = cVar.A();
                    break;
                case 1:
                    aVarForValue = u0.i.a.forValue(cVar.t());
                    break;
                case 2:
                    bVarF = d.f(cVar, gVar, false);
                    break;
                case 3:
                    mVarB = a.b(cVar, gVar);
                    break;
                case 4:
                    bVarF2 = d.f(cVar, gVar, false);
                    break;
                case 5:
                    bVarF4 = d.f(cVar, gVar, true);
                    break;
                case 6:
                    bVarF6 = d.f(cVar, gVar, false);
                    break;
                case 7:
                    bVarF3 = d.f(cVar, gVar, true);
                    break;
                case 8:
                    bVarF5 = d.f(cVar, gVar, false);
                    break;
                case 9:
                    zP = cVar.p();
                    break;
                default:
                    cVar.f0();
                    cVar.g0();
                    break;
            }
        }
        return new u0.i(strA, aVarForValue, bVarF, mVarB, bVarF2, bVarF3, bVarF4, bVarF5, bVarF6, zP);
    }
}
