package x0;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class d0 implements k0<a1.k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f19897a = new d0();

    @Override // x0.k0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a1.k a(y0.c cVar, float f10) throws IOException {
        boolean z10 = cVar.O() == y0.c.b.BEGIN_ARRAY;
        if (z10) {
            cVar.c();
        }
        float fQ = (float) cVar.q();
        float fQ2 = (float) cVar.q();
        while (cVar.o()) {
            cVar.g0();
        }
        if (z10) {
            cVar.h();
        }
        return new a1.k((fQ / 100.0f) * f10, (fQ2 / 100.0f) * f10);
    }
}
