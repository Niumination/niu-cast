package k3;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class x extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y f6702c;

    public x(y yVar, int i8) {
        this.f6702c = yVar;
        Object[] objArr = yVar.zzb;
        objArr.getClass();
        this.f6700a = objArr[i8];
        this.f6701b = i8;
    }

    public final void a() {
        int i8 = this.f6701b;
        Object obj = this.f6700a;
        y yVar = this.f6702c;
        if (i8 != -1 && i8 < yVar.size()) {
            int i9 = this.f6701b;
            Object[] objArr = yVar.zzb;
            objArr.getClass();
            if (ia.a(obj, objArr[i9])) {
                return;
            }
        }
        this.f6701b = yVar.b(obj);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f6700a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        y yVar = this.f6702c;
        Map mapZzj = yVar.zzj();
        if (mapZzj != null) {
            return mapZzj.get(this.f6700a);
        }
        a();
        int i8 = this.f6701b;
        if (i8 == -1) {
            return null;
        }
        Object[] objArr = yVar.zzc;
        objArr.getClass();
        return objArr[i8];
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        y yVar = this.f6702c;
        Map mapZzj = yVar.zzj();
        Object obj2 = this.f6700a;
        if (mapZzj != null) {
            return mapZzj.put(obj2, obj);
        }
        a();
        int i8 = this.f6701b;
        if (i8 == -1) {
            yVar.put(obj2, obj);
            return null;
        }
        Object[] objArr = yVar.zzc;
        objArr.getClass();
        Object obj3 = objArr[i8];
        objArr[i8] = obj;
        return obj3;
    }
}
