package lq;

import kn.l0;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nlongSaturatedMath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,81:1\n80#1:82\n80#1:83\n80#1:84\n80#1:85\n80#1:86\n80#1:87\n*S KotlinDebug\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n14#1:82\n17#1:83\n36#1:84\n46#1:85\n53#1:86\n57#1:87\n*E\n"})
public final class m {
    public static final long a(long j10, long j11, long j12) {
        if (!e.e0(j11) || (j10 ^ j12) >= 0) {
            return j10;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    public static final long b(long j10) {
        if (j10 < 0) {
            e.f10247b.getClass();
            return e.f10250e;
        }
        e.f10247b.getClass();
        return e.f10249d;
    }

    public static final boolean c(long j10) {
        return ((j10 - 1) | 1) == Long.MAX_VALUE;
    }

    public static final long d(long j10, @os.l h hVar, long j11) {
        l0.p(hVar, "unit");
        long jS0 = e.s0(j11, hVar);
        if (((j10 - 1) | 1) == Long.MAX_VALUE) {
            return a(j10, j11, jS0);
        }
        if ((1 | (jS0 - 1)) == Long.MAX_VALUE) {
            return e(j10, hVar, j11);
        }
        long j12 = j10 + jS0;
        if (((j10 ^ j12) & (jS0 ^ j12)) < 0) {
            return j10 < 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        return j12;
    }

    public static final long e(long j10, h hVar, long j11) {
        long jQ = e.q(j11, 2);
        long jS0 = e.s0(jQ, hVar);
        return (1 | (jS0 - 1)) == Long.MAX_VALUE ? jS0 : d(d(j10, hVar, jQ), hVar, e.h0(j11, jQ));
    }

    public static final long f(long j10, long j11, @os.l h hVar) {
        l0.p(hVar, "unit");
        return (1 | (j11 - 1)) == Long.MAX_VALUE ? e.z0(b(j11)) : g(j10, j11, hVar);
    }

    public static final long g(long j10, long j11, h hVar) {
        long j12 = j10 - j11;
        if (((j12 ^ j10) & (~(j12 ^ j11))) >= 0) {
            return g.n0(j12, hVar);
        }
        h hVar2 = h.MILLISECONDS;
        if (hVar.compareTo(hVar2) >= 0) {
            return e.z0(b(j12));
        }
        long jB = j.b(1L, hVar2, hVar);
        long j13 = (j10 / jB) - (j11 / jB);
        long j14 = (j10 % jB) - (j11 % jB);
        e.a aVar = e.f10247b;
        return e.i0(g.n0(j13, hVar2), g.n0(j14, hVar));
    }

    public static final long h(long j10, long j11, @os.l h hVar) {
        l0.p(hVar, "unit");
        if (((j11 - 1) | 1) != Long.MAX_VALUE) {
            return (1 | (j10 - 1)) == Long.MAX_VALUE ? b(j10) : g(j10, j11, hVar);
        }
        if (j10 != j11) {
            return e.z0(b(j11));
        }
        e.f10247b.getClass();
        return e.f10248c;
    }
}
