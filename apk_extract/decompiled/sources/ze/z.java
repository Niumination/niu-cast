package ze;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p2 f11480d = new p2(1);
    public static final long e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f11481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f11482i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p2 f11483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f11484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f11485c;

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        e = nanos;
        f11481h = -nanos;
        f11482i = TimeUnit.SECONDS.toNanos(1L);
    }

    public z(p2 p2Var, long j8) {
        p2Var.getClass();
        long jNanoTime = System.nanoTime();
        this.f11483a = p2Var;
        long jMin = Math.min(e, Math.max(f11481h, j8));
        this.f11484b = jNanoTime + jMin;
        this.f11485c = jMin <= 0;
    }

    public static z a(long j8, TimeUnit timeUnit, p2 p2Var) {
        if (timeUnit != null) {
            return new z(p2Var, timeUnit.toNanos(j8));
        }
        throw new NullPointerException("units");
    }

    public final void b(z zVar) {
        p2 p2Var = zVar.f11483a;
        p2 p2Var2 = this.f11483a;
        if (p2Var2 == p2Var) {
            return;
        }
        throw new AssertionError("Tickers (" + p2Var2 + " and " + zVar.f11483a + ") don't match. Custom Ticker should only be used in tests!");
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final int compareTo(z zVar) {
        b(zVar);
        long j8 = this.f11484b - zVar.f11484b;
        if (j8 < 0) {
            return -1;
        }
        return j8 > 0 ? 1 : 0;
    }

    public final boolean d(z zVar) {
        b(zVar);
        return this.f11484b - zVar.f11484b < 0;
    }

    public final boolean e() {
        if (!this.f11485c) {
            long j8 = this.f11484b;
            this.f11483a.getClass();
            if (j8 - System.nanoTime() > 0) {
                return false;
            }
            this.f11485c = true;
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        p2 p2Var = this.f11483a;
        if (p2Var != null ? p2Var == zVar.f11483a : zVar.f11483a == null) {
            return this.f11484b == zVar.f11484b;
        }
        return false;
    }

    public final long f(TimeUnit timeUnit) {
        this.f11483a.getClass();
        long jNanoTime = System.nanoTime();
        if (!this.f11485c && this.f11484b - jNanoTime <= 0) {
            this.f11485c = true;
        }
        return timeUnit.convert(this.f11484b - jNanoTime, TimeUnit.NANOSECONDS);
    }

    public final int hashCode() {
        return Arrays.asList(this.f11483a, Long.valueOf(this.f11484b)).hashCode();
    }

    public final String toString() {
        long jF = f(TimeUnit.NANOSECONDS);
        long jAbs = Math.abs(jF);
        long j8 = f11482i;
        long j10 = jAbs / j8;
        long jAbs2 = Math.abs(jF) % j8;
        StringBuilder sb2 = new StringBuilder();
        if (jF < 0) {
            sb2.append('-');
        }
        sb2.append(j10);
        if (jAbs2 > 0) {
            sb2.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        }
        sb2.append("s from now");
        p2 p2Var = f11480d;
        p2 p2Var2 = this.f11483a;
        if (p2Var2 != p2Var) {
            sb2.append(" (ticker=" + p2Var2 + ")");
        }
        return sb2.toString();
    }
}
