package x0;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static y0.c.a f19904a = y0.c.a.a("nm", "hd", "it");

    public static u0.n a(y0.c cVar, n0.g gVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strA = null;
        boolean zP = false;
        while (cVar.o()) {
            int iE0 = cVar.e0(f19904a);
            if (iE0 == 0) {
                strA = cVar.A();
            } else if (iE0 == 1) {
                zP = cVar.p();
            } else if (iE0 != 2) {
                cVar.g0();
            } else {
                cVar.c();
                while (cVar.o()) {
                    u0.b bVarA = g.a(cVar, gVar);
                    if (bVarA != null) {
                        arrayList.add(bVarA);
                    }
                }
                cVar.h();
            }
        }
        return new u0.n(strA, arrayList, zP);
    }
}
