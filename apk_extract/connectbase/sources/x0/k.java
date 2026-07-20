package x0;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0.c.a f19914a = y0.c.a.a("fFamily", "fName", "fStyle", "ascent");

    public static s0.d a(y0.c cVar) throws IOException {
        cVar.d();
        String strA = null;
        String strA2 = null;
        float fQ = 0.0f;
        String strA3 = null;
        while (cVar.o()) {
            int iE0 = cVar.e0(f19914a);
            if (iE0 == 0) {
                strA = cVar.A();
            } else if (iE0 == 1) {
                strA3 = cVar.A();
            } else if (iE0 == 2) {
                strA2 = cVar.A();
            } else if (iE0 != 3) {
                cVar.f0();
                cVar.g0();
            } else {
                fQ = (float) cVar.q();
            }
        }
        cVar.k();
        return new s0.d(strA, strA3, strA2, fQ);
    }
}
