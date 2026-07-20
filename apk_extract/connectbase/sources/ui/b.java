package ui;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Interpolator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16283d = 4096;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16284a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f16285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f16286c;

    public b(float f10, float f11, float f12, float f13) {
        PointF pointF = new PointF();
        this.f16285b = pointF;
        PointF pointF2 = new PointF();
        this.f16286c = pointF2;
        pointF.x = f10;
        pointF.y = f11;
        pointF2.x = f12;
        pointF2.y = f13;
    }

    public static double a(double d10, double d11, double d12, double d13, double d14) {
        double d15 = 1.0d - d10;
        double d16 = d10 * d10;
        double d17 = d15 * d15;
        double d18 = d17 * d15 * d11;
        return (d16 * d10 * d14) + (d15 * 3.0d * d16 * d13) + (d17 * 3.0d * d10 * d12) + d18;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        float f11 = f10;
        for (int i10 = this.f16284a; i10 < 4096; i10++) {
            f11 = (i10 * 1.0f) / 4096.0f;
            if (a(f11, 0.0d, this.f16285b.x, this.f16286c.x, 1.0d) >= f10) {
                this.f16284a = i10;
                break;
            }
        }
        double dA = a(f11, 0.0d, this.f16285b.y, this.f16286c.y, 1.0d);
        if (dA > 0.999d) {
            this.f16284a = 0;
            dA = 1.0d;
        }
        return (float) dA;
    }
}
