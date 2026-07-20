package m3;

import java.util.AbstractMap;
import k3.gb;

/* JADX INFO: loaded from: classes.dex */
public final class ab extends va {
    final /* synthetic */ bb zza;

    public ab(bb bbVar) {
        this.zza = bbVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i8) {
        gb.a(i8, this.zza.e);
        bb bbVar = this.zza;
        int i9 = i8 + i8;
        Object obj = bbVar.f7640d[i9];
        obj.getClass();
        Object obj2 = bbVar.f7640d[i9 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.e;
    }
}
