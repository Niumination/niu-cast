package k3;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class j extends AbstractMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient h f6498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient i4.n f6499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Map f6500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p f6501d;

    public j(p pVar, Map map) {
        this.f6501d = pVar;
        this.f6500c = map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Collection get(Object obj) {
        Object obj2;
        Map map = this.f6500c;
        map.getClass();
        try {
            obj2 = map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection == null) {
            return null;
        }
        return this.f6501d.zzd(obj, collection);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        p pVar = this.f6501d;
        if (this.f6500c == pVar.f6568d) {
            pVar.zzs();
            return;
        }
        i iVar = new i(this);
        while (iVar.hasNext()) {
            iVar.next();
            iVar.remove();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map map = this.f6500c;
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        h hVar = this.f6498a;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(this);
        this.f6498a = hVar2;
        return hVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        return this == obj || this.f6500c.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.f6500c.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.f6501d.zzw();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.f6500c.remove(obj);
        if (collection == null) {
            return null;
        }
        p pVar = this.f6501d;
        Collection collectionZza = pVar.zza();
        collectionZza.addAll(collection);
        pVar.e -= collection.size();
        collection.clear();
        return collectionZza;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f6500c.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.f6500c.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        i4.n nVar = this.f6499b;
        if (nVar != null) {
            return nVar;
        }
        i4.n nVar2 = new i4.n(this);
        this.f6499b = nVar2;
        return nVar2;
    }
}
