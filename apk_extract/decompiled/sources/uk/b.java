package uk;

import a8.e;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f10452d;
    public double e;
    public double f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f10453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f10454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f10455i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f10449a = Math.sqrt(1500.0d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f10450b = 0.5d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10451c = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f10456j = new e();

    public b(float f) {
        this.f10455i = f;
    }

    public final e a(double d7, double d10, long j8) {
        double dCos;
        double dPow;
        if (!this.f10451c) {
            if (this.f10455i == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            double d11 = this.f10450b;
            if (d11 > 1.0d) {
                double d12 = this.f10449a;
                this.f = (Math.sqrt((d11 * d11) - 1.0d) * d12) + ((-d11) * d12);
                double d13 = this.f10450b;
                double d14 = this.f10449a;
                this.f10453g = ((-d13) * d14) - (Math.sqrt((d13 * d13) - 1.0d) * d14);
            } else if (d11 >= 0.0d && d11 < 1.0d) {
                this.f10454h = Math.sqrt(1.0d - (d11 * d11)) * this.f10449a;
            }
            this.f10451c = true;
        }
        double d15 = j8 / 1000.0d;
        double d16 = d7 - this.f10455i;
        double d17 = this.f10450b;
        if (d17 > 1.0d) {
            double d18 = this.f10453g;
            double d19 = ((d18 * d16) - d10) / (d18 - this.f);
            double d20 = d16 - d19;
            dPow = (Math.pow(2.718281828459045d, this.f * d15) * d19) + (Math.pow(2.718281828459045d, d18 * d15) * d20);
            double d21 = this.f10453g;
            double dPow2 = Math.pow(2.718281828459045d, d21 * d15) * d20 * d21;
            double d22 = this.f;
            dCos = (Math.pow(2.718281828459045d, d22 * d15) * d19 * d22) + dPow2;
        } else if (d17 == 1.0d) {
            double d23 = this.f10449a;
            double d24 = (d23 * d16) + d10;
            double d25 = (d24 * d15) + d16;
            double dPow3 = Math.pow(2.718281828459045d, (-d23) * d15) * d25;
            double dPow4 = Math.pow(2.718281828459045d, (-this.f10449a) * d15) * d25;
            double d26 = -this.f10449a;
            dCos = (Math.pow(2.718281828459045d, d26 * d15) * d24) + (dPow4 * d26);
            dPow = dPow3;
        } else {
            double d27 = 1.0d / this.f10454h;
            double d28 = this.f10449a;
            double d29 = ((d17 * d28 * d16) + d10) * d27;
            double dSin = ((Math.sin(this.f10454h * d15) * d29) + (Math.cos(this.f10454h * d15) * d16)) * Math.pow(2.718281828459045d, (-d17) * d28 * d15);
            double d30 = this.f10449a;
            double d31 = this.f10450b;
            double d32 = (-d30) * dSin * d31;
            double dPow5 = Math.pow(2.718281828459045d, (-d31) * d30 * d15);
            double d33 = this.f10454h;
            double dSin2 = Math.sin(d33 * d15) * (-d33) * d16;
            double d34 = this.f10454h;
            dCos = (((Math.cos(d34 * d15) * d29 * d34) + dSin2) * dPow5) + d32;
            dPow = dSin;
        }
        float f = (float) (dPow + this.f10455i);
        e eVar = this.f10456j;
        eVar.f55a = f;
        eVar.f56b = (float) dCos;
        return eVar;
    }

    public final void b(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f10450b = f;
        this.f10451c = false;
    }

    public final void c(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f10449a = Math.sqrt(f);
        this.f10451c = false;
    }
}
