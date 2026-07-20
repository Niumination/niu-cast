package x0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.animation.PathInterpolatorCompat;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f19924a = 100.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static SparseArrayCompat<WeakReference<Interpolator>> f19926c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Interpolator f19925b = new LinearInterpolator();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static y0.c.a f19927d = y0.c.a.a("t", p6.s.f13016a, "e", p6.o.f13007a, b9.i.f771b, "h", TypedValues.TransitionType.S_TO, "ti");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static y0.c.a f19928e = y0.c.a.a("x", "y");

    @Nullable
    public static WeakReference<Interpolator> a(int i10) {
        WeakReference<Interpolator> weakReference;
        synchronized (q.class) {
            weakReference = g().get(i10);
        }
        return weakReference;
    }

    public static Interpolator b(PointF pointF, PointF pointF2) {
        Interpolator interpolatorCreate;
        pointF.x = z0.g.c(pointF.x, -1.0f, 1.0f);
        pointF.y = z0.g.c(pointF.y, -100.0f, 100.0f);
        pointF2.x = z0.g.c(pointF2.x, -1.0f, 1.0f);
        float fC = z0.g.c(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fC;
        int i10 = z0.h.i(pointF.x, pointF.y, pointF2.x, fC);
        WeakReference<Interpolator> weakReferenceA = a(i10);
        Interpolator interpolator = weakReferenceA != null ? weakReferenceA.get() : null;
        if (weakReferenceA == null || interpolator == null) {
            try {
                interpolatorCreate = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e10) {
                interpolatorCreate = "The Path cannot loop back on itself.".equals(e10.getMessage()) ? PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
            }
            interpolator = interpolatorCreate;
            try {
                h(i10, new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    public static <T> a1.a<T> c(y0.c cVar, n0.g gVar, float f10, k0<T> k0Var, boolean z10, boolean z11) throws IOException {
        if (z10 && z11) {
            return e(gVar, cVar, f10, k0Var);
        }
        return z10 ? d(gVar, cVar, f10, k0Var) : f(cVar, f10, k0Var);
    }

    public static <T> a1.a<T> d(n0.g gVar, y0.c cVar, float f10, k0<T> k0Var) throws IOException {
        Interpolator interpolatorB;
        T t10;
        cVar.d();
        PointF pointFE = null;
        T tA = null;
        T tA2 = null;
        PointF pointFE2 = null;
        PointF pointFE3 = null;
        float fQ = 0.0f;
        boolean z10 = false;
        PointF pointFE4 = null;
        while (cVar.o()) {
            switch (cVar.e0(f19927d)) {
                case 0:
                    fQ = (float) cVar.q();
                    break;
                case 1:
                    tA2 = k0Var.a(cVar, f10);
                    break;
                case 2:
                    tA = k0Var.a(cVar, f10);
                    break;
                case 3:
                    pointFE = p.e(cVar, 1.0f);
                    break;
                case 4:
                    pointFE4 = p.e(cVar, 1.0f);
                    break;
                case 5:
                    z10 = cVar.t() == 1;
                    break;
                case 6:
                    pointFE2 = p.e(cVar, f10);
                    break;
                case 7:
                    pointFE3 = p.e(cVar, f10);
                    break;
                default:
                    cVar.g0();
                    break;
            }
        }
        cVar.k();
        if (z10) {
            interpolatorB = f19925b;
            t10 = tA2;
        } else {
            interpolatorB = (pointFE == null || pointFE4 == null) ? f19925b : b(pointFE, pointFE4);
            t10 = tA;
        }
        a1.a<T> aVar = new a1.a<>(gVar, tA2, t10, interpolatorB, fQ, null);
        aVar.f19o = pointFE2;
        aVar.f20p = pointFE3;
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:78:0x01c0  */
    public static <T> a1.a<T> e(n0.g gVar, y0.c cVar, float f10, k0<T> k0Var) throws IOException {
        Interpolator interpolatorB;
        Interpolator interpolatorB2;
        Interpolator interpolatorB3;
        T t10;
        a1.a<T> aVar;
        PointF pointF;
        float f11;
        PointF pointF2;
        float f12;
        cVar.d();
        PointF pointFE = null;
        boolean z10 = false;
        PointF pointFE2 = null;
        PointF pointFE3 = null;
        PointF pointF3 = null;
        T tA = null;
        PointF pointF4 = null;
        PointF pointF5 = null;
        PointF pointF6 = null;
        float fQ = 0.0f;
        PointF pointFE4 = null;
        T tA2 = null;
        while (cVar.o()) {
            switch (cVar.e0(f19927d)) {
                case 0:
                    pointF = pointFE;
                    fQ = (float) cVar.q();
                    pointFE = pointF;
                    break;
                case 1:
                    pointF = pointFE;
                    tA = k0Var.a(cVar, f10);
                    pointFE = pointF;
                    break;
                case 2:
                    pointF = pointFE;
                    tA2 = k0Var.a(cVar, f10);
                    pointFE = pointF;
                    break;
                case 3:
                    pointF = pointFE;
                    f11 = fQ;
                    PointF pointF7 = pointFE4;
                    if (cVar.O() == y0.c.b.BEGIN_OBJECT) {
                        cVar.d();
                        float fQ2 = 0.0f;
                        float fQ3 = 0.0f;
                        float fQ4 = 0.0f;
                        float fQ5 = 0.0f;
                        while (cVar.o()) {
                            int iE0 = cVar.e0(f19928e);
                            if (iE0 != 0) {
                                if (iE0 != 1) {
                                    cVar.g0();
                                } else if (cVar.O() == y0.c.b.NUMBER) {
                                    fQ5 = (float) cVar.q();
                                    fQ3 = fQ5;
                                } else {
                                    cVar.c();
                                    fQ3 = (float) cVar.q();
                                    fQ5 = (float) cVar.q();
                                    cVar.h();
                                }
                            } else if (cVar.O() == y0.c.b.NUMBER) {
                                fQ4 = (float) cVar.q();
                                fQ2 = fQ4;
                            } else {
                                cVar.c();
                                fQ2 = (float) cVar.q();
                                fQ4 = (float) cVar.q();
                                cVar.h();
                            }
                        }
                        PointF pointF8 = new PointF(fQ2, fQ3);
                        PointF pointF9 = new PointF(fQ4, fQ5);
                        cVar.k();
                        pointF4 = pointF9;
                        pointF3 = pointF8;
                        pointFE4 = pointF7;
                        fQ = f11;
                    } else {
                        pointFE2 = p.e(cVar, f10);
                        fQ = f11;
                        pointFE4 = pointF7;
                    }
                    pointFE = pointF;
                    break;
                case 4:
                    if (cVar.O() == y0.c.b.BEGIN_OBJECT) {
                        cVar.d();
                        float fQ6 = 0.0f;
                        float fQ7 = 0.0f;
                        float fQ8 = 0.0f;
                        float fQ9 = 0.0f;
                        while (cVar.o()) {
                            PointF pointF10 = pointFE4;
                            int iE1 = cVar.e0(f19928e);
                            if (iE1 != 0) {
                                pointF2 = pointFE;
                                if (iE1 != 1) {
                                    cVar.g0();
                                } else if (cVar.O() == y0.c.b.NUMBER) {
                                    fQ9 = (float) cVar.q();
                                    fQ = fQ;
                                    fQ7 = fQ9;
                                } else {
                                    f12 = fQ;
                                    cVar.c();
                                    fQ7 = (float) cVar.q();
                                    fQ9 = (float) cVar.q();
                                    cVar.h();
                                    fQ = f12;
                                }
                            } else {
                                pointF2 = pointFE;
                                f12 = fQ;
                                if (cVar.O() == y0.c.b.NUMBER) {
                                    fQ8 = (float) cVar.q();
                                    fQ = f12;
                                    fQ6 = fQ8;
                                } else {
                                    cVar.c();
                                    fQ6 = (float) cVar.q();
                                    fQ8 = (float) cVar.q();
                                    cVar.h();
                                    fQ = f12;
                                }
                            }
                            pointFE4 = pointF10;
                            pointFE = pointF2;
                        }
                        pointF = pointFE;
                        f11 = fQ;
                        PointF pointF11 = new PointF(fQ6, fQ7);
                        PointF pointF12 = new PointF(fQ8, fQ9);
                        cVar.k();
                        pointF6 = pointF12;
                        pointF5 = pointF11;
                        fQ = f11;
                    } else {
                        pointF = pointFE;
                        pointFE3 = p.e(cVar, f10);
                    }
                    pointFE = pointF;
                    break;
                case 5:
                    z10 = cVar.t() == 1;
                    break;
                case 6:
                    pointFE4 = p.e(cVar, f10);
                    break;
                case 7:
                    pointFE = p.e(cVar, f10);
                    break;
                default:
                    cVar.g0();
                    break;
            }
        }
        PointF pointF13 = pointFE;
        float f13 = fQ;
        PointF pointF14 = pointFE4;
        cVar.k();
        if (z10) {
            interpolatorB = f19925b;
            t10 = tA;
        } else {
            if (pointFE2 == null || pointFE3 == null) {
                if (pointF3 == null || pointF4 == null || pointF5 == null || pointF6 == null) {
                    interpolatorB = f19925b;
                } else {
                    interpolatorB2 = b(pointF3, pointF5);
                    interpolatorB3 = b(pointF4, pointF6);
                    t10 = tA2;
                    interpolatorB = null;
                }
                if (interpolatorB2 != null || interpolatorB3 == null) {
                    aVar = new a1.a<>(gVar, tA, t10, interpolatorB, f13, null);
                } else {
                    aVar = new a1.a<>(gVar, tA, t10, interpolatorB2, interpolatorB3, f13, null);
                }
                aVar.f19o = pointF14;
                aVar.f20p = pointF13;
                return aVar;
            }
            interpolatorB = b(pointFE2, pointFE3);
            t10 = tA2;
        }
        interpolatorB2 = null;
        interpolatorB3 = null;
        if (interpolatorB2 != null) {
            aVar = new a1.a<>(gVar, tA, t10, interpolatorB, f13, null);
        } else {
            aVar = new a1.a<>(gVar, tA, t10, interpolatorB, f13, null);
        }
        aVar.f19o = pointF14;
        aVar.f20p = pointF13;
        return aVar;
    }

    public static <T> a1.a<T> f(y0.c cVar, float f10, k0<T> k0Var) throws IOException {
        return new a1.a<>(k0Var.a(cVar, f10));
    }

    public static SparseArrayCompat<WeakReference<Interpolator>> g() {
        if (f19926c == null) {
            f19926c = new SparseArrayCompat<>();
        }
        return f19926c;
    }

    public static void h(int i10, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            f19926c.put(i10, weakReference);
        }
    }
}
