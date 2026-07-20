package ie;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5758a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f5759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f5760c;

    public a(float f, float f4) {
        PointF pointF = new PointF();
        this.f5759b = pointF;
        PointF pointF2 = new PointF();
        this.f5760c = pointF2;
        pointF.x = f;
        pointF.y = 0.0f;
        pointF2.x = f4;
        pointF2.y = 1.0f;
    }

    public static double a(double d7, double d10, double d11) {
        double d12 = 1.0d - d7;
        double d13 = d7 * d7;
        double d14 = d12 * d12;
        double d15 = d14 * d12 * 0.0d;
        return (d13 * d7 * 1.0d) + (d12 * 3.0d * d13 * d11) + (d14 * 3.0d * d7 * d10) + d15;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        PointF pointF;
        PointF pointF2;
        int i8 = this.f5758a;
        float f4 = f;
        while (true) {
            pointF = this.f5760c;
            pointF2 = this.f5759b;
            if (i8 >= 4096) {
                break;
            }
            f4 = (i8 * 1.0f) / 4096.0f;
            if (a(f4, pointF2.x, pointF.x) >= f) {
                this.f5758a = i8;
                break;
            }
            i8++;
        }
        double dA = a(f4, pointF2.y, pointF.y);
        if (dA > 0.999d) {
            this.f5758a = 0;
            dA = 1.0d;
        }
        return (float) dA;
    }
}
