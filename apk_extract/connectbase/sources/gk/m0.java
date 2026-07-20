package gk;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 {
    @os.m
    public static final lq.e a(@os.l el.a aVar) {
        kn.l0.p(aVar, "<this>");
        return lq.e.k(lq.g.n0(aVar.f4492a, lq.h.SECONDS));
    }

    @lq.l
    public static /* synthetic */ void b(el.a aVar) {
    }

    public static final long c(@os.l d.a aVar) {
        kn.l0.p(aVar, "<this>");
        return lq.g.n0(aVar.f6572h, lq.h.SECONDS);
    }

    public static final long d(@os.l i0.a aVar) {
        kn.l0.p(aVar, "<this>");
        return lq.g.n0(aVar.f6649c, lq.h.SECONDS);
    }

    @lq.l
    public static /* synthetic */ void e(d.a aVar) {
    }

    @lq.l
    public static /* synthetic */ void f(i0.a aVar) {
    }

    public static final void g(@os.l el.a aVar, @os.m lq.e eVar) {
        kn.l0.p(aVar, "$this$maxAge");
        if (eVar != null && lq.e.f0(eVar.f10251a)) {
            throw new IllegalArgumentException("Only non-negative durations can be specified");
        }
        aVar.n(eVar == null ? 0L : pn.d.M0(lq.e.p0(eVar.f10251a, lq.h.SECONDS)));
    }

    public static final void h(@os.l d.a aVar, long j10) {
        kn.l0.p(aVar, "$this$maxAgeDuration");
        if (lq.e.f0(j10)) {
            throw new IllegalArgumentException("Only non-negative durations can be specified");
        }
        aVar.F(pn.d.M0(lq.e.p0(j10, lq.h.SECONDS)));
    }

    public static final void i(@os.l i0.a aVar, long j10) {
        kn.l0.p(aVar, "$this$maxAgeDuration");
        if (lq.e.f0(j10)) {
            throw new IllegalArgumentException("Only non-negative durations can be specified");
        }
        aVar.i(pn.d.M0(lq.e.p0(j10, lq.h.SECONDS)));
    }
}
