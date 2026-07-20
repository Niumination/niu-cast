package x0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static y0.c.a f19929a = y0.c.a.a("k");

    public static <T> List<a1.a<T>> a(y0.c cVar, n0.g gVar, float f10, k0<T> k0Var, boolean z10) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (cVar.O() == y0.c.b.STRING) {
            gVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        cVar.d();
        while (cVar.o()) {
            if (cVar.e0(f19929a) != 0) {
                cVar.g0();
            } else if (cVar.O() == y0.c.b.BEGIN_ARRAY) {
                cVar.c();
                if (cVar.O() == y0.c.b.NUMBER) {
                    arrayList.add(q.c(cVar, gVar, f10, k0Var, false, z10));
                } else {
                    while (cVar.o()) {
                        arrayList.add(q.c(cVar, gVar, f10, k0Var, true, z10));
                    }
                }
                cVar.h();
            } else {
                arrayList.add(q.c(cVar, gVar, f10, k0Var, false, z10));
            }
        }
        cVar.k();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends a1.a<T>> list) {
        int i10;
        T t10;
        int size = list.size();
        int i11 = 0;
        while (true) {
            i10 = size - 1;
            if (i11 >= i10) {
                break;
            }
            a1.a<T> aVar = list.get(i11);
            i11++;
            a1.a<T> aVar2 = list.get(i11);
            aVar.f12h = Float.valueOf(aVar2.f11g);
            if (aVar.f7c == null && (t10 = aVar2.f6b) != null) {
                aVar.f7c = t10;
                if (aVar instanceof q0.h) {
                    ((q0.h) aVar).i();
                }
            }
        }
        a1.a<T> aVar3 = list.get(i10);
        if ((aVar3.f6b == null || aVar3.f7c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
