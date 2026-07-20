package o1;

import c1.h0;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@f
public final class v extends Number implements Comparable<v> {
    private final int value;
    public static final v ZERO = fromIntBits(0);
    public static final v ONE = fromIntBits(1);
    public static final v MAX_VALUE = fromIntBits(-1);

    public v(int value) {
        this.value = value;
    }

    public static v fromIntBits(int bits) {
        return new v(bits);
    }

    public static v valueOf(long value) {
        h0.p((4294967295L & value) == value, "value (%s) is outside the range for an unsigned integer value", value);
        return fromIntBits((int) value);
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(longValue());
    }

    public v dividedBy(v val) {
        int i10 = this.value;
        val.getClass();
        return fromIntBits(w.d(i10, val.value));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return longValue();
    }

    public boolean equals(@gm.a Object obj) {
        return (obj instanceof v) && this.value == ((v) obj).value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return longValue();
    }

    public int hashCode() {
        return this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return ((long) this.value) & 4294967295L;
    }

    public v minus(v val) {
        int i10 = this.value;
        val.getClass();
        return fromIntBits(i10 - val.value);
    }

    public v mod(v val) {
        int i10 = this.value;
        val.getClass();
        return fromIntBits(w.l(i10, val.value));
    }

    public v plus(v val) {
        int i10 = this.value;
        val.getClass();
        return fromIntBits(i10 + val.value);
    }

    @b1.c
    @b1.d
    public v times(v val) {
        int i10 = this.value;
        val.getClass();
        return fromIntBits(i10 * val.value);
    }

    public String toString() {
        return toString(10);
    }

    @Override // java.lang.Comparable
    public int compareTo(v other) {
        other.getClass();
        return w.b(this.value, other.value);
    }

    public String toString(int radix) {
        return w.t(this.value, radix);
    }

    public static v valueOf(String string) {
        return valueOf(string, 10);
    }

    public static v valueOf(String string, int radix) {
        return fromIntBits(w.k(string, radix));
    }

    public static v valueOf(BigInteger value) {
        value.getClass();
        h0.u(value.signum() >= 0 && value.bitLength() <= 32, "value (%s) is outside the range for an unsigned integer value", value);
        return fromIntBits(value.intValue());
    }
}
