package j1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@b1.a
@l
public final class h<T> implements c1.i0<T>, Serializable {
    private final i.c bits;
    private final o<? super T> funnel;
    private final int numHashFunctions;
    private final c strategy;

    public static class b<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final o<? super T> funnel;
        final int numHashFunctions;
        final c strategy;

        public b(h<T> bf2) {
            this.data = i.c.i(((h) bf2).bits.f8395a);
            this.numHashFunctions = ((h) bf2).numHashFunctions;
            this.funnel = ((h) bf2).funnel;
            this.strategy = ((h) bf2).strategy;
        }

        public Object readResolve() {
            return new h(new i.c(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    public interface c extends Serializable {
        <T> boolean mightContain(@i0 T object, o<? super T> funnel, int numHashFunctions, i.c bits);

        int ordinal();

        <T> boolean put(@i0 T object, o<? super T> funnel, int numHashFunctions, i.c bits);
    }

    public static <T> h<T> create(o<? super T> funnel, int expectedInsertions, double fpp) {
        return create(funnel, expectedInsertions, fpp);
    }

    @b1.e
    public static long optimalNumOfBits(long n10, double p10) {
        if (p10 == 0.0d) {
            p10 = Double.MIN_VALUE;
        }
        return (long) ((Math.log(p10) * (-n10)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    @b1.e
    public static int optimalNumOfHashFunctions(long n10, long m10) {
        return Math.max(1, (int) Math.round(Math.log(2.0d) * (m10 / n10)));
    }

    public static <T> h<T> readFrom(InputStream in2, o<? super T> funnel) throws IOException {
        int i10;
        int i11;
        c1.h0.F(in2, "InputStream");
        c1.h0.F(funnel, "Funnel");
        int i12 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(in2);
            byte b10 = dataInputStream.readByte();
            try {
                i11 = dataInputStream.readByte() & 255;
                try {
                    i12 = dataInputStream.readInt();
                    i iVar = i.values()[b10];
                    i.c cVar = new i.c(m1.h.d(i12, 64L));
                    for (int i13 = 0; i13 < i12; i13++) {
                        cVar.g(i13, dataInputStream.readLong());
                    }
                    return new h<>(cVar, i11, funnel, iVar);
                } catch (RuntimeException e10) {
                    e = e10;
                    int i14 = i12;
                    i12 = b10;
                    i10 = i14;
                    StringBuilder sbA = i0.a.a("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ", i12, " numHashFunctions: ", i11, " dataLength: ");
                    sbA.append(i10);
                    throw new IOException(sbA.toString(), e);
                }
            } catch (RuntimeException e11) {
                e = e11;
                i11 = -1;
                i12 = b10;
                i10 = -1;
            }
        } catch (RuntimeException e12) {
            e = e12;
            i10 = -1;
            i11 = -1;
        }
    }

    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private Object writeReplace() {
        return new b(this);
    }

    @Override // c1.i0
    @Deprecated
    public boolean apply(@i0 T input) {
        return mightContain(input);
    }

    public long approximateElementCount() {
        double dB = this.bits.b();
        return m1.c.q(((-Math.log1p(-(this.bits.f8396b.sum() / dB))) * dB) / ((double) this.numHashFunctions), RoundingMode.HALF_UP);
    }

    @b1.e
    public long bitSize() {
        return this.bits.b();
    }

    public h<T> copy() {
        return new h<>(this.bits.c(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // c1.i0
    public boolean equals(@gm.a Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof h)) {
            return false;
        }
        h hVar = (h) object;
        return this.numHashFunctions == hVar.numHashFunctions && this.funnel.equals(hVar.funnel) && this.bits.equals(hVar.bits) && this.strategy.equals(hVar.strategy);
    }

    public double expectedFpp() {
        return Math.pow(this.bits.f8396b.sum() / bitSize(), this.numHashFunctions);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits});
    }

    public boolean isCompatible(h<T> that) {
        that.getClass();
        return this != that && this.numHashFunctions == that.numHashFunctions && bitSize() == that.bitSize() && this.strategy.equals(that.strategy) && this.funnel.equals(that.funnel);
    }

    public boolean mightContain(@i0 T object) {
        return this.strategy.mightContain(object, this.funnel, this.numHashFunctions, this.bits);
    }

    @t1.a
    public boolean put(@i0 T object) {
        return this.strategy.put(object, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(h<T> that) {
        that.getClass();
        c1.h0.e(this != that, "Cannot combine a BloomFilter with itself.");
        int i10 = this.numHashFunctions;
        int i11 = that.numHashFunctions;
        c1.h0.m(i10 == i11, "BloomFilters must have the same number of hash functions (%s != %s)", i10, i11);
        c1.h0.s(bitSize() == that.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), that.bitSize());
        c1.h0.y(this.strategy.equals(that.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, that.strategy);
        c1.h0.y(this.funnel.equals(that.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, that.funnel);
        this.bits.f(that.bits);
    }

    public void writeTo(OutputStream out) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(out);
        dataOutputStream.writeByte(o1.t.a(this.strategy.ordinal()));
        dataOutputStream.writeByte(o1.u.a(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.f8395a.length());
        for (int i10 = 0; i10 < this.bits.f8395a.length(); i10++) {
            dataOutputStream.writeLong(this.bits.f8395a.get(i10));
        }
    }

    public h(i.c bits, int numHashFunctions, o<? super T> funnel, c strategy) {
        c1.h0.k(numHashFunctions > 0, "numHashFunctions (%s) must be > 0", numHashFunctions);
        c1.h0.k(numHashFunctions <= 255, "numHashFunctions (%s) must be <= 255", numHashFunctions);
        bits.getClass();
        this.bits = bits;
        this.numHashFunctions = numHashFunctions;
        funnel.getClass();
        this.funnel = funnel;
        strategy.getClass();
        this.strategy = strategy;
    }

    public static <T> h<T> create(o<? super T> funnel, long expectedInsertions, double fpp) {
        return create(funnel, expectedInsertions, fpp, i.MURMUR128_MITZ_64);
    }

    public static <T> h<T> create(o<? super T> funnel, int expectedInsertions) {
        return create(funnel, expectedInsertions);
    }

    public static <T> h<T> create(o<? super T> funnel, long expectedInsertions) {
        return create(funnel, expectedInsertions, 0.03d);
    }

    @b1.e
    public static <T> h<T> create(o<? super T> funnel, long expectedInsertions, double fpp, c strategy) {
        funnel.getClass();
        c1.h0.p(expectedInsertions >= 0, "Expected insertions (%s) must be >= 0", expectedInsertions);
        c1.h0.u(fpp > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(fpp));
        c1.h0.u(fpp < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(fpp));
        strategy.getClass();
        if (expectedInsertions == 0) {
            expectedInsertions = 1;
        }
        long jOptimalNumOfBits = optimalNumOfBits(expectedInsertions, fpp);
        try {
            return new h<>(new i.c(jOptimalNumOfBits), optimalNumOfHashFunctions(expectedInsertions, jOptimalNumOfBits), funnel, strategy);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(g.a("Could not create BloomFilter of ", jOptimalNumOfBits, " bits"), e10);
        }
    }
}
