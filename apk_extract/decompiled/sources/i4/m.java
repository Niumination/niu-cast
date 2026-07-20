package i4;

import java.util.Map;
import k3.u8;

/* JADX INFO: loaded from: classes.dex */
public final class m extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f5642c;

    public m(o oVar, int i8) {
        this.f5642c = oVar;
        this.f5640a = o.access$100(oVar, i8);
        this.f5641b = i8;
    }

    public final void a() {
        int i8 = this.f5641b;
        Object obj = this.f5640a;
        o oVar = this.f5642c;
        if (i8 == -1 || i8 >= oVar.size() || !u8.a(obj, o.access$100(oVar, this.f5641b))) {
            this.f5641b = oVar.b(obj);
        }
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f5640a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        o oVar = this.f5642c;
        Map<Object, Object> mapDelegateOrNull = oVar.delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.get(this.f5640a);
        }
        a();
        int i8 = this.f5641b;
        if (i8 == -1) {
            return null;
        }
        return o.access$600(oVar, i8);
    }

    @Override // i4.e, java.util.Map.Entry
    public final Object setValue(Object obj) {
        o oVar = this.f5642c;
        Map<Object, Object> mapDelegateOrNull = oVar.delegateOrNull();
        Object obj2 = this.f5640a;
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.put(obj2, obj);
        }
        a();
        int i8 = this.f5641b;
        if (i8 == -1) {
            oVar.put(obj2, obj);
            return null;
        }
        Object objAccess$600 = o.access$600(oVar, i8);
        o.access$1300(oVar, this.f5641b, obj);
        return objAccess$600;
    }
}
