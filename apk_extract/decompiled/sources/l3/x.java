package l3;

/* JADX INFO: loaded from: classes.dex */
public final class x extends a0 {
    private final int zzc;
    private final int zzd;

    public x(byte[] bArr, int i8, int i9) {
        super(bArr);
        b0.zzo(i8, i8 + i9, bArr.length);
        this.zzc = i8;
        this.zzd = i9;
    }

    @Override // l3.a0, l3.b0
    public final byte zza(int i8) {
        b0.zzv(i8, this.zzd);
        return this.zza[this.zzc + i8];
    }

    @Override // l3.a0, l3.b0
    public final byte zzb(int i8) {
        return this.zza[this.zzc + i8];
    }

    @Override // l3.a0
    public final int zzc() {
        return this.zzc;
    }

    @Override // l3.a0, l3.b0
    public final int zzd() {
        return this.zzd;
    }

    @Override // l3.a0, l3.b0
    public final void zze(byte[] bArr, int i8, int i9, int i10) {
        System.arraycopy(this.zza, this.zzc + i8, bArr, i9, i10);
    }
}
