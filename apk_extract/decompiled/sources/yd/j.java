package yd;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final float f11137s = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final float[] f11138t = new float[101];
    public static final float[] u = new float[101];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11142d;
    public float e;
    public float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f11143g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11144h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11145i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f11146j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11147k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f11148l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f11149m = ViewConfiguration.getScrollFriction();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f11150n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SpringAnimation f11151o;
    public final float p;
    public final float q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DynamicAnimation.OnAnimationUpdateListener f11152r;

    static {
        float f;
        float f4;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18 = 0.0f;
        float f19 = 0.0f;
        for (int i8 = 0; i8 < 100; i8++) {
            float f20 = i8 / 100.0f;
            float f21 = 1.0f;
            while (true) {
                f = 2.0f;
                f4 = ((f21 - f18) / 2.0f) + f18;
                f10 = 3.0f;
                f11 = 1.0f - f4;
                f12 = f4 * 3.0f * f11;
                f13 = f4 * f4 * f4;
                float f22 = (((f4 * 0.35000002f) + (f11 * 0.175f)) * f12) + f13;
                if (Math.abs(f22 - f20) < 1.0E-5d) {
                    break;
                } else if (f22 > f20) {
                    f21 = f4;
                } else {
                    f18 = f4;
                }
            }
            f11138t[i8] = (((f11 * 0.5f) + f4) * f12) + f13;
            float f23 = 1.0f;
            while (true) {
                f14 = ((f23 - f19) / f) + f19;
                f15 = 1.0f - f14;
                f16 = f14 * f10 * f15;
                f17 = f14 * f14 * f14;
                float f24 = (((f15 * 0.5f) + f14) * f16) + f17;
                if (Math.abs(f24 - f20) < 1.0E-5d) {
                    break;
                }
                if (f24 > f20) {
                    f23 = f14;
                } else {
                    f19 = f14;
                }
                f = 2.0f;
                f10 = 3.0f;
            }
            u[i8] = (((f14 * 0.35000002f) + (f15 * 0.175f)) * f16) + f17;
        }
        float[] fArr = f11138t;
        u[100] = 1.0f;
        fArr[100] = 1.0f;
    }

    public j(Context context) {
        this.q = 3.0f;
        g gVar = new g("splineOverScrollerSpring");
        this.f11147k = true;
        this.q = context.getResources().getDisplayMetrics().density;
        this.p = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        SpringAnimation springAnimation = new SpringAnimation(this, gVar);
        this.f11151o = springAnimation;
        springAnimation.addUpdateListener(new h(this));
        springAnimation.addEndListener(new i(this));
    }

    public final void a(int i8, int i9) {
        float fAbs = Math.abs((0 - i8) / (i9 - i8));
        int i10 = (int) (fAbs * 100.0f);
        if (i10 < 100) {
            float f = i10 / 100.0f;
            int i11 = i10 + 1;
            float[] fArr = u;
            float f4 = fArr[i10];
            this.f11144h = (int) (this.f11144h * a1.a.b(fArr[i11], f4, (fAbs - f) / ((i11 / 100.0f) - f), f4));
        }
    }

    public final void b() {
        SpringAnimation springAnimation = this.f11151o;
        if (springAnimation != null && springAnimation.isRunning()) {
            springAnimation.cancel();
        }
        this.f11140b = this.f11141c;
        this.f11147k = true;
    }

    public final void c(int i8, int i9, int i10) {
        this.f11147k = false;
        this.f11150n = 3;
        this.f11139a = i8;
        this.f11140b = i8;
        this.f11141c = i9;
        SpringAnimation springAnimation = this.f11151o;
        if (springAnimation != null && springAnimation.isRunning()) {
            springAnimation.cancel();
        }
        springAnimation.setSpring(new SpringForce(this.f11141c).setStiffness(200.0f).setDampingRatio(1.0f));
        springAnimation.setStartVelocity(i10);
        springAnimation.start();
    }

    public final boolean d() {
        float fB;
        float f;
        double d7;
        if (this.f11150n == 3) {
            return this.f11147k;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f11143g;
        if (jCurrentAnimationTimeMillis == 0) {
            return this.f11144h > 0;
        }
        int i8 = this.f11144h;
        if (jCurrentAnimationTimeMillis > i8) {
            return false;
        }
        int i9 = this.f11150n;
        if (i9 == 0) {
            float f4 = this.f11145i;
            float f10 = jCurrentAnimationTimeMillis / f4;
            int i10 = (int) (f10 * 100.0f);
            if (i10 < 100) {
                float f11 = i10 / 100.0f;
                int i11 = i10 + 1;
                float[] fArr = f11138t;
                float f12 = fArr[i10];
                f = (fArr[i11] - f12) / ((i11 / 100.0f) - f11);
                fB = a1.a.b(f10, f11, f, f12);
            } else {
                fB = 1.0f;
                f = 0.0f;
            }
            float f13 = this.f11146j;
            this.e = ((f * f13) / f4) * 1000.0f;
            d7 = fB * f13;
        } else if (i9 == 1) {
            float f14 = jCurrentAnimationTimeMillis / i8;
            float f15 = f14 * f14;
            float fSignum = Math.signum(this.f11142d) * this.f11148l;
            this.e = ((-f14) + f15) * fSignum * 6.0f;
            d7 = ((3.0f * f15) - ((2.0f * f14) * f15)) * fSignum;
        } else if (i9 != 2) {
            d7 = 0.0d;
        } else {
            float f16 = jCurrentAnimationTimeMillis / 1000.0f;
            float f17 = this.f11142d;
            float f18 = this.f * f16;
            this.e = f18 + f17;
            d7 = ((f18 * f16) / 2.0f) + (f17 * f16);
        }
        this.f11140b = this.f11139a + ((int) Math.round(d7));
        return true;
    }

    public void setSpringAnimationListener(DynamicAnimation.OnAnimationUpdateListener onAnimationUpdateListener) {
        this.f11152r = onAnimationUpdateListener;
    }
}
