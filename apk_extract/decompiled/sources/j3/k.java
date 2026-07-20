package j3;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class k extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient g f6075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient Object[] f6076d;
    public final transient int e;

    public k(g gVar, Object[] objArr, int i8, int i9) {
        this.f6075c = gVar;
        this.f6076d = objArr;
        this.e = i9;
    }

    @Override // j3.a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f6075c.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // j3.h, j3.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzf().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.e;
    }

    @Override // j3.a
    public final int zza(Object[] objArr, int i8) {
        return zzf().zza(objArr, 0);
    }

    @Override // j3.h, j3.a
    /* JADX INFO: renamed from: zzd */
    public final o iterator() {
        return zzf().listIterator(0);
    }

    @Override // j3.h
    public final d zzg() {
        return new j(this);
    }
}
