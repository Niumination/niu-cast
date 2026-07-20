package k3;

/* JADX INFO: loaded from: classes.dex */
public final class p0 extends e0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f6569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f6570d;
    public final transient int e;

    public p0(Object[] objArr, int i8, int i9) {
        this.f6569c = objArr;
        this.f6570d = i8;
        this.e = i9;
    }

    @Override // java.util.List
    public final Object get(int i8) {
        na.a(i8, this.e);
        Object obj = this.f6569c[i8 + i8 + this.f6570d];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
