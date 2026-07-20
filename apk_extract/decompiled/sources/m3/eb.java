package m3;

/* JADX INFO: loaded from: classes.dex */
public final class eb extends xa {
    static final xa zza = new eb(new Object[0], 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f7668d;
    final transient Object[] zzb;

    public eb(Object[] objArr, int i8) {
        this.zzb = objArr;
        this.f7668d = i8;
    }

    public static eb zzg(int i8, Object[] objArr, wa waVar) {
        objArr[0].getClass();
        objArr[1].getClass();
        return new eb(objArr, 1);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0005  */
    @Override // m3.xa, java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        Object[] objArr = this.zzb;
        if (obj != null && this.f7668d == 1) {
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
        return this.f7668d;
    }

    @Override // m3.xa
    public final n9 zza() {
        return new db(this.zzb, 1, this.f7668d);
    }

    @Override // m3.xa
    public final ya zzd() {
        return new bb(this, this.zzb, 0, this.f7668d);
    }

    @Override // m3.xa
    public final ya zze() {
        return new cb(this, new db(this.zzb, 0, this.f7668d));
    }
}
