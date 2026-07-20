package xi;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f20237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile float f20238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f20239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f20240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f20241e = 0.2f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f20242f = 0.125f;

    public e() {
    }

    public static final float a(float f10, float f11, float f12) {
        if (f10 == f11) {
            return f11;
        }
        float fA = g.a.a(f11, f10, f12, f10);
        if (Math.abs(fA - f10) < 1.0E-4f || fA == f10) {
            return f11;
        }
        if (f10 <= f11 || fA >= f11) {
            return (f10 >= f11 || fA <= f11) ? fA : f11;
        }
        return f11;
    }

    public static final float b(float f10, float f11, float f12, float f13, float f14) {
        float f15 = f11 - f10;
        if (Math.abs(f15) <= f14) {
            return f11;
        }
        float fA = a(f10, (f13 * f15) + f10, f12);
        return Math.abs(fA - f10) < f14 ? (Math.signum(f15) * f14) + f10 : fA;
    }

    public final void c(float f10) {
        if (f10 != 0.0f) {
            float fAbs = Math.abs(f10 * this.f20242f);
            this.f20240d = fAbs;
            if (fAbs < 1.0E-4f) {
                this.f20240d = 1.0E-4f;
            }
        }
    }

    public final void d() {
        this.f20239c = false;
        this.f20238b = this.f20237a;
    }

    public final float e() {
        return this.f20238b;
    }

    public final float f() {
        return this.f20237a;
    }

    public boolean g() {
        return this.f20239c;
    }

    public final void h(float f10) {
        this.f20239c = false;
        this.f20238b = f10;
        this.f20237a = f10;
    }

    public final void i(float f10) {
        this.f20241e = f10;
    }

    public final void j(float f10) {
        this.f20242f = f10;
    }

    public final void k(float f10) {
        if (this.f20237a != f10) {
            this.f20237a = f10;
            c(f10 - this.f20238b);
            this.f20239c = true;
        }
    }

    public final boolean l(float f10) {
        if (this.f20239c) {
            this.f20238b = b(this.f20238b, this.f20237a, f10, this.f20241e, this.f20240d);
            this.f20239c = this.f20238b != this.f20237a;
        }
        return this.f20239c;
    }

    public e(float f10) {
        this.f20238b = f10;
        this.f20237a = f10;
    }
}
