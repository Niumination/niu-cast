package wj;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class i1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @b1.e
    public static final int f18730h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @b1.e
    public static final long f18731i = TimeUnit.HOURS.toNanos(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f18732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f18734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f18735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f18736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f18737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f18738g;

    @b1.e
    public static class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18739a = new a();

        @Override // wj.i1.b
        public long a() {
            return System.nanoTime();
        }
    }

    @b1.e
    public interface b {
        long a();
    }

    public i1(boolean z10, long j10, TimeUnit timeUnit) {
        this(z10, j10, timeUnit, a.f18739a);
    }

    public static long a(long j10, long j11) {
        return j10 - j11;
    }

    public void b() {
        this.f18737f = true;
    }

    public void c() {
        this.f18737f = false;
    }

    @gm.c
    public boolean d() {
        long jA = this.f18734c.a();
        if (this.f18737f || this.f18732a ? (this.f18736e + this.f18733b) - jA <= 0 : (this.f18736e + f18731i) - jA <= 0) {
            this.f18736e = jA;
            return true;
        }
        int i10 = this.f18738g + 1;
        this.f18738g = i10;
        return i10 <= 2;
    }

    public void e() {
        this.f18736e = this.f18735d;
        this.f18738g = 0;
    }

    @b1.e
    public i1(boolean z10, long j10, TimeUnit timeUnit, b bVar) {
        c1.h0.p(j10 >= 0, "minTime must be non-negative: %s", j10);
        this.f18732a = z10;
        this.f18733b = Math.min(timeUnit.toNanos(j10), f18731i);
        this.f18734c = bVar;
        long jA = bVar.a();
        this.f18735d = jA;
        this.f18736e = jA;
    }
}
