package x0;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static y0.c.a f19938a = y0.c.a.a(p6.w.f13020a, "h", "ip", "op", "fr", "v", RtspHeaders.Values.LAYERS, "assets", "fonts", "chars", "markers");

    public static n0.g a(y0.c cVar) throws IOException {
        float fE = z0.h.e();
        LongSparseArray<v0.d> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArrayCompat<s0.e> sparseArrayCompat = new SparseArrayCompat<>();
        n0.g gVar = new n0.g();
        cVar.d();
        float fQ = 0.0f;
        float fQ2 = 0.0f;
        float fQ3 = 0.0f;
        int iT = 0;
        int iT2 = 0;
        while (cVar.o()) {
            switch (cVar.e0(f19938a)) {
                case 0:
                    iT = cVar.t();
                    break;
                case 1:
                    iT2 = cVar.t();
                    break;
                case 2:
                    fQ = (float) cVar.q();
                    break;
                case 3:
                    fQ2 = ((float) cVar.q()) - 0.01f;
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                case 4:
                    fQ3 = (float) cVar.q();
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                case 5:
                    String[] strArrSplit = cVar.A().split("\\.");
                    if (!z0.h.j(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        gVar.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    break;
                case 6:
                    b(cVar, gVar, arrayList, longSparseArray);
                default:
                    cVar.g0();
                    break;
            }
        }
        gVar.u(new Rect(0, 0, (int) (iT * fE), (int) (iT2 * fE)), fQ, fQ2, fQ3, arrayList, longSparseArray, map, map2, sparseArrayCompat, map3, arrayList2);
        return gVar;
    }

    public static void b(y0.c cVar, n0.g gVar, List<v0.d> list, LongSparseArray<v0.d> longSparseArray) throws IOException {
        cVar.c();
        int i10 = 0;
        while (cVar.o()) {
            v0.d dVarB = s.b(cVar, gVar);
            if (dVarB.d() == v0.d.a.IMAGE) {
                i10++;
            }
            list.add(dVarB);
            longSparseArray.put(dVarB.b(), dVarB);
            if (i10 > 4) {
                z0.d.e("You have " + i10 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        cVar.h();
    }
}
