package j3;

import k3.w9;

/* JADX INFO: loaded from: classes.dex */
public final class m extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f6079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f6080d;
    public final transient int e;

    public m(Object[] objArr, int i8, int i9) {
        this.f6079c = objArr;
        this.f6080d = i8;
        this.e = i9;
    }

    @Override // java.util.List
    public final Object get(int i8) {
        w9.a(i8, this.e);
        Object obj = this.f6079c[i8 + i8 + this.f6080d];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
