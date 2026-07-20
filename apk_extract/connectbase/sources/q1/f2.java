package q1;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.a
@b1.d
public abstract class f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f13460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.a
    public volatile Object f13461b;

    public static abstract class a {

        /* JADX INFO: renamed from: q1.f2$a$a, reason: collision with other inner class name */
        public class C0338a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final c1.o0 f13462a = c1.o0.c();

            @Override // q1.f2.a
            public long b() {
                return this.f13462a.g(TimeUnit.MICROSECONDS);
            }

            @Override // q1.f2.a
            public void c(long micros) {
                if (micros > 0) {
                    e3.k(micros, TimeUnit.MICROSECONDS);
                }
            }
        }

        public static a a() {
            return new C0338a();
        }

        public abstract long b();

        public abstract void c(long micros);
    }

    public f2(a stopwatch) {
        stopwatch.getClass();
        this.f13460a = stopwatch;
    }

    public static void d(int permits) {
        c1.h0.k(permits > 0, "Requested permits (%s) must be positive", permits);
    }

    public static f2 e(double permitsPerSecond) {
        return h(permitsPerSecond, new a.C0338a());
    }

    public static f2 f(double permitsPerSecond, long warmupPeriod, TimeUnit unit) {
        c1.h0.p(warmupPeriod >= 0, "warmupPeriod must not be negative: %s", warmupPeriod);
        return g(permitsPerSecond, warmupPeriod, unit, 3.0d, new a.C0338a());
    }

    @b1.e
    public static f2 g(double permitsPerSecond, long warmupPeriod, TimeUnit unit, double coldFactor, a stopwatch) {
        o2.c cVar = new o2.c(stopwatch, warmupPeriod, unit, coldFactor);
        cVar.q(permitsPerSecond);
        return cVar;
    }

    @b1.e
    public static f2 h(double permitsPerSecond, a stopwatch) {
        o2.b bVar = new o2.b(stopwatch, 1.0d);
        bVar.q(permitsPerSecond);
        return bVar;
    }

    @t1.a
    public double a() {
        return b(1);
    }

    @t1.a
    public double b(int permits) {
        long jN = n(permits);
        this.f13460a.c(jN);
        return (jN * 1.0d) / TimeUnit.SECONDS.toMicros(1L);
    }

    public final boolean c(long nowMicros, long timeoutMicros) {
        return m(nowMicros) - timeoutMicros <= nowMicros;
    }

    public abstract double i();

    public abstract void j(double permitsPerSecond, long nowMicros);

    public final double k() {
        double dI;
        synchronized (l()) {
            dI = i();
        }
        return dI;
    }

    public final Object l() {
        Object obj = this.f13461b;
        if (obj == null) {
            synchronized (this) {
                try {
                    obj = this.f13461b;
                    if (obj == null) {
                        obj = new Object();
                        this.f13461b = obj;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return obj;
    }

    public abstract long m(long nowMicros);

    public final long n(int permits) {
        long jO;
        d(permits);
        synchronized (l()) {
            jO = o(permits, this.f13460a.b());
        }
        return jO;
    }

    public final long o(int permits, long nowMicros) {
        return Math.max(p(permits, nowMicros) - nowMicros, 0L);
    }

    public abstract long p(int permits, long nowMicros);

    public final void q(double permitsPerSecond) {
        c1.h0.e(permitsPerSecond > 0.0d && !Double.isNaN(permitsPerSecond), "rate must be positive");
        synchronized (l()) {
            j(permitsPerSecond, this.f13460a.b());
        }
    }

    public boolean r() {
        return t(1, 0L, TimeUnit.MICROSECONDS);
    }

    public boolean s(int permits) {
        return t(permits, 0L, TimeUnit.MICROSECONDS);
    }

    public boolean t(int permits, long timeout, TimeUnit unit) {
        long jMax = Math.max(unit.toMicros(timeout), 0L);
        d(permits);
        synchronized (l()) {
            try {
                long jB = this.f13460a.b();
                if (!c(jB, jMax)) {
                    return false;
                }
                this.f13460a.c(o(permits, jB));
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", Double.valueOf(k()));
    }

    public boolean u(long timeout, TimeUnit unit) {
        return t(1, timeout, unit);
    }
}
