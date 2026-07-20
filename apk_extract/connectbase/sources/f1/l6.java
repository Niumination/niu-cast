package f1;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public final class l6<E> extends t3<E> {
    final transient E element;

    public l6(E element) {
        element.getClass();
        this.element = element;
    }

    @Override // f1.t3, f1.e3
    public i3<E> asList() {
        return i3.of((Object) this.element);
    }

    @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object target) {
        return this.element.equals(target);
    }

    @Override // f1.e3
    public int copyIntoArray(Object[] dst, int offset) {
        dst[offset] = this.element;
        return offset + 1;
    }

    @Override // f1.t3, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.element.hashCode();
    }

    @Override // f1.e3
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return "[" + this.element.toString() + ']';
    }

    @Override // f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
    public x7<E> iterator() {
        return new h4.k(this.element);
    }
}
