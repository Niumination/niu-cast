package x0;

import android.graphics.Color;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class f implements k0<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f19901a = new f();

    @Override // x0.k0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(y0.c cVar, float f10) throws IOException {
        boolean z10 = cVar.O() == y0.c.b.BEGIN_ARRAY;
        if (z10) {
            cVar.c();
        }
        double dQ = cVar.q();
        double dQ2 = cVar.q();
        double dQ3 = cVar.q();
        double dQ4 = cVar.O() == y0.c.b.NUMBER ? cVar.q() : 1.0d;
        if (z10) {
            cVar.h();
        }
        if (dQ <= 1.0d && dQ2 <= 1.0d && dQ3 <= 1.0d) {
            dQ *= 255.0d;
            dQ2 *= 255.0d;
            dQ3 *= 255.0d;
            if (dQ4 <= 1.0d) {
                dQ4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dQ4, (int) dQ, (int) dQ2, (int) dQ3));
    }
}
