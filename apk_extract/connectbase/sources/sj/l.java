package sj;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f15089a;

    public l(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            this.f15089a = bigInteger;
        } else {
            throw new IllegalArgumentException("Attempt to construct ConfigMemorySize with negative number: " + bigInteger);
        }
    }

    public static l a(long j10) {
        return new l(BigInteger.valueOf(j10));
    }

    public static l b(BigInteger bigInteger) {
        return new l(bigInteger);
    }

    public long c() {
        if (this.f15089a.bitLength() < 64) {
            return this.f15089a.longValue();
        }
        throw new IllegalArgumentException("size-in-bytes value is out of range for a 64-bit long: '" + this.f15089a + "'");
    }

    public BigInteger d() {
        return this.f15089a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            return ((l) obj).f15089a.equals(this.f15089a);
        }
        return false;
    }

    public int hashCode() {
        return this.f15089a.hashCode();
    }

    public String toString() {
        return "ConfigMemorySize(" + this.f15089a + ")";
    }
}
