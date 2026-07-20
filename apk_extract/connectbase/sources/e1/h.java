package e1;

import c1.h0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@i
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f3940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3942f;

    public h(long hitCount, long missCount, long loadSuccessCount, long loadExceptionCount, long totalLoadTime, long evictionCount) {
        h0.d(hitCount >= 0);
        h0.d(missCount >= 0);
        h0.d(loadSuccessCount >= 0);
        h0.d(loadExceptionCount >= 0);
        h0.d(totalLoadTime >= 0);
        h0.d(evictionCount >= 0);
        this.f3937a = hitCount;
        this.f3938b = missCount;
        this.f3939c = loadSuccessCount;
        this.f3940d = loadExceptionCount;
        this.f3941e = totalLoadTime;
        this.f3942f = evictionCount;
    }

    public double a() {
        long jX = m1.h.x(this.f3939c, this.f3940d);
        if (jX == 0) {
            return 0.0d;
        }
        return this.f3941e / jX;
    }

    public long b() {
        return this.f3942f;
    }

    public long c() {
        return this.f3937a;
    }

    public double d() {
        long jM = m();
        if (jM == 0) {
            return 1.0d;
        }
        return this.f3937a / jM;
    }

    public long e() {
        return m1.h.x(this.f3939c, this.f3940d);
    }

    public boolean equals(@gm.a Object object) {
        if (!(object instanceof h)) {
            return false;
        }
        h hVar = (h) object;
        return this.f3937a == hVar.f3937a && this.f3938b == hVar.f3938b && this.f3939c == hVar.f3939c && this.f3940d == hVar.f3940d && this.f3941e == hVar.f3941e && this.f3942f == hVar.f3942f;
    }

    public long f() {
        return this.f3940d;
    }

    public double g() {
        long jX = m1.h.x(this.f3939c, this.f3940d);
        if (jX == 0) {
            return 0.0d;
        }
        return this.f3940d / jX;
    }

    public long h() {
        return this.f3939c;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f3937a), Long.valueOf(this.f3938b), Long.valueOf(this.f3939c), Long.valueOf(this.f3940d), Long.valueOf(this.f3941e), Long.valueOf(this.f3942f)});
    }

    public h i(h other) {
        return new h(Math.max(0L, m1.h.A(this.f3937a, other.f3937a)), Math.max(0L, m1.h.A(this.f3938b, other.f3938b)), Math.max(0L, m1.h.A(this.f3939c, other.f3939c)), Math.max(0L, m1.h.A(this.f3940d, other.f3940d)), Math.max(0L, m1.h.A(this.f3941e, other.f3941e)), Math.max(0L, m1.h.A(this.f3942f, other.f3942f)));
    }

    public long j() {
        return this.f3938b;
    }

    public double k() {
        long jM = m();
        if (jM == 0) {
            return 0.0d;
        }
        return this.f3938b / jM;
    }

    public h l(h other) {
        return new h(m1.h.x(this.f3937a, other.f3937a), m1.h.x(this.f3938b, other.f3938b), m1.h.x(this.f3939c, other.f3939c), m1.h.x(this.f3940d, other.f3940d), m1.h.x(this.f3941e, other.f3941e), m1.h.x(this.f3942f, other.f3942f));
    }

    public long m() {
        return m1.h.x(this.f3937a, this.f3938b);
    }

    public long n() {
        return this.f3941e;
    }

    public String toString() {
        return c1.z.c(this).e("hitCount", this.f3937a).e("missCount", this.f3938b).e("loadSuccessCount", this.f3939c).e("loadExceptionCount", this.f3940d).e("totalLoadTime", this.f3941e).e("evictionCount", this.f3942f).toString();
    }
}
