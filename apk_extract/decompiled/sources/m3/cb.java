package m3;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class cb extends ya {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient xa f7648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient va f7649d;

    public cb(xa xaVar, va vaVar) {
        this.f7648c = xaVar;
        this.f7649d = vaVar;
    }

    @Override // m3.n9, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f7648c.get(obj) != null;
    }

    @Override // m3.ya, m3.n9, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.f7649d.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f7648c.size();
    }

    @Override // m3.n9
    public final int zza(Object[] objArr, int i8) {
        return this.f7649d.zza(objArr, 0);
    }

    @Override // m3.ya, m3.n9
    /* JADX INFO: renamed from: zzd */
    public final a iterator() {
        return this.f7649d.listIterator(0);
    }
}
