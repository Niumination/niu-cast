package tn;

import lm.f1;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends m implements g<Long>, r<Long> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f15928e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final o f15929f = new o(1, 0);

    public static final class a {
        public a() {
        }

        @os.l
        public final o a() {
            return o.f15929f;
        }

        public a(kn.w wVar) {
        }
    }

    public o(long j10, long j11) {
        super(j10, j11, 1L);
    }

    @f1(version = "1.9")
    @lm.k(message = "Can throw an exception when it's impossible to represent the value with Long type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @p2(markerClass = {lm.r.class})
    public static /* synthetic */ void n() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tn.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return l(((Number) comparable).longValue());
    }

    @Override // tn.m
    public boolean equals(@os.m Object obj) {
        if (obj instanceof o) {
            if (!isEmpty() || !((o) obj).isEmpty()) {
                o oVar = (o) obj;
                if (this.f15921a != oVar.f15921a || this.f15922b != oVar.f15922b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // tn.g
    public Comparable getEndInclusive() {
        return Long.valueOf(this.f15922b);
    }

    @Override // tn.g
    public Comparable getStart() {
        return Long.valueOf(this.f15921a);
    }

    @Override // tn.m
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j10 = this.f15921a;
        long j11 = ((long) 31) * (j10 ^ (j10 >>> 32));
        long j12 = this.f15922b;
        return (int) (j11 + (j12 ^ (j12 >>> 32)));
    }

    @Override // tn.m, tn.g
    public boolean isEmpty() {
        return this.f15921a > this.f15922b;
    }

    public boolean l(long j10) {
        return this.f15921a <= j10 && j10 <= this.f15922b;
    }

    @Override // tn.r
    @os.l
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public Long c() {
        long j10 = this.f15922b;
        if (j10 != Long.MAX_VALUE) {
            return Long.valueOf(j10 + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @os.l
    public Long o() {
        return Long.valueOf(this.f15922b);
    }

    @os.l
    public Long q() {
        return Long.valueOf(this.f15921a);
    }

    @Override // tn.m
    @os.l
    public String toString() {
        return this.f15921a + ".." + this.f15922b;
    }
}
