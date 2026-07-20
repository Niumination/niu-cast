package u1;

import android.graphics.Color;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public final class f implements f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f10284b = new f(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f10285c = new f(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f10286d = new f(2);
    public static final f e = new f(3);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f10287h = new f(4);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f f10288i = new f(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10289a;

    public /* synthetic */ f(int i8) {
        this.f10289a = i8;
    }

    @Override // u1.f0
    public final Object c(v1.d dVar, float f) {
        switch (this.f10289a) {
            case 0:
                boolean z2 = dVar.s() == v1.c.BEGIN_ARRAY;
                if (z2) {
                    dVar.a();
                }
                double dL = dVar.l();
                double dL2 = dVar.l();
                double dL3 = dVar.l();
                double dL4 = dVar.s() == v1.c.NUMBER ? dVar.l() : 1.0d;
                if (z2) {
                    dVar.g();
                }
                if (dL <= 1.0d && dL2 <= 1.0d && dL3 <= 1.0d) {
                    dL *= 255.0d;
                    dL2 *= 255.0d;
                    dL3 *= 255.0d;
                    if (dL4 <= 1.0d) {
                        dL4 *= 255.0d;
                    }
                }
                return Integer.valueOf(Color.argb((int) dL4, (int) dL, (int) dL2, (int) dL3));
            case 1:
                return Float.valueOf(o.d(dVar) * f);
            case 2:
                return Integer.valueOf(Math.round(o.d(dVar) * f));
            case 3:
                return o.b(dVar, f);
            case 4:
                v1.c cVarS = dVar.s();
                if (cVarS != v1.c.BEGIN_ARRAY && cVarS != v1.c.BEGIN_OBJECT) {
                    if (cVarS != v1.c.NUMBER) {
                        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + cVarS);
                    }
                    PointF pointF = new PointF(((float) dVar.l()) * f, ((float) dVar.l()) * f);
                    while (dVar.i()) {
                        dVar.B();
                    }
                    return pointF;
                }
                return o.b(dVar, f);
            default:
                boolean z3 = dVar.s() == v1.c.BEGIN_ARRAY;
                if (z3) {
                    dVar.a();
                }
                float fL = (float) dVar.l();
                float fL2 = (float) dVar.l();
                while (dVar.i()) {
                    dVar.B();
                }
                if (z3) {
                    dVar.g();
                }
                return new x1.d((fL / 100.0f) * f, (fL2 / 100.0f) * f);
        }
    }
}
