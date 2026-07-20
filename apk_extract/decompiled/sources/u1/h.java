package u1;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public final class h implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f10291a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f5.a f10292b = f5.a.g("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz");

    @Override // u1.f0
    public final Object c(v1.d dVar, float f) {
        p1.b bVar = p1.b.CENTER;
        dVar.c();
        String strO = null;
        float fL = 0.0f;
        float fL2 = 0.0f;
        float fL3 = 0.0f;
        float fL4 = 0.0f;
        int iM = 0;
        int iA = 0;
        int iA2 = 0;
        boolean zK = true;
        String strO2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        while (dVar.i()) {
            switch (dVar.w(f10292b)) {
                case 0:
                    strO = dVar.o();
                    break;
                case 1:
                    strO2 = dVar.o();
                    break;
                case 2:
                    fL = (float) dVar.l();
                    break;
                case 3:
                    int iM2 = dVar.m();
                    p1.b bVar2 = p1.b.CENTER;
                    bVar = (iM2 <= bVar2.ordinal() && iM2 >= 0) ? p1.b.values()[iM2] : bVar2;
                    break;
                case 4:
                    iM = dVar.m();
                    break;
                case 5:
                    fL2 = (float) dVar.l();
                    break;
                case 6:
                    fL3 = (float) dVar.l();
                    break;
                case 7:
                    iA = o.a(dVar);
                    break;
                case 8:
                    iA2 = o.a(dVar);
                    break;
                case 9:
                    fL4 = (float) dVar.l();
                    break;
                case 10:
                    zK = dVar.k();
                    break;
                case 11:
                    dVar.a();
                    pointF = new PointF(((float) dVar.l()) * f, ((float) dVar.l()) * f);
                    dVar.g();
                    break;
                case 12:
                    dVar.a();
                    pointF2 = new PointF(((float) dVar.l()) * f, ((float) dVar.l()) * f);
                    dVar.g();
                    break;
                default:
                    dVar.A();
                    dVar.B();
                    break;
            }
        }
        dVar.h();
        p1.c cVar = new p1.c();
        cVar.f8618a = strO;
        cVar.f8619b = strO2;
        cVar.f8620c = fL;
        cVar.f8621d = bVar;
        cVar.e = iM;
        cVar.f = fL2;
        cVar.f8622g = fL3;
        cVar.f8623h = iA;
        cVar.f8624i = iA2;
        cVar.f8625j = fL4;
        cVar.f8626k = zK;
        cVar.f8627l = pointF;
        cVar.f8628m = pointF2;
        return cVar;
    }
}
