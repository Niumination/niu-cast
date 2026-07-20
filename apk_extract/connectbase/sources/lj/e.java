package lj;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10031e = "OverScroller";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f10032f = 250;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f10033g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f10034h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Interpolator f10035i = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f10037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TimeInterpolator f10038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f10039d;

    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    public static class b {
        public static final float A = 0.175f;
        public static final float B = 0.35000002f;
        public static final int C = 100;
        public static final int F = 0;
        public static final int G = 1;
        public static final int H = 2;
        public static final int I = 3;
        public static final int J = 1500;
        public static final float K = 200.0f;
        public static final float L = 1.0f;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final float f10040v = 2000.0f;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final float f10042x = 0.35f;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final float f10043y = 0.5f;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final float f10044z = 1.0f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f10047c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f10048d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f10049e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f10050f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f10051g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f10052h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f10053i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f10054j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f10055k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f10056l;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Context f10059o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public SpringAnimation f10060p;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f10062r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f10063s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public DynamicAnimation.OnAnimationUpdateListener f10064t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final FloatPropertyCompat<b> f10065u;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static float f10041w = (float) (Math.log(0.78d) / Math.log(0.9d));
        public static final float[] D = new float[101];
        public static final float[] E = new float[101];

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f10057m = ViewConfiguration.getScrollFriction();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f10058n = 0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f10061q = true;

        public class a extends FloatPropertyCompat<b> {
            public a(String str) {
                super(str);
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public float getValue(b bVar) {
                return bVar.f10046b;
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void setValue(b bVar, float f10) {
                bVar.f10061q = false;
                bVar.f10046b = (int) f10;
                Log.d(e.f10031e, "setValue: 卡顿过滤 SPRING_PROPERTY value = " + f10);
            }
        }

        /* JADX INFO: renamed from: lj.e$b$b, reason: collision with other inner class name */
        public class C0263b implements DynamicAnimation.OnAnimationUpdateListener {
            public C0263b() {
            }

            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f10, float f11) {
                if (b.this.f10064t != null) {
                    b.this.f10064t.onAnimationUpdate(dynamicAnimation, f10, f11);
                }
            }
        }

        public class c implements DynamicAnimation.OnAnimationEndListener {
            public c() {
            }

            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z10, float f10, float f11) {
                b.this.q();
                b bVar = b.this;
                bVar.f10058n = 0;
                bVar.f10046b = (int) f10;
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
                    float[] fArr = D;
                    E[100] = 1.0f;
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
                D[i10] = (((f10 * 0.5f) + fA) * f11) + f12;
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
                E[i10] = (((fA2 * 0.35000002f) + (f13 * 0.175f)) * f14) + f15;
                i10++;
            }
        }

        public b(Context context) {
            this.f10063s = 3.0f;
            a aVar = new a("splineOverScrollerSpring");
            this.f10065u = aVar;
            this.f10059o = context;
            this.f10055k = true;
            this.f10063s = context.getResources().getDisplayMetrics().density;
            this.f10062r = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
            SpringAnimation springAnimation = new SpringAnimation(this, aVar);
            this.f10060p = springAnimation;
            springAnimation.addUpdateListener(new C0263b());
            this.f10060p.addEndListener(new c());
        }

        public static float t(int i10) {
            return i10 > 0 ? -2000.0f : 2000.0f;
        }

        public void A(float f10) {
            this.f10057m = f10;
        }

        public void B(DynamicAnimation.OnAnimationUpdateListener onAnimationUpdateListener) {
            this.f10064t = onAnimationUpdateListener;
        }

        public void C() {
            SpringAnimation springAnimation = this.f10060p;
            if (springAnimation != null && springAnimation.isRunning()) {
                this.f10060p.cancel();
            }
            this.f10055k = true;
        }

        public boolean D(int i10, int i11, int i12) {
            this.f10047c = i10;
            this.f10045a = i10;
            this.f10046b = i10;
            this.f10048d = 0;
            this.f10051g = AnimationUtils.currentAnimationTimeMillis();
            this.f10052h = 0;
            if (i10 < i11) {
                I(i10, i11, 0);
            } else if (i10 > i12) {
                I(i10, i12, 0);
            }
            return !this.f10055k;
        }

        public final void E(int i10, int i11, int i12, int i13) {
            if (i10 > i11 && i10 < i12) {
                Log.d(e.f10031e, "finish: " + Log.getStackTraceString(new Throwable()));
                this.f10055k = true;
                return;
            }
            boolean z10 = i10 > i12;
            int i14 = z10 ? i12 : i11;
            int i15 = i10 - i14;
            if (i15 * i13 >= 0) {
                F(i10, i14, i13);
            } else if (v(i13) > Math.abs(i15)) {
                s(i10, i13, z10 ? i11 : i10, z10 ? i10 : i12, this.f10056l);
            } else {
                I(i10, i14, i13);
            }
        }

        public final void F(int i10, int i11, int i12) {
            this.f10050f = t(i12 == 0 ? i10 - i11 : i12);
            I(i11, i11, i12);
        }

        public void G(int i10, int i11, int i12) {
            H(i10, i11, i12, 0.0f);
        }

        public void H(int i10, int i11, int i12, float f10) {
            this.f10055k = false;
            this.f10045a = i10;
            this.f10046b = i10;
            this.f10047c = i10 + i11;
            this.f10051g = AnimationUtils.currentAnimationTimeMillis();
            this.f10052h = i12;
            this.f10050f = 0.0f;
            this.f10048d = 0;
        }

        public final void I(int i10, int i11, int i12) {
            this.f10055k = false;
            this.f10058n = 3;
            this.f10045a = i10;
            this.f10046b = i10;
            this.f10047c = i11;
            SpringAnimation springAnimation = this.f10060p;
            if (springAnimation != null && springAnimation.isRunning()) {
                this.f10060p.cancel();
            }
            this.f10060p.setSpring(new SpringForce(this.f10047c).setStiffness(200.0f).setDampingRatio(1.0f));
            this.f10060p.setStartVelocity(i12);
            this.f10060p.start();
        }

        public boolean J() {
            float fA;
            float f10;
            double d10;
            if (this.f10058n == 3) {
                return this.f10055k;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f10051g;
            if (jCurrentAnimationTimeMillis == 0) {
                return this.f10052h > 0;
            }
            int i10 = this.f10052h;
            if (jCurrentAnimationTimeMillis > i10) {
                return false;
            }
            int i11 = this.f10058n;
            if (i11 == 0) {
                int i12 = this.f10053i;
                float f11 = jCurrentAnimationTimeMillis / i12;
                int i13 = (int) (f11 * 100.0f);
                if (i13 < 100) {
                    float f12 = i13 / 100.0f;
                    int i14 = i13 + 1;
                    float[] fArr = D;
                    float f13 = fArr[i13];
                    f10 = (fArr[i14] - f13) / ((i14 / 100.0f) - f12);
                    fA = g.a.a(f11, f12, f10, f13);
                } else {
                    fA = 1.0f;
                    f10 = 0.0f;
                }
                int i15 = this.f10054j;
                this.f10049e = ((f10 * i15) / i12) * 1000.0f;
                d10 = fA * i15;
            } else if (i11 == 1) {
                float f14 = jCurrentAnimationTimeMillis / i10;
                float f15 = f14 * f14;
                float fSignum = Math.signum(this.f10048d);
                int i16 = this.f10056l;
                this.f10049e = ((-f14) + f15) * fSignum * i16 * 6.0f;
                d10 = ((3.0f * f15) - ((2.0f * f14) * f15)) * i16 * fSignum;
            } else if (i11 != 2) {
                d10 = 0.0d;
            } else {
                float f16 = jCurrentAnimationTimeMillis / 1000.0f;
                int i17 = this.f10048d;
                float f17 = this.f10050f;
                this.f10049e = (f17 * f16) + i17;
                d10 = (((f17 * f16) * f16) / 2.0f) + (i17 * f16);
            }
            this.f10046b = this.f10045a + ((int) Math.round(d10));
            return true;
        }

        public void K(float f10) {
            if (this.f10058n == 3) {
                return;
            }
            int i10 = this.f10045a;
            this.f10046b = Math.round(f10 * (this.f10047c - i10)) + i10;
        }

        public final void n(int i10, int i11, int i12) {
            float fAbs = Math.abs((i12 - i10) / (i11 - i10));
            int i13 = (int) (fAbs * 100.0f);
            if (i13 < 100) {
                float f10 = i13 / 100.0f;
                int i14 = i13 + 1;
                float[] fArr = E;
                float f11 = fArr[i13];
                this.f10052h = (int) (this.f10052h * g.a.a(fArr[i14], f11, (fAbs - f10) / ((i14 / 100.0f) - f10), f11));
            }
        }

        public boolean o() {
            int i10 = this.f10058n;
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                if (i10 == 2) {
                    this.f10051g += (long) this.f10052h;
                    I(this.f10047c, this.f10045a, 0);
                }
            } else {
                if (this.f10052h >= this.f10053i) {
                    return false;
                }
                int i11 = this.f10047c;
                this.f10045a = i11;
                this.f10046b = i11;
                int i12 = (int) this.f10049e;
                this.f10048d = i12;
                this.f10050f = t(i12);
                this.f10051g += (long) this.f10052h;
                y();
            }
            J();
            return true;
        }

        public void p(int i10) {
            int iCurrentAnimationTimeMillis = ((int) (AnimationUtils.currentAnimationTimeMillis() - this.f10051g)) + i10;
            this.f10053i = iCurrentAnimationTimeMillis;
            this.f10052h = iCurrentAnimationTimeMillis;
            this.f10055k = false;
        }

        public void q() {
            SpringAnimation springAnimation = this.f10060p;
            if (springAnimation != null && springAnimation.isRunning()) {
                this.f10060p.cancel();
            }
            this.f10046b = this.f10047c;
            this.f10055k = true;
        }

        public final void r(int i10, int i11, int i12) {
            float f10 = this.f10050f;
            float f11 = (-i12) / f10;
            float f12 = i12;
            float fSqrt = (float) Math.sqrt((((double) ((((f12 * f12) / 2.0f) / Math.abs(f10)) + Math.abs(i11 - i10))) * 2.0d) / ((double) Math.abs(this.f10050f)));
            this.f10051g -= (long) ((int) ((fSqrt - f11) * 1000.0f));
            this.f10045a = i11;
            this.f10046b = i11;
            this.f10048d = (int) ((-this.f10050f) * fSqrt);
        }

        public void s(int i10, int i11, int i12, int i13, int i14) {
            double dV;
            this.f10056l = i14;
            this.f10055k = false;
            if (Math.abs(i11) < this.f10063s * 1500.0f) {
                i11 = i11 < 0 ? -1500 : J;
            }
            this.f10048d = i11;
            float f10 = i11;
            this.f10049e = f10;
            this.f10053i = 0;
            this.f10052h = 0;
            this.f10051g = AnimationUtils.currentAnimationTimeMillis();
            this.f10045a = i10;
            this.f10046b = i10;
            if (i10 > i13 || i10 < i12) {
                if (i10 > i13) {
                    i12 = i13;
                }
                I(i10, i12, 0);
                return;
            }
            this.f10058n = 0;
            if (i11 != 0) {
                int iW = w(i11);
                this.f10053i = iW;
                this.f10052h = iW;
                dV = v(i11);
            } else {
                dV = 0.0d;
            }
            int iSignum = (int) (dV * ((double) Math.signum(f10)));
            this.f10054j = iSignum;
            int i15 = i10 + iSignum;
            this.f10047c = i15;
            if (i15 < i12) {
                n(this.f10045a, i15, i12);
                this.f10047c = i12;
            }
            int i16 = this.f10047c;
            if (i16 > i13) {
                n(this.f10045a, i16, i13);
                this.f10047c = i13;
            }
        }

        public final double u(int i10) {
            return Math.log((Math.abs(i10) * 0.35f) / (this.f10057m * this.f10062r));
        }

        public final double v(int i10) {
            double dU = u(i10);
            float f10 = f10041w;
            return Math.exp((((double) f10) / (((double) f10) - 1.0d)) * dU) * ((double) (this.f10057m * this.f10062r));
        }

        public final int w(int i10) {
            return (int) (Math.exp(u(i10) / (((double) f10041w) - 1.0d)) * 1000.0d);
        }

        public void x(int i10, int i11, int i12) {
            if (this.f10058n == 0) {
                this.f10056l = i12;
                this.f10051g = AnimationUtils.currentAnimationTimeMillis();
                E(i10, i11, i11, (int) this.f10049e);
            }
        }

        public final void y() {
            this.f10058n = 3;
            int i10 = this.f10045a;
            I(i10, i10, (int) (this.f10048d * 0.85f));
        }

        public void z(int i10) {
            SpringAnimation springAnimation;
            this.f10047c = i10;
            if (this.f10058n == 3 && (springAnimation = this.f10060p) != null) {
                springAnimation.animateToFinalPosition(i10);
            }
            this.f10054j = this.f10047c - this.f10045a;
            this.f10055k = false;
        }
    }

    public e(Context context) {
        this(context, null, true);
    }

    public void a() {
        this.f10037b.q();
    }

    public boolean b() {
        if (this.f10037b.f10055k) {
            return false;
        }
        int i10 = this.f10036a;
        if (i10 != 0) {
            if (i10 == 1) {
                b bVar = this.f10037b;
                if (!bVar.f10055k && !bVar.J() && !this.f10037b.o()) {
                    this.f10037b.q();
                }
            }
        } else {
            if (o()) {
                return true;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            b bVar2 = this.f10037b;
            long j10 = jCurrentAnimationTimeMillis - bVar2.f10051g;
            int i11 = bVar2.f10052h;
            if (j10 < i11) {
                this.f10037b.K(this.f10038c.getInterpolation(j10 / i11));
            } else {
                a();
            }
        }
        return true;
    }

    public void c(int i10) {
        this.f10037b.p(i10);
    }

    public void d(int i10, int i11, int i12, int i13) {
        e(i10, i11, i12, i13, 0);
    }

    public void e(int i10, int i11, int i12, int i13, int i14) {
        if (this.f10039d && !this.f10037b.f10055k) {
            float f10 = this.f10037b.f10049e;
            float f11 = i11;
            if (Math.signum(f11) == Math.signum(f10)) {
                i11 = (int) (f11 + f10);
            }
        }
        this.f10036a = 1;
        this.f10037b.s(i10, i11, i12, i13, i14);
    }

    public final void f(boolean z10) {
        this.f10037b.f10055k = z10;
    }

    public final int g() {
        this.f10037b.f10061q = true;
        return this.f10037b.f10046b;
    }

    public float h() {
        return this.f10037b.f10049e;
    }

    public final int i() {
        return this.f10037b.f10052h;
    }

    public final int j() {
        return this.f10037b.f10047c;
    }

    public b k() {
        return this.f10037b;
    }

    public final int l() {
        return this.f10037b.f10045a;
    }

    public final boolean m() {
        return this.f10037b.f10055k;
    }

    public boolean n() {
        return (this.f10037b.f10055k || this.f10037b.f10058n == 0) ? false : true;
    }

    public boolean o() {
        return this.f10037b.f10058n == 3 && !this.f10037b.f10055k;
    }

    public void p(int i10, int i11, int i12) {
        this.f10037b.x(i10, i11, i12);
    }

    public void q(int i10) {
        this.f10037b.z(i10);
    }

    public final void r(float f10) {
        this.f10037b.A(f10);
    }

    public void s(TimeInterpolator timeInterpolator) {
        if (timeInterpolator == null) {
            this.f10038c = f10035i;
        } else {
            this.f10038c = timeInterpolator;
        }
    }

    public void t() {
        this.f10037b.C();
    }

    public boolean u(int i10, int i11, int i12) {
        this.f10036a = 1;
        return this.f10037b.D(i10, i11, i12);
    }

    public void v(int i10, int i11) {
        w(i10, i11, 250);
    }

    public void w(int i10, int i11, int i12) {
        this.f10036a = 0;
        this.f10037b.G(i10, i11, i12);
    }

    public void x(int i10, int i11, int i12, float f10) {
        this.f10036a = 0;
        this.f10037b.f10058n = 3;
        this.f10037b.H(i10, i11, i12, f10);
    }

    public int y() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.f10037b.f10051g);
    }

    public e(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public e(Context context, Interpolator interpolator, boolean z10) {
        if (interpolator == null) {
            this.f10038c = f10035i;
        } else {
            this.f10038c = interpolator;
        }
        this.f10039d = z10;
        this.f10037b = new b(context);
    }
}
