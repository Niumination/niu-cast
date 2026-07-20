package rn;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kn.l0;
import kn.r1;
import lm.f1;
import os.l;
import tn.o;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/RandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,383:1\n1#2:384\n*E\n"})
public final class g {
    @f1(version = "1.3")
    @l
    public static final f a(int i10) {
        return new i(i10, i10 >> 31);
    }

    @f1(version = "1.3")
    @l
    public static final f b(long j10) {
        return new i((int) j10, (int) (j10 >> 32));
    }

    @l
    public static final String c(@l Object obj, @l Object obj2) {
        l0.p(obj, TypedValues.TransitionType.S_FROM);
        l0.p(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }

    public static final void d(double d10, double d11) {
        if (d11 <= d10) {
            throw new IllegalArgumentException(c(Double.valueOf(d10), Double.valueOf(d11)).toString());
        }
    }

    public static final void e(int i10, int i11) {
        if (i11 <= i10) {
            throw new IllegalArgumentException(c(Integer.valueOf(i10), Integer.valueOf(i11)).toString());
        }
    }

    public static final void f(long j10, long j11) {
        if (j11 <= j10) {
            throw new IllegalArgumentException(c(Long.valueOf(j10), Long.valueOf(j11)).toString());
        }
    }

    public static final int g(int i10) {
        return 31 - Integer.numberOfLeadingZeros(i10);
    }

    @f1(version = "1.3")
    public static final int h(@l f fVar, @l tn.l lVar) {
        l0.p(fVar, "<this>");
        l0.p(lVar, "range");
        if (lVar.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + lVar);
        }
        int i10 = lVar.f15912b;
        if (i10 < Integer.MAX_VALUE) {
            return fVar.nextInt(lVar.f15911a, i10 + 1);
        }
        int i11 = lVar.f15911a;
        return i11 > Integer.MIN_VALUE ? fVar.nextInt(i11 - 1, i10) + 1 : fVar.nextInt();
    }

    @f1(version = "1.3")
    public static final long i(@l f fVar, @l o oVar) {
        l0.p(fVar, "<this>");
        l0.p(oVar, "range");
        if (oVar.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + oVar);
        }
        long j10 = oVar.f15922b;
        if (j10 < Long.MAX_VALUE) {
            return fVar.nextLong(oVar.f15921a, j10 + 1);
        }
        long j11 = oVar.f15921a;
        return j11 > Long.MIN_VALUE ? fVar.nextLong(j11 - 1, j10) + 1 : fVar.nextLong();
    }

    public static final int j(int i10, int i11) {
        return (i10 >>> (32 - i11)) & ((-i11) >> 31);
    }
}
