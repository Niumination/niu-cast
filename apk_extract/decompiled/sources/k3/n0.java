package k3;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class n0 extends h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient g0 f6545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient Object[] f6546d;
    public final transient int e;

    public n0(g0 g0Var, Object[] objArr, int i8, int i9) {
        this.f6545c = g0Var;
        this.f6546d = objArr;
        this.e = i9;
    }

    @Override // k3.z, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f6545c.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // k3.h0, k3.z, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
        return zzf().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.e;
    }

    @Override // k3.z
    public final int zza(Object[] objArr, int i8) {
        return zzf().zza(objArr, i8);
    }

    @Override // k3.h0, k3.z
    /* JADX INFO: renamed from: zzd */
    public final r0 iterator() {
        return zzf().listIterator(0);
    }

    @Override // k3.h0
    public final e0 zzg() {
        return new m0(this);
    }
}
