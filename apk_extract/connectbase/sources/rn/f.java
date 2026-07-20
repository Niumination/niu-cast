package rn;

import an.m;
import java.io.Serializable;
import kn.l0;
import kn.r1;
import kn.w;
import lm.f1;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/Random\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,383:1\n1#2:384\n*E\n"})
@f1(version = "1.3")
public abstract class f {

    @l
    public static final a Default = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final f f14591a = m.f417a.b();

    public static final class a extends f implements Serializable {

        /* JADX INFO: renamed from: rn.f$a$a, reason: collision with other inner class name */
        public static final class C0358a implements Serializable {

            @l
            public static final C0358a INSTANCE = new C0358a();
            private static final long serialVersionUID = 0;

            private final Object readResolve() {
                return f.Default;
            }
        }

        public a() {
        }

        private final Object writeReplace() {
            return C0358a.INSTANCE;
        }

        @Override // rn.f
        public int nextBits(int i10) {
            return f.f14591a.nextBits(i10);
        }

        @Override // rn.f
        public boolean nextBoolean() {
            return f.f14591a.nextBoolean();
        }

        @Override // rn.f
        @l
        public byte[] nextBytes(@l byte[] bArr) {
            l0.p(bArr, dc.d.f3685p);
            return f.f14591a.nextBytes(bArr);
        }

        @Override // rn.f
        public double nextDouble() {
            return f.f14591a.nextDouble();
        }

        @Override // rn.f
        public float nextFloat() {
            return f.f14591a.nextFloat();
        }

        @Override // rn.f
        public int nextInt() {
            return f.f14591a.nextInt();
        }

        @Override // rn.f
        public long nextLong() {
            return f.f14591a.nextLong();
        }

        public a(w wVar) {
        }

        @Override // rn.f
        @l
        public byte[] nextBytes(int i10) {
            return f.f14591a.nextBytes(i10);
        }

        @Override // rn.f
        public double nextDouble(double d10) {
            return f.f14591a.nextDouble(d10);
        }

        @Override // rn.f
        public int nextInt(int i10) {
            return f.f14591a.nextInt(i10);
        }

        @Override // rn.f
        public long nextLong(long j10) {
            return f.f14591a.nextLong(j10);
        }

        @Override // rn.f
        @l
        public byte[] nextBytes(@l byte[] bArr, int i10, int i11) {
            l0.p(bArr, dc.d.f3685p);
            return f.f14591a.nextBytes(bArr, i10, i11);
        }

        @Override // rn.f
        public double nextDouble(double d10, double d11) {
            return f.f14591a.nextDouble(d10, d11);
        }

        @Override // rn.f
        public int nextInt(int i10, int i11) {
            return f.f14591a.nextInt(i10, i11);
        }

        @Override // rn.f
        public long nextLong(long j10, long j11) {
            return f.f14591a.nextLong(j10, j11);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(f fVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return fVar.nextBytes(bArr, i10, i11);
    }

    public abstract int nextBits(int i10);

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    @l
    public byte[] nextBytes(@l byte[] bArr, int i10, int i11) {
        l0.p(bArr, dc.d.f3685p);
        if (!new tn.l(0, bArr.length, 1).l(i10) || !new tn.l(0, bArr.length, 1).l(i11)) {
            throw new IllegalArgumentException(u.a.a(i0.a.a("fromIndex (", i10, ") or toIndex (", i11, ") are out of range: 0.."), bArr.length, n1.e.f11183c).toString());
        }
        if (i10 > i11) {
            throw new IllegalArgumentException(("fromIndex (" + i10 + ") must be not greater than toIndex (" + i11 + ").").toString());
        }
        int i12 = (i11 - i10) / 4;
        for (int i13 = 0; i13 < i12; i13++) {
            int iNextInt = nextInt();
            bArr[i10] = (byte) iNextInt;
            bArr[i10 + 1] = (byte) (iNextInt >>> 8);
            bArr[i10 + 2] = (byte) (iNextInt >>> 16);
            bArr[i10 + 3] = (byte) (iNextInt >>> 24);
            i10 += 4;
        }
        int i14 = i11 - i10;
        int iNextBits = nextBits(i14 * 8);
        for (int i15 = 0; i15 < i14; i15++) {
            bArr[i10 + i15] = (byte) (iNextBits >>> (i15 * 8));
        }
        return bArr;
    }

    public double nextDouble() {
        return e.d(nextBits(26), nextBits(27));
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public double nextDouble(double d10) {
        return nextDouble(0.0d, d10);
    }

    public int nextInt(int i10) {
        return nextInt(0, i10);
    }

    public long nextLong(long j10) {
        return nextLong(0L, j10);
    }

    public double nextDouble(double d10, double d11) {
        double dNextDouble;
        g.d(d10, d11);
        double d12 = d11 - d10;
        if (Double.isInfinite(d12) && !Double.isInfinite(d10) && !Double.isNaN(d10) && !Double.isInfinite(d11) && !Double.isNaN(d11)) {
            double d13 = 2;
            double dNextDouble2 = ((d11 / d13) - (d10 / d13)) * nextDouble();
            dNextDouble = d10 + dNextDouble2 + dNextDouble2;
        } else {
            dNextDouble = d10 + (nextDouble() * d12);
        }
        return dNextDouble >= d11 ? Math.nextAfter(d11, Double.NEGATIVE_INFINITY) : dNextDouble;
    }

    public int nextInt(int i10, int i11) {
        int iNextInt;
        int i12;
        int iNextBits;
        g.e(i10, i11);
        int i13 = i11 - i10;
        if (i13 > 0 || i13 == Integer.MIN_VALUE) {
            if (((-i13) & i13) == i13) {
                iNextBits = nextBits(g.g(i13));
            } else {
                do {
                    iNextInt = nextInt() >>> 1;
                    i12 = iNextInt % i13;
                } while ((i13 - 1) + (iNextInt - i12) < 0);
                iNextBits = i12;
            }
            return i10 + iNextBits;
        }
        while (true) {
            int iNextInt2 = nextInt();
            if (i10 <= iNextInt2 && iNextInt2 < i11) {
                return iNextInt2;
            }
        }
    }

    public long nextLong(long j10, long j11) {
        long jNextLong;
        long j12;
        long jNextBits;
        int iNextInt;
        g.f(j10, j11);
        long j13 = j11 - j10;
        if (j13 > 0) {
            if (((-j13) & j13) == j13) {
                int i10 = (int) j13;
                int i11 = (int) (j13 >>> 32);
                if (i10 != 0) {
                    iNextInt = nextBits(g.g(i10));
                } else if (i11 == 1) {
                    iNextInt = nextInt();
                } else {
                    jNextBits = (((long) nextBits(g.g(i11))) << 32) + (((long) nextInt()) & 4294967295L);
                }
                jNextBits = ((long) iNextInt) & 4294967295L;
            } else {
                do {
                    jNextLong = nextLong() >>> 1;
                    j12 = jNextLong % j13;
                } while ((j13 - 1) + (jNextLong - j12) < 0);
                jNextBits = j12;
            }
            return j10 + jNextBits;
        }
        while (true) {
            long jNextLong2 = nextLong();
            if (j10 <= jNextLong2 && jNextLong2 < j11) {
                return jNextLong2;
            }
        }
    }

    @l
    public byte[] nextBytes(@l byte[] bArr) {
        l0.p(bArr, dc.d.f3685p);
        return nextBytes(bArr, 0, bArr.length);
    }

    @l
    public byte[] nextBytes(int i10) {
        return nextBytes(new byte[i10]);
    }
}
