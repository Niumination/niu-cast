package k3;

/* JADX INFO: loaded from: classes.dex */
public final class l0 extends e0 {
    static final e0 zza = new l0(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f6519c;
    final transient Object[] zzb;

    public l0(Object[] objArr, int i8) {
        this.zzb = objArr;
        this.f6519c = i8;
    }

    @Override // java.util.List
    public final Object get(int i8) {
        na.a(i8, this.f6519c);
        Object obj = this.zzb[i8];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6519c;
    }

    @Override // k3.e0, k3.z
    public final int zza(Object[] objArr, int i8) {
        Object[] objArr2 = this.zzb;
        int i9 = this.f6519c;
        System.arraycopy(objArr2, 0, objArr, i8, i9);
        return i8 + i9;
    }

    @Override // k3.z
    public final int zzb() {
        return this.f6519c;
    }

    @Override // k3.z
    public final int zzc() {
        return 0;
    }

    @Override // k3.z
    public final Object[] zze() {
        return this.zzb;
    }
}
