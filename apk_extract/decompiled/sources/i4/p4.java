package i4;

import java.util.Objects;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class p4 extends h0 {
    static final h0 EMPTY = new p4(new Object[0], 0);
    final transient Object[] array;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f5675c;

    public p4(Object[] objArr, int i8) {
        this.array = objArr;
        this.f5675c = i8;
    }

    @Override // i4.h0, i4.a0
    public int copyIntoArray(Object[] objArr, int i8) {
        Object[] objArr2 = this.array;
        int i9 = this.f5675c;
        System.arraycopy(objArr2, 0, objArr, i8, i9);
        return i8 + i9;
    }

    @Override // java.util.List
    public Object get(int i8) {
        v8.h(i8, this.f5675c);
        Object obj = this.array[i8];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // i4.a0
    public Object[] internalArray() {
        return this.array;
    }

    @Override // i4.a0
    public int internalArrayEnd() {
        return this.f5675c;
    }

    @Override // i4.a0
    public int internalArrayStart() {
        return 0;
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f5675c;
    }
}
