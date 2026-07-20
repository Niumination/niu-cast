package k3;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class w extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f6689b;

    public /* synthetic */ w(y yVar, int i8) {
        this.f6688a = i8;
        this.f6689b = yVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f6688a) {
            case 0:
                this.f6689b.clear();
                break;
            default:
                this.f6689b.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f6688a) {
            case 0:
                y yVar = this.f6689b;
                Map mapZzj = yVar.zzj();
                if (mapZzj != null) {
                    return mapZzj.entrySet().contains(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    int iB = yVar.b(entry.getKey());
                    if (iB != -1) {
                        Object[] objArr = yVar.zzc;
                        objArr.getClass();
                        if (ia.a(objArr[iB], entry.getValue())) {
                            return true;
                        }
                    }
                }
                return false;
            default:
                return this.f6689b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f6688a) {
            case 0:
                y yVar = this.f6689b;
                Map mapZzj = yVar.zzj();
                return mapZzj != null ? mapZzj.entrySet().iterator() : new v(yVar, 2);
            default:
                y yVar2 = this.f6689b;
                Map mapZzj2 = yVar2.zzj();
                return mapZzj2 != null ? mapZzj2.keySet().iterator() : new v(yVar2, 0);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f6688a) {
            case 0:
                y yVar = this.f6689b;
                Map mapZzj = yVar.zzj();
                if (mapZzj != null) {
                    return mapZzj.entrySet().remove(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (!yVar.zzo()) {
                        int iA = yVar.a();
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        Object objZzh = y.zzh(yVar);
                        int[] iArr = yVar.zza;
                        iArr.getClass();
                        Object[] objArr = yVar.zzb;
                        objArr.getClass();
                        Object[] objArr2 = yVar.zzc;
                        objArr2.getClass();
                        int iA2 = pa.a(key, value, iA, objZzh, iArr, objArr, objArr2);
                        if (iA2 != -1) {
                            yVar.zzn(iA2, iA);
                            yVar.f6714c--;
                            yVar.zzl();
                            return true;
                        }
                    }
                }
                return false;
            default:
                y yVar2 = this.f6689b;
                Map mapZzj2 = yVar2.zzj();
                if (mapZzj2 != null) {
                    return mapZzj2.keySet().remove(obj);
                }
                return yVar2.d(obj) != y.f6711i;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f6688a) {
            case 0:
                break;
        }
        return this.f6689b.size();
    }
}
