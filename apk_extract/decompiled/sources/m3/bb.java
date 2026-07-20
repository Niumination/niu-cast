package m3;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class bb extends ya {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient xa f7639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient Object[] f7640d;
    public final transient int e;

    public bb(xa xaVar, Object[] objArr, int i8, int i9) {
        this.f7639c = xaVar;
        this.f7640d = objArr;
        this.e = i9;
    }

    @Override // m3.n9, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f7639c.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // m3.ya, m3.n9, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return zzf().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.e;
    }

    @Override // m3.n9
    public final int zza(Object[] objArr, int i8) {
        return zzf().zza(objArr, 0);
    }

    @Override // m3.ya, m3.n9
    /* JADX INFO: renamed from: zzd */
    public final a iterator() {
        return zzf().listIterator(0);
    }

    @Override // m3.ya
    public final va zzg() {
        return new ab(this);
    }
}
