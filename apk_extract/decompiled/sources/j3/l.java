package j3;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class l extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient g f6077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient d f6078d;

    public l(g gVar, d dVar) {
        this.f6077c = gVar;
        this.f6078d = dVar;
    }

    @Override // j3.a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f6077c.get(obj) != null;
    }

    @Override // j3.h, j3.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.f6078d.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f6077c.size();
    }

    @Override // j3.a
    public final int zza(Object[] objArr, int i8) {
        return this.f6078d.zza(objArr, 0);
    }

    @Override // j3.h, j3.a
    /* JADX INFO: renamed from: zzd */
    public final o iterator() {
        return this.f6078d.listIterator(0);
    }
}
