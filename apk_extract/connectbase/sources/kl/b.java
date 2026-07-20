package kl;

import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    @l
    public static final d a(@l d dVar, long j10) {
        l0.p(dVar, "<this>");
        return a.b(Long.valueOf(dVar.f9262n - j10));
    }

    @lq.l
    @l
    public static final d b(@l d dVar, long j10) {
        l0.p(dVar, "$this$minus");
        return a.b(Long.valueOf(dVar.f9262n - lq.e.N(j10)));
    }

    @l
    public static final d c(@l d dVar, long j10) {
        l0.p(dVar, "<this>");
        return a.b(Long.valueOf(dVar.f9262n + j10));
    }

    @lq.l
    @l
    public static final d d(@l d dVar, long j10) {
        l0.p(dVar, "$this$plus");
        return a.b(Long.valueOf(lq.e.N(j10) + dVar.f9262n));
    }

    @l
    public static final d e(@l d dVar) {
        l0.p(dVar, "<this>");
        return a.a(dVar.f9254a, dVar.f9255b, dVar.f9256c, dVar.f9258e, dVar.f9260g, dVar.f9261i);
    }
}
