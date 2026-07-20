package m3;

import k3.gb;

/* JADX INFO: loaded from: classes.dex */
public final class za extends va {
    static final va zza = new za(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f7908c;
    final transient Object[] zzb;

    public za(Object[] objArr, int i8) {
        this.zzb = objArr;
        this.f7908c = i8;
    }

    @Override // java.util.List
    public final Object get(int i8) {
        gb.a(i8, this.f7908c);
        Object obj = this.zzb[i8];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7908c;
    }

    @Override // m3.va, m3.n9
    public final int zza(Object[] objArr, int i8) {
        Object[] objArr2 = this.zzb;
        int i9 = this.f7908c;
        System.arraycopy(objArr2, 0, objArr, 0, i9);
        return i9;
    }

    @Override // m3.n9
    public final int zzb() {
        return this.f7908c;
    }

    @Override // m3.n9
    public final int zzc() {
        return 0;
    }

    @Override // m3.n9
    public final Object[] zze() {
        return this.zzb;
    }
}
