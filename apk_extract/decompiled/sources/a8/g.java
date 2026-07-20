package a8;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f75d;
    public double e;
    public double f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f76g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f77h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f72a = Math.sqrt(1500.0d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f73b = 0.5d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f74c = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f78i = Double.MAX_VALUE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f79j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f80k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final double f81l = 0.0d;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final double f82m = 0.0d;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final double f83n = 0.0d;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final double f84o = 0.0d;
    public final e p = new e();

    public final void a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f73b = f;
        this.f74c = false;
    }

    public final void b(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f72a = Math.sqrt(f);
        this.f74c = false;
    }

    public final e c(double d7, double d10, long j8) {
        double dCos;
        double dPow;
        if (this.f79j) {
            float fCurrentTimeMillis = System.currentTimeMillis() - this.f80k;
            float f = 0L;
            if (fCurrentTimeMillis >= f) {
                this.f79j = false;
                b((float) this.f83n);
                a((float) this.f84o);
            } else {
                float f4 = fCurrentTimeMillis / f;
                float f10 = (3.0f - (f4 * 2.0f)) * f4 * f4;
                double d11 = this.f81l;
                double d12 = f10;
                double d13 = ((this.f83n - d11) * d12) + d11;
                double d14 = this.f82m;
                double d15 = ((this.f84o - d14) * d12) + d14;
                b((float) d13);
                a((float) d15);
            }
        }
        if (!this.f74c) {
            if (Double.compare(this.f78i, Double.MAX_VALUE) == 0) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            double d16 = this.f73b;
            if (d16 > 1.0d) {
                double d17 = this.f72a;
                this.f = (Math.sqrt((d16 * d16) - 1.0d) * d17) + ((-d16) * d17);
                double d18 = this.f73b;
                double d19 = this.f72a;
                this.f76g = ((-d18) * d19) - (Math.sqrt((d18 * d18) - 1.0d) * d19);
            } else if (d16 >= 0.0d && d16 < 1.0d) {
                this.f77h = Math.sqrt(1.0d - (d16 * d16)) * this.f72a;
            }
            this.f74c = true;
        }
        double d20 = j8 / 1.0E9d;
        double d21 = d7 - this.f78i;
        double d22 = this.f73b;
        if (d22 > 1.0d) {
            double d23 = this.f76g;
            double d24 = ((d23 * d21) - d10) / (d23 - this.f);
            double d25 = d21 - d24;
            dPow = (Math.pow(2.718281828459045d, this.f * d20) * d24) + (Math.pow(2.718281828459045d, d23 * d20) * d25);
            double d26 = this.f76g;
            double dPow2 = Math.pow(2.718281828459045d, d26 * d20) * d25 * d26;
            double d27 = this.f;
            dCos = (Math.pow(2.718281828459045d, d27 * d20) * d24 * d27) + dPow2;
        } else if (d22 == 1.0d) {
            double d28 = this.f72a;
            double d29 = (d28 * d21) + d10;
            double d30 = (d29 * d20) + d21;
            double dPow3 = Math.pow(2.718281828459045d, (-d28) * d20) * d30;
            double dPow4 = Math.pow(2.718281828459045d, (-this.f72a) * d20) * d30;
            double d31 = -this.f72a;
            dCos = (Math.pow(2.718281828459045d, d31 * d20) * d29) + (dPow4 * d31);
            dPow = dPow3;
        } else {
            double d32 = 1.0d / this.f77h;
            double d33 = this.f72a;
            double d34 = ((d22 * d33 * d21) + d10) * d32;
            double dSin = ((Math.sin(this.f77h * d20) * d34) + (Math.cos(this.f77h * d20) * d21)) * Math.pow(2.718281828459045d, (-d22) * d33 * d20);
            double d35 = this.f72a;
            double d36 = this.f73b;
            double d37 = (-d35) * dSin * d36;
            double dPow5 = Math.pow(2.718281828459045d, (-d36) * d35 * d20);
            double d38 = this.f77h;
            double dSin2 = Math.sin(d38 * d20) * (-d38) * d21;
            double d39 = this.f77h;
            dCos = (((Math.cos(d39 * d20) * d34 * d39) + dSin2) * dPow5) + d37;
            dPow = dSin;
        }
        float f11 = (float) (dPow + this.f78i);
        e eVar = this.p;
        eVar.f55a = f11;
        eVar.f56b = (float) dCos;
        return eVar;
    }
}
