package j3;

import k3.w9;

/* JADX INFO: loaded from: classes.dex */
public final class i extends d {
    static final d zza = new i(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f6074c;
    final transient Object[] zzb;

    public i(Object[] objArr, int i8) {
        this.zzb = objArr;
        this.f6074c = i8;
    }

    @Override // java.util.List
    public final Object get(int i8) {
        w9.a(i8, this.f6074c);
        Object obj = this.zzb[i8];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6074c;
    }

    @Override // j3.d, j3.a
    public final int zza(Object[] objArr, int i8) {
        Object[] objArr2 = this.zzb;
        int i9 = this.f6074c;
        System.arraycopy(objArr2, 0, objArr, 0, i9);
        return i9;
    }

    @Override // j3.a
    public final int zzb() {
        return this.f6074c;
    }

    @Override // j3.a
    public final int zzc() {
        return 0;
    }

    @Override // j3.a
    public final Object[] zze() {
        return this.zzb;
    }
}
