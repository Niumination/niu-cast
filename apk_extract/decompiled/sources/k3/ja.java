package k3;

/* JADX INFO: loaded from: classes.dex */
public enum ja implements v0 {
    TYPE_UNKNOWN(0),
    TYPE_THIN(1),
    TYPE_THICK(2),
    TYPE_GMV(3);

    private final int zzf;

    ja(int i8) {
        this.zzf = i8;
    }

    @Override // k3.v0
    public final int zza() {
        return this.zzf;
    }
}
