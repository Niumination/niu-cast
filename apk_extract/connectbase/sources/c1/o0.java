package c1;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@k
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u0 f1226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1229d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1230a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f1230a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1230a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1230a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1230a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1230a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1230a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1230a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public o0() {
        this.f1226a = u0.b();
    }

    public static String a(TimeUnit unit) {
        switch (a.f1230a[unit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return p6.s.f13016a;
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }

    public static TimeUnit b(long nanos) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(nanos, timeUnit2) > 0) {
            return timeUnit;
        }
        TimeUnit timeUnit3 = TimeUnit.HOURS;
        if (timeUnit3.convert(nanos, timeUnit2) > 0) {
            return timeUnit3;
        }
        TimeUnit timeUnit4 = TimeUnit.MINUTES;
        if (timeUnit4.convert(nanos, timeUnit2) > 0) {
            return timeUnit4;
        }
        TimeUnit timeUnit5 = TimeUnit.SECONDS;
        if (timeUnit5.convert(nanos, timeUnit2) > 0) {
            return timeUnit5;
        }
        TimeUnit timeUnit6 = TimeUnit.MILLISECONDS;
        if (timeUnit6.convert(nanos, timeUnit2) > 0) {
            return timeUnit6;
        }
        TimeUnit timeUnit7 = TimeUnit.MICROSECONDS;
        return timeUnit7.convert(nanos, timeUnit2) > 0 ? timeUnit7 : timeUnit2;
    }

    public static o0 c() {
        return new o0().k();
    }

    public static o0 d(u0 ticker) {
        return new o0(ticker).k();
    }

    public static o0 e() {
        return new o0();
    }

    public static o0 f(u0 ticker) {
        return new o0(ticker);
    }

    public long g(TimeUnit desiredUnit) {
        return desiredUnit.convert(h(), TimeUnit.NANOSECONDS);
    }

    public final long h() {
        return this.f1227b ? (this.f1226a.a() - this.f1229d) + this.f1228c : this.f1228c;
    }

    public boolean i() {
        return this.f1227b;
    }

    @t1.a
    public o0 j() {
        this.f1228c = 0L;
        this.f1227b = false;
        return this;
    }

    @t1.a
    public o0 k() {
        h0.h0(!this.f1227b, "This stopwatch is already running.");
        this.f1227b = true;
        this.f1229d = this.f1226a.a();
        return this;
    }

    @t1.a
    public o0 l() {
        long jA = this.f1226a.a();
        h0.h0(this.f1227b, "This stopwatch is already stopped.");
        this.f1227b = false;
        this.f1228c = (jA - this.f1229d) + this.f1228c;
        return this;
    }

    public String toString() {
        long jH = h();
        TimeUnit timeUnitB = b(jH);
        return g0.c(jH / TimeUnit.NANOSECONDS.convert(1L, timeUnitB)) + " " + a(timeUnitB);
    }

    public o0(u0 ticker) {
        this.f1226a = (u0) h0.F(ticker, "ticker");
    }
}
