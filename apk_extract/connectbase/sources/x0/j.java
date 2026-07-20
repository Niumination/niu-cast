package x0;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0.c.a f19911a = y0.c.a.a("ch", ik.f.b.f7973h, p6.w.f13020a, dc.d.f3682m, "fFamily", "data");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y0.c.a f19912b = y0.c.a.a("shapes");

    public static s0.e a(y0.c cVar, n0.g gVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        cVar.d();
        double dQ = 0.0d;
        String strA = null;
        String strA2 = null;
        char cCharAt = 0;
        double dQ2 = 0.0d;
        while (cVar.o()) {
            int iE0 = cVar.e0(f19911a);
            if (iE0 == 0) {
                cCharAt = cVar.A().charAt(0);
            } else if (iE0 == 1) {
                dQ2 = cVar.q();
            } else if (iE0 == 2) {
                dQ = cVar.q();
            } else if (iE0 == 3) {
                strA = cVar.A();
            } else if (iE0 == 4) {
                strA2 = cVar.A();
            } else if (iE0 != 5) {
                cVar.f0();
                cVar.g0();
            } else {
                cVar.d();
                while (cVar.o()) {
                    if (cVar.e0(f19912b) != 0) {
                        cVar.f0();
                        cVar.g0();
                    } else {
                        cVar.c();
                        while (cVar.o()) {
                            arrayList.add((u0.n) g.a(cVar, gVar));
                        }
                        cVar.h();
                    }
                }
                cVar.k();
            }
        }
        cVar.k();
        return new s0.e(arrayList, cCharAt, dQ2, dQ, strA, strA2);
    }
}
