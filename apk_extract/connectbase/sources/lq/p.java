package lq;

import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.3")
public final class p implements s.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final p f10262b = new p();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f10263c = System.nanoTime();

    private final long f() {
        return System.nanoTime() - f10263c;
    }

    @Override // lq.s.c, lq.s
    public d a() {
        return new s.b.a(f());
    }

    public final long b(long j10, long j11) {
        return m.d(j10, h.NANOSECONDS, j11);
    }

    public final long c(long j10, long j11) {
        return m.h(j10, j11, h.NANOSECONDS);
    }

    public final long d(long j10) {
        return m.f(f(), j10, h.NANOSECONDS);
    }

    public long e() {
        return f();
    }

    @os.l
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }

    @Override // lq.s
    public r a() {
        return new s.b.a(f());
    }
}
