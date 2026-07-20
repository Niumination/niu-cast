package x0;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static y0.c.a f19903a = y0.c.a.a("ty", "d");

    @Nullable
    public static u0.b a(y0.c cVar, n0.g gVar) throws IOException {
        u0.b bVarA;
        String strA;
        byte b10 = 1;
        cVar.d();
        int iT = 2;
        while (true) {
            bVarA = null;
            if (!cVar.o()) {
                strA = null;
                break;
            }
            int iE0 = cVar.e0(f19903a);
            if (iE0 == 0) {
                strA = cVar.A();
                break;
            }
            if (iE0 != 1) {
                cVar.f0();
                cVar.g0();
            } else {
                iT = cVar.t();
            }
        }
        if (strA == null) {
            return null;
        }
        switch (strA.hashCode()) {
            case 3239:
                b10 = !strA.equals("el") ? (byte) -1 : (byte) 0;
                break;
            case 3270:
                if (!strA.equals("fl")) {
                    b10 = -1;
                }
                break;
            case 3295:
                b10 = !strA.equals("gf") ? (byte) -1 : (byte) 2;
                break;
            case 3307:
                b10 = !strA.equals("gr") ? (byte) -1 : (byte) 3;
                break;
            case 3308:
                b10 = !strA.equals("gs") ? (byte) -1 : (byte) 4;
                break;
            case 3488:
                b10 = !strA.equals("mm") ? (byte) -1 : (byte) 5;
                break;
            case 3633:
                b10 = !strA.equals("rc") ? (byte) -1 : (byte) 6;
                break;
            case 3646:
                b10 = !strA.equals("rp") ? (byte) -1 : (byte) 7;
                break;
            case 3669:
                b10 = !strA.equals("sh") ? (byte) -1 : (byte) 8;
                break;
            case 3679:
                b10 = !strA.equals("sr") ? (byte) -1 : (byte) 9;
                break;
            case 3681:
                b10 = !strA.equals("st") ? (byte) -1 : (byte) 10;
                break;
            case 3705:
                b10 = !strA.equals("tm") ? (byte) -1 : c1.c.f1119m;
                break;
            case 3710:
                b10 = !strA.equals("tr") ? (byte) -1 : c1.c.f1120n;
                break;
            default:
                b10 = -1;
                break;
        }
        switch (b10) {
            case 0:
                bVarA = e.a(cVar, gVar, iT);
                break;
            case 1:
                bVarA = f0.a(cVar, gVar);
                break;
            case 2:
                bVarA = m.a(cVar, gVar);
                break;
            case 3:
                bVarA = g0.a(cVar, gVar);
                break;
            case 4:
                bVarA = n.a(cVar, gVar);
                break;
            case 5:
                bVarA = w.a(cVar);
                gVar.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                bVarA = b0.a(cVar, gVar);
                break;
            case 7:
                bVarA = c0.a(cVar, gVar);
                break;
            case 8:
                bVarA = h0.a(cVar, gVar);
                break;
            case 9:
                bVarA = a0.a(cVar, gVar);
                break;
            case 10:
                bVarA = i0.a(cVar, gVar);
                break;
            case 11:
                bVarA = j0.a(cVar, gVar);
                break;
            case 12:
                bVarA = c.g(cVar, gVar);
                break;
            default:
                z0.d.e("Unknown shape type ".concat(strA));
                break;
        }
        while (cVar.o()) {
            cVar.g0();
        }
        cVar.k();
        return bVarA;
    }
}
