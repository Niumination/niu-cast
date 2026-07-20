package m3;

import k3.gb;

/* JADX INFO: loaded from: classes.dex */
public final class db extends va {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f7661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f7662d;
    public final transient int e;

    public db(Object[] objArr, int i8, int i9) {
        this.f7661c = objArr;
        this.f7662d = i8;
        this.e = i9;
    }

    @Override // java.util.List
    public final Object get(int i8) {
        gb.a(i8, this.e);
        Object obj = this.f7661c[i8 + i8 + this.f7662d];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
