package i4;

import k3.f9;

/* JADX INFO: loaded from: classes.dex */
public final class z4 extends s1 {
    static final z4 EMPTY;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object[] f5715h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f5716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f5717d;
    public final transient int e;
    final transient Object[] elements;
    final transient Object[] table;

    static {
        Object[] objArr = new Object[0];
        f5715h = objArr;
        EMPTY = new z4(objArr, 0, objArr, 0, 0);
    }

    public z4(Object[] objArr, int i8, Object[] objArr2, int i9, int i10) {
        this.elements = objArr;
        this.f5716c = i8;
        this.table = objArr2;
        this.f5717d = i9;
        this.e = i10;
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        Object[] objArr = this.table;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iB = f9.b(obj);
        while (true) {
            int i8 = iB & this.f5717d;
            Object obj2 = objArr[i8];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iB = i8 + 1;
        }
    }

    @Override // i4.a0
    public int copyIntoArray(Object[] objArr, int i8) {
        Object[] objArr2 = this.elements;
        int i9 = this.e;
        System.arraycopy(objArr2, 0, objArr, i8, i9);
        return i8 + i9;
    }

    @Override // i4.s1
    public h0 createAsList() {
        return h0.asImmutableList(this.elements, this.e);
    }

    @Override // i4.s1, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f5716c;
    }

    @Override // i4.a0
    public Object[] internalArray() {
        return this.elements;
    }

    @Override // i4.a0
    public int internalArrayEnd() {
        return this.e;
    }

    @Override // i4.a0
    public int internalArrayStart() {
        return 0;
    }

    @Override // i4.s1
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.e;
    }

    @Override // i4.s1, i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public h5 iterator() {
        return asList().iterator();
    }
}
