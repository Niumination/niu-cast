package pj;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static final int B = 250;
    public static final int C = 0;
    public static final int D = 1;
    public static final float F = 0.35f;
    public static final float G = 0.5f;
    public static final float H = 1.0f;
    public static final float I = 0.175f;
    public static final float J = 0.35000002f;
    public static final int K = 100;
    public float A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Interpolator f13125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13133i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13134j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13135k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13136l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f13137m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13138n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f13139o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13140p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f13141q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f13142r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f13143s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f13144t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f13145u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13146v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f13147w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f13148x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f13149y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f13150z;
    public static float E = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final float[] L = new float[101];
    public static final float[] M = new float[101];

    public static class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final float f13151a = 8.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final float f13152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final float f13153c;

        static {
            float fA = 1.0f / a(1.0f);
            f13152b = fA;
            f13153c = 1.0f - (a(1.0f) * fA);
        }

        public static float a(float f10) {
            float f11 = f10 * 8.0f;
            return f11 < 1.0f ? f11 - (1.0f - ((float) Math.exp(-f11))) : g.a.a(1.0f, (float) Math.exp(1.0f - f11), 0.63212055f, 0.36787945f);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float fA = a(f10) * f13152b;
            return fA > 0.0f ? fA + f13153c : fA;
        }
    }

    static {
        float fA;
        float f10;
        float f11;
        float f12;
        float fA2;
        float f13;
        float f14;
        float f15;
        float f16 = 0.0f;
        int i10 = 0;
        float f17 = 0.0f;
        while (true) {
            float f18 = 1.0f;
            if (i10 >= 100) {
                float[] fArr = L;
                M[100] = 1.0f;
                fArr[100] = 1.0f;
                return;
            }
            float f19 = i10 / 100.0f;
            float f20 = 1.0f;
            while (true) {
                fA = t.a.a(f20, f16, 2.0f, f16);
                f10 = f18 - fA;
                f11 = fA * 3.0f * f10;
                f12 = fA * fA * fA;
                float f21 = (((fA * 0.35000002f) + (f10 * 0.175f)) * f11) + f12;
                if (Math.abs(f21 - f19) < 1.0E-5d) {
                    break;
                }
                float f22 = f19;
                if (f21 > f22) {
                    f20 = fA;
                } else {
                    f16 = fA;
                }
                f19 = f22;
                f18 = 1.0f;
            }
            L[i10] = (((f10 * 0.5f) + fA) * f11) + f12;
            float f23 = f18;
            while (true) {
                fA2 = t.a.a(f23, f17, 2.0f, f17);
                f13 = f18 - fA2;
                f14 = fA2 * 3.0f * f13;
                f15 = fA2 * fA2 * fA2;
                float f24 = (((f13 * 0.5f) + fA2) * f14) + f15;
                float f25 = f19;
                if (Math.abs(f24 - f19) < 1.0E-5d) {
                    break;
                }
                if (f24 > f25) {
                    f23 = fA2;
                } else {
                    f17 = fA2;
                }
                f19 = f25;
                f18 = 1.0f;
            }
            M[i10] = (((fA2 * 0.35000002f) + (f13 * 0.175f)) * f14) + f15;
            i10++;
        }
    }

    public d(Context context) {
        this(context, null);
    }

    public int A() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.f13137m);
    }

    public void a() {
        this.f13135k = this.f13129e;
        this.f13136l = this.f13130f;
        this.f13142r = true;
    }

    public final float b(float f10) {
        return this.f13150z * 386.0878f * f10;
    }

    public boolean c() {
        float fA;
        float f10;
        if (this.f13142r) {
            return false;
        }
        int iCurrentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.f13137m);
        int i10 = this.f13138n;
        if (iCurrentAnimationTimeMillis < i10) {
            int i11 = this.f13126b;
            if (i11 == 0) {
                float interpolation = this.f13125a.getInterpolation(iCurrentAnimationTimeMillis * this.f13139o);
                this.f13135k = Math.round(this.f13140p * interpolation) + this.f13127c;
                this.f13136l = Math.round(interpolation * this.f13141q) + this.f13128d;
            } else if (i11 == 1) {
                float f11 = iCurrentAnimationTimeMillis / i10;
                int i12 = (int) (f11 * 100.0f);
                if (i12 < 100) {
                    float f12 = i12 / 100.0f;
                    int i13 = i12 + 1;
                    float[] fArr = L;
                    float f13 = fArr[i12];
                    f10 = (fArr[i13] - f13) / ((i13 / 100.0f) - f12);
                    fA = g.a.a(f11, f12, f10, f13);
                } else {
                    fA = 1.0f;
                    f10 = 0.0f;
                }
                this.f13145u = ((f10 * this.f13146v) / i10) * 1000.0f;
                int i14 = this.f13127c;
                int iRound = Math.round((this.f13129e - i14) * fA) + i14;
                this.f13135k = iRound;
                int iMin = Math.min(iRound, this.f13132h);
                this.f13135k = iMin;
                this.f13135k = Math.max(iMin, this.f13131g);
                int i15 = this.f13128d;
                int iRound2 = Math.round(fA * (this.f13130f - i15)) + i15;
                this.f13136l = iRound2;
                int iMin2 = Math.min(iRound2, this.f13134j);
                this.f13136l = iMin2;
                int iMax = Math.max(iMin2, this.f13133i);
                this.f13136l = iMax;
                if (this.f13135k == this.f13129e && iMax == this.f13130f) {
                    this.f13142r = true;
                }
            }
        } else {
            this.f13135k = this.f13129e;
            this.f13136l = this.f13130f;
            this.f13142r = true;
        }
        return true;
    }

    public void d(int i10) {
        int iA = A() + i10;
        this.f13138n = iA;
        this.f13139o = 1.0f / iA;
        this.f13142r = false;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0072  */
    /* JADX WARN: Code duplicated, block: B:16:0x0074  */
    /* JADX WARN: Code duplicated, block: B:19:0x0079  */
    public void e(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18;
        int i19;
        float fHypot;
        float f10;
        if (this.f13143s && !this.f13142r) {
            float fG = g();
            float f11 = this.f13129e - this.f13127c;
            float f12 = this.f13130f - this.f13128d;
            float fHypot2 = (float) Math.hypot(f11, f12);
            float f13 = (f11 / fHypot2) * fG;
            float f14 = (f12 / fHypot2) * fG;
            i18 = i12;
            float f15 = i18;
            if (Math.signum(f15) == Math.signum(f13)) {
                i19 = i13;
                float f16 = i19;
                if (Math.signum(f16) == Math.signum(f14)) {
                    i18 = (int) (f15 + f13);
                    i19 = (int) (f16 + f14);
                }
            }
            this.f13126b = 1;
            this.f13142r = false;
            fHypot = (float) Math.hypot(i18, i19);
            this.f13144t = fHypot;
            this.f13138n = p(fHypot);
            this.f13137m = AnimationUtils.currentAnimationTimeMillis();
            this.f13127c = i10;
            this.f13128d = i11;
            if (fHypot == 0.0f) {
                f10 = 1.0f;
            } else {
                f10 = i18 / fHypot;
            }
            float f17 = fHypot != 0.0f ? i19 / fHypot : 1.0f;
            double dO = o(fHypot);
            this.f13146v = (int) (((double) Math.signum(fHypot)) * dO);
            this.f13131g = i14;
            this.f13132h = i15;
            this.f13133i = i16;
            this.f13134j = i17;
            int iRound = i10 + ((int) Math.round(((double) f10) * dO));
            this.f13129e = iRound;
            int iMin = Math.min(iRound, this.f13132h);
            this.f13129e = iMin;
            this.f13129e = Math.max(iMin, this.f13131g);
            int iRound2 = ((int) Math.round(dO * ((double) f17))) + i11;
            this.f13130f = iRound2;
            int iMin2 = Math.min(iRound2, this.f13134j);
            this.f13130f = iMin2;
            this.f13130f = Math.max(iMin2, this.f13133i);
            this.f13147w = 0.0f;
        }
        i18 = i12;
        i19 = i13;
        this.f13126b = 1;
        this.f13142r = false;
        fHypot = (float) Math.hypot(i18, i19);
        this.f13144t = fHypot;
        this.f13138n = p(fHypot);
        this.f13137m = AnimationUtils.currentAnimationTimeMillis();
        this.f13127c = i10;
        this.f13128d = i11;
        if (fHypot == 0.0f) {
            f10 = 1.0f;
        } else {
            f10 = i18 / fHypot;
        }
        if (fHypot != 0.0f) {
        }
        double dO2 = o(fHypot);
        this.f13146v = (int) (((double) Math.signum(fHypot)) * dO2);
        this.f13131g = i14;
        this.f13132h = i15;
        this.f13133i = i16;
        this.f13134j = i17;
        int iRound3 = i10 + ((int) Math.round(((double) f10) * dO2));
        this.f13129e = iRound3;
        int iMin3 = Math.min(iRound3, this.f13132h);
        this.f13129e = iMin3;
        this.f13129e = Math.max(iMin3, this.f13131g);
        int iRound4 = ((int) Math.round(dO2 * ((double) f17))) + i11;
        this.f13130f = iRound4;
        int iMin4 = Math.min(iRound4, this.f13134j);
        this.f13130f = iMin4;
        this.f13130f = Math.max(iMin4, this.f13133i);
        this.f13147w = 0.0f;
    }

    public final void f(boolean z10) {
        this.f13142r = z10;
    }

    public float g() {
        return this.f13126b == 1 ? this.f13145u : this.f13144t - ((this.f13149y * A()) / 2000.0f);
    }

    public final int h() {
        return this.f13135k;
    }

    public final int i() {
        return this.f13136l;
    }

    public final int j() {
        return this.f13138n;
    }

    public final int k() {
        return this.f13129e;
    }

    public final int l() {
        return this.f13130f;
    }

    public float m() {
        if (this.f13126b != 1) {
            return 0.0f;
        }
        int iCurrentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.f13137m);
        int i10 = this.f13138n;
        if (iCurrentAnimationTimeMillis >= i10 || i10 <= 0) {
            return this.f13147w;
        }
        float interpolation = iCurrentAnimationTimeMillis / i10;
        Interpolator interpolator = this.f13125a;
        if (interpolator != null) {
            interpolation = interpolator.getInterpolation(interpolation);
        }
        return interpolation * this.f13147w;
    }

    public final double n(float f10) {
        return Math.log((Math.abs(f10) * 0.35f) / (this.f13148x * this.A));
    }

    public final double o(float f10) {
        double dN = n(f10);
        float f11 = E;
        return Math.exp((((double) f11) / (((double) f11) - 1.0d)) * dN) * ((double) (this.f13148x * this.A));
    }

    public final int p(float f10) {
        return (int) (Math.exp(n(f10) / (((double) E) - 1.0d)) * 1000.0d);
    }

    public final int q() {
        return this.f13127c;
    }

    public final int r() {
        return this.f13128d;
    }

    public final boolean s() {
        return this.f13142r;
    }

    public boolean t(float f10, float f11) {
        return !this.f13142r && Math.signum(f10) == Math.signum((float) (this.f13129e - this.f13127c)) && Math.signum(f11) == Math.signum((float) (this.f13130f - this.f13128d));
    }

    public void u(int i10) {
        this.f13129e = i10;
        this.f13140p = i10 - this.f13127c;
        this.f13142r = false;
    }

    public void v(int i10) {
        this.f13130f = i10;
        this.f13141q = i10 - this.f13128d;
        this.f13142r = false;
    }

    public void w(float f10) {
        this.f13147w = f10;
    }

    public final void x(float f10) {
        this.f13149y = b(f10);
        this.f13148x = f10;
    }

    public void y(int i10, int i11, int i12, int i13) {
        z(i10, i11, i12, i13, 250);
    }

    public void z(int i10, int i11, int i12, int i13, int i14) {
        this.f13126b = 0;
        this.f13142r = false;
        this.f13138n = i14;
        this.f13137m = AnimationUtils.currentAnimationTimeMillis();
        this.f13127c = i10;
        this.f13128d = i11;
        this.f13129e = i10 + i12;
        this.f13130f = i11 + i13;
        this.f13140p = i12;
        this.f13141q = i13;
        this.f13139o = 1.0f / this.f13138n;
        this.f13147w = 0.0f;
    }

    public d(Context context, Interpolator interpolator) {
        this(context, interpolator, context.getApplicationInfo().targetSdkVersion >= 11);
    }

    public d(Context context, Interpolator interpolator, boolean z10) {
        this.f13148x = ViewConfiguration.getScrollFriction();
        this.f13142r = true;
        if (interpolator == null) {
            this.f13125a = new a();
        } else {
            this.f13125a = interpolator;
        }
        this.f13150z = context.getResources().getDisplayMetrics().density * 160.0f;
        this.f13149y = b(ViewConfiguration.getScrollFriction());
        this.f13143s = z10;
        this.A = b(0.25f);
    }
}
