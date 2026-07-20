package tn;

import nm.w0;

/* JADX INFO: loaded from: classes3.dex */
public class m implements Iterable<Long>, ln.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final a f15920d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f15922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f15923c;

    public static final class a {
        public a() {
        }

        @os.l
        public final m a(long j10, long j11, long j12) {
            return new m(j10, j11, j12);
        }

        public a(kn.w wVar) {
        }
    }

    public m(long j10, long j11, long j12) {
        if (j12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j12 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f15921a = j10;
        this.f15922b = an.n.d(j10, j11, j12);
        this.f15923c = j12;
    }

    public final long e() {
        return this.f15921a;
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof m) {
            if (!isEmpty() || !((m) obj).isEmpty()) {
                m mVar = (m) obj;
                if (this.f15921a != mVar.f15921a || this.f15922b != mVar.f15922b || this.f15923c != mVar.f15923c) {
                }
            }
            return true;
        }
        return false;
    }

    public final long f() {
        return this.f15922b;
    }

    public final long g() {
        return this.f15923c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j10 = 31;
        long j11 = this.f15921a;
        long j12 = this.f15922b;
        long j13 = (((j11 ^ (j11 >>> 32)) * j10) + (j12 ^ (j12 >>> 32))) * j10;
        long j14 = this.f15923c;
        return (int) (j13 + (j14 ^ (j14 >>> 32)));
    }

    @Override // java.lang.Iterable
    @os.l
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public w0 iterator() {
        return new n(this.f15921a, this.f15922b, this.f15923c);
    }

    public boolean isEmpty() {
        long j10 = this.f15923c;
        long j11 = this.f15921a;
        long j12 = this.f15922b;
        if (j10 > 0) {
            if (j11 <= j12) {
                return false;
            }
        } else if (j11 >= j12) {
            return false;
        }
        return true;
    }

    @os.l
    public String toString() {
        StringBuilder sb2;
        long j10;
        if (this.f15923c > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f15921a);
            sb2.append("..");
            sb2.append(this.f15922b);
            sb2.append(" step ");
            j10 = this.f15923c;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f15921a);
            sb2.append(" downTo ");
            sb2.append(this.f15922b);
            sb2.append(" step ");
            j10 = -this.f15923c;
        }
        sb2.append(j10);
        return sb2.toString();
    }
}
