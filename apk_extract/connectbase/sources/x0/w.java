package x0;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0.c.a f19939a = y0.c.a.a("nm", "mm", "hd");

    public static u0.h a(y0.c cVar) throws IOException {
        String strA = null;
        boolean zP = false;
        u0.h.a aVarForId = null;
        while (cVar.o()) {
            int iE0 = cVar.e0(f19939a);
            if (iE0 == 0) {
                strA = cVar.A();
            } else if (iE0 == 1) {
                aVarForId = u0.h.a.forId(cVar.t());
            } else if (iE0 != 2) {
                cVar.f0();
                cVar.g0();
            } else {
                zP = cVar.p();
            }
        }
        return new u0.h(strA, aVarForId, zP);
    }
}
