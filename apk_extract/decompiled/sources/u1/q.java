package u1;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f5.a f10311a = f5.a.g("k");

    public static ArrayList a(v1.d dVar, j1.j jVar, float f, f0 f0Var, boolean z2) {
        ArrayList arrayList = new ArrayList();
        if (dVar.s() == v1.c.STRING) {
            jVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        dVar.c();
        while (dVar.i()) {
            if (dVar.w(f10311a) != 0) {
                dVar.B();
            } else if (dVar.s() == v1.c.BEGIN_ARRAY) {
                dVar.a();
                if (dVar.s() == v1.c.NUMBER) {
                    arrayList.add(p.b(dVar, jVar, f, f0Var, false, z2));
                } else {
                    while (dVar.i()) {
                        arrayList.add(p.b(dVar, jVar, f, f0Var, true, z2));
                    }
                }
                dVar.g();
            } else {
                arrayList.add(p.b(dVar, jVar, f, f0Var, false, z2));
            }
        }
        dVar.h();
        b(arrayList);
        return arrayList;
    }

    public static void b(ArrayList arrayList) {
        int i8;
        Object obj;
        int size = arrayList.size();
        int i9 = 0;
        while (true) {
            i8 = size - 1;
            if (i9 >= i8) {
                break;
            }
            x1.a aVar = (x1.a) arrayList.get(i9);
            i9++;
            x1.a aVar2 = (x1.a) arrayList.get(i9);
            aVar.f10811h = Float.valueOf(aVar2.f10810g);
            if (aVar.f10808c == null && (obj = aVar2.f10807b) != null) {
                aVar.f10808c = obj;
                if (aVar instanceof m1.l) {
                    ((m1.l) aVar).d();
                }
            }
        }
        x1.a aVar3 = (x1.a) arrayList.get(i8);
        if ((aVar3.f10807b == null || aVar3.f10808c == null) && arrayList.size() > 1) {
            arrayList.remove(aVar3);
        }
    }
}
