package m1;

import c1.h0;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@e
@b1.d
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f10346a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f10347b = new o();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f10348c = 0.0d;

    public static double d(double value) {
        return o1.d.f(value, -1.0d, 1.0d);
    }

    public void a(double x10, double y10) {
        this.f10346a.a(x10);
        if (o1.d.n(x10) && o1.d.n(y10)) {
            o oVar = this.f10346a;
            if (oVar.f10354a > 1) {
                this.f10348c = ((y10 - this.f10347b.l()) * (x10 - oVar.l())) + this.f10348c;
            }
        } else {
            this.f10348c = Double.NaN;
        }
        this.f10347b.a(y10);
    }

    public void b(j values) {
        if (values.count() == 0) {
            return;
        }
        this.f10346a.d(values.xStats());
        if (this.f10347b.f10354a == 0) {
            this.f10348c = values.sumOfProductsOfDeltas();
        } else {
            this.f10348c = ((values.yStats().mean() - this.f10347b.l()) * (values.xStats().mean() - this.f10346a.l()) * values.count()) + values.sumOfProductsOfDeltas() + this.f10348c;
        }
        this.f10347b.d(values.yStats());
    }

    public long c() {
        return this.f10346a.f10354a;
    }

    public final double e(double value) {
        if (value > 0.0d) {
            return value;
        }
        return Double.MIN_VALUE;
    }

    public final g f() {
        h0.g0(this.f10346a.f10354a > 1);
        if (Double.isNaN(this.f10348c)) {
            return g.c.f10326a;
        }
        o oVar = this.f10346a;
        double d10 = oVar.f10356c;
        if (d10 > 0.0d) {
            o oVar2 = this.f10347b;
            return oVar2.f10356c > 0.0d ? g.f(oVar.l(), this.f10347b.l()).b(this.f10348c / d10) : g.b(oVar2.l());
        }
        h0.g0(this.f10347b.f10356c > 0.0d);
        return g.i(this.f10346a.l());
    }

    public final double g() {
        h0.g0(this.f10346a.f10354a > 1);
        if (Double.isNaN(this.f10348c)) {
            return Double.NaN;
        }
        double d10 = this.f10346a.f10356c;
        double d11 = this.f10347b.f10356c;
        h0.g0(d10 > 0.0d);
        h0.g0(d11 > 0.0d);
        return d(this.f10348c / Math.sqrt(e(d10 * d11)));
    }

    public double h() {
        h0.g0(this.f10346a.f10354a != 0);
        return this.f10348c / this.f10346a.f10354a;
    }

    public final double i() {
        h0.g0(this.f10346a.f10354a > 1);
        return this.f10348c / (this.f10346a.f10354a - 1);
    }

    public j j() {
        return new j(this.f10346a.s(), this.f10347b.s(), this.f10348c);
    }

    public n k() {
        return this.f10346a.s();
    }

    public n l() {
        return this.f10347b.s();
    }
}
