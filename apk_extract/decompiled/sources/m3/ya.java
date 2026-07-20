package m3;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class ya extends n9 implements Set {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient va f7902b;

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

    @Override // m3.n9, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: zzd */
    public abstract a iterator();

    public final va zzf() {
        va vaVar = this.f7902b;
        if (vaVar != null) {
            return vaVar;
        }
        va vaVarZzg = zzg();
        this.f7902b = vaVarZzg;
        return vaVarZzg;
    }

    public va zzg() {
        return va.zzg(toArray());
    }
}
