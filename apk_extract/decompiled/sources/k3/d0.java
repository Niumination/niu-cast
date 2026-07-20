package k3;

/* JADX INFO: loaded from: classes.dex */
public final class d0 extends e0 {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ e0 zzc;

    public d0(e0 e0Var, int i8, int i9) {
        this.zzc = e0Var;
        this.zza = i8;
        this.zzb = i9;
    }

    @Override // java.util.List
    public final Object get(int i8) {
        na.a(i8, this.zzb);
        return this.zzc.get(i8 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // k3.z
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // k3.z
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // k3.z
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // k3.e0, java.util.List
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final e0 subList(int i8, int i9) {
        na.b(i8, i9, this.zzb);
        e0 e0Var = this.zzc;
        int i10 = this.zza;
        return e0Var.subList(i8 + i10, i9 + i10);
    }
}
