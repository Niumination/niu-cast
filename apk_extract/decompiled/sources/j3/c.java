package j3;

import k3.w9;

/* JADX INFO: loaded from: classes.dex */
public final class c extends d {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ d zzc;

    public c(d dVar, int i8, int i9) {
        this.zzc = dVar;
        this.zza = i8;
        this.zzb = i9;
    }

    @Override // java.util.List
    public final Object get(int i8) {
        w9.a(i8, this.zzb);
        return this.zzc.get(i8 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // j3.a
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // j3.a
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // j3.a
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // j3.d, java.util.List
    /* JADX INFO: renamed from: zzf */
    public final d subList(int i8, int i9) {
        w9.c(i8, i9, this.zzb);
        d dVar = this.zzc;
        int i10 = this.zza;
        return dVar.subList(i8 + i10, i9 + i10);
    }
}
