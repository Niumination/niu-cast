package f1;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
public final class b6<E> extends y3<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient long[] f4708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient int f4709e;

    @b1.e
    final transient c6<E> elementSet;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f4710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long[] f4707g = {0};
    static final y3<Comparable> NATURAL_EMPTY_MULTISET = new b6(l5.natural());

    public b6(Comparator<? super E> comparator) {
        this.elementSet = a4.emptySet(comparator);
        this.f4708d = f4707g;
        this.f4709e = 0;
        this.f4710f = 0;
    }

    @Override // f1.b5
    public int count(@gm.a Object element) {
        int iIndexOf = this.elementSet.indexOf(element);
        if (iIndexOf >= 0) {
            return e(iIndexOf);
        }
        return 0;
    }

    public final int e(int index) {
        long[] jArr = this.f4708d;
        int i10 = this.f4709e;
        return (int) (jArr[(i10 + index) + 1] - jArr[i10 + index]);
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    @Override // f1.p3
    public b5.a<E> getEntry(int index) {
        return c5.k(this.elementSet.asList().get(index), e(index));
    }

    public y3<E> getSubMultiset(int from, int to2) {
        c1.h0.f0(from, to2, this.f4710f);
        if (from == to2) {
            return y3.emptyMultiset(comparator());
        }
        return (from == 0 && to2 == this.f4710f) ? this : new b6(this.elementSet.getSubSet(from, to2), this.f4708d, this.f4709e + from, to2 - from);
    }

    @Override // f1.e3
    public boolean isPartialView() {
        return this.f4709e > 0 || this.f4710f < this.f4708d.length - 1;
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.f4710f - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, f1.b5
    public int size() {
        long[] jArr = this.f4708d;
        int i10 = this.f4709e;
        return o1.l.z(jArr[this.f4710f + i10] - jArr[i10]);
    }

    @Override // f1.y3, f1.r6
    public y3<E> headMultiset(E upperBound, x boundType) {
        c6<E> c6Var = this.elementSet;
        boundType.getClass();
        return getSubMultiset(0, c6Var.headIndex(upperBound, boundType == x.CLOSED));
    }

    @Override // f1.y3, f1.r6
    public y3<E> tailMultiset(E lowerBound, x boundType) {
        c6<E> c6Var = this.elementSet;
        boundType.getClass();
        return getSubMultiset(c6Var.tailIndex(lowerBound, boundType == x.CLOSED), this.f4710f);
    }

    @Override // f1.y3, f1.p3, f1.b5, f1.r6, f1.s6
    public a4<E> elementSet() {
        return this.elementSet;
    }

    public b6(c6<E> elementSet, long[] cumulativeCounts, int offset, int length) {
        this.elementSet = elementSet;
        this.f4708d = cumulativeCounts;
        this.f4709e = offset;
        this.f4710f = length;
    }
}
