package k3;

import java.util.AbstractMap;

/* JADX INFO: loaded from: classes.dex */
public final class m0 extends e0 {
    final /* synthetic */ n0 zza;

    public m0(n0 n0Var) {
        this.zza = n0Var;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i8) {
        na.a(i8, this.zza.e);
        n0 n0Var = this.zza;
        int i9 = i8 + i8;
        Object obj = n0Var.f6546d[i9];
        obj.getClass();
        Object obj2 = n0Var.f6546d[i9 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.e;
    }
}
