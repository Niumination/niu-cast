package tn;

import lm.a2;
import lm.f1;
import lm.o2;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.5")
@p2(markerClass = {lm.t.class})
public final class a0 extends y implements g<a2>, r<a2> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f15894e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final a0 f15895f = new a0(-1, 0);

    public static final class a {
        public a() {
        }

        @os.l
        public final a0 a() {
            return a0.f15895f;
        }

        public a(kn.w wVar) {
        }
    }

    public a0(long j10, long j11) {
        super(j10, j11, 1L);
    }

    @f1(version = "1.9")
    @lm.k(message = "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @p2(markerClass = {lm.r.class})
    public static /* synthetic */ void m() {
    }

    @Override // tn.r
    public /* bridge */ /* synthetic */ Comparable c() {
        return a2.b(l());
    }

    @Override // tn.g
    public /* synthetic */ boolean contains(Comparable comparable) {
        return j(((a2) comparable).f10177a);
    }

    @Override // tn.y
    public boolean equals(@os.m Object obj) {
        if (obj instanceof a0) {
            if (!isEmpty() || !((a0) obj).isEmpty()) {
                a0 a0Var = (a0) obj;
                if (this.f15945a != a0Var.f15945a || this.f15946b != a0Var.f15946b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // tn.g
    public Comparable getEndInclusive() {
        return a2.b(this.f15946b);
    }

    @Override // tn.g
    public Comparable getStart() {
        return a2.b(this.f15945a);
    }

    @Override // tn.y
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j10 = this.f15945a;
        int iM = ((int) (j10 ^ a2.m(j10 >>> 32))) * 31;
        long j11 = this.f15946b;
        return ((int) ((j11 >>> 32) ^ j11)) + iM;
    }

    @Override // tn.y, tn.g
    public boolean isEmpty() {
        return Long.compareUnsigned(this.f15945a, this.f15946b) > 0;
    }

    public boolean j(long j10) {
        return Long.compareUnsigned(this.f15945a, j10) <= 0 && Long.compareUnsigned(j10, this.f15946b) <= 0;
    }

    public long l() {
        long j10 = this.f15946b;
        if (j10 != -1) {
            return a2.m(((long) 1) & 4294967295L) + j10;
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    public long n() {
        return this.f15946b;
    }

    public long o() {
        return this.f15945a;
    }

    @Override // tn.y
    @os.l
    public String toString() {
        return ((Object) a2.h0(this.f15945a)) + ".." + ((Object) o2.l(this.f15946b, 10));
    }

    public /* synthetic */ a0(long j10, long j11, kn.w wVar) {
        this(j10, j11);
    }
}
