package u1;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f10308a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f5.a f10309b = f5.a.g("t", "s", "e", "o", "i", "h", "to", "ti");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f5.a f10310c = f5.a.g("x", "y");

    public static Interpolator a(PointF pointF, PointF pointF2) {
        Interpolator interpolatorCreate;
        pointF.x = w1.f.b(pointF.x, -1.0f, 1.0f);
        pointF.y = w1.f.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = w1.f.b(pointF2.x, -1.0f, 1.0f);
        float fB = w1.f.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fB;
        g3.h hVar = w1.g.f10647a;
        j1.a aVar = j1.d.f5945a;
        try {
            interpolatorCreate = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, fB);
        } catch (IllegalArgumentException e) {
            interpolatorCreate = "The Path cannot loop back on itself.".equals(e.getMessage()) ? PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
        }
        j1.a aVar2 = j1.d.f5945a;
        return interpolatorCreate;
    }

    /* JADX WARN: Code duplicated, block: B:98:0x021b  */
    public static x1.a b(v1.d dVar, j1.j jVar, float f, f0 f0Var, boolean z2, boolean z3) {
        Object obj;
        Interpolator interpolatorA;
        Interpolator interpolatorA2;
        Interpolator interpolatorA3;
        Object obj2;
        x1.a aVar;
        LinearInterpolator linearInterpolator;
        f5.a aVar2;
        PointF pointF;
        PointF pointF2;
        Object obj3;
        PointF pointF3;
        LinearInterpolator linearInterpolator2 = f10308a;
        f5.a aVar3 = f10309b;
        if (!z2 || !z3) {
            f5.a aVar4 = aVar3;
            if (!z2) {
                return new x1.a(f0Var.c(dVar, f));
            }
            dVar.c();
            Object objC = null;
            PointF pointFB = null;
            boolean z5 = false;
            float fL = 0.0f;
            PointF pointFB2 = null;
            PointF pointFB3 = null;
            PointF pointFB4 = null;
            Object objC2 = null;
            while (dVar.i()) {
                f5.a aVar5 = aVar4;
                switch (dVar.w(aVar5)) {
                    case 0:
                        fL = (float) dVar.l();
                        break;
                    case 1:
                        objC = f0Var.c(dVar, f);
                        break;
                    case 2:
                        objC2 = f0Var.c(dVar, f);
                        break;
                    case 3:
                        pointFB2 = o.b(dVar, 1.0f);
                        break;
                    case 4:
                        pointFB = o.b(dVar, 1.0f);
                        break;
                    case 5:
                        z5 = dVar.m() == 1;
                        break;
                    case 6:
                        pointFB3 = o.b(dVar, f);
                        break;
                    case 7:
                        pointFB4 = o.b(dVar, f);
                        break;
                    default:
                        dVar.B();
                        break;
                }
                aVar4 = aVar5;
            }
            dVar.h();
            if (!z5) {
                if (pointFB2 == null || pointFB == null) {
                    obj = objC2;
                } else {
                    interpolatorA = a(pointFB2, pointFB);
                    obj = objC2;
                }
                x1.a aVar6 = new x1.a(jVar, objC, obj, interpolatorA, fL, (Float) null);
                aVar6.f10818o = pointFB3;
                aVar6.p = pointFB4;
                return aVar6;
            }
            obj = objC;
            interpolatorA = linearInterpolator2;
            x1.a aVar7 = new x1.a(jVar, objC, obj, interpolatorA, fL, (Float) null);
            aVar7.f10818o = pointFB3;
            aVar7.p = pointFB4;
            return aVar7;
        }
        dVar.c();
        PointF pointF4 = null;
        PointF pointFB5 = null;
        PointF pointFB6 = null;
        boolean z10 = false;
        PointF pointFB7 = null;
        PointF pointFB8 = null;
        PointF pointF5 = null;
        Object objC3 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        float fL2 = 0.0f;
        Object objC4 = null;
        while (dVar.i()) {
            int iW = dVar.w(aVar3);
            f5.a aVar8 = f10310c;
            switch (iW) {
                case 0:
                    linearInterpolator = linearInterpolator2;
                    aVar2 = aVar3;
                    pointF = pointFB6;
                    fL2 = (float) dVar.l();
                    linearInterpolator2 = linearInterpolator;
                    aVar3 = aVar2;
                    pointFB6 = pointF;
                    break;
                case 1:
                    pointF = pointFB6;
                    objC3 = f0Var.c(dVar, f);
                    pointFB6 = pointF;
                    break;
                case 2:
                    pointF = pointFB6;
                    objC4 = f0Var.c(dVar, f);
                    pointFB6 = pointF;
                    break;
                case 3:
                    linearInterpolator = linearInterpolator2;
                    aVar2 = aVar3;
                    PointF pointF8 = pointFB5;
                    pointF = pointFB6;
                    Object obj4 = objC3;
                    PointF pointF9 = pointF6;
                    if (dVar.s() == v1.c.BEGIN_OBJECT) {
                        dVar.c();
                        float fL3 = 0.0f;
                        float fL4 = 0.0f;
                        float fL5 = 0.0f;
                        float fL6 = 0.0f;
                        while (dVar.i()) {
                            int iW2 = dVar.w(aVar8);
                            if (iW2 == 0) {
                                v1.c cVarS = dVar.s();
                                v1.c cVar = v1.c.NUMBER;
                                if (cVarS == cVar) {
                                    fL5 = (float) dVar.l();
                                    fL3 = fL5;
                                } else {
                                    dVar.a();
                                    fL3 = (float) dVar.l();
                                    fL5 = dVar.s() == cVar ? (float) dVar.l() : fL3;
                                    dVar.g();
                                }
                            } else if (iW2 != 1) {
                                dVar.B();
                            } else {
                                v1.c cVarS2 = dVar.s();
                                v1.c cVar2 = v1.c.NUMBER;
                                if (cVarS2 == cVar2) {
                                    fL6 = (float) dVar.l();
                                    fL4 = fL6;
                                } else {
                                    dVar.a();
                                    fL4 = (float) dVar.l();
                                    fL6 = dVar.s() == cVar2 ? (float) dVar.l() : fL4;
                                    dVar.g();
                                }
                            }
                        }
                        pointF5 = new PointF(fL3, fL4);
                        pointF6 = new PointF(fL5, fL6);
                        dVar.h();
                        pointFB5 = pointF8;
                        objC3 = obj4;
                    } else {
                        pointFB7 = o.b(dVar, f);
                        pointFB5 = pointF8;
                        objC3 = obj4;
                        pointF6 = pointF9;
                    }
                    linearInterpolator2 = linearInterpolator;
                    aVar3 = aVar2;
                    pointFB6 = pointF;
                    break;
                case 4:
                    linearInterpolator = linearInterpolator2;
                    aVar2 = aVar3;
                    if (dVar.s() == v1.c.BEGIN_OBJECT) {
                        dVar.c();
                        float fL7 = 0.0f;
                        float fL8 = 0.0f;
                        float fL9 = 0.0f;
                        float fL10 = 0.0f;
                        while (dVar.i()) {
                            PointF pointF10 = pointFB6;
                            int iW3 = dVar.w(aVar8);
                            if (iW3 != 0) {
                                pointF2 = pointFB5;
                                if (iW3 != 1) {
                                    dVar.B();
                                    pointFB5 = pointF2;
                                } else {
                                    v1.c cVarS3 = dVar.s();
                                    v1.c cVar3 = v1.c.NUMBER;
                                    if (cVarS3 == cVar3) {
                                        fL10 = (float) dVar.l();
                                        pointFB5 = pointF2;
                                        fL8 = fL10;
                                    } else {
                                        dVar.a();
                                        obj3 = objC3;
                                        pointF3 = pointF6;
                                        fL8 = (float) dVar.l();
                                        fL10 = dVar.s() == cVar3 ? (float) dVar.l() : fL8;
                                        dVar.g();
                                    }
                                }
                                pointFB6 = pointF10;
                            } else {
                                pointF2 = pointFB5;
                                obj3 = objC3;
                                pointF3 = pointF6;
                                v1.c cVarS4 = dVar.s();
                                v1.c cVar4 = v1.c.NUMBER;
                                if (cVarS4 == cVar4) {
                                    fL9 = (float) dVar.l();
                                    pointFB5 = pointF2;
                                    objC3 = obj3;
                                    fL7 = fL9;
                                } else {
                                    dVar.a();
                                    fL7 = (float) dVar.l();
                                    fL9 = dVar.s() == cVar4 ? (float) dVar.l() : fL7;
                                    dVar.g();
                                }
                                pointF6 = pointF3;
                                pointFB6 = pointF10;
                            }
                            pointFB5 = pointF2;
                            objC3 = obj3;
                            pointF6 = pointF3;
                            pointFB6 = pointF10;
                        }
                        pointF = pointFB6;
                        PointF pointF11 = new PointF(fL7, fL8);
                        PointF pointF12 = new PointF(fL9, fL10);
                        dVar.h();
                        pointF4 = pointF12;
                        pointF7 = pointF11;
                    } else {
                        pointF = pointFB6;
                        pointFB8 = o.b(dVar, f);
                    }
                    linearInterpolator2 = linearInterpolator;
                    aVar3 = aVar2;
                    pointFB6 = pointF;
                    break;
                case 5:
                    z10 = dVar.m() == 1;
                    break;
                case 6:
                    pointFB5 = o.b(dVar, f);
                    break;
                case 7:
                    pointFB6 = o.b(dVar, f);
                    break;
                default:
                    dVar.B();
                    break;
            }
        }
        Interpolator interpolatorA4 = linearInterpolator2;
        PointF pointF13 = pointFB5;
        PointF pointF14 = pointFB6;
        Object obj5 = objC3;
        PointF pointF15 = pointF6;
        dVar.h();
        if (z10) {
            obj2 = obj5;
        } else {
            if (pointFB7 == null || pointFB8 == null) {
                if (pointF5 != null && pointF15 != null && pointF7 != null && pointF4 != null) {
                    interpolatorA2 = a(pointF5, pointF7);
                    interpolatorA3 = a(pointF15, pointF4);
                    obj2 = objC4;
                    interpolatorA4 = null;
                }
                if (interpolatorA2 != null || interpolatorA3 == null) {
                    aVar = new x1.a(jVar, obj5, obj2, interpolatorA4, fL2, (Float) null);
                } else {
                    aVar = new x1.a(jVar, obj5, obj2, interpolatorA2, interpolatorA3, fL2);
                }
                aVar.f10818o = pointF13;
                aVar.p = pointF14;
                return aVar;
            }
            interpolatorA4 = a(pointFB7, pointFB8);
            obj2 = objC4;
        }
        interpolatorA2 = null;
        interpolatorA3 = null;
        if (interpolatorA2 != null) {
            aVar = new x1.a(jVar, obj5, obj2, interpolatorA4, fL2, (Float) null);
        } else {
            aVar = new x1.a(jVar, obj5, obj2, interpolatorA4, fL2, (Float) null);
        }
        aVar.f10818o = pointF13;
        aVar.p = pointF14;
        return aVar;
    }
}
