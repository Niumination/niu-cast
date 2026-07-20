package i4;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import k3.ia;

/* JADX INFO: loaded from: classes.dex */
public class n extends AbstractCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5649b;

    public /* synthetic */ n(Serializable serializable, int i8) {
        this.f5648a = i8;
        this.f5649b = serializable;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        switch (this.f5648a) {
            case 0:
                ((o) this.f5649b).clear();
                break;
            case 1:
                ((u3) this.f5649b).clear();
                break;
            case 2:
                ((k3.p) this.f5649b).zzs();
                break;
            case 3:
                ((k3.y) this.f5649b).clear();
                break;
            default:
                ((k3.j) this.f5649b).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        switch (this.f5648a) {
            case 1:
                return ((u3) this.f5649b).containsValue(obj);
            case 2:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return ((k3.p) this.f5649b).zzx(entry.getKey(), entry.getValue());
            case 3:
            default:
                return super.contains(obj);
            case 4:
                return ((k3.j) this.f5649b).containsValue(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch (this.f5648a) {
            case 1:
                return ((u3) this.f5649b).isEmpty();
            case 4:
                return ((k3.j) this.f5649b).isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f5648a) {
            case 0:
                return ((o) this.f5649b).valuesIterator();
            case 1:
                return new n2((u3) this.f5649b, 2);
            case 2:
                return ((k3.p) this.f5649b).zzl();
            case 3:
                k3.y yVar = (k3.y) this.f5649b;
                Map mapZzj = yVar.zzj();
                return mapZzj != null ? mapZzj.values().iterator() : new k3.v(yVar, 1);
            default:
                return new k3.j0(((k3.j) this.f5649b).entrySet().iterator());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        switch (this.f5648a) {
            case 2:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return ((k3.p) this.f5649b).zzy(entry.getKey(), entry.getValue());
            case 3:
            default:
                return super.remove(obj);
            case 4:
                try {
                    return super.remove(obj);
                } catch (UnsupportedOperationException unused) {
                    k3.j jVar = (k3.j) this.f5649b;
                    for (Map.Entry entry2 : jVar.entrySet()) {
                        if (ia.a(obj, entry2.getValue())) {
                            jVar.remove(entry2.getKey());
                            return true;
                        }
                    }
                    return false;
                }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        switch (this.f5648a) {
            case 4:
                try {
                    if (collection != null) {
                        return super.removeAll(collection);
                    }
                    throw null;
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    k3.j jVar = (k3.j) this.f5649b;
                    for (Map.Entry entry : jVar.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return jVar.f6501d.zzw().removeAll(hashSet);
                }
            default:
                return super.removeAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        switch (this.f5648a) {
            case 4:
                try {
                    if (collection != null) {
                        return super.retainAll(collection);
                    }
                    throw null;
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    k3.j jVar = (k3.j) this.f5649b;
                    for (Map.Entry entry : jVar.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return jVar.f6501d.zzw().retainAll(hashSet);
                }
            default:
                return super.retainAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        switch (this.f5648a) {
            case 0:
                return ((o) this.f5649b).size();
            case 1:
                return ((u3) this.f5649b).size();
            case 2:
                return ((k3.p) this.f5649b).zzh();
            case 3:
                return ((k3.y) this.f5649b).size();
            default:
                return ((k3.j) this.f5649b).f6500c.size();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        switch (this.f5648a) {
            case 1:
                return u3.access$1800(this).toArray();
            default:
                return super.toArray();
        }
    }

    public n(k3.j jVar) {
        this.f5648a = 4;
        this.f5649b = jVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        switch (this.f5648a) {
            case 1:
                return u3.access$1800(this).toArray(objArr);
            default:
                return super.toArray(objArr);
        }
    }
}
