package f1;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
public final class u0<E> extends a4<E> {
    private final a4<E> forward;

    public u0(a4<E> forward) {
        super(l5.from(forward.comparator()).reverse());
        this.forward = forward;
    }

    @Override // f1.a4, java.util.NavigableSet
    @gm.a
    public E ceiling(E element) {
        return this.forward.floor(element);
    }

    @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object object) {
        return this.forward.contains(object);
    }

    @Override // f1.a4
    @b1.c("NavigableSet")
    public a4<E> createDescendingSet() {
        throw new AssertionError("should never be called");
    }

    @Override // f1.a4, java.util.NavigableSet
    @gm.a
    public E floor(E element) {
        return this.forward.ceiling(element);
    }

    @Override // f1.a4
    public a4<E> headSetImpl(E toElement, boolean inclusive) {
        return this.forward.tailSet((Object) toElement, inclusive).descendingSet();
    }

    @Override // f1.a4, java.util.NavigableSet
    @gm.a
    public E higher(E element) {
        return this.forward.lower(element);
    }

    @Override // f1.a4
    public int indexOf(@gm.a Object target) {
        int iIndexOf = this.forward.indexOf(target);
        return iIndexOf == -1 ? iIndexOf : (size() - 1) - iIndexOf;
    }

    @Override // f1.e3
    public boolean isPartialView() {
        return this.forward.isPartialView();
    }

    @Override // f1.a4, java.util.NavigableSet
    @gm.a
    public E lower(E element) {
        return this.forward.higher(element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.forward.size();
    }

    @Override // f1.a4
    public a4<E> subSetImpl(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return this.forward.subSet((Object) toElement, toInclusive, (Object) fromElement, fromInclusive).descendingSet();
    }

    @Override // f1.a4
    public a4<E> tailSetImpl(E fromElement, boolean inclusive) {
        return this.forward.headSet((Object) fromElement, inclusive).descendingSet();
    }

    @Override // f1.a4, java.util.NavigableSet
    @b1.c("NavigableSet")
    public x7<E> descendingIterator() {
        return this.forward.iterator();
    }

    @Override // f1.a4, java.util.NavigableSet
    @b1.c("NavigableSet")
    public a4<E> descendingSet() {
        return this.forward;
    }

    @Override // f1.a4, f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
    public x7<E> iterator() {
        return this.forward.descendingIterator();
    }
}
