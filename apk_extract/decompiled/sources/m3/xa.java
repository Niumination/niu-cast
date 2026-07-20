package m3;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class xa implements Map, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient ya f7894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient ya f7895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient n9 f7896c;

    public static xa zzc(Object obj, Object obj2) {
        return eb.zzg(1, new Object[]{"optional-module-barcode", "com.google.android.gms.vision.barcode"}, null);
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        Iterator it = entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        ya yaVar = this.f7895b;
        if (yaVar != null) {
            return yaVar;
        }
        ya yaVarZze = zze();
        this.f7895b = yaVarZze;
        return yaVarZze;
    }

    @Override // java.util.Map
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size < 0) {
            throw new IllegalArgumentException(a1.a.o(size, "size cannot be negative but was: "));
        }
        StringBuilder sb2 = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb2.append('{');
        boolean z2 = true;
        for (Map.Entry entry : entrySet()) {
            if (!z2) {
                sb2.append(", ");
            }
            sb2.append(entry.getKey());
            sb2.append('=');
            sb2.append(entry.getValue());
            z2 = false;
        }
        sb2.append('}');
        return sb2.toString();
    }

    public abstract n9 zza();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final n9 values() {
        n9 n9Var = this.f7896c;
        if (n9Var != null) {
            return n9Var;
        }
        n9 n9VarZza = zza();
        this.f7896c = n9VarZza;
        return n9VarZza;
    }

    public abstract ya zzd();

    public abstract ya zze();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final ya entrySet() {
        ya yaVar = this.f7894a;
        if (yaVar != null) {
            return yaVar;
        }
        ya yaVarZzd = zzd();
        this.f7894a = yaVarZzd;
        return yaVarZzd;
    }
}
