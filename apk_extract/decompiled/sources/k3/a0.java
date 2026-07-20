package k3;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class a0 extends q implements Serializable {
    final Object zza;
    final Object zzb;

    public a0(Object obj, Object obj2) {
        this.zza = obj;
        this.zzb = obj2;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zza;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.zzb;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
