package il;

import java.util.List;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> extends nm.f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final List<T> f8238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8240c;

    public a(@l List<T> list, int i10, int i11) {
        l0.p(list, n1.d.a.f11176d);
        this.f8238a = list;
        this.f8239b = i10;
        this.f8240c = i11;
    }

    @Override // nm.f, java.util.AbstractList, java.util.List
    public void add(int i10, T t10) {
        throw new IllegalStateException("Unsupported append in ConcurrentList slice");
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i10) {
        return this.f8238a.get(this.f8239b + i10);
    }

    @Override // nm.f
    public int getSize() {
        return Math.min(this.f8238a.size(), this.f8240c - this.f8239b);
    }

    @Override // nm.f
    public T removeAt(int i10) {
        throw new IllegalStateException("Unsupported remove in ConcurrentList slice");
    }

    @Override // nm.f, java.util.AbstractList, java.util.List
    public T set(int i10, T t10) {
        return this.f8238a.set(this.f8239b + i10, t10);
    }
}
