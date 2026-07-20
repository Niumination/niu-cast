package f1;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public class v5<E> extends b3<E> {
    private final e3<E> delegate;
    private final i3<? extends E> delegateList;

    public v5(e3<E> delegate, i3<? extends E> delegateList) {
        this.delegate = delegate;
        this.delegateList = delegateList;
    }

    @Override // f1.i3, f1.e3
    @b1.c
    public int copyIntoArray(Object[] dst, int offset) {
        return this.delegateList.copyIntoArray(dst, offset);
    }

    @Override // f1.b3
    public e3<E> delegateCollection() {
        return this.delegate;
    }

    public i3<? extends E> delegateList() {
        return this.delegateList;
    }

    @Override // java.util.List
    public E get(int index) {
        return this.delegateList.get(index);
    }

    @Override // f1.e3
    @gm.a
    public Object[] internalArray() {
        return this.delegateList.internalArray();
    }

    @Override // f1.e3
    public int internalArrayEnd() {
        return this.delegateList.internalArrayEnd();
    }

    @Override // f1.e3
    public int internalArrayStart() {
        return this.delegateList.internalArrayStart();
    }

    @Override // f1.i3, java.util.List
    public y7<E> listIterator(int i10) {
        return this.delegateList.listIterator(i10);
    }

    public v5(e3<E> delegate, Object[] array) {
        this(delegate, i3.asImmutableList(array));
    }

    public v5(e3<E> delegate, Object[] array, int size) {
        this(delegate, i3.asImmutableList(array, size));
    }
}
