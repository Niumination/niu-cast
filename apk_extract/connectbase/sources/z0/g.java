package z0;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.List;
import p0.k;
import u0.l;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PointF f21761a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static double b(double d10, double d11, double d12) {
        return Math.max(d11, Math.min(d12, d10));
    }

    public static float c(float f10, float f11, float f12) {
        return Math.max(f11, Math.min(f12, f10));
    }

    public static int d(int i10, int i11, int i12) {
        return Math.max(i11, Math.min(i12, i10));
    }

    public static boolean e(float f10, float f11, float f12) {
        return f10 >= f11 && f10 <= f12;
    }

    public static int f(int i10, int i11) {
        int i12 = i10 / i11;
        return (((i10 ^ i11) >= 0) || i10 % i11 == 0) ? i12 : i12 - 1;
    }

    public static int g(float f10, float f11) {
        return h((int) f10, (int) f11);
    }

    public static int h(int i10, int i11) {
        return i10 - (f(i10, i11) * i11);
    }

    public static void i(l lVar, Path path) {
        path.reset();
        PointF pointFB = lVar.b();
        path.moveTo(pointFB.x, pointFB.y);
        f21761a.set(pointFB.x, pointFB.y);
        for (int i10 = 0; i10 < lVar.a().size(); i10++) {
            s0.a aVar = lVar.a().get(i10);
            PointF pointFA = aVar.a();
            PointF pointFB2 = aVar.b();
            PointF pointFC = aVar.c();
            if (pointFA.equals(f21761a) && pointFB2.equals(pointFC)) {
                path.lineTo(pointFC.x, pointFC.y);
            } else {
                path.cubicTo(pointFA.x, pointFA.y, pointFB2.x, pointFB2.y, pointFC.x, pointFC.y);
            }
            f21761a.set(pointFC.x, pointFC.y);
        }
        if (lVar.d()) {
            path.close();
        }
    }

    public static double j(double d10, double d11, @FloatRange(from = 0.0d, to = 1.0d) double d12) {
        return ((d11 - d10) * d12) + d10;
    }

    public static float k(float f10, float f11, @FloatRange(from = 0.0d, to = 1.0d) float f12) {
        return g.a.a(f11, f10, f12, f10);
    }

    public static int l(int i10, int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return (int) ((f10 * (i11 - i10)) + i10);
    }

    public static void m(s0.f fVar, int i10, List<s0.f> list, s0.f fVar2, k kVar) {
        if (fVar.c(kVar.getName(), i10)) {
            list.add(fVar2.a(kVar.getName()).j(kVar));
        }
    }
}
