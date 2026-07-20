package k3;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Collection f6634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient Set f6635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient Map f6636c;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            return zzv().equals(((r) obj).zzv());
        }
        return false;
    }

    public final int hashCode() {
        return zzv().hashCode();
    }

    public final String toString() {
        return zzv().toString();
    }

    public abstract Collection zzi();

    public abstract Map zzo();

    public abstract Set zzp();

    public final Collection zzu() {
        Collection collection = this.f6634a;
        if (collection != null) {
            return collection;
        }
        Collection collectionZzi = zzi();
        this.f6634a = collectionZzi;
        return collectionZzi;
    }

    public final Map zzv() {
        Map map = this.f6636c;
        if (map != null) {
            return map;
        }
        Map mapZzo = zzo();
        this.f6636c = mapZzo;
        return mapZzo;
    }

    public final Set zzw() {
        Set set = this.f6635b;
        if (set != null) {
            return set;
        }
        Set setZzp = zzp();
        this.f6635b = setZzp;
        return setZzp;
    }

    public final boolean zzx(Object obj, Object obj2) {
        Collection collectionA = ((j) zzv()).get(obj);
        return collectionA != null && collectionA.contains(obj2);
    }

    public final boolean zzy(Object obj, Object obj2) {
        Collection collectionA = ((j) zzv()).get(obj);
        return collectionA != null && collectionA.remove(obj2);
    }
}
