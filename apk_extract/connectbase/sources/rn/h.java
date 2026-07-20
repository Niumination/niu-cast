package rn;

import kn.l0;
import kn.r1;
import lm.a2;
import lm.f1;
import lm.p2;
import lm.t;
import lm.w1;
import os.l;
import tn.a0;
import tn.x;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nURandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 URandom.kt\nkotlin/random/URandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,155:1\n1#2:156\n*E\n"})
public final class h {
    public static final void a(int i10, int i11) {
        if (Integer.compareUnsigned(i11, i10) <= 0) {
            throw new IllegalArgumentException(g.c(w1.b(i10), new w1(i11)).toString());
        }
    }

    public static final void b(long j10, long j11) {
        if (Long.compareUnsigned(j11, j10) <= 0) {
            throw new IllegalArgumentException(g.c(a2.b(j10), new a2(j11)).toString());
        }
    }

    @f1(version = "1.3")
    @t
    @l
    public static final byte[] c(@l f fVar, int i10) {
        l0.p(fVar, "<this>");
        byte[] bArrNextBytes = fVar.nextBytes(i10);
        l0.p(bArrNextBytes, "storage");
        return bArrNextBytes;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final byte[] d(@l f fVar, @l byte[] bArr) {
        l0.p(fVar, "$this$nextUBytes");
        l0.p(bArr, dc.d.f3685p);
        fVar.nextBytes(bArr);
        return bArr;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final byte[] e(@l f fVar, @l byte[] bArr, int i10, int i11) {
        l0.p(fVar, "$this$nextUBytes");
        l0.p(bArr, dc.d.f3685p);
        fVar.nextBytes(bArr, i10, i11);
        return bArr;
    }

    public static byte[] f(f fVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return e(fVar, bArr, i10, i11);
    }

    @f1(version = "1.5")
    @p2(markerClass = {t.class})
    public static final int g(@l f fVar) {
        l0.p(fVar, "<this>");
        return w1.m(fVar.nextInt());
    }

    @f1(version = "1.5")
    @p2(markerClass = {t.class})
    public static final int h(@l f fVar, @l x xVar) {
        l0.p(fVar, "<this>");
        l0.p(xVar, "range");
        if (xVar.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + xVar);
        }
        if (Integer.compareUnsigned(xVar.f15936b, -1) < 0) {
            return i(fVar, xVar.f15935a, w1.m(xVar.f15936b + 1));
        }
        return Integer.compareUnsigned(xVar.f15935a, 0) > 0 ? i(fVar, w1.m(xVar.f15935a - 1), xVar.f15936b) + 1 : g(fVar);
    }

    @f1(version = "1.5")
    @p2(markerClass = {t.class})
    public static final int i(@l f fVar, int i10, int i11) {
        l0.p(fVar, "$this$nextUInt");
        a(i10, i11);
        return w1.m(fVar.nextInt(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @f1(version = "1.5")
    @p2(markerClass = {t.class})
    public static final int j(@l f fVar, int i10) {
        l0.p(fVar, "$this$nextUInt");
        return i(fVar, 0, i10);
    }

    @f1(version = "1.5")
    @p2(markerClass = {t.class})
    public static final long k(@l f fVar) {
        l0.p(fVar, "<this>");
        return a2.m(fVar.nextLong());
    }

    @f1(version = "1.5")
    @p2(markerClass = {t.class})
    public static final long l(@l f fVar, @l a0 a0Var) {
        l0.p(fVar, "<this>");
        l0.p(a0Var, "range");
        if (a0Var.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + a0Var);
        }
        if (Long.compareUnsigned(a0Var.f15946b, -1L) < 0) {
            return n(fVar, a0Var.f15945a, a2.m(((long) 1) & 4294967295L) + a0Var.f15946b);
        }
        if (Long.compareUnsigned(a0Var.f15945a, 0L) <= 0) {
            return k(fVar);
        }
        long j10 = ((long) 1) & 4294967295L;
        return n(fVar, a0Var.f15945a - a2.m(j10), a0Var.f15946b) + j10;
    }

    @f1(version = "1.5")
    @p2(markerClass = {t.class})
    public static final long m(@l f fVar, long j10) {
        l0.p(fVar, "$this$nextULong");
        return n(fVar, 0L, j10);
    }

    @f1(version = "1.5")
    @p2(markerClass = {t.class})
    public static final long n(@l f fVar, long j10, long j11) {
        l0.p(fVar, "$this$nextULong");
        b(j10, j11);
        return a2.m(fVar.nextLong(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }
}
