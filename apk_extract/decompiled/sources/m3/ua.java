package m3;

import k3.gb;

/* JADX INFO: loaded from: classes.dex */
public final class ua extends va {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ va zzc;

    public ua(va vaVar, int i8, int i9) {
        this.zzc = vaVar;
        this.zza = i8;
        this.zzb = i9;
    }

    @Override // java.util.List
    public final Object get(int i8) {
        gb.a(i8, this.zzb);
        return this.zzc.get(i8 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // m3.n9
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // m3.n9
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // m3.n9
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // m3.va, java.util.List
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final va subList(int i8, int i9) {
        gb.b(i8, i9, this.zzb);
        va vaVar = this.zzc;
        int i10 = this.zza;
        return vaVar.subList(i8 + i10, i9 + i10);
    }
}
