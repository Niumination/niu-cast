package k3;

/* JADX INFO: loaded from: classes.dex */
public final class q0 extends g0 {
    static final g0 zza = new q0(new Object[0], 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f6622d;
    final transient Object[] zzb;

    public q0(Object[] objArr, int i8) {
        this.zzb = objArr;
        this.f6622d = i8;
    }

    public static q0 zzg(int i8, Object[] objArr, f0 f0Var) {
        objArr[0].getClass();
        objArr[1].getClass();
        return new q0(objArr, 1);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0005  */
    @Override // k3.g0, java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        Object[] objArr = this.zzb;
        if (obj != null && this.f6622d == 1) {
            Object obj3 = objArr[0];
            obj3.getClass();
            if (obj3.equals(obj)) {
                obj2 = objArr[1];
                obj2.getClass();
            } else {
                obj2 = null;
            }
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f6622d;
    }

    @Override // k3.g0
    public final z zza() {
        return new p0(this.zzb, 1, this.f6622d);
    }

    @Override // k3.g0
    public final h0 zzd() {
        return new n0(this, this.zzb, 0, this.f6622d);
    }

    @Override // k3.g0
    public final h0 zze() {
        return new o0(this, new p0(this.zzb, 0, this.f6622d));
    }
}
