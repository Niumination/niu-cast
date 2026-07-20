package m1;

import c1.h0;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@m1.e
@b1.d
public abstract class g {

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f10324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f10325b;

        public g a(double x10, double y10) {
            h0.d(m1.d.d(x10) && m1.d.d(y10));
            double d10 = this.f10324a;
            if (x10 != d10) {
                return b((y10 - this.f10325b) / (x10 - d10));
            }
            h0.d(y10 != this.f10325b);
            return new e(this.f10324a);
        }

        public g b(double slope) {
            h0.d(!Double.isNaN(slope));
            return m1.d.d(slope) ? new d(slope, this.f10325b - (this.f10324a * slope)) : new e(this.f10324a);
        }

        public b(double x10, double y10) {
            this.f10324a = x10;
            this.f10325b = y10;
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f10326a = new c();

        @Override // m1.g
        public g c() {
            return this;
        }

        @Override // m1.g
        public boolean d() {
            return false;
        }

        @Override // m1.g
        public boolean e() {
            return false;
        }

        @Override // m1.g
        public double g() {
            return Double.NaN;
        }

        @Override // m1.g
        public double h(double x10) {
            return Double.NaN;
        }

        public String toString() {
            return "NaN";
        }
    }

    public static g a() {
        return c.f10326a;
    }

    public static g b(double y10) {
        h0.d(m1.d.d(y10));
        return new d(0.0d, y10);
    }

    public static b f(double x10, double y10) {
        h0.d(m1.d.d(x10) && m1.d.d(y10));
        return new b(x10, y10);
    }

    public static g i(double x10) {
        h0.d(m1.d.d(x10));
        return new e(x10);
    }

    public abstract g c();

    public abstract boolean d();

    public abstract boolean e();

    public abstract double g();

    public abstract double h(double x10);

    public static final class e extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f10330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @u1.b
        @gm.a
        public g f10331b;

        public e(double x10) {
            this.f10330a = x10;
            this.f10331b = null;
        }

        private g j() {
            return new d(0.0d, this.f10330a, this);
        }

        @Override // m1.g
        public g c() {
            g gVar = this.f10331b;
            if (gVar != null) {
                return gVar;
            }
            g gVarJ = j();
            this.f10331b = gVarJ;
            return gVarJ;
        }

        @Override // m1.g
        public boolean d() {
            return false;
        }

        @Override // m1.g
        public boolean e() {
            return true;
        }

        @Override // m1.g
        public double g() {
            throw new IllegalStateException();
        }

        @Override // m1.g
        public double h(double x10) {
            throw new IllegalStateException();
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f10330a));
        }

        public e(double x10, g inverse) {
            this.f10330a = x10;
            this.f10331b = inverse;
        }
    }

    public static final class d extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f10327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f10328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @u1.b
        @gm.a
        public g f10329c;

        public d(double slope, double yIntercept) {
            this.f10327a = slope;
            this.f10328b = yIntercept;
            this.f10329c = null;
        }

        @Override // m1.g
        public g c() {
            g gVar = this.f10329c;
            if (gVar != null) {
                return gVar;
            }
            g gVarJ = j();
            this.f10329c = gVarJ;
            return gVarJ;
        }

        @Override // m1.g
        public boolean d() {
            return this.f10327a == 0.0d;
        }

        @Override // m1.g
        public boolean e() {
            return false;
        }

        @Override // m1.g
        public double g() {
            return this.f10327a;
        }

        @Override // m1.g
        public double h(double x10) {
            return (x10 * this.f10327a) + this.f10328b;
        }

        public final g j() {
            double d10 = this.f10327a;
            return d10 != 0.0d ? new d(1.0d / d10, (this.f10328b * (-1.0d)) / d10, this) : new e(this.f10328b, this);
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.f10327a), Double.valueOf(this.f10328b));
        }

        public d(double slope, double yIntercept, g inverse) {
            this.f10327a = slope;
            this.f10328b = yIntercept;
            this.f10329c = inverse;
        }
    }
}
