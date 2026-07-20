package f1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public class x5<E> extends i3<E> {
    static final i3<Object> EMPTY = new x5(new Object[0], 0);

    @b1.e
    final transient Object[] array;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f5565c;

    public x5(Object[] array, int size) {
        this.array = array;
        this.f5565c = size;
    }

    @Override // f1.i3, f1.e3
    public int copyIntoArray(Object[] dst, int dstOff) {
        System.arraycopy(this.array, 0, dst, dstOff, this.f5565c);
        return dstOff + this.f5565c;
    }

    @Override // java.util.List
    public E get(int i10) {
        c1.h0.C(i10, this.f5565c);
        E e10 = (E) this.array[i10];
        Objects.requireNonNull(e10);
        return e10;
    }

    @Override // f1.e3
    public Object[] internalArray() {
        return this.array;
    }

    @Override // f1.e3
    public int internalArrayEnd() {
        return this.f5565c;
    }

    @Override // f1.e3
    public int internalArrayStart() {
        return 0;
    }

    @Override // f1.e3
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f5565c;
    }
}
