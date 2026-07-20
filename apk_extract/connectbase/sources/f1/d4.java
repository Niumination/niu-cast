package f1;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public abstract class d4<E> extends t3<E> {

    public class a extends i3<E> {
        public a() {
        }

        @Override // java.util.List
        public E get(int i10) {
            return (E) d4.this.get(i10);
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return d4.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return d4.this.size();
        }
    }

    @Override // f1.e3
    @b1.c
    public int copyIntoArray(Object[] dst, int offset) {
        return asList().copyIntoArray(dst, offset);
    }

    @Override // f1.t3
    public i3<E> createAsList() {
        return new a();
    }

    public abstract E get(int index);

    @Override // f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
    public x7<E> iterator() {
        return asList().iterator();
    }
}
