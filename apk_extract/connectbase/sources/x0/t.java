package x0;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0.c.a f19934a = y0.c.a.a(p6.w.f13020a, "h", "ip", "op", "fr", "v", RtspHeaders.Values.LAYERS, "assets", "fonts", "chars", "markers");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static y0.c.a f19935b = y0.c.a.a(dc.d.f3692w, RtspHeaders.Values.LAYERS, p6.w.f13020a, "h", "p", p6.u.f13018b);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y0.c.a f19936c = y0.c.a.a("list");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y0.c.a f19937d = y0.c.a.a("cm", "tm", "dr");

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
            switch (cVar.e0(f19934a)) {
                case 0:
                    iT = cVar.t();
                    continue;
                case 1:
                    iT2 = cVar.t();
                    continue;
                case 2:
                    fQ = (float) cVar.q();
                    continue;
                case 3:
                    fQ2 = ((float) cVar.q()) - 0.01f;
                    break;
                case 4:
                    fQ3 = (float) cVar.q();
                    break;
                case 5:
                    String[] strArrSplit = cVar.A().split("\\.");
                    if (!z0.h.j(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        gVar.a("Lottie only supports bodymovin >= 4.4.0");
                        continue;
                    }
                    break;
                case 6:
                    e(cVar, gVar, arrayList, longSparseArray);
                    continue;
                case 7:
                    b(cVar, gVar, map, map2);
                    continue;
                case 8:
                    d(cVar, map3);
                    continue;
                case 9:
                    c(cVar, gVar, sparseArrayCompat);
                    continue;
                case 10:
                    f(cVar, gVar, arrayList2);
                    continue;
                default:
                    cVar.f0();
                    cVar.g0();
                    continue;
            }
            map3 = map3;
            arrayList2 = arrayList2;
        }
        gVar.u(new Rect(0, 0, (int) (iT * fE), (int) (iT2 * fE)), fQ, fQ2, fQ3, arrayList, longSparseArray, map, map2, sparseArrayCompat, map3, arrayList2);
        return gVar;
    }

    public static void b(y0.c cVar, n0.g gVar, Map<String, List<v0.d>> map, Map<String, n0.k> map2) throws IOException {
        cVar.c();
        while (cVar.o()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            cVar.d();
            int iT = 0;
            int iT2 = 0;
            String strA = null;
            String strA2 = null;
            String strA3 = null;
            while (cVar.o()) {
                int iE0 = cVar.e0(f19935b);
                if (iE0 == 0) {
                    strA = cVar.A();
                } else if (iE0 == 1) {
                    cVar.c();
                    while (cVar.o()) {
                        v0.d dVarB = s.b(cVar, gVar);
                        longSparseArray.put(dVarB.b(), dVarB);
                        arrayList.add(dVarB);
                    }
                    cVar.h();
                } else if (iE0 == 2) {
                    iT = cVar.t();
                } else if (iE0 == 3) {
                    iT2 = cVar.t();
                } else if (iE0 == 4) {
                    strA2 = cVar.A();
                } else if (iE0 != 5) {
                    cVar.f0();
                    cVar.g0();
                } else {
                    strA3 = cVar.A();
                }
            }
            cVar.k();
            if (strA2 != null) {
                n0.k kVar = new n0.k(iT, iT2, strA, strA2, strA3);
                map2.put(kVar.f11040c, kVar);
            } else {
                map.put(strA, arrayList);
            }
        }
        cVar.h();
    }

    public static void c(y0.c cVar, n0.g gVar, SparseArrayCompat<s0.e> sparseArrayCompat) throws IOException {
        cVar.c();
        while (cVar.o()) {
            s0.e eVarA = j.a(cVar, gVar);
            sparseArrayCompat.put(eVarA.hashCode(), eVarA);
        }
        cVar.h();
    }

    public static void d(y0.c cVar, Map<String, s0.d> map) throws IOException {
        cVar.d();
        while (cVar.o()) {
            if (cVar.e0(f19936c) != 0) {
                cVar.f0();
                cVar.g0();
            } else {
                cVar.c();
                while (cVar.o()) {
                    s0.d dVarA = k.a(cVar);
                    map.put(dVarA.c(), dVarA);
                }
                cVar.h();
            }
        }
        cVar.k();
    }

    public static void e(y0.c cVar, n0.g gVar, List<v0.d> list, LongSparseArray<v0.d> longSparseArray) throws IOException {
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

    public static void f(y0.c cVar, n0.g gVar, List<s0.i> list) throws IOException {
        cVar.c();
        while (cVar.o()) {
            cVar.d();
            float fQ = 0.0f;
            String strA = null;
            float fQ2 = 0.0f;
            while (cVar.o()) {
                int iE0 = cVar.e0(f19937d);
                if (iE0 == 0) {
                    strA = cVar.A();
                } else if (iE0 == 1) {
                    fQ = (float) cVar.q();
                } else if (iE0 != 2) {
                    cVar.f0();
                    cVar.g0();
                } else {
                    fQ2 = (float) cVar.q();
                }
            }
            cVar.k();
            list.add(new s0.i(strA, fQ, fQ2));
        }
        cVar.h();
    }
}
