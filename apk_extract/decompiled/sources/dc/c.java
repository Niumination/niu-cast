package dc;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import k3.m1;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f4402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PointF f4403d;

    public c(float f, float f4) {
        this.f4400a = 0;
        PointF pointF = new PointF();
        this.f4402c = pointF;
        PointF pointF2 = new PointF();
        this.f4403d = pointF2;
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
        PointF pointF3;
        PointF pointF4;
        switch (this.f4400a) {
            case 0:
                int i8 = this.f4401b;
                float f4 = f;
                while (true) {
                    pointF = this.f4403d;
                    pointF2 = this.f4402c;
                    if (i8 < 4096) {
                        f4 = (i8 * 1.0f) / 4096;
                        if (m1.a(f4, pointF2.x, pointF.x) >= f) {
                            this.f4401b = i8;
                        } else {
                            i8++;
                        }
                    }
                }
                double dA = m1.a(f4, pointF2.y, pointF.y);
                if (dA > 0.999d) {
                    this.f4401b = 0;
                    dA = 1.0d;
                }
                return (float) dA;
            default:
                int i9 = this.f4401b;
                float f10 = f;
                while (true) {
                    pointF3 = this.f4403d;
                    pointF4 = this.f4402c;
                    if (i9 < 4096) {
                        f10 = (i9 * 1.0f) / 4096.0f;
                        if (a(f10, pointF4.x, pointF3.x) >= f) {
                            this.f4401b = i9;
                        } else {
                            i9++;
                        }
                    }
                }
                double dA2 = a(f10, pointF4.y, pointF3.y);
                if (dA2 > 0.999d) {
                    this.f4401b = 0;
                    dA2 = 1.0d;
                }
                return (float) dA2;
        }
    }

    public c() {
        this.f4400a = 1;
        this.f4401b = 0;
        PointF pointF = new PointF();
        this.f4402c = pointF;
        PointF pointF2 = new PointF();
        this.f4403d = pointF2;
        pointF.x = 0.33f;
        pointF.y = 0.0f;
        pointF2.x = 0.66f;
        pointF2.y = 1.0f;
    }
}
