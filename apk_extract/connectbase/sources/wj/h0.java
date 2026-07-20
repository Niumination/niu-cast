package wj;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Random f18705a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f18706b = TimeUnit.SECONDS.toNanos(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f18707c = TimeUnit.MINUTES.toNanos(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f18708d = 1.6d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f18709e = 0.2d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f18710f = this.f18706b;

    public static final class a implements k.a {
        @Override // wj.k.a
        public k get() {
            return new h0();
        }
    }

    @Override // wj.k
    public long a() {
        long j10 = this.f18710f;
        double d10 = j10;
        this.f18710f = Math.min((long) (this.f18708d * d10), this.f18707c);
        double d11 = this.f18709e;
        return g((-d11) * d10, d11 * d10) + j10;
    }

    @b1.e
    public h0 b(long j10) {
        this.f18706b = j10;
        return this;
    }

    @b1.e
    public h0 c(double d10) {
        this.f18709e = d10;
        return this;
    }

    @b1.e
    public h0 d(long j10) {
        this.f18707c = j10;
        return this;
    }

    @b1.e
    public h0 e(double d10) {
        this.f18708d = d10;
        return this;
    }

    @b1.e
    public h0 f(Random random) {
        this.f18705a = random;
        return this;
    }

    public final long g(double d10, double d11) {
        c1.h0.d(d11 >= d10);
        return (long) ((this.f18705a.nextDouble() * (d11 - d10)) + d10);
    }
}
