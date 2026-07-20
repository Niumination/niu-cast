package o1;

import c1.h0;
import java.io.Serializable;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@f
public final class x extends Number implements Comparable<x>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f12060a = Long.MAX_VALUE;
    private final long value;
    public static final x ZERO = new x(0);
    public static final x ONE = new x(1);
    public static final x MAX_VALUE = new x(-1);

    public x(long value) {
        this.value = value;
    }

    public static x fromLongBits(long bits) {
        return new x(bits);
    }

    @t1.a
    public static x valueOf(long value) {
        h0.p(value >= 0, "value (%s) is outside the range for an unsigned long value", value);
        return fromLongBits(value);
    }

    public BigInteger bigIntegerValue() {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        return this.value < 0 ? bigIntegerValueOf.setBit(63) : bigIntegerValueOf;
    }

    public x dividedBy(x val) {
        long j10 = this.value;
        val.getClass();
        return fromLongBits(y.c(j10, val.value));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long j10 = this.value;
        if (j10 >= 0) {
            return j10;
        }
        return ((j10 & 1) | (j10 >>> 1)) * 2.0d;
    }

    public boolean equals(@gm.a Object obj) {
        return (obj instanceof x) && this.value == ((x) obj).value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long j10 = this.value;
        if (j10 >= 0) {
            return j10;
        }
        return ((j10 & 1) | (j10 >>> 1)) * 2.0f;
    }

    public int hashCode() {
        return n.l(this.value);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public x minus(x val) {
        long j10 = this.value;
        val.getClass();
        return fromLongBits(j10 - val.value);
    }

    public x mod(x val) {
        long j10 = this.value;
        val.getClass();
        return fromLongBits(y.k(j10, val.value));
    }

    public x plus(x val) {
        long j10 = this.value;
        val.getClass();
        return fromLongBits(j10 + val.value);
    }

    public x times(x val) {
        long j10 = this.value;
        val.getClass();
        return fromLongBits(j10 * val.value);
    }

    public String toString() {
        return y.q(this.value, 10);
    }

    @Override // java.lang.Comparable
    public int compareTo(x o10) {
        o10.getClass();
        return y.a(this.value, o10.value);
    }

    @t1.a
    public static x valueOf(String string) {
        return valueOf(string, 10);
    }

    public String toString(int radix) {
        return y.q(this.value, radix);
    }

    @t1.a
    public static x valueOf(String string, int radix) {
        return fromLongBits(y.j(string, radix));
    }

    @t1.a
    public static x valueOf(BigInteger value) {
        value.getClass();
        h0.u(value.signum() >= 0 && value.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", value);
        return fromLongBits(value.longValue());
    }
}
