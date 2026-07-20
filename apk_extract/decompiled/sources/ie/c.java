package ie;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Interpolator f5763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5766d;
    public int e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5767g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5768h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5769i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f5770j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5771k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f5772l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f5773m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f5774n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f5775o;
    public final boolean p;
    public float q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f5776r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f5777s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f5778t;
    public float u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final SpringAnimation f5779v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f5780w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f5781x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f5782y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final float f5762z = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final float[] A = new float[101];
    public static final float[] B = new float[101];

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
            A[i8] = (((f11 * 0.5f) + f4) * f12) + f13;
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
            B[i8] = (((f14 * 0.35000002f) + (f15 * 0.175f)) * f16) + f17;
        }
        float[] fArr = A;
        B[100] = 1.0f;
        fArr[100] = 1.0f;
    }

    public c(Context context, OvershootInterpolator overshootInterpolator) {
        boolean z2 = context.getApplicationInfo().targetSdkVersion >= 11;
        this.u = ViewConfiguration.getScrollFriction();
        b bVar = new b(this);
        this.f5775o = true;
        this.f5763a = overshootInterpolator;
        float f = context.getResources().getDisplayMetrics().density * 160.0f;
        this.f5781x = f;
        this.f5780w = f * 386.0878f * ViewConfiguration.getScrollFriction();
        this.p = z2;
        this.f5782y = f * 386.0878f * 0.25f;
        if (this.f5779v == null) {
            this.f5779v = new SpringAnimation(this, bVar);
        }
    }

    public final void a(float f, float f4, boolean z2) {
        SpringAnimation springAnimation = this.f5779v;
        if (springAnimation != null && springAnimation.isRunning()) {
            springAnimation.cancel();
        }
        springAnimation.setSpring(new SpringForce(f4).setStiffness(50.0f).setDampingRatio(1.1f));
        if (!z2) {
            springAnimation.setStartVelocity(Math.min(this.q, 4000.0f));
        }
        springAnimation.setStartValue(f);
        springAnimation.start();
    }

    public float getCurrVelocity() {
        return this.f5764b == 1 ? this.f5776r : this.q - ((this.f5780w * ((int) (AnimationUtils.currentAnimationTimeMillis() - this.f5770j))) / 2000.0f);
    }

    public final int getCurrX() {
        return this.f5768h;
    }

    public final int getCurrY() {
        return this.f5769i;
    }

    public final int getDuration() {
        return this.f5771k;
    }

    public final int getFinalX() {
        return this.f5766d;
    }

    public final int getFinalY() {
        return this.e;
    }

    public float getFixedFlingValue() {
        if (this.f5764b != 1) {
            return 0.0f;
        }
        int iCurrentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.f5770j);
        int i8 = this.f5771k;
        if (iCurrentAnimationTimeMillis >= i8 || i8 <= 0 || this.f5775o) {
            return this.f5778t;
        }
        float interpolation = iCurrentAnimationTimeMillis / i8;
        Interpolator interpolator = this.f5763a;
        if (interpolator != null) {
            interpolation = interpolator.getInterpolation(interpolation);
        }
        return interpolation * this.f5778t;
    }

    public final int getStartX() {
        return 0;
    }

    public final int getStartY() {
        return this.f5765c;
    }

    public void setFinalX(int i8) {
        this.f5766d = i8;
        this.f5773m = i8;
        this.f5775o = false;
    }

    public void setFinalY(int i8) {
        this.e = i8;
        this.f5774n = i8 - this.f5765c;
        this.f5775o = false;
    }

    public void setFixedFlingValue(float f) {
        this.f5778t = f;
    }

    public final void setFriction(float f) {
        this.f5780w = this.f5781x * 386.0878f * f;
        this.u = f;
    }
}
