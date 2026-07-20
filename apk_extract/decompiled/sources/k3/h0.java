package k3;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class h0 extends z implements Set {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient e0 f6465b;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this || this == obj) {
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
        return sa.a(this);
    }

    @Override // k3.z, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    /* JADX INFO: renamed from: zzd */
    public abstract r0 iterator();

    public final e0 zzf() {
        e0 e0Var = this.f6465b;
        if (e0Var != null) {
            return e0Var;
        }
        e0 e0VarZzg = zzg();
        this.f6465b = e0VarZzg;
        return e0VarZzg;
    }

    public e0 zzg() {
        Object[] array = toArray();
        c0 c0Var = e0.f6415b;
        return e0.zzg(array, array.length);
    }
}
