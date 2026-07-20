package u1;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class z implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f10325a = new z();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f5.a f10326b = f5.a.g("c", "v", "i", "o");

    @Override // u1.f0
    public final Object c(v1.d dVar, float f) {
        if (dVar.s() == v1.c.BEGIN_ARRAY) {
            dVar.a();
        }
        dVar.c();
        ArrayList arrayListC = null;
        ArrayList arrayListC2 = null;
        ArrayList arrayListC3 = null;
        boolean zK = false;
        while (dVar.i()) {
            int iW = dVar.w(f10326b);
            if (iW == 0) {
                zK = dVar.k();
            } else if (iW == 1) {
                arrayListC = o.c(dVar, f);
            } else if (iW == 2) {
                arrayListC2 = o.c(dVar, f);
            } else if (iW != 3) {
                dVar.A();
                dVar.B();
            } else {
                arrayListC3 = o.c(dVar, f);
            }
        }
        dVar.h();
        if (dVar.s() == v1.c.END_ARRAY) {
            dVar.g();
        }
        if (arrayListC == null || arrayListC2 == null || arrayListC3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (arrayListC.isEmpty()) {
            return new r1.q(new PointF(), false, Collections.emptyList());
        }
        int size = arrayListC.size();
        PointF pointF = (PointF) arrayListC.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i8 = 1; i8 < size; i8++) {
            PointF pointF2 = (PointF) arrayListC.get(i8);
            int i9 = i8 - 1;
            arrayList.add(new p1.a(w1.f.a((PointF) arrayListC.get(i9), (PointF) arrayListC3.get(i9)), w1.f.a(pointF2, (PointF) arrayListC2.get(i8)), pointF2));
        }
        if (zK) {
            PointF pointF3 = (PointF) arrayListC.get(0);
            int i10 = size - 1;
            arrayList.add(new p1.a(w1.f.a((PointF) arrayListC.get(i10), (PointF) arrayListC3.get(i10)), w1.f.a(pointF3, (PointF) arrayListC2.get(0)), pointF3));
        }
        return new r1.q(pointF, zK, arrayList);
    }
}
