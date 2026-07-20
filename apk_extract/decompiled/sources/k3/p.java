package k3;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class p extends r implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient Map f6568d;
    public transient int e;

    public p(Map map) {
        if (!map.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.f6568d = map;
    }

    public static /* bridge */ /* synthetic */ void zzr(p pVar, Object obj) {
        Object objRemove;
        try {
            objRemove = pVar.f6568d.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            objRemove = null;
        }
        Collection collection = (Collection) objRemove;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            pVar.e -= size;
        }
    }

    public abstract Collection zza();

    public Collection zzb() {
        throw null;
    }

    public Collection zzc(Collection collection) {
        throw null;
    }

    public Collection zzd(Object obj, Collection collection) {
        throw null;
    }

    public final int zzh() {
        return this.e;
    }

    @Override // k3.r
    public final Collection zzi() {
        return new i4.n(this, 2);
    }

    public final Collection zzj(Object obj) {
        Collection collectionZza = (Collection) this.f6568d.get(obj);
        if (collectionZza == null) {
            collectionZza = zza();
        }
        return zzd(obj, collectionZza);
    }

    public final Collection zzk(Object obj) {
        Collection collection = (Collection) this.f6568d.remove(obj);
        if (collection == null) {
            return zzb();
        }
        Collection collectionZza = zza();
        collectionZza.addAll(collection);
        this.e -= collection.size();
        collection.clear();
        return zzc(collectionZza);
    }

    public final Iterator zzl() {
        return new hf.g(this);
    }

    public final List zzm(Object obj, List list, m mVar) {
        return list instanceof RandomAccess ? new l(this, obj, list, mVar) : new o(this, obj, list, mVar);
    }

    @Override // k3.r
    public final Map zzo() {
        return new j(this, this.f6568d);
    }

    @Override // k3.r
    public final Set zzp() {
        return new k(this, this.f6568d);
    }

    public final void zzs() {
        Map map = this.f6568d;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        map.clear();
        this.e = 0;
    }

    public final boolean zzt(Object obj, Object obj2) {
        Map map = this.f6568d;
        Collection collection = (Collection) map.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.e++;
            return true;
        }
        Collection collectionZza = zza();
        if (!collectionZza.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.e++;
        map.put(obj, collectionZza);
        return true;
    }
}
