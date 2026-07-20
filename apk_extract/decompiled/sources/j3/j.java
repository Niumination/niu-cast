package j3;

import java.util.AbstractMap;
import k3.w9;

/* JADX INFO: loaded from: classes.dex */
public final class j extends d {
    final /* synthetic */ k zza;

    public j(k kVar) {
        this.zza = kVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i8) {
        w9.a(i8, this.zza.e);
        k kVar = this.zza;
        int i9 = i8 + i8;
        Object obj = kVar.f6076d[i9];
        obj.getClass();
        Object obj2 = kVar.f6076d[i9 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.e;
    }
}
