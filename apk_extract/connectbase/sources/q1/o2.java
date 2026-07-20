package q1;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public abstract class o2 extends f2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f13644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f13645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f13646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f13647f;

    public static final class b extends o2 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final double f13648g;

        public b(f2.a stopwatch, double maxBurstSeconds) {
            super(stopwatch);
            this.f13648g = maxBurstSeconds;
        }

        @Override // q1.o2
        public double v() {
            return this.f13646e;
        }

        @Override // q1.o2
        public void w(double permitsPerSecond, double stableIntervalMicros) {
            double d10 = this.f13645d;
            double d11 = this.f13648g * permitsPerSecond;
            this.f13645d = d11;
            if (d10 == Double.POSITIVE_INFINITY) {
                this.f13644c = d11;
            } else {
                this.f13644c = d10 != 0.0d ? (this.f13644c * d11) / d10 : 0.0d;
            }
        }

        @Override // q1.o2
        public long y(double storedPermits, double permitsToTake) {
            return 0L;
        }
    }

    public static final class c extends o2 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f13649g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public double f13650h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public double f13651i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public double f13652j;

        public c(f2.a stopwatch, long warmupPeriod, TimeUnit timeUnit, double coldFactor) {
            super(stopwatch);
            this.f13649g = timeUnit.toMicros(warmupPeriod);
            this.f13652j = coldFactor;
        }

        @Override // q1.o2
        public double v() {
            return this.f13649g / this.f13645d;
        }

        @Override // q1.o2
        public void w(double permitsPerSecond, double stableIntervalMicros) {
            double d10 = this.f13645d;
            double d11 = this.f13652j * stableIntervalMicros;
            long j10 = this.f13649g;
            double d12 = (j10 * 0.5d) / stableIntervalMicros;
            this.f13651i = d12;
            double d13 = ((j10 * 2.0d) / (stableIntervalMicros + d11)) + d12;
            this.f13645d = d13;
            this.f13650h = (d11 - stableIntervalMicros) / (d13 - d12);
            if (d10 == Double.POSITIVE_INFINITY) {
                this.f13644c = 0.0d;
                return;
            }
            if (d10 != 0.0d) {
                d13 = (this.f13644c * d13) / d10;
            }
            this.f13644c = d13;
        }

        @Override // q1.o2
        public long y(double storedPermits, double permitsToTake) {
            long jZ;
            double d10 = storedPermits - this.f13651i;
            if (d10 > 0.0d) {
                double dMin = Math.min(d10, permitsToTake);
                jZ = (long) (((z(d10 - dMin) + z(d10)) * dMin) / 2.0d);
                permitsToTake -= dMin;
            } else {
                jZ = 0;
            }
            return jZ + ((long) (this.f13646e * permitsToTake));
        }

        public final double z(double permits) {
            return (permits * this.f13650h) + this.f13646e;
        }
    }

    @Override // q1.f2
    public final double i() {
        return TimeUnit.SECONDS.toMicros(1L) / this.f13646e;
    }

    @Override // q1.f2
    public final void j(double permitsPerSecond, long nowMicros) {
        x(nowMicros);
        double micros = TimeUnit.SECONDS.toMicros(1L) / permitsPerSecond;
        this.f13646e = micros;
        w(permitsPerSecond, micros);
    }

    @Override // q1.f2
    public final long m(long nowMicros) {
        return this.f13647f;
    }

    @Override // q1.f2
    public final long p(int requiredPermits, long nowMicros) {
        x(nowMicros);
        long j10 = this.f13647f;
        double d10 = requiredPermits;
        double dMin = Math.min(d10, this.f13644c);
        this.f13647f = m1.h.x(this.f13647f, y(this.f13644c, dMin) + ((long) ((d10 - dMin) * this.f13646e)));
        this.f13644c -= dMin;
        return j10;
    }

    public abstract double v();

    public abstract void w(double permitsPerSecond, double stableIntervalMicros);

    public void x(long nowMicros) {
        long j10 = this.f13647f;
        if (nowMicros > j10) {
            this.f13644c = Math.min(this.f13645d, this.f13644c + ((nowMicros - j10) / v()));
            this.f13647f = nowMicros;
        }
    }

    public abstract long y(double storedPermits, double permitsToTake);

    public o2(f2.a stopwatch) {
        super(stopwatch);
        this.f13647f = 0L;
    }
}
