package i4;

/* JADX INFO: loaded from: classes.dex */
public final class d5 extends s1 {
    final transient Object element;

    public d5(Object obj) {
        obj.getClass();
        this.element = obj;
    }

    @Override // i4.s1, i4.a0
    public h0 asList() {
        return h0.of(this.element);
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.element.equals(obj);
    }

    @Override // i4.a0
    public int copyIntoArray(Object[] objArr, int i8) {
        objArr[i8] = this.element;
        return i8 + 1;
    }

    @Override // i4.s1, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.element.hashCode();
    }

    @Override // i4.a0
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

    @Override // i4.s1, i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public h5 iterator() {
        return new d2(this.element);
    }
}
