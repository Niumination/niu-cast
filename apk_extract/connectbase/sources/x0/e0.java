package x0;

import android.graphics.PointF;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e0 implements k0<u0.l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f19899a = new e0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y0.c.a f19900b = y0.c.a.a("c", "v", b9.i.f771b, p6.o.f13007a);

    @Override // x0.k0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u0.l a(y0.c cVar, float f10) throws IOException {
        if (cVar.O() == y0.c.b.BEGIN_ARRAY) {
            cVar.c();
        }
        cVar.d();
        List<PointF> listF = null;
        List<PointF> listF2 = null;
        List<PointF> listF3 = null;
        boolean zP = false;
        while (cVar.o()) {
            int iE0 = cVar.e0(f19900b);
            if (iE0 == 0) {
                zP = cVar.p();
            } else if (iE0 == 1) {
                listF = p.f(cVar, f10);
            } else if (iE0 == 2) {
                listF2 = p.f(cVar, f10);
            } else if (iE0 != 3) {
                cVar.f0();
                cVar.g0();
            } else {
                listF3 = p.f(cVar, f10);
            }
        }
        cVar.k();
        if (cVar.O() == y0.c.b.END_ARRAY) {
            cVar.h();
        }
        if (listF == null || listF2 == null || listF3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listF.isEmpty()) {
            return new u0.l(new PointF(), false, Collections.emptyList());
        }
        int size = listF.size();
        PointF pointF = listF.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 1; i10 < size; i10++) {
            PointF pointF2 = listF.get(i10);
            int i11 = i10 - 1;
            arrayList.add(new s0.a(z0.g.a(listF.get(i11), listF3.get(i11)), z0.g.a(pointF2, listF2.get(i10)), pointF2));
        }
        if (zP) {
            PointF pointF3 = listF.get(0);
            int i12 = size - 1;
            arrayList.add(new s0.a(z0.g.a(listF.get(i12), listF3.get(i12)), z0.g.a(pointF3, listF2.get(0)), pointF3));
        }
        return new u0.l(pointF, zP, arrayList);
    }
}
