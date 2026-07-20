package x0;

import android.graphics.PointF;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class z implements k0<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f19941a = new z();

    @Override // x0.k0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(y0.c cVar, float f10) throws IOException {
        y0.c.b bVarO = cVar.O();
        if (bVarO != y0.c.b.BEGIN_ARRAY && bVarO != y0.c.b.BEGIN_OBJECT) {
            if (bVarO != y0.c.b.NUMBER) {
                throw new IllegalArgumentException("Cannot convert json to point. Next token is " + bVarO);
            }
            PointF pointF = new PointF(((float) cVar.q()) * f10, ((float) cVar.q()) * f10);
            while (cVar.o()) {
                cVar.g0();
            }
            return pointF;
        }
        return p.e(cVar, f10);
    }
}
