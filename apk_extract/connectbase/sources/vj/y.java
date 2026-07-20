package vj;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class y implements Comparable<y> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f17540d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f17541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f17542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f17543g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f17544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f17546c;

    public static class b extends c {
        public b() {
        }

        @Override // vj.y.c
        public long a() {
            return System.nanoTime();
        }

        public b(a aVar) {
        }
    }

    public static abstract class c {
        public abstract long a();
    }

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        f17541e = nanos;
        f17542f = -nanos;
        f17543g = TimeUnit.SECONDS.toNanos(1L);
    }

    public y(c cVar, long j10, boolean z10) {
        this(cVar, cVar.a(), j10, z10);
    }

    public static y a(long j10, TimeUnit timeUnit) {
        return b(j10, timeUnit, f17540d);
    }

    public static y b(long j10, TimeUnit timeUnit, c cVar) {
        d(timeUnit, "units");
        return new y(cVar, timeUnit.toNanos(j10), true);
    }

    public static <T> T d(T t10, Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static c k() {
        return f17540d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        c cVar = this.f17544a;
        if (cVar != null ? cVar == yVar.f17544a : yVar.f17544a == null) {
            return this.f17545b == yVar.f17545b;
        }
        return false;
    }

    public final void f(y yVar) {
        if (this.f17544a == yVar.f17544a) {
            return;
        }
        throw new AssertionError("Tickers (" + this.f17544a + " and " + yVar.f17544a + ") don't match. Custom Ticker should only be used in tests!");
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compareTo(y yVar) {
        f(yVar);
        long j10 = this.f17545b - yVar.f17545b;
        if (j10 < 0) {
            return -1;
        }
        return j10 > 0 ? 1 : 0;
    }

    public int hashCode() {
        return Arrays.asList(this.f17544a, Long.valueOf(this.f17545b)).hashCode();
    }

    public boolean l(y yVar) {
        f(yVar);
        return this.f17545b - yVar.f17545b < 0;
    }

    public boolean m() {
        if (!this.f17546c) {
            if (this.f17545b - this.f17544a.a() > 0) {
                return false;
            }
            this.f17546c = true;
        }
        return true;
    }

    public y n(y yVar) {
        f(yVar);
        return l(yVar) ? this : yVar;
    }

    public y o(long j10, TimeUnit timeUnit) {
        return j10 == 0 ? this : new y(this.f17544a, this.f17545b, timeUnit.toNanos(j10), m());
    }

    public ScheduledFuture<?> p(Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        d(runnable, "task");
        d(scheduledExecutorService, "scheduler");
        return scheduledExecutorService.schedule(runnable, this.f17545b - this.f17544a.a(), TimeUnit.NANOSECONDS);
    }

    public long q(TimeUnit timeUnit) {
        long jA = this.f17544a.a();
        if (!this.f17546c && this.f17545b - jA <= 0) {
            this.f17546c = true;
        }
        return timeUnit.convert(this.f17545b - jA, TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long jQ = q(TimeUnit.NANOSECONDS);
        long jAbs = Math.abs(jQ);
        long j10 = f17543g;
        long j11 = jAbs / j10;
        long jAbs2 = Math.abs(jQ) % j10;
        StringBuilder sb2 = new StringBuilder();
        if (jQ < 0) {
            sb2.append('-');
        }
        sb2.append(j11);
        if (jAbs2 > 0) {
            sb2.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        }
        sb2.append("s from now");
        if (this.f17544a != f17540d) {
            sb2.append(" (ticker=" + this.f17544a + ")");
        }
        return sb2.toString();
    }

    public y(c cVar, long j10, long j11, boolean z10) {
        this.f17544a = cVar;
        long jMin = Math.min(f17541e, Math.max(f17542f, j11));
        this.f17545b = j10 + jMin;
        this.f17546c = z10 && jMin <= 0;
    }
}
