package f1;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
public final class t0<E> extends y3<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient y3<E> f5289d;

    public t0(y3<E> forward) {
        this.f5289d = forward;
    }

    @Override // f1.b5
    public int count(@gm.a Object element) {
        return this.f5289d.count(element);
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> firstEntry() {
        return this.f5289d.lastEntry();
    }

    @Override // f1.p3
    public b5.a<E> getEntry(int index) {
        return this.f5289d.entrySet().asList().reverse().get(index);
    }

    @Override // f1.e3
    public boolean isPartialView() {
        return this.f5289d.isPartialView();
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> lastEntry() {
        return this.f5289d.firstEntry();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, f1.b5
    public int size() {
        return this.f5289d.size();
    }

    @Override // f1.y3, f1.r6
    public y3<E> descendingMultiset() {
        return this.f5289d;
    }

    @Override // f1.y3, f1.r6
    public y3<E> headMultiset(E upperBound, x boundType) {
        return this.f5289d.tailMultiset((Object) upperBound, boundType).descendingMultiset();
    }

    @Override // f1.y3, f1.r6
    public y3<E> tailMultiset(E lowerBound, x boundType) {
        return this.f5289d.headMultiset((Object) lowerBound, boundType).descendingMultiset();
    }

    @Override // f1.y3, f1.p3, f1.b5, f1.r6, f1.s6
    public a4<E> elementSet() {
        return this.f5289d.elementSet().descendingSet();
    }
}
