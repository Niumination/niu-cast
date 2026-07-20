package tn;

import java.util.Iterator;
import lm.a2;
import lm.f1;
import lm.o2;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.5")
@p2(markerClass = {lm.t.class})
public class y implements Iterable<a2>, ln.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final a f15944d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f15946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f15947c;

    public static final class a {
        public a() {
        }

        @os.l
        public final y a(long j10, long j11, long j12) {
            return new y(j10, j11, j12);
        }

        public a(kn.w wVar) {
        }
    }

    public /* synthetic */ y(long j10, long j11, long j12, kn.w wVar) {
        this(j10, j11, j12);
    }

    public final long e() {
        return this.f15945a;
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof y) {
            if (!isEmpty() || !((y) obj).isEmpty()) {
                y yVar = (y) obj;
                if (this.f15945a != yVar.f15945a || this.f15946b != yVar.f15946b || this.f15947c != yVar.f15947c) {
                }
            }
            return true;
        }
        return false;
    }

    public final long f() {
        return this.f15946b;
    }

    public final long g() {
        return this.f15947c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j10 = this.f15945a;
        int iM = ((int) (j10 ^ a2.m(j10 >>> 32))) * 31;
        long j11 = this.f15946b;
        int i10 = (iM + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.f15947c;
        return ((int) ((j12 >>> 32) ^ j12)) + i10;
    }

    public boolean isEmpty() {
        long j10 = this.f15947c;
        int iCompareUnsigned = Long.compareUnsigned(this.f15945a, this.f15946b);
        if (j10 > 0) {
            if (iCompareUnsigned <= 0) {
                return false;
            }
        } else if (iCompareUnsigned >= 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Iterable
    @os.l
    public final Iterator<a2> iterator() {
        return new z(this.f15945a, this.f15946b, this.f15947c);
    }

    @os.l
    public String toString() {
        StringBuilder sb2;
        long j10;
        if (this.f15947c > 0) {
            sb2 = new StringBuilder();
            sb2.append((Object) a2.h0(this.f15945a));
            sb2.append("..");
            sb2.append((Object) o2.l(this.f15946b, 10));
            sb2.append(" step ");
            j10 = this.f15947c;
        } else {
            sb2 = new StringBuilder();
            sb2.append((Object) a2.h0(this.f15945a));
            sb2.append(" downTo ");
            sb2.append((Object) o2.l(this.f15946b, 10));
            sb2.append(" step ");
            j10 = -this.f15947c;
        }
        sb2.append(j10);
        return sb2.toString();
    }

    public y(long j10, long j11, long j12) {
        if (j12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j12 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f15945a = j10;
        this.f15946b = an.r.c(j10, j11, j12);
        this.f15947c = j12;
    }
}
