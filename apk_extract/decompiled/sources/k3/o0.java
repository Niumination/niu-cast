package k3;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class o0 extends h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient g0 f6555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient e0 f6556d;

    public o0(g0 g0Var, e0 e0Var) {
        this.f6555c = g0Var;
        this.f6556d = e0Var;
    }

    @Override // k3.z, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.f6555c.get(obj) != null;
    }

    @Override // k3.h0, k3.z, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
        return this.f6556d.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f6555c.size();
    }

    @Override // k3.z
    public final int zza(Object[] objArr, int i8) {
        return this.f6556d.zza(objArr, i8);
    }

    @Override // k3.h0, k3.z
    /* JADX INFO: renamed from: zzd */
    public final r0 iterator() {
        return this.f6556d.listIterator(0);
    }
}
