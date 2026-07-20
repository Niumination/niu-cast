package lq;

import kn.r1;
import lm.f1;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nTimeSources.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeSources.kt\nkotlin/time/TestTimeSource\n+ 2 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,199:1\n80#2:200\n80#2:201\n*S KotlinDebug\n*F\n+ 1 TimeSources.kt\nkotlin/time/TestTimeSource\n*L\n173#1:200\n180#1:201\n*E\n"})
@f1(version = "1.9")
@p2(markerClass = {l.class})
public final class q extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f10264d;

    public q() {
        super(h.NANOSECONDS);
        a();
    }

    @Override // lq.b
    public long f() {
        return this.f10264d;
    }

    public final void g(long j10) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.f10264d + k.h(this.f10240b) + " is advanced by " + ((Object) e.v0(j10)) + n1.e.f11183c);
    }

    public final void h(long j10) {
        long jS0 = e.s0(j10, this.f10240b);
        if (((jS0 - 1) | 1) != Long.MAX_VALUE) {
            long j11 = this.f10264d;
            long j12 = j11 + jS0;
            if ((jS0 ^ j11) >= 0 && (j11 ^ j12) < 0) {
                g(j10);
            }
            this.f10264d = j12;
            return;
        }
        long jQ = e.q(j10, 2);
        if ((1 | (e.s0(jQ, this.f10240b) - 1)) == Long.MAX_VALUE) {
            g(j10);
            return;
        }
        long j13 = this.f10264d;
        try {
            h(jQ);
            h(e.h0(j10, jQ));
        } catch (IllegalStateException e10) {
            this.f10264d = j13;
            throw e10;
        }
    }
}
