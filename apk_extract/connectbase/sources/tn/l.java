package tn;

import lm.f1;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends j implements g<Integer>, r<Integer> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f15918e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final l f15919f = new l(1, 0, 1);

    public static final class a {
        public a() {
        }

        @os.l
        public final l a() {
            return l.f15919f;
        }

        public a(kn.w wVar) {
        }
    }

    public l(int i10, int i11) {
        super(i10, i11, 1);
    }

    @f1(version = "1.9")
    @lm.k(message = "Can throw an exception when it's impossible to represent the value with Int type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @p2(markerClass = {lm.r.class})
    public static /* synthetic */ void n() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tn.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return l(((Number) comparable).intValue());
    }

    @Override // tn.j
    public boolean equals(@os.m Object obj) {
        if (obj instanceof l) {
            if (!isEmpty() || !((l) obj).isEmpty()) {
                l lVar = (l) obj;
                if (this.f15911a != lVar.f15911a || this.f15912b != lVar.f15912b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // tn.g
    public Comparable getEndInclusive() {
        return Integer.valueOf(this.f15912b);
    }

    @Override // tn.g
    public Comparable getStart() {
        return Integer.valueOf(this.f15911a);
    }

    @Override // tn.j
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return this.f15912b + (this.f15911a * 31);
    }

    @Override // tn.j, tn.g
    public boolean isEmpty() {
        return this.f15911a > this.f15912b;
    }

    public boolean l(int i10) {
        return this.f15911a <= i10 && i10 <= this.f15912b;
    }

    @Override // tn.r
    @os.l
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public Integer c() {
        int i10 = this.f15912b;
        if (i10 != Integer.MAX_VALUE) {
            return Integer.valueOf(i10 + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @os.l
    public Integer o() {
        return Integer.valueOf(this.f15912b);
    }

    @os.l
    public Integer q() {
        return Integer.valueOf(this.f15911a);
    }

    @Override // tn.j
    @os.l
    public String toString() {
        return this.f15911a + ".." + this.f15912b;
    }
}
