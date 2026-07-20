package f1;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public final class a6<E> extends t3<E> {
    static final a6<Object> EMPTY;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object[] f4701i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient int f4702e;

    @b1.e
    final transient Object[] elements;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f4703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient int f4704g;

    @b1.e
    final transient Object[] table;

    static {
        Object[] objArr = new Object[0];
        f4701i = objArr;
        EMPTY = new a6<>(objArr, 0, objArr, 0, 0);
    }

    public a6(Object[] elements, int hashCode, Object[] table, int mask, int size) {
        this.elements = elements;
        this.f4702e = hashCode;
        this.table = table;
        this.f4703f = mask;
        this.f4704g = size;
    }

    @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object target) {
        Object[] objArr = this.table;
        if (target == null || objArr.length == 0) {
            return false;
        }
        int iD = z2.d(target);
        while (true) {
            int i10 = iD & this.f4703f;
            Object obj = objArr[i10];
            if (obj == null) {
                return false;
            }
            if (obj.equals(target)) {
                return true;
            }
            iD = i10 + 1;
        }
    }

    @Override // f1.e3
    public int copyIntoArray(Object[] dst, int offset) {
        System.arraycopy(this.elements, 0, dst, offset, this.f4704g);
        return offset + this.f4704g;
    }

    @Override // f1.t3
    public i3<E> createAsList() {
        return i3.asImmutableList(this.elements, this.f4704g);
    }

    @Override // f1.t3, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f4702e;
    }

    @Override // f1.e3
    public Object[] internalArray() {
        return this.elements;
    }

    @Override // f1.e3
    public int internalArrayEnd() {
        return this.f4704g;
    }

    @Override // f1.e3
    public int internalArrayStart() {
        return 0;
    }

    @Override // f1.t3
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // f1.e3
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f4704g;
    }

    @Override // f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
    public x7<E> iterator() {
        return asList().iterator();
    }
}
