package j3;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends a implements Set {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient d f6073b;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    @Override // j3.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzd */
    public abstract o iterator();

    public final d zzf() {
        d dVar = this.f6073b;
        if (dVar != null) {
            return dVar;
        }
        d dVarZzg = zzg();
        this.f6073b = dVarZzg;
        return dVarZzg;
    }

    public d zzg() {
        Object[] array = toArray();
        b bVar = d.f6063b;
        return d.zzg(array, array.length);
    }
}
