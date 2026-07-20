package m1;

import c1.h0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@e
@b1.d
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10354a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f10355b = 0.0d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f10356c = 0.0d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f10357d = Double.NaN;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f10358e = Double.NaN;

    public static double i(double previousMean, double value) {
        if (o1.d.n(previousMean)) {
            return value;
        }
        if (o1.d.n(value) || previousMean == value) {
            return previousMean;
        }
        return Double.NaN;
    }

    public void a(double value) {
        long j10 = this.f10354a;
        if (j10 == 0) {
            this.f10354a = 1L;
            this.f10355b = value;
            this.f10357d = value;
            this.f10358e = value;
            if (o1.d.n(value)) {
                return;
            }
            this.f10356c = Double.NaN;
            return;
        }
        this.f10354a = j10 + 1;
        if (o1.d.n(value) && o1.d.n(this.f10355b)) {
            double d10 = this.f10355b;
            double d11 = value - d10;
            double d12 = (d11 / this.f10354a) + d10;
            this.f10355b = d12;
            this.f10356c = ((value - d12) * d11) + this.f10356c;
        } else {
            this.f10355b = i(this.f10355b, value);
            this.f10356c = Double.NaN;
        }
        this.f10357d = Math.min(this.f10357d, value);
        this.f10358e = Math.max(this.f10358e, value);
    }

    public void b(Iterable<? extends Number> values) {
        Iterator<? extends Number> it = values.iterator();
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void c(Iterator<? extends Number> values) {
        while (values.hasNext()) {
            a(values.next().doubleValue());
        }
    }

    public void d(n values) {
        if (values.count() == 0) {
            return;
        }
        m(values.count(), values.mean(), values.sumOfSquaresOfDeltas(), values.min(), values.max());
    }

    public void e(o values) {
        long j10 = values.f10354a;
        if (j10 == 0) {
            return;
        }
        m(j10, values.l(), values.f10356c, values.n(), values.k());
    }

    public void f(double... values) {
        for (double d10 : values) {
            a(d10);
        }
    }

    public void g(int... values) {
        for (int i10 : values) {
            a(i10);
        }
    }

    public void h(long... values) {
        for (long j10 : values) {
            a(j10);
        }
    }

    public long j() {
        return this.f10354a;
    }

    public double k() {
        h0.g0(this.f10354a != 0);
        return this.f10358e;
    }

    public double l() {
        h0.g0(this.f10354a != 0);
        return this.f10355b;
    }

    public final void m(long otherCount, double otherMean, double otherSumOfSquaresOfDeltas, double otherMin, double otherMax) {
        long j10 = this.f10354a;
        if (j10 == 0) {
            this.f10354a = otherCount;
            this.f10355b = otherMean;
            this.f10356c = otherSumOfSquaresOfDeltas;
            this.f10357d = otherMin;
            this.f10358e = otherMax;
            return;
        }
        this.f10354a = j10 + otherCount;
        if (o1.d.n(this.f10355b) && o1.d.n(otherMean)) {
            double d10 = this.f10355b;
            double d11 = otherMean - d10;
            double d12 = otherCount;
            double d13 = ((d11 * d12) / this.f10354a) + d10;
            this.f10355b = d13;
            this.f10356c = ((otherMean - d13) * d11 * d12) + otherSumOfSquaresOfDeltas + this.f10356c;
        } else {
            this.f10355b = i(this.f10355b, otherMean);
            this.f10356c = Double.NaN;
        }
        this.f10357d = Math.min(this.f10357d, otherMin);
        this.f10358e = Math.max(this.f10358e, otherMax);
    }

    public double n() {
        h0.g0(this.f10354a != 0);
        return this.f10357d;
    }

    public final double o() {
        return Math.sqrt(p());
    }

    public final double p() {
        h0.g0(this.f10354a != 0);
        if (Double.isNaN(this.f10356c)) {
            return Double.NaN;
        }
        if (this.f10354a == 1) {
            return 0.0d;
        }
        return d.b(this.f10356c) / this.f10354a;
    }

    public final double q() {
        return Math.sqrt(r());
    }

    public final double r() {
        h0.g0(this.f10354a > 1);
        if (Double.isNaN(this.f10356c)) {
            return Double.NaN;
        }
        return d.b(this.f10356c) / (this.f10354a - 1);
    }

    public n s() {
        return new n(this.f10354a, this.f10355b, this.f10356c, this.f10357d, this.f10358e);
    }

    public final double t() {
        return this.f10355b * this.f10354a;
    }

    public double u() {
        return this.f10356c;
    }
}
