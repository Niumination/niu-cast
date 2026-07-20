package i4;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import k3.e9;
import k3.u8;

/* JADX INFO: loaded from: classes.dex */
public final class l extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractMap f5629b;

    public /* synthetic */ l(AbstractMap abstractMap, int i8) {
        this.f5628a = i8;
        this.f5629b = abstractMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        switch (this.f5628a) {
            case 2:
                Map.Entry entry = (Map.Entry) obj;
                if (contains(entry)) {
                    return false;
                }
                ((l3.h2) this.f5629b).put((Comparable) entry.getKey(), entry.getValue());
                return true;
            default:
                return super.add(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f5628a) {
            case 0:
                ((o) this.f5629b).clear();
                break;
            case 1:
                ((o) this.f5629b).clear();
                break;
            default:
                ((l3.h2) this.f5629b).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f5628a) {
            case 0:
                o oVar = (o) this.f5629b;
                Map<Object, Object> mapDelegateOrNull = oVar.delegateOrNull();
                if (mapDelegateOrNull != null) {
                    return mapDelegateOrNull.entrySet().contains(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    int iB = oVar.b(entry.getKey());
                    if (iB != -1 && u8.a(o.access$600(oVar, iB), entry.getValue())) {
                        return true;
                    }
                }
                return false;
            case 1:
                return ((o) this.f5629b).containsKey(obj);
            default:
                Map.Entry entry2 = (Map.Entry) obj;
                Object obj2 = ((l3.h2) this.f5629b).get(entry2.getKey());
                Object value = entry2.getValue();
                boolean z2 = true;
                if (obj2 != value) {
                    if (obj2 == null) {
                        z2 = false;
                    } else if (!obj2.equals(value)) {
                        return false;
                    }
                }
                return z2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f5628a) {
            case 0:
                return ((o) this.f5629b).entrySetIterator();
            case 1:
                return ((o) this.f5629b).keySetIterator();
            default:
                return new l3.m2((l3.h2) this.f5629b);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f5628a) {
            case 0:
                o oVar = (o) this.f5629b;
                Map<Object, Object> mapDelegateOrNull = oVar.delegateOrNull();
                if (mapDelegateOrNull != null) {
                    return mapDelegateOrNull.entrySet().remove(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (!oVar.needsAllocArrays()) {
                        int iA = oVar.a();
                        int iD = e9.d(entry.getKey(), entry.getValue(), iA, o.access$800(oVar), oVar.d(), oVar.e(), oVar.f());
                        if (iD != -1) {
                            oVar.moveLastEntry(iD, iA);
                            o.access$1210(oVar);
                            oVar.incrementModCount();
                            return true;
                        }
                    }
                }
                return false;
            case 1:
                o oVar2 = (o) this.f5629b;
                Map<Object, Object> mapDelegateOrNull2 = oVar2.delegateOrNull();
                if (mapDelegateOrNull2 != null) {
                    return mapDelegateOrNull2.keySet().remove(obj);
                }
                return oVar2.c(obj) != o.f5659i;
            default:
                Map.Entry entry2 = (Map.Entry) obj;
                if (!contains(entry2)) {
                    return false;
                }
                ((l3.h2) this.f5629b).remove(entry2.getKey());
                return true;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f5628a) {
            case 0:
                return ((o) this.f5629b).size();
            case 1:
                return ((o) this.f5629b).size();
            default:
                return ((l3.h2) this.f5629b).size();
        }
    }
}
